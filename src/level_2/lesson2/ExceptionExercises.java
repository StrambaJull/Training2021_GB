package level_2.lesson2;

public class ExceptionExercises {

    public static void main (String[] args) {
        try {
            String[][] arr = {
                    {"12", "22", "44", "0"},
                    {"1", "3", "4", "b"},
                    {"34", "55", "34", "33"},
                    {"43", "56", "44", "22"}
            };
            myArray(arr);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void myArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int summ = 0;
        if(arr.length > 4){
            throw new MyArraySizeException(arr.length, "Длина внешнего массива: ");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length > 4) {
                    throw new MyArraySizeException(arr[i].length, "Длина внутреннего массива: ");
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++){
                    try{
                        int x = Integer.parseInt(arr[i][j]);
                        summ = summ + x;
                    } catch (Exception e){
                        throw new MyArrayDataException("В ячейке: [" + i + "][" +  j + "] не число");
                    }
                }
            }
        }
            System.out.println("Сумма: " + summ);
        }
}
