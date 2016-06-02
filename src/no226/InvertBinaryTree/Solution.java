package no226.InvertBinaryTree;

import java.util.Stack;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

/*
 * Invert a binary tree.

 4
 /   \
 2     7
 / \   / \
 1   3 6   9


 to
 4
 /   \
 7     2
 / \   / \
 9   6 3   1

 Trivia:
 This problem was inspired by this original tweet by Max Howell:
 Google: 90% of our engineers use the software you wrote (Homebrew),
 but you can��t invert a binary tree on a whiteboard so fuck off.

 ��Ŀ����ת������
 �Ѷȣ���...(һ��д�����ˣ����Խ�google�˹�������~~~ --~����
 ˼·��
 ����һ���ݹ鴦�� ��my way��
 ���������ǵݹ�����ջ����

 ״̬�� Accepted 

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

		TreeNode node4 = new TreeNode(4);

		TreeNode node2 = new TreeNode(2);
		TreeNode node7 = new TreeNode(7);

		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);

		TreeNode node6 = new TreeNode(6);
		TreeNode node9 = new TreeNode(9);

		node4.left = node2;
		node4.right = node7;

		node2.left = node1;
		node2.right = node3;

		node7.left = node6;
		node7.right = node9;

		invertTree2(node4);

		System.out.println("...");
	}

	/**
	 * �ҵķ������ݹ鴦��
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode newRoot = null;
		TreeNode parent = null;
		TreeNode current = root;

		if (current.left != null) {
			invertTree(current.left);
		}

		if (current.right != null) {
			invertTree(current.right);
		}

		parent = current;
		TreeNode temp = current.left;
		parent.left = current.right;
		parent.right = temp;
		newRoot = parent;
		return newRoot;
	}

	// --------------------------------------------------------------------------------
	// �ο�����
	public static TreeNode invertTree2(TreeNode root) {
		if (root == null)
			return null;

		// �ݹ鵽��� ��Ҫ���Ľ����ǽ���������������
		TreeNode tmpleft = root.left; // �ݴ����������
		root.left = invertTree2(root.right); // ����ʱ �����������Ѿ��ı䣬������Ҫ�ݴ�
		root.right = invertTree2(tmpleft);
		return root;

	}

	/**
	 * �ݹ鷽�������⣬����������� stackoverflow ��������ջ���зǵݹ鴦�����ܸ���׳
	 * 
	 * ���Ʋ�α���
	 * ״̬ AC
	 * @param root
	 * @return
	 */
	public static TreeNode invertTree_stack(TreeNode root) {
		if (root == null) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		//�Ӷ��㵽�ײ㲻�ϵĽ���������������
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			TreeNode leftchild = node.left;
			TreeNode rightchild = node.right;
			node.left = rightchild;
			node.right = leftchild;

			if (leftchild != null) {
				stack.push(leftchild);
			}

			if (rightchild != null) {
				stack.push(rightchild);
			}

		}

		return root;

	}

}