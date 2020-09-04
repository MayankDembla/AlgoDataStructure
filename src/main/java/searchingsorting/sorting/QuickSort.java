package searchingsorting.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class QuickSort {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input with spaces .. ");
        String line = sc.nextLine();

        adapter(line) ;
    }

    private static void adapter(String input ){
        int arr[] = Stream.of(input.split("\\s+")).mapToInt(Integer::parseInt).toArray() ;

        sort(arr,0,arr.length-1) ;

        Arrays.stream(arr).forEach(i-> System.out.print(i + " "));

    }

    private static void sort(int[] arr, int low, int high) {

        if (low < high) {
            int pi = partition(arr, 0 , high ) ;

            // recursively sort the other
            sort(arr,0,pi-1);
            sort(arr,pi+1,high) ;

         }
    }

    private static int partition(int[] arr, int low, int high) {

        // Taking pivot as the last element
        int pivot = arr[low];
        int start = low;
        int end = high;

        while (end > start) {

            // Find Greater from left to right
            while (arr[start] <= pivot && end > start) {
                start++;
            }

            // find lower element from right to left
            while (arr[end] > pivot && end > start) {
                end--;
            }

            // swap if not cross the element
            if (end > start) {
                // swap the start and end element
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }

        arr[low] = arr[end];
        arr[end] = pivot;
        return end;
    }


}
