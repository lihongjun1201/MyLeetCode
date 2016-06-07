package no34.SearchForARange;

import java.lang.management.MemoryUsage;
import java.util.Arrays;

import javax.print.attribute.standard.NumberUpSupported;
import javax.sound.midi.MidiChannel;

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

//û���
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] nums = { 5, 7, 7, 8, 8, 10 };
		 int[] nums = { 2,2 };
		
		
//		int[] result = searchRange(nums, 8);
//		for (int i : result) {
//			System.out.print(i + " ");
//		}
	}

	/**
	 * ���ö��ֲ���˼��
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };

		result[0] = lowerBound(nums, target);
		result[1] = upperBound(nums, target);

		return result;
	}

	// -------------------------------------------------------------------------

	public static int lowerBound(int nums[], int target) {

		int low = 0, high = nums.length - 1;

		// ��ȡ���
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return target == nums[low] ? low : -1;
	}

	// ��ȡ�ҽ�

	public static int upperBound(int nums[], int target) {

		int low = 0, high = nums.length - 1;

		// ��ȡ�ҽ�
		while (low < high) {
			int mid = (low + (high - low) / 2) + 1;

			if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid;
			}
		}

		return target == nums[high] ? high : -1;
	}

	// ---------------------------------------------------------------------
}
