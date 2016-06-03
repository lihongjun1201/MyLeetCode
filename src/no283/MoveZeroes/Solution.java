package no283.MoveZeroes;

import javax.xml.transform.Templates;

/*Given an array nums, write a function to move all 0's to the end of it
 *  while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], 
 after calling your function 
 nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 *题目:将数组中所有0元素 移到最后，并且保持非0元素的原本相对顺序
 *难度：easy
 *思路：
 *双指针
 *
 *状态：
 *
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] original = {0, 1, 0, 3, 12};
	    
		moveZeroes(original);
		for (int i : original) {
			System.out.print(i + " ");
		}
		
	}

	public static void moveZeroes(int[] nums) {
		int j = -1, i = 0;

		for (; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[++j];
				nums[j] = temp;
			}
		}

	}

}
