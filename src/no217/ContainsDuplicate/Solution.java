package no217.ContainsDuplicate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.crypto.spec.IvParameterSpec;

/*Given an array of integers, find if the array contains any duplicates. 
 Your function should return true if any value appears at least twice in the array, 
 and it should return false if every element is distinct.*/

/*题目：判断数组有没重复元素
 难度：简单
 思路：hash*/

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	//Accepted 
	public boolean containsDuplicate(int[] nums) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				return true;
			}
		}

		return false;

	}

}
