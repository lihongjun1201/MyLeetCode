package no112.PathSum;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*Given a binary tree and a sum,
 determine if the tree has a root-to-leaf path such that adding up all the values along the path 
 equals the given sum.

 For example:
 Given the below binary tree and sum = 22,*/

/*题目：判断二叉树从根到叶子节点的所有点之和等于给定的数值
 难度：easy
 思路：递归 / 非递归
 状态： 
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode n5 = new TreeNode(5);

		TreeNode n4a = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		n5.left = n4a;
		n5.right = n8;

		TreeNode n11 = new TreeNode(11);
		n4a.left = n11;

		TreeNode n13 = new TreeNode(13);
		TreeNode n4b = new TreeNode(4);
		n8.left = n13;
		n8.right = n4b;

		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2);
		n11.left = n7;
		n11.right = n2;

		TreeNode n1 = new TreeNode(1);
		n4b.right = n1;
		// -------------------------------------

		Stack<Integer> stack = new Stack<>();
		// System.out.println(preTraverse(n5,stack,22));
		System.out.println("该树：" + hasPathSum(n5, 22));
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node1.left = node2;
		System.out.println("该树：" + hasPathSum(node1, 1));
		
		
	}

	//  Accepted 
	//深度优先遍历(树的先序遍历，每次遍历时将sum - curNode.val ，如果减到0，则证明有一条路径满足条件)
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root != null  ) {
			System.out.println(root.val);
			if ( (sum - root.val) == 0 && root.left == null && root.right == null ) { //保证叶子节点
				return true;
			}
			
			return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
		}
		
		return false;
	}
	
	
	

	//---------------------------------------------------------------------
	// 利用深度优先遍历 (测试答案是对的，但该方式会超时)
	public static boolean hasPathSum2(TreeNode root, int sum) {
		Stack<Integer> sumStack = new Stack<>();
		List<Boolean> hasOnePath = new ArrayList<>();
		preTraverse(root, sumStack, sum, hasOnePath);

		if (!hasOnePath.isEmpty()) {
			return true;
		}

		return false;
	}

	public static boolean preTraverse(TreeNode root, Stack<Integer> stack,
			int sum, List<Boolean> hasOnePath) {
		if (root != null) {
			stack.push(root.val);

			int currentSum = 0;
			for (Iterator iterator = stack.iterator(); iterator.hasNext();) {
				Integer intNum = (Integer) iterator.next();
				currentSum += intNum;

				if (currentSum == sum) {
					hasOnePath.add(true);
					return true;
				}
			}

			preTraverse(root.left, stack, sum, hasOnePath);

			if (root.left == null && root.right == null && !stack.isEmpty()) {
				stack.pop();
			}

			preTraverse(root.right, stack, sum, hasOnePath);

			return false;
		}

		return false;

	}
	//--------------------------------------------------------------------------------------
	
	
	

}
