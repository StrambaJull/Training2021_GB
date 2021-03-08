package level_2.lesson6;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private static int PORT = 1111;

    public static void main (String[] args) {
        Socket clientSocket = null;
        String clientMsg;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); //создаем поток для чтения с клавиатуры
        try(ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен!");

            clientSocket = server.accept();

            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            Thread threadRead = new Thread(new Runnable() {
                @Override
                public void run () {
                    while (true){
                        try {
                            out.writeUTF(keyboard.readLine());
                            out.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            threadRead.setDaemon(true);
            threadRead.start();

            while (true){
                try{
                    clientMsg = in.readUTF();
                } catch (EOFException e) {
                    break;
                }
                if(clientMsg.equalsIgnoreCase("end")){
                    System.out.println("Клиент отключился");
                    out.writeUTF("end");
                    break;
                } else{
                    System.out.println("Клиент: " + clientMsg);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

}

