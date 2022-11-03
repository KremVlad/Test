import java.util.Scanner;   //Нужно для ввода данных с клавиатуры

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    //Нужно для ввода данных с клавиатуры
        String str = sc.nextLine();
        int counterRepeat = 0;  //Счётчик количества повторений
        int maxCounterRepeat = 0;  //Счётчик максимального количества повторений
        int counterElem = 0;    //Счётчик элементов с максимальным повторением

        String[] strArr = str.split(" ");
        int[] numArr = new int[strArr.length];  //Массив для записи чисел из строки
        int[] answer = new int[strArr.length];  //Массив для записи повторяющихся элементов

        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        for (int i = 0; i < numArr.length - 1; i++) {
            for (int j = i; j < numArr.length; j++) {
                if (numArr[i] == numArr[j]) {
                    counterRepeat++;
                }
            }
            if (counterRepeat >= maxCounterRepeat) {
                if (counterRepeat == maxCounterRepeat) {
                    if (answer[counterElem - 1] != numArr[i]) {
                        counterElem++;
                        answer[counterElem - 1] = numArr[i];
                    }
                } else {
                    answer[0] = numArr[i];
                    counterElem = 1;
                }
                maxCounterRepeat = counterRepeat;
            }
            counterRepeat = 0;
        }
        SortArr(answer, counterElem);
        for (int i = 0; i < counterElem; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static void SortArr(int[] arrToSort, int counter) {  //сортировка массива
        int temp;

        for (int i = 0; i < counter; i++) { //сортировка основного массива(arrToSort)
            for (int j = 0; j < i; j++) {
                if (arrToSort[i] < arrToSort[j]) {
                    temp = arrToSort[i];
                    arrToSort[i] = arrToSort[j];
                    arrToSort[j] = temp;
                }
            }
        }
    }
}
