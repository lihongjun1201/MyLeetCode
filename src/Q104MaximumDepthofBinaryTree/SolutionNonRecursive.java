package Q104MaximumDepthofBinaryTree;

import java.util.HashMap;
import java.util.Stack;

import org.omg.CORBA.portable.ValueInputStream;

public class SolutionNonRecursive {

	//Accepted
	public static int maxDepth(TreeNode root) {
		//�пղ���©����Ȼ�� RUNTIME ERROR
		if (root == null) {
			return 0;
		}
		
		Stack<Pair<TreeNode,Integer>> stack = new Stack<Pair<TreeNode,Integer>>();
		Pair<TreeNode,Integer> pair = new Pair(root, 1);
		stack.push(pair);
		
		int maxdepth = 0;
		while (!stack.isEmpty()) {
			int currentDepth = stack.peek().second;
			
			if (currentDepth > maxdepth) {
				maxdepth = currentDepth;
			}
			
			TreeNode popNode = stack.pop().first;
			
			if (popNode.left != null) {
				stack.push(new Pair(popNode.left, currentDepth + 1));
			}
			
			if (popNode.right != null) {
				stack.push(new Pair(popNode.right, currentDepth + 1));
			}
		}
		
		return maxdepth;
	}
	
}

/**
 * ���ڵ� �� ���������� pair
 * @author AllenLee
 *
 * @param <K>
 * @param <V>
 */
class Pair<K,V> {
	K first;
	V second;
	
	public Pair(K first, V second) {
		super();
		this.first = first;
		this.second = second;
	}
	
	
}