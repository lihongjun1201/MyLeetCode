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
 * 解法：将要删除的节点 的下一个 节点的值 赋予要删除的节点，然后要删除的节点指向下一个节点的下一个即可。
 * 难度： Easy
 * 状态： AC
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