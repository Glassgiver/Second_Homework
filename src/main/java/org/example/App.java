package org.example;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class App 
{
    public static void main( String[] args ){
        
        boolean isContinue = true;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (isContinue){
            print("Choose the exercise (1/2/3/4/5/6/7): \n" +
                    "1. change array (1 -> 0 and 0 -> 1)\n" +
                    "2. create array\n" +
                    "3. double array elements that are < 6\n" +
                    "4. filling in the diagonal of the two dimensional array\n" +
                    "5. min and max\n" +
                    "6. sum of sides\n" +
                    "7. change arr on n\n");
            int chooseOption = scanner.nextInt();
            int length;
            int value;
            switch (chooseOption){
                case 1:
                    print("---------------start-----------------");

                    print("choose the length of the array:");
                    length = scanner.nextInt(); //длина массива
                    int[] arr = new int[length]; //создание массива с выбранной длинной
                    for (int i = 0; i < arr.length; i++) { //заполняю случайными нулями и единицами
                        arr[i] = random.nextInt(2);
                    }
                    print("your original array: ");
                    printArr(arr); //вывод изначального массива

                    print(""); //просто отступ

                    changeArr(arr); //изменяем массив
                    print("your changed array: ");
                    printArr(arr); //вывод измененного массива

                    print("\n---------------end-----------------");
                    break;
                case 2:
                    print("---------------start-----------------");

                    print("choose the length of the array (for a hw result write 8):");
                    length = scanner.nextInt(); //длина массива
                    int[] arr2 = new int[length];//созданеи массива с выбранной длинной
                    print("choose the increase value (for a hw result write 3): ");
                    value = scanner.nextInt(); //длина шага
                    for (int i = 0; i < length - 1; i++){
                        arr2[i + 1] = arr2[i] + value; //заполнение массива
                    }
                    printArr(arr2); //вывод полученного массива

                    print("\n---------------end-----------------");
                    break;
                case 3:
                    print("---------------start-----------------");

                    int arr3[] = {1,5,3,2,11,4,5,2,4,8,9,1};
                    print("original array: ");
                    printArr(arr3); //вывод массива

                    for (int i = 0; i < arr3.length; i++){
                        if (arr3[i] < 6){
                            arr3[i] *= 2; // ув. в 2
                        }
                    }
                    print("\nchanged array: ");
                    printArr(arr3);

                    print("\n---------------end-----------------");
                    break;
                case 4:
                    print("---------------start-----------------");

                    print("choose the length and width of the array:");
                    length = scanner.nextInt();
                    int[][] dimArr = new int[length][length]; //создаем двумерный массив

                    fillDimDiag(dimArr, length);

                    printDimArr(dimArr);

                    print("---------------end-----------------");
                    break;
                case 5:
                    print("---------------start-----------------");

                    print("choose the length of the array:");
                    length = scanner.nextInt();
                    print("choose the maximum of the range (ex. if it's from 0 to 10, then write down 10):");
                    value = scanner.nextInt();
                    int[] arr5 = new int[length];

                    for (int i = 0; i < length; i++) { //заполняю случайными числами
                        arr5[i] = random.nextInt(value);
                    }

                    print("your original array: ");
                    printArr(arr5); //вывод массива

                    print("\nyour max: " + findMax(arr5));
                    System.out.println("your min: " + findMin(arr5));


                    print("---------------end-----------------");
                    break;
                case 6:
                    print("---------------start-----------------");
                    int[] arr6 = {1, 1, 1, 2, 1};
                    int[] arr6_1 = {2,2,2,1,2,2,10,1};
                    int[] arr6_2 = {1,2,3,4};
                    printArr(arr6);
                    System.out.print(" -> " + checkSums(arr6) + "\n");
                    printArr(arr6_1);
                    System.out.print(" -> " + checkSums(arr6_1) + "\n");
                    printArr(arr6_2);
                    System.out.print(" -> " + checkSums(arr6_2) + "\n");
                    print("---------------end-----------------");
                    break;
                case 7:
                    print("---------------start-----------------");
                    int[] arr7 = {1, 2, 3, 4, 5};
                    print("write n: ");
                    int n = scanner.nextInt();
                    print("your original array: ");
                    printArr(arr7);
                    print("\nyour changed array: ");
                    moveElements(arr7, n);
                    printArr(arr7);
                    print("\n---------------end-----------------");
            }
        }
    }

    /* методы домашнего задания*/
    public static void changeArr(int[] arr){
        int index = 0;
        for (int i: arr) {
            if (i == 0){
                arr[index] = 1;
            }
            else{
                arr[index] = 0;
            }
            index++;
        }
    }

    public static void fillDimDiag(int[][] dimArr, int length){
        //1 диагональ
        for (int i = 0; i < length; i++){
            dimArr[i][i] = 1;
            dimArr[i][length - 1 - i] = 1;
        }
    }

    public static int findMax(int[] arr){
        int max = arr[0];

        for (int i: arr) {
            if (i > max){
                max = i;
            }
        }
        return max;
    }

    public static int findMin(int[] arr){
        int min = arr[0];

        for (int i: arr) {
            if (i < min){
                min = i;
            }
        }
        return min;
    }

    public static boolean checkSums(int[] arr){ //1 1 1 2 1
        int sum1 = arr[1];
        int sum2 = 0;
        for(int i = 0; i < arr.length - 2; i++){
            sum1 = sum1 + arr[i+1]; //сумма левой части (начинается с первых двух элементов)
            for (int j = i + 2; j < arr.length; j++){
                sum2 += arr[j]; //сумма всех остальных элементов
            }
            if (sum1 == sum2){
                return true;
            }
            sum2 = 0;
        }
        return false;
    }

    public static void moveElements(int[] arr, int n){
        int storage;
        int storage2;
        if (n > 0){ //если ув.
            for (int i = 0; i < n; i++) {
                int temp = arr[arr.length - 1]; //сохраняем последний элемент
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1]; //элемент меняется с предшествующим
                }
                arr[0] = temp; //меняем первый элемент на последний
            }

        }
        else{
            n = -n; // Преобразуем отрицательное смещение в положительное
            for (int i = 0; i < n; i++) {
                int temp = arr[0]; //сохраняем первый элемент
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1]; //элемент меняется с последующим
                }
                arr[arr.length - 1] = temp; //меняем последний элемент на первый
            }
        }

    }

    /* методы для удобства (свои) */
    public static void print(String str){
        System.out.println(str);
    }

    public static void printArr(int[] arr){
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    public static void printDimArr(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
