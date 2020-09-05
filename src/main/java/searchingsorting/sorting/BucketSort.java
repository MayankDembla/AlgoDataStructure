package searchingsorting.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class BucketSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter the size of the input");

        int n = sc.nextInt() ;

        float[] input = new float[n] ;
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextFloat() ;
        }
        bucketSort(input,n) ;
    }


    static void bucketSort(float[] arr, int n ){

        if(n <= 0 )
            return;

        // create an empty bucket
        ArrayList<Float>[] b = new ArrayList[n];

        // 1. initlialize the bucket
        for (int i = 0; i < n; i++) {
            b[i] = new ArrayList<>() ;
        }

        // 2. putting array element in different bucket
        for (int i = 0; i < n; i++) {

            int idx = (int) arr[i] * n ;
            b[idx].add(arr[i]) ;
        }

        // 3. sort the bucket
        for (int i = 0; i < n; i++) {
            Collections.sort(b[i]);
        }


        // 4. Conactinate the buckets
        int index = 0 ;
        for (int i = 0; i < n; i++) { // array
            for (int j = 0; j < b[i].size(); j++) { // bucket
                arr[index++] = b[i].get(j) ;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
