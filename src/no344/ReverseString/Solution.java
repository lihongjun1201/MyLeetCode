package no344.ReverseString;

/*Total Accepted: 30489 Total Submissions: 52190 Difficulty: Easy

 Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".

��Ŀ����ת�ַ���
�Ѷȣ���
˼·�� ����һ��ͷβ�������ɡ�
	�������� �ݹ鴦���ο���
״̬��AC
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
	 * ����һ��ͷβ����
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
	 * �ݹ鴦��
	 * ���ϵݹ黮���ַ��������Һ���
	 * ���Ӵ�ֻʣ��һ���ַ�ʱ����
	 * ���ս�����ǣ� ���Ҵ���...��������
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
