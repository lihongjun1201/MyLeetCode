package no169.MajorityElement;

import java.util.Arrays;

/*Given an array of size n ,find the majority element. 
 The majority element is the element that appears more than [ n/2 ] times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 */

/*
 * 
 ��Ŀ��Ѱ�������г��ִ�������  [N/2](����ȥĤ)����Ԫ��
 �Ѷȣ�easy
 
 ˼·
 ����һ�������м�Ԫ�ؼ�Ϊ���� AC
���д��6 ��7 �ַ���....hash����������Σ�Ħ��ͶƱ����bit������
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
