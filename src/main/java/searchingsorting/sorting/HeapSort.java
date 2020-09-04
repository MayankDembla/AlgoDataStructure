package searchingsorting.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class HeapSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input seperated by space..");

        String input = sc.nextLine();

        adapter(input);
    }

    private static void adapter(String str) {
        int[] arr = Stream.of(str.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        sort(arr);

        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }

    private static void sort(int[] arr) {

        int n = arr.length ;

        // Heapfy non child nodes
        for(int i = n/2-1 ; i > 0 ; i--)
        {
            heapify(arr, n , i );
        }

        // remove one by one
        for(int i = n-1 ; i > 0 ; i--){

            // swap elements
            int temp = arr[0] ; //max element
            arr[0] = arr[i] ;
            arr[i] = temp ;

            // heapify rest
            heapify(arr,i,0);
        }
    }


    private static  void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1; // left element 2 * i + 1
        int r = 2 * i + 2;

        // check if left element is larger
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // check if right element is larger
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // check if root is not in correct position.

        if (largest != i) {

            // swap
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // again heapify  the rest
            heapify(arr, n, largest);
        }
    }
}
