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

 难度：Easy
 结果： AC

 思路: 1.直接用java集合方法求并集 （my thought...）

 参考：
 2.分别排序两个数组，然后归并放入set 
 3.二分查找

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

	// 方法一：AC O(n)
	public static int[] intersection(int[] nums1, int[] nums2) {

		// 利用java 集合快速解决
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

	// 方法一： AC
	// 先排序，后归并到set O(nlogn)
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
	 * 方法三：Accepted
	 * 
	 * 二分查找 将其中一个数组排序，在另一个数组中查找 有序数组中出现的数字，加入set即可 O(nlogn)
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
