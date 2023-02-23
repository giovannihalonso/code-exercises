package interviewsExercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicatesNumbersInAnArray {

	/*
	 *  Description problem 
	 *
	Given an array of n elements that contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.
	
	Input : n = 7 and array[] = {1, 2, 3, 6, 3, 6, 1}
	Output: 1, 3, 6

	Explanation: The numbers 1 , 3 and 6 appears more
	than once in the array.

	Input : n = 5 and array[] = {1, 2, 3, 4 ,3}
	Output: 3

	Explanation: The number 3 appears more than once
	in the array.
	
	*/
	
	public static void main(String[] args) {

		
		int[] nums = {1, 2, 3, 6, 3, 6, 1};
		int[] nums1 = {1, 2, 3, 4 ,3};
		
		System.out.println("solution for {1, 2, 3, 6, 3, 6, 1} is: " + solution(nums) );
		
		System.out.println("solution for {1, 2, 3, 4 ,3} is: " + solution(nums1) );
		
		
	}

	
	// Analysis:
	// 1- I use Set because repeted elements are not allowed
	// 2- One Set cointains just new elemnts added one first and single time
	// 3- One second set is going to have the repeted elements, because already exist in the set described above
	
    public static Set<Integer> solution(int[] A) {

    	List<Integer> nums = Arrays.stream(A).boxed().collect( Collectors.toList() );
    	
    	Set<Integer> building = new HashSet<Integer>();
    	
    	Set<Integer> duplicateds = new HashSet<Integer>();
    	
    	for (Integer num : nums) {
			
    		if( !building.contains( num  ) ) {
    			building.add(num);
    		}
    		else {
    			duplicateds.add(num);
    		}
    		
		}
    	
    	
        return duplicateds;

    }
	
}
