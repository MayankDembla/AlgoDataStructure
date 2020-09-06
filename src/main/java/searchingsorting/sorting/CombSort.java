package searchingsorting.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class CombSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter elements seprerated by spaces");

        String line = sc.nextLine() ;

        int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray() ;

        combsort(arr,arr.length);

        Arrays.stream(arr).forEach(i-> System.out.print( i + " "));

    }

    private static void combsort(int[] arr , int n){

        int gap = n ;

        boolean swapped = true ;

        while(gap >= 1 || swapped){

            // find the next gap
            gap = (int) (gap/1.3) ;
            swapped = false ; // extra

            for(int i = 0 ; i<n-gap ; i ++ ){

                if(arr[i] > arr[i + gap]){
                    // swap
                    int temp = arr[i] ;
                    arr[i] = arr[i+gap] ;
                    arr[i+gap] = temp ;

                    // set swapped
                    swapped = true ;
                }
            }
        }
    }
}
