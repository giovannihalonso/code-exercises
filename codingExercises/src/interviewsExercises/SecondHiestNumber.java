package interviewsExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//Given a list of integers, find the second hiest number from the list of integers 


public class SecondHiestNumber {

	public static void main(String[] args) {
	
		int[] nums = { 1, 5, 10, 11, 15 };
		
		System.out.println("solution for {1, 5, 10, 11, 15} is: " + solutionWithJava8(nums) );
		
		System.out.println("solution for {1, 5, 10, 11, 15} is: " + solutionWithJava(nums) );
		

	}

	
	// solution one : I use sort method, then a set is returned to eliminate duplicated elements
    public static int solutionWithJava8(int[] A) {

    	int temp = 0;
    	
    	Set<Integer> numsSet = Arrays.stream(A).boxed()
    											.sorted().collect(Collectors.toSet());
    	
    	if( numsSet.size() > 2 )
    		temp = (int) numsSet.toArray()[ numsSet.size()-2 ];
        
    	return temp;

    }
    
    
    // solution two: fisrt we recover hiest number, then second hiest number is the lowest subtraction between hiest number and each of others 
    public static int solutionWithJava(int[] A) {

    	int maxNum = 0;
    	int minSub = 0;
    	HashMap<Integer, Integer> minSubNumber = new HashMap<Integer, Integer>();
    	    	
    	for (int i : A) {
    		maxNum  = Math.max(maxNum, i);
		}
    
    	
    	for(int i = 0; i < A.length ; i++   ) {

    		if( A[i] != maxNum ) { // no hacer la resta del maxNum - el MaxNum pues da cero y distorciona el sentido de la resta menor para encontrar al segundo valor mas grande
    			
        		if( i == 0 ) {
        			minSub = maxNum - A[i];
        		}
        		
        		minSub  = Math.min(minSub, ( maxNum - A[i]   ) );
        		minSubNumber.put( maxNum -A[i]   , A[i]  );
        		
    		}
    	}
    	
    	return minSubNumber.get(minSub);

    }
    
}
