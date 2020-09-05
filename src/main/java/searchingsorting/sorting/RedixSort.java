package searchingsorting.sorting;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class RedixSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter the line with spaces");
        String line = sc.nextLine() ;

        radixsort(Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray()) ;

    }

    private static void radixsort(int[] arr){

        int max = Arrays.stream(arr).max().getAsInt() ;
        int nd = 0 ;
        int radix  =1;

        // getting number of digits
        while(max > 0 ){
            max /= 10 ;
            nd++;
        }

        for(int i = 0 ; i< nd ; i++)
        {
            // count array
            int[] count = new int[10] ;
            int[] output = new int[arr.length] ;

            // put the last digits to the count array
            for(int j = 0 ; j < arr.length ; j++){
                count[(arr[j]/radix)%10]++;
            }

            // get the indexes
            for(int j = 1 ; j < count.length ; j++){
                count[j] += count[j-1] ;
            }

            // putting it in the output array
            for(int j = arr.length-1 ; j >= 0 ; j--){
                output[count[(arr[j]/radix)%10]-1] = arr[j] ;
                --count[(arr[j]/radix)%10] ;
            }

            // copy to final array
            System.arraycopy(output,0,arr,0,arr.length);

            radix *= 10 ;
        }

        Arrays.stream(arr).forEach(k -> System.out.print(k + " "));
    }

}
