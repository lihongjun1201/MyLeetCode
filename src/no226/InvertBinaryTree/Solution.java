package no226.InvertBinaryTree;

import java.util.Stack;

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
 but you can’t invert a binary tree on a whiteboard so fuck off.

 题目：翻转二叉树
 难度：简单...(一次写出来了，可以进google了哈哈哈哈~~~ --~？）
 思路：
 方法一：递归处理 （my way）
 方法二：非递归利用栈处理

 状态： Accepted 

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
		
		TreeNode node0 = new TreeNode(0);
		TreeNode node5 = new TreeNode(-5);
		
		node0.left = node5;
		
		TreeNode node00 = new TreeNode(00);
		TreeNode node8 = new TreeNode(-8);
		node00.left = node8;
		
		boolean issame = isSameTree(node0, node00);
		System.out.println(issame);

	}

	/**
	 * 我的方法，递归处理
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
	// 参考高手
	public static TreeNode invertTree2(TreeNode root) {
		if (root == null)
			return null;

		// 递归到最后 需要做的仅仅是交换根的左右子树
		TreeNode tmpleft = root.left; // 暂存根的左子树
		root.left = invertTree2(root.right); // 返回时 根的左子树已经改变，所以需要暂存
		root.right = invertTree2(tmpleft);
		return root;

	}

	/**
	 * 递归方法好理解，但是容易造成 stackoverflow 所以利用栈进行非递归处理，能更健壮
	 * 
	 * 类似层次遍历 状态 AC
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode invertTree_stack(TreeNode root) {
		if (root == null) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		// 从顶层到底层不断的交换左右子树即可
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

	
	/**
	 * 递归判断两个树是否结构和数据一致
	 * 状态 Accepted
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if ( (p == null && q != null) || p != null && q == null ) {
			return false;
		}
		
		
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) ;
		}
		
		return false;
	}

}
