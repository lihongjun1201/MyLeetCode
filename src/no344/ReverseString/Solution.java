package no344.ReverseString;

/*Total Accepted: 30489 Total Submissions: 52190 Difficulty: Easy

 Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".

题目：反转字符串
难度：简单
思路： 方法一：头尾交换即可。
	方法二： 递归处理（参考）
状态：AC
https://github.com/lihongjun1201/MyLeetCode.git
 *
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello";
		System.out.println(reverseString(s));
		System.out.println(reverseString_recursive(s));
	}

	/**
	 * 方法一：头尾交换
	 * @param s
	 * @return
	 */
	public static String reverseString(String s) {
		if (s == null) {
			return null;
		}
		
		char[] str = s.toCharArray();
		int head = 0, tail = s.length() - 1;
		
		while (head <= tail) {
			char temp = str[head];
			str[head] = str[tail];
			str[tail] = temp;
			head++;
			tail--;
		}
		
		return new String(str);
		
	}
	
	/**
	 * 递归处理
	 * 不断递归划分字符串，先右后左
	 * 当子串只剩下一个字符时返回
	 * 最终结果即是： 最右次右...次左最左
	 * @param s
	 * @return
	 */
	public static String reverseString_recursive(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString_recursive(rightStr) + reverseString_recursive(leftStr);
    }
	
	

}
