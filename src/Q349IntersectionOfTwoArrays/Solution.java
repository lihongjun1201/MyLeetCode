package Q349IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

难度：Easy
结果： AC

思路: 求并集

*/


public class Solution {

	public static void main(String[] args) {
		
		int[] a1 = {1, 2, 2, 1};
		int[] a2 = {2, 2};
		
		int[] intersection = intersection(a1, a2);
		for (int i = 0; i < intersection.length; i++) {
			System.out.print(intersection[i] + " ");
		}
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		
		//利用java 集合快速解决
		List<Integer> array1 = new ArrayList<Integer>();
		List<Integer> array2 = new ArrayList<Integer>();
		
		for (int i = 0; i < nums1.length; i++) {
			array1.add(nums1[i]);
		}
		
		for (int i = 0; i < nums2.length; i++) {
			array2.add(nums2[i]);
		}
		
		array1.retainAll(array2);
		Set<Integer> interSet = new HashSet<Integer>(array1);
		
		List<Integer> array = new ArrayList<Integer>(interSet);
		
		int[] result = new int[array.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = array.get(i);
		}
		
		return  result;
	}

}
