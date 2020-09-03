package searchingsorting.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class MergeSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input with spaces ");

        String line = sc.nextLine();
        merge(line);
    }

    private static void merge(String input) {

        int[] arr = Stream.of(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        sort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }

    private static void sort(int[] arr, int l, int r) {

        if (l < r) {

            int mid = (l + r) / 2;

            sort(arr, l, mid);
            sort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {

        // length calculate subrray
        int n1 = mid - l + 1;
        int n2 = r - mid;

        // create 2 sub array
        int[] left = new int[n1];
        int[] right = new int[n2];

        // copy value in 2 subarray
        System.arraycopy(arr, l, left, 0, n1);
        System.arraycopy(arr, mid + 1, right, 0, n2);

        // checking ..
        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (right[j] >= left[i]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < n2) {
            arr[k] = right[j];
            k++;
            j++;
        }

    }
}
