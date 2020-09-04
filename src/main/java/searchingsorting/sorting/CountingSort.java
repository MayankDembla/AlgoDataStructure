package searchingsorting.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter input by spaces ...");
        String line = sc.nextLine() ;

//        char[] input = new char[line.split("\\s+").length] ;
//
//        char[] ar = line.toCharArray() ;
//        int count = 0 ;
//        for(int i = 0 ; i < ar.length; i++){
//            if(ar[i] != ' '){
//                input[count] = ar[i] ;
//                count++ ;
//            }
//        }

        // non negative character values
//        sort(input);

        // similary for integers
        int arr[] = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray() ;
        countSort(arr) ;

    }



    private static void sort(char arr[]){

        int n = arr.length ;
        char[] output = new char[n] ;

        int count[] = new int[256] ;
        Arrays.fill(count,0);

        // store count of each character
        for (int i = 0; i < n; i++) {
            ++count[arr[i]] ;
        }
        
        // get the indexes 
        for (int i = 1; i <= 255 ; i++) {
            count[i] += count[i-1] ;
        }

        // Build the output character array
        for (int i = n-1; i >=0 ; i--) {
            output[count[arr[i]] -1 ] = arr[i] ; // trick
            --count[arr[i]];
        }

      for(char c : output){
          System.out.print( c + " ");
      }
    }

    private static void countSort(int[] arr){

        int max = Arrays.stream(arr).max().getAsInt() ;
        int min = Arrays.stream(arr).min().getAsInt() ;
        int range = max - min + 1  ;
        int[] count = new int[range] ;
        int[] output = new int[arr.length] ;

        // incrementing the value 
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++ ;
        }

        // getting indexes 
        for (int i = 1; i < count.length; i++) {
            count[i] +=count[i-1] ;
        }

        // geting indexes
        for (int i = arr.length-1; i >= 0  ; i--) {
            output[count[arr[i] - min] - 1 ] = arr[i] ;
            count[arr[i]-min]-- ;
        }

       // System.arraycopy(arr,0,output,0,output.length);

        Arrays.stream(output).forEach(i-> System.out.print(i + " "));

    }

}
