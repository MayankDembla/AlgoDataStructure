package searchingsorting.search;

import java.util.Scanner;
import java.util.stream.Stream;

public class TernarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Input seperated by spaces");
        String input = sc.nextLine();
        System.out.println("You  Enter Input : " + input);
        System.out.println("Enter Key ");
        int key = sc.nextInt();
        System.out.println("You Enter Key " + key);

        adapter(input, key);
    }

    private static void adapter(String input, int key) {

        int[] in = Stream.of(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println( binarySearch(in,0,in.length-1,key) );
        System.out.println(ternarySearch(in,0,in.length-1,key)) ;

    }


    private static int binarySearch(int arr[] , int l , int r , int key){

        if(r>=l){

            int mid = l + (r-l) /2  ;

            if(arr[mid] == key)
                return mid ;

            if (arr[mid] > key)
                return binarySearch(arr, l, mid-1, key);

            return binarySearch(arr, mid+1, r, key);
        }
       return -1 ;
    }

    private static int ternarySearch(int arr[] , int r , int l , int x){

        if(r >= l){

            int mid1 = (l + (r-l))/3  ;
            int mid2 = mid1 + (r-l)/3 ;

            // If x is present at the mid1
            if (arr[mid1] == x)  return mid1;

            // If x is present at the mid2
            if (arr[mid2] == x)  return mid2;


            // If x is present in left one-third
            if (arr[mid1] > x)
                return ternarySearch(arr, l, mid1 - 1, x);

            // If x is present in right one-third
            if (arr[mid2] < x)
                return ternarySearch(arr, mid2 + 1, r, x);

            // If x is present in middle one-third
            return ternarySearch(arr, mid1 + 1,
                    mid2 - 1, x);
        }

        // We reach here when element is
        // not present in array
        return -1;
    }

}
