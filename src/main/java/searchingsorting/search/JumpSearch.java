package searchingsorting.search;

import java.util.Scanner;
import java.util.stream.Stream;

public class JumpSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;

        System.out.println("Enter Input  with delimit by Spaces : ");
        String input = sc.nextLine() ;

        System.out.println("You Entered  : " + input) ;
        int key = sc.nextInt() ;

        System.out.println("Key you want to find is : " + key);

        System.out.println("Key Found at index : " + search(input,key)) ;

    }

    private static  int search(String input, int key ){

        int[] actualInput = Stream.of(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = actualInput.length -1 ;

        // Calculate optimized Step, which is sqrt n
        int step = (int)Math.floor(Math.sqrt(n)) ;

        // Find the Block where Element is Present if any
        int prev = 0 ;

        while(n >= step){
            if(actualInput[step] == key )
                return step ;

            if(actualInput[step] >  key){  // backtrack
                // Linear Search
                while(step-- >= prev){
                    if(actualInput[step] == key)
                        return step ;
                }
                return  -1 ;
            }else {  // move forward
                prev = Math.min(n, prev+step) ;
                step = step*2 ;
            }

        }

        return  -1 ;
    }

}