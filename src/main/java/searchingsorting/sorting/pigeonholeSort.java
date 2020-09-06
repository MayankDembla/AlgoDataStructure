package searchingsorting.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class pigeonholeSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter elements seprerated by spaces");

        String line = sc.nextLine() ;

        int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray() ;

        peigonsort(arr,arr.length);

        Arrays.stream(arr).forEach(i-> System.out.print( i + " "));
    }

    private static void peigonsort(int arr[] , int n){

        // 1. Find min and max
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        // find range
        int range = max-min+1 ;
        int[] phole = new int[range] ;
        Arrays.fill(phole,0);


        for (int i = 0; i < n; i++) {
            phole[arr[i]-min]++ ;
        }

        int index = 0 ;

        for (int i = 0; i < range; i++) {
            while (phole[i]-- > 0 )
                arr[index++] = i+min ;
        }
    }

}
