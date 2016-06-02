package no349.IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.

 �Ѷȣ�Easy
 ����� AC

 ˼·: 1.ֱ����java���Ϸ����󲢼� ��my thought...��

 �ο���
 2.�ֱ������������飬Ȼ��鲢����set 
 3.���ֲ���

 */

public class Solution {

	public static void main(String[] args) {

		/*
		 * int[] a1 = { 1, 2, 2, 1 }; int[] a2 = { 2, 2 };
		 */
		int[] a1 = { 1, 2 };
		int[] a2 = { 2, 1 };

		int[] intersection = intersection2(a1, a2);
		for (int i = 0; i < intersection.length; i++) {
			System.out.print(intersection[i] + " ");
		}
	}

	// ����һ��AC O(n)
	public static int[] intersection(int[] nums1, int[] nums2) {

		// ����java ���Ͽ��ٽ��
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

		return result;
	}

	// ����һ�� AC
	// �����򣬺�鲢��set O(nlogn)
	public static int[] intersection2(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0, j = 0, k = 0;

		Set<Integer> set = new HashSet<Integer>();

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				set.add(nums1[i++]);
			}
		}

		int[] result = new int[set.size()];
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			result[k++] = integer;
		}

		return result;
	}

	/**
	 * ��������Accepted
	 * 
	 * ���ֲ��� ������һ��������������һ�������в��� ���������г��ֵ����֣�����set���� O(nlogn)
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersection3(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Set<Integer> set = new HashSet<>();

		for (int num : nums2) {
			if (Arrays.binarySearch(nums1, num) >= 0) {
				set.add(num);
			}
		}

		int i = 0;
		int[] result = new int[set.size()];
		for (Integer num : set) {
			result[i++] = num;
		}

		return result;

	}

}
