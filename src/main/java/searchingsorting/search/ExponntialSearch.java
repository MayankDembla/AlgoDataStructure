package searchingsorting.search;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class ExponntialSearch {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Input seperated by spaces");
        String input = sc.nextLine();
        System.out.println("You  Enter Input : " + input);
        System.out.println("Enter Key ");
        int key = sc.nextInt();
        System.out.println("You Enter Key " + key);

        System.out.println("Key found at index : " + search(input, key));
    }

    private static int search(String input, int key) {

        int[] in = Stream.of(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = in.length - 1;

        if (in[0] == key)
            return 0;

        // Exponantially find the Range where the key lies
        int i = 1;
        while (i < n && in[i] <= key)
            i = i *2 ;

           return Arrays.binarySearch(in,i/2,Math.min(i,n),key) ;
    }

}
