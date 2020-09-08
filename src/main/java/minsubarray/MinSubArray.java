package minsubarray;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted..
 */
public class MinSubArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        String line = sc.nextLine() ;

        int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray() ;

        getminSubArray(arr, arr.length) ;

    }

    public static void getminSubArray(int[] arr, int n){

        int s = 0 , e = n-1;

        // get start index from left to right
        while(s < n-1 && arr[s] < arr[s+1]){
            s++ ;
        }

        if(s == n-1){
            System.out.println("Already Sorted !");
            return;
        }

        // get end index from right to left
        while (e > 0 && arr[e] > arr[e-1] ) {
            e--;
        }

        // Calculate min and max in the subarray
        int min  = arr[s+1] ;
        int max = arr[e] ;

        for(int i = s+1 ; i <= e ; i++){
            if(arr[i] > max) {
                max = arr[i];
            }

            if(arr[i] < min )
                min = arr[i] ;
        }

        // check from left to right
        for (int i = 0 ; i < s ; i++){

            if(arr[i] > min ) {
                s = i;
                break ;
            }
        }

        // check from right to left
        for(int i =n-1 ; i >= e+1  ; i-- )
        {
            if(arr[i] < max){
                e = i ;
                break;
            }
        }

        System.out.println("Start Index  : " + s) ;
        System.out.println("Ending Index  : " + e );

    }

}
