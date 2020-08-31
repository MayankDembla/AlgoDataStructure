package searchingsorting.sorting;

import java.util.Scanner;
import java.util.stream.Stream;

public class SelectionSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter the Elements with Spaces ");
        String input = sc.nextLine() ;
        System.out.println("Your Enter Input is : " + input);

        selectionSort(input) ;

    }

    private static void selectionSort(String input){

        int[] arr = Stream.of(input.split("\\s+")).mapToInt(Integer::parseInt).toArray() ;

        int n = arr.length -1 ;

        for(int i = 0 ; i < n ; i++){

           int min_idx = i  ;
            for (int j = i+1; j < n ; j++) {
                      if(arr[j] < arr[min_idx])
                          min_idx = j ;
            }

            // swap the elements with i
            int temp = arr[i] ;
            arr[i] = arr[min_idx] ;
            arr[min_idx] = temp ;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
