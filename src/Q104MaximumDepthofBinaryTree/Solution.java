package Q104MaximumDepthofBinaryTree;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/*
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * �Ѷȣ�Easy
 * ״̬��AC
 * 
 * ˼·�� 1�� �ֱ�ݹ������� �� ������ ����󷵻����������нϴ����ȡ�
 * 	   2�� �ǵݹ鷽ʽ�� ��ջ����С����Ʋ�α���
 * 
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
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

	public static int maxDepth(TreeNode root) {
	
		
		/* �鷳���� AC	
		int maxleft = 0;
		int maxright = 0;
		
		if (root == null) {
			return 0;
		}
		
		if (root.left != null) {
			maxleft = maxDepth(root.left);
			
		}
		
		if (root.right != null) {
			maxright = maxDepth(root.right);
		}
		
		
		if (maxleft > maxright) {
			return maxleft + 1;
		}
		else {
			return maxright + 1;
		}*/
		
		//�򵥷��� һ�仰��������ȣ� AC
		return root != null ?  max(maxDepth(root.left),maxDepth(root.right)) + 1 : 0;
		
	}

	public static int max(int a,int b) {
		return a > b ? a : b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode9 = new TreeNode(9);
		TreeNode treeNode20 = new TreeNode(20);
		TreeNode treeNode15 = new TreeNode(15);
		TreeNode treeNode7 = new TreeNode(7);

		treeNode3.left = treeNode9;
		treeNode3.right = treeNode20;
		treeNode20.left = treeNode15;
		treeNode20.right = treeNode7;
		
		TreeNode treeNode0 = new TreeNode(0);
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		treeNode0.right = treeNode1;
		treeNode1.right = treeNode2;
		
//		System.out.println( maxDepth(treeNode3));
		System.out.println( SolutionNonRecursive.maxDepth(treeNode0));
		
	}

}
