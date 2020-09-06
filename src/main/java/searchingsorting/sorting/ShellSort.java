package searchingsorting.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class ShellSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter the number seperated by spaces");

        String line = sc.nextLine();

        int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        shellSort(arr,arr.length);

        Arrays.stream(arr).forEach(i-> System.out.print(i + " "));
    }

    private static void shellSort(int[] arr,int n ){

        for(int gap =n/2 ; gap >= 1 ; gap /= 2){

            int a = 0 , b = gap ;
            while(b < n ) {
                if (arr[a] > arr[b]) {
                    // swap elements
                    int temp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = temp;

                    // move backward
                    int prev = a - gap;
                    int ba = a;
                    while (prev >= 0 && arr[ba] < arr[prev]) {

                        // swap
                        temp = arr[ba];
                        arr[ba] = arr[prev];
                        arr[prev] = temp;

                        // and decrement the previous
                        ba = prev;
                        prev -= gap;
                    }
                }
                a++ ;
                b++ ;
            }
        }


    }

}
