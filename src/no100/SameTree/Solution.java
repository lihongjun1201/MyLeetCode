package no100.SameTree;




/*Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical
 and the nodes have the same value.

题目：递归判断两个树是否结构和数据一致
难度：简单
思路：递归判断即可

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
