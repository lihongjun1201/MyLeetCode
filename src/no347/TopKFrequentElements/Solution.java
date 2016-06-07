package no347.TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note: 
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.*/

/*题目： 给定一个非空整数数组，返回其前k个出现次数最多的元素。
 *   （刚开始理解错题目意思：错误的因为是--找出数组中出现k次的所有元素）
 难度：easy
 思路:hashtable + 堆
 将数组中所有元素 及其 频率 加入hashmap
 然后维护一个堆，取频率最大的前K个即可。
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		List<Integer> r = topKFrequent(nums, 2);
		for (Integer integer : r) {
			System.out.print(integer + " ");
		}

	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		//将各元素及其频率存入map
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			Integer frequence = map.getOrDefault(i, 0);
			map.put(i, ++frequence);
		}

		List<Integer> topKfreqResult = new ArrayList<>();

		//要找出topK 最大的K个，则要维护一个K个元素的小根堆，所有元素依次进堆，每次都淘汰堆顶最小元素，最后剩下的K个即为最大的K个
		PriorityQueue<Map.Entry<Integer, Integer>> heap
				= new PriorityQueue<>((a, b) -> a.getValue()-b.getValue()); //lambda表达式:频率高的优先

		
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			heap.offer(entry);
	        if(heap.size() > k) heap.poll();
	    }
		

		
		 while(!heap.isEmpty()) {
			 Entry<Integer, Integer> poll = heap.poll();
//				System.out.println(poll.getKey() + ": " + poll.getValue() );
		        topKfreqResult.add( heap.poll().getKey());
		        
		    }

		return topKfreqResult;
	}
}
