package Q237DeleteNodeinaLinkedList;


/*
 * Q: 237  Delete Node in a Linked List
 * Write a function to delete a node (except the tail) in a singly linked list
 * given only access to that node.
 * 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 * 
 *
 * �ⷨ����Ҫɾ���Ľڵ� ����һ�� �ڵ��ֵ ����Ҫɾ���Ľڵ㣬Ȼ��Ҫɾ���Ľڵ�ָ����һ���ڵ����һ�����ɡ�
 * �Ѷȣ� Easy
 * ״̬�� AC
 * 
 * 
 * 
 *
*/
public class Solution {
	
	public static void main(String[] args) {
		
		
		
	}
	
	public void deleteNode(ListNode node) {
		if (node == null) {
			return;
		}
		
		ListNode nextNode = node.next;
		node.val = nextNode.val;
		node.next = nextNode.next;
		
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

}