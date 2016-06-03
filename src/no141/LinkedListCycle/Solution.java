package no141.LinkedListCycle;

import java.awt.TexturePaint;

/*Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */

/*
 * 题目：判断链表有环 难度：简单 思路：快慢指针 有环必会套圈！
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		
		n1.next = n2;
		n2.next = n3;
		
		System.out.println(hasCycle(n1));

	}

	
	//Accepted 
	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				return true;
			}
		}
		
		return false;
		
	}

}
