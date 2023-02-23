package interviewsExercises;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Description
 * 
 * 
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [-1, -3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [-1,000,000..1,000,000].
Copyright 2009–2023 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
*/

public class SmallestPositiveNumberNotOccur {

	public static void main(String[] args) {

		int[] nums = {1, 3, 6, 4, 1, 2};
		int[] nums1 = {1, 2, 3};
		int[] nums2 = {-1, -3};
		
		System.out.println("solution for {1, 3, 6, 4, 1, 2} is: " + solutionWithSet(nums) );
		
		System.out.println("solution for {1, 2, 3} is: " + solutionWithSet(nums1) );
		
		System.out.println("solution for {-1, -3} is: " + solutionWithSet(nums2) );
		
		
	}
	

	// Analysis:
	// 1- To all negatives numbers or zero, always is returned 1, for that are filtered values > 0
	// 2- are removed duplicaded elemnts with a Set and are sort and returned the elements
	// 3- temp is initialized with 1, for the same number of elements within the Set, is checked if temp value exist within the set, if present temp is increased by one, at the end we have the smallest positive number not present in the collection 
	
    public static int solutionWithSet(int[] A) {

    	Integer temp = 1;
    	
    	Set<Integer> numsSet = Arrays.stream(A).boxed()
    											.filter( n -> n > 0 )
    											.sorted().collect(Collectors.toSet());
    	
    	
    	for(int i = 0;  i <  numsSet.size() ; i++  ) {
    		if( numsSet.contains(temp)) {
    			temp = temp +1;
    		}
    	}
    	
        return temp.intValue();

    }

}
