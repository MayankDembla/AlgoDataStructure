package lecture1;

/**
 * Linear Search
 * Worst Case, Average Case and Best Case
 */
public class TestClass1 {

    public static void main(String[] args) {
        int arr[] = {1, 10, 30, 15};
        int x = 30;
        int n = arr.length;
        System.out.printf("%d is present at index %d",x,search(arr,n,x));
    }

    private static int search(int[] arr, int n, int x) {
        for (int j = 0; j < n; j++) {
            if(arr[j] == x)
                return j; // found at index j
        }
        return -1 ; // Not found
    }
}
