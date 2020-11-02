package ru.geekbrains;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args)
    {
        changeElements();
        System.out.println();
        fillArray();
        System.out.println();
        changeArray();
        System.out.println();
        createArray();
        System.out.println();
        findMaxMin();
        int[] testArr1 = {5, 1 , 1 , 1};
        int[] testArr2 = {3, 1 , 1 , 1};
        System.out.println(checkBalance(testArr1));
        System.out.println(checkBalance(testArr2));
        int[] testArr3 = {1,2,3,4,5,6,7,8,9,10};
        printArray(testArr3);
        printArray(shiftArray(testArr3, 6));

    }


// 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void changeElements()
    {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length; i++)
        {
            switch (arr[i])
            {
                case 1:
                    arr[i] = 0;
                    System.out.print("0 ");
                    break;
                case 0:
                    arr[i] = 1;
                    System.out.print("1 ");
                    break;
                default:
                    System.out.print("Invalid");
            }
        }
    }

//2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

    public static void fillArray()
    {
        int[] arr = new int[8];

        for (int i = 0; i <= 21; i = i + 3)
        {

            System.out.print(i + " ");        //System.out.print(arr[i]); - not working. Why?
        }
    }

//3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void changeArray()
    {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++)
        {

            if(arr[i] < 6)
            {
               arr[i] = arr[i] * 2;
            }

            System.out.print(arr[i] + " ");
        }

    }

//4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

    public static void createArray()
    {
        int[][] arr = new int[5][5];
        int symbol = 1;
        for (int i = 0; i < arr.length; i++)
        {
                arr[i][i] = symbol;
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

//5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void findMaxMin()
    {
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] =  (int)(1000 * (1 - 2 * Math.random()));
            System.out.print(arr[i] + " ");
        }

        int max = arr[0];
        int min = arr[0];
        for(int i = 0; i < arr.length; i++)
        {


            if(arr[i] > max)
            {
                max = arr[i];

            }
            else if (arr[i] < min)
            {
                min = arr[i];
            }


        }
        System.out.println();
        System.out.println("Maximum number is " + max);
        System.out.println("Minimal number is " + min);

    }

//6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
// если в массиве есть место, в котором сумма левой и правой части массива равны.
// Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
// граница показана символами ||, эти символы в массив не входят.


    public static boolean checkBalance(int[] arr)
    {
        int sumLeft = 0;
        int sumRight = IntStream.of(arr).sum();

        for(int i = 0; i < arr.length; i++)
        {
            sumLeft = sumLeft + arr[i];
            sumRight = sumRight - arr[i];
            if(sumLeft == sumRight)
            {
                return true;
            }
        }
        return false;
    }

    //Не полностью решила сама, можно не защитать, но, пожалуйста проверьте

    //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.

   public static int[] shiftArray(int[] arr, int n)
    {
        //Shift is zero, array is to be the same
        if (n == 0) return  arr;
        if (arr.length >= Math.abs(n) && arr.length % Math.abs(n) == 0 || arr.length < Math.abs(n) && Math.abs(n) % arr.length == 0) return arr;

        if (n > arr.length)
        {
            n = n % arr.length;
        }

        int curIdx = 0;
        int curValNew;
        int curVal = arr[0];
        int iterLengthCount = 0;
        boolean IsFirstIteration = true;
        boolean ShiftIndexForward;

        for (int i = 0; i < arr.length; i++)
        {
            ShiftIndexForward = false;
            curIdx += n;
            while (curIdx < 0)
            {

                curIdx = arr.length + curIdx;
                if (!IsFirstIteration && (iterLengthCount % n) == 0) ShiftIndexForward = true;
            }
            while (curIdx >= arr.length)
            {
                iterLengthCount += arr.length;
                curIdx = curIdx - arr.length;
                if ((iterLengthCount % n) == 0) ShiftIndexForward = true;
            }

            curValNew = arr[curIdx];

            arr[curIdx] = curVal;
            curVal = curValNew;
            if (ShiftIndexForward)
            {
                curIdx +=1;
                curVal = arr[curIdx];
            }
            if (IsFirstIteration) IsFirstIteration = false;
            //printArray(arr);
        }

        return arr;

    }

    public static void printArray(int[] arr)
    {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        System.out.println();
    }
}
