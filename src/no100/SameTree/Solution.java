package no100.SameTree;

import java.util.Deque;
import java.util.LinkedList;

/*Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical
 and the nodes have the same value.

 ��Ŀ���ݹ��ж��������Ƿ�ṹ������һ��
 �Ѷȣ���
 ˼·��
 ����һ���ݹ��жϼ��ɣ�my way��
 ������������ջ ��������ж�

 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		node2.left = node3;
		node2.right = node4;

		TreeNode node2a = new TreeNode(2);
		TreeNode node4a = new TreeNode(4);
		
		node2a.right = node4a;

		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);

		boolean issame = isSameTree2(node2a, node2);
		System.out.println(issame);
	}
	
	/**
	 * �ݹ��ж��������Ƿ�ṹ������һ�� ״̬ Accepted
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if ((p == null && q != null) || p != null && q == null) {
			return false;
		}

		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}

		return false;
	}

	/**
	 * ����ջ�������  (�߼����壬д��̬�鷳�ˣ�
	 * Submission Result: Accepted 
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean isSameTree2(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if ((p == null && q != null) || p != null && q == null) {
			return false;
		}

		Deque<TreeNode> qdeque = new LinkedList<TreeNode>();
		Deque<TreeNode> pdeque = new LinkedList<TreeNode>();

		qdeque.offer(p);
		pdeque.offer(q);

		boolean isSame = false;
		while (!qdeque.isEmpty() && !pdeque.isEmpty()) {
			TreeNode leftnode = qdeque.poll();
			TreeNode rightnode = pdeque.poll();

			if (leftnode.val == rightnode.val) {
				isSame = true;

			} else {
				isSame = false;
				break;
			}

			// �������Ľڵ�ֱ������������
			if (leftnode.left != null) {
				qdeque.offer(leftnode.left);
				if (rightnode.left == null) {
					isSame = false;
					break;
				} else {
					pdeque.offer(rightnode.left);
				}
			} else {
				if (rightnode.left != null) {
					isSame = false;
					break;
				}
			}

			if (leftnode.right != null) {
				qdeque.offer(leftnode.right);
				if (rightnode.right == null) {
					isSame = false;
					break;
				} else {
					pdeque.offer(rightnode.right);
				}
			} else {
				if (rightnode.right != null) {
					isSame = false;
					break;
				}
			}
		}

		return isSame;

	}

}
