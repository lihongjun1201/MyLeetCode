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
 You may assume k is always valid, 1 �� k �� number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.*/

/*��Ŀ�� ����һ���ǿ��������飬������ǰk�����ִ�������Ԫ�ء�
 *   ���տ�ʼ������Ŀ��˼���������Ϊ��--�ҳ������г���k�ε�����Ԫ�أ�
 �Ѷȣ�easy
 ˼·:hashtable + ��
 ������������Ԫ�� ���� Ƶ�� ����hashmap
 Ȼ��ά��һ���ѣ�ȡƵ������ǰK�����ɡ�
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
		//����Ԫ�ؼ���Ƶ�ʴ���map
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			Integer frequence = map.getOrDefault(i, 0);
			map.put(i, ++frequence);
		}

		List<Integer> topKfreqResult = new ArrayList<>();

		//Ҫ�ҳ�topK ����K������Ҫά��һ��K��Ԫ�ص�С���ѣ�����Ԫ�����ν��ѣ�ÿ�ζ���̭�Ѷ���СԪ�أ����ʣ�µ�K����Ϊ����K��
		PriorityQueue<Map.Entry<Integer, Integer>> heap
				= new PriorityQueue<>((a, b) -> a.getValue()-b.getValue()); //lambda���ʽ:Ƶ�ʸߵ�����

		
		
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
