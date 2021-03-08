package level_2.lesson6;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final int SERVER_PORT = 1111;
    private static final String SERVER_HOST = "127.0.0.1";

    public static void main (String[] args) {
        Socket socket = null;
    try {
        try {
            socket = new Socket(InetAddress.getByName(SERVER_HOST), SERVER_PORT); //создаем сокет для подключения к серверу
            System.out.println("Сеанс клиента запущен");

            DataInputStream in = new DataInputStream(socket.getInputStream()); //получаем входной поток сокета
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); //получаем выходной поток сокета

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); //создаем поток для чтения с клавиатуры
            String serverMsg;
            System.out.println("Введите сообщение и нажмите Enter");

            Thread threadRead = new Thread(new Runnable() {
                @Override
                public void run () {
                    while (true){
                        try {
                            out.writeUTF(keyboard.readLine());
                            out.flush(); //выталкиваем сообщение из буфера
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            threadRead.setDaemon(true);
            threadRead.start();

            while (true) {
                try {
                    serverMsg = in.readUTF(); //ждем ответ от сервера
                } catch (EOFException e){
                    break;
                }
                if (serverMsg.equalsIgnoreCase("finish")) { //если ввели finish, закрываем соединение
                    break;
                } else {
                    System.out.println("Сервер: " + serverMsg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } finally {
        try {
            if (socket != null){
                socket.close();
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    }
}
