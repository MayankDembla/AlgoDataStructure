package searchingsorting.search;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LinearSearch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the numbers");
        String str = scanner.nextLine();

        System.out.println("You entered : " + str);

        System.out.println("Enter key you want to search ? ");
        int key = scanner.nextInt();

        System.out.println("Key you entered : - " + key);

        System.out.println("The key present using linear search is : " + linearSearch(str.split("\\s+"), key));
    }

    /**
     * Linear Search
     *
     * @param arr
     * @param key
     * @return
     */
    public static int linearSearch(String[] arr, int key) {

        int[] arrayint = Stream.of(arr).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arr.length; i++) {
            if (arrayint[i] == key)
                return i;
        }
        return -1;
    }

}
