package searchingsorting.sorting;

import java.util.Scanner;
import java.util.stream.Stream;

public class BubbleSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter the Elements with Spaces ");
        String input = sc.nextLine() ;
        System.out.println("Your Enter Input is : " + input);

        bubbleSort(input) ;
    }

    private static void bubbleSort(String string){
        int[] arr = Stream.of(string.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = arr.length ;
        boolean isSwap = false ;

        for (int i = 0; i < n-1 ; i++) {

            for (int j = 0; j < n-i-1  ; j++) {
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j] ;
                    arr[j] = arr[j+1] ;
                    arr[j+1] = temp ;
                    isSwap = true ;
                }
            }

            if(!isSwap)
                break;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
