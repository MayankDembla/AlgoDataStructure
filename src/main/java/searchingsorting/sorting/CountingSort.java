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

        char[] input = new char[line.split("\\s+").length] ;

        char[] ar = line.toCharArray() ;
        int count = 0 ;
        for(int i = 0 ; i < ar.length; i++){
            if(ar[i] != ' '){
                input[count] = ar[i] ;
                count++ ;
            }
        }

        sort(input);

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

}
