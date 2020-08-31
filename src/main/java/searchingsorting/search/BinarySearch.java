package searchingsorting.search;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BinarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array with spaces..");
        String input = sc.nextLine();

        System.out.println("you enter input : " + input);

        System.out.println("Enter the Key you want to Search ");
        int key = sc.nextInt();

        System.out.println("Key found at : " + adapter(input, key));

    }

    public static int adapter(String str, int k) {

        int[] input = Stream.of(str.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        return search(input, 0, input.length - 1, k);
    }

    private static int search(int[] arr, int start, int end, int key) {

        if (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key)
                return search(arr, start, mid - 1, key);
             else
                return search(arr, mid + 1, end, key);
        }
        return -1;
    }

    private static int search(int[] arr , int key){

        int start = 0 , end = arr.length  ;

        while (start <= end){
            int mid = (start + end) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key)
               end = mid -1 ;
            else
               start = mid + 1 ;
        }
        return -1;
    }

}
