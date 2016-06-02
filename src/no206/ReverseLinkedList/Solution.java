package no206.ReverseLinkedList;

/*Reverse a singly linked list.
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * 
 * 题目：反转链表
 * 难度：简单
 * 
 * 思路
 * 方法一：迭代  AC
 * 方法二：递归 （not yet） 
 *
 * 
 * 
 * 
 */

/**
 * Definition for singly-linked list.
 * 
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		showlist(n1);
		System.out.println();

		ListNode newHead = reverseList(n1);
		showlist(newHead);

	}

	/**
	 * 递归反转链表 (虽然通过，但自己写得逻辑比较乱...)
	 * Accepted 
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode currentNode = head;
		if (head.next != null) {  
			ListNode newhead = reverseList(head.next);

			if (newhead.next == null) { //遍历到最尾一个节点时 ，特殊处理
				newhead.next = currentNode;
				currentNode.next = null;
			} else {

				ListNode tail = null;  //找到返回的新逆序子链的末尾
				ListNode cur = newhead;
				while (cur != null) {
					tail = cur;
					cur = cur.next;
				}
				
				
				tail.next = currentNode;
				currentNode.next = null;  //将末尾置空，避免循环链表
			}
			return newhead;
			
		} else { //只有递归到最后一个节点时才会走这里，返回最后一个节点 ，其余都走上面代码
			return currentNode;
		}

	}

	public static void showlist(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	/**
	 * 迭代反转链表 Accepted
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode reverseList2(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode newhead = null;

		ListNode current = head;
		while (head != null) {
			head = head.next;

			if (newhead == null) { // 第一次插入节点需要特殊对待
				newhead = current;
				current.next = null;
			} else {
				current.next = newhead;
				newhead = current;
			}

			current = head;
		}

		return newhead;
	}

	// ---------------------------------------------------------

	/*
	 * 递归打印链表
	 */
	public static void showList(ListNode head) {
		if (head != null) {
			showList(head.next);
			System.out.print(head.val + " ");
		}

	}

}
