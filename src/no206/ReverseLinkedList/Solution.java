package no206.ReverseLinkedList;

/*Reverse a singly linked list.
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * 
 * ��Ŀ����ת����
 * �Ѷȣ���
 * ˼·��
 * ����һ������
 * ���������ݹ�
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

		ListNode newHead = reverseList2(n1);
		showlist(newHead);

	}

	/**
	 * �ݹ鷴ת����
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode newhead = head.next;
		ListNode beforeNode = head;
		if (head.next != null) {
			beforeNode = reverseList(head.next);
		}

		newhead = beforeNode;
		return beforeNode;
	}

	public static void showlist(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	/**
	 * ������ת����
	 * Accepted 
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

			if (newhead == null) { //��һ�β���ڵ���Ҫ����Դ�
				newhead = current;
				current.next = null;
			}
			else {
				current.next = newhead;
				newhead = current;
			}
			
			current = head;
		}
		
		return newhead;
	}

	// ---------------------------------------------------------

	/*
	 * �ݹ��ӡ����
	 */
	public static void showList(ListNode head) {
		if (head != null) {
			showList(head.next);
			System.out.print(head.val + " ");
		}

	}

}
