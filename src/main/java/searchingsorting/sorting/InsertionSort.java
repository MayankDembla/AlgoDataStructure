package searchingsorting.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Elements with Spaces ");
        String input = sc.nextLine();
        System.out.println("Your Enter Input is : " + input);

        System.out.println("Using Selection Sort ... ");
        selectionSort(input);

        System.out.println("\nUsing the Bubble Sort ...");
        bubbleSort(input);

        System.out.println("\nUsing the Insertion Sort ...");
        insertionSort(input);

    }


    private static void insertionSort(String input) {

        int[] arr = Stream.of(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = arr.length;

//        for (int i = 1; i < n; i++) {
//
//            int pointer = i;
//            int current = arr[i];
//
//            //swap till not found its position
//            while (pointer > 0 && arr[--pointer] > current) {
//
//                int temp = arr[pointer];
//                arr[pointer] = current;
//                arr[pointer + 1] = temp;
//            }
//        }

        // optimized
        for (int i = 1; i < n; i++) {
            int current = arr[i] ;
            int j  = i -1 ;

            while(j >= 0 && arr[j] > current){
                arr[j+1] = arr[j] ;
                j--;
            }

            arr[j+1] = current ;
        }


        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }


    private static void selectionSort(String str) {

        int[] arr = Stream.of(str.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arr.length; i++) {

            int min_cur = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[min_cur] > arr[j])
                    min_cur = j;
            }

            // swap shorted element ...
            int temp = arr[i];
            arr[i] = arr[min_cur];
            arr[min_cur] = temp;
        }

        System.out.println("Sorted is : ");
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

    }


    private static void bubbleSort(String str) {

        int[] arr = Stream.of(str.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arr.length; i++) {
            boolean isswap = false;
            // pass i
            for (int j = 0; j < arr.length - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isswap = true;
                }

            }
            if (!isswap)
                break;
        }

        System.out.println("Sorted is : ");
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }

}
