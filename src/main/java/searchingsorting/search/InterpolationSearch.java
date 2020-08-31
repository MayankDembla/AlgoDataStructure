package searchingsorting.search;

import java.util.Scanner;
import java.util.stream.Stream;

public class InterpolationSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Input seperated by spaces");
        String input = sc.nextLine();
        System.out.println("You  Enter Input : " + input);
        System.out.println("Enter Key ");
        int key = sc.nextInt();
        System.out.println("You Enter Key " + key);

        System.out.println("Key found at index : " + search(input,key));
    }

    private static int search(String input, int key) {

        int[] in = Stream.of(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        // int n = in.length-1;

        int start = 0;
        int end = in.length-1;

        while (end >= start && key >= in[start] && key <= in[end])  {

            /*
             * Instead of using the mid as a mid we use formula as
             * pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ]
             */

            // handle one element
            if (start == end )
            {
                if (in[start] == key)
                    return start;
                return -1;
            }

            int mid = start + ((key - in[start]) * (end-start)) / (in[end] - in[start]); // (end + start) / 2;
            System.out.println("Position to start is : " + mid);

            if(in[mid] == key)
                return mid;

            if (in[mid] > key)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return  -1 ;
    }
}
