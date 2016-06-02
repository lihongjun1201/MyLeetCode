package no34.SearchForARange;

import java.util.Arrays;

/*
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].

��Ŀ����������������ĳԪ�س��ֵ��±귶Χ
 �Ѷȣ� �е�
 ˼·�� ��ΪҪ��ʱ�临�Ӷ� O��log n�� �����Կ������ö��ֲ���
״̬�� ��


 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {5, 7, 7, 8, 8,10};
		searchRange(nums,8);
	}

	
	/**
	 * ���ö��ֲ���˼��
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		Arrays.binarySearch(nums, target);
	

		for (int i : result) {
			System.out.println(i);
		}
		
		return result;
	}
}
