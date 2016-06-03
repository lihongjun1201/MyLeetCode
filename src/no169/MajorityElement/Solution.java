package no169.MajorityElement;

import java.util.Arrays;

/*Given an array of size n ,find the majority element. 
 The majority element is the element that appears more than [ n/2 ] times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 */

/*
 * 
 题目：寻找数组中出现次数大于  [N/2](向上去膜)的主元素
 难度：easy
 
 思路
 方法一：排序，中间元素即为所求 AC
还有大概6 ，7 种方法....hash，随机，分治，摩尔投票法，bit操作法
 *
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Accepted 
	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

}
