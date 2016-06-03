package no258.AddDigits;

/*Given a non-negative integer num,
 repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
 Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?*/

/*��Ŀ����һ�������ĸ���λ�ü��������ж�ֱ���ú�Ϊ��λ���򷵻�
 �Ѷȣ���
 ˼·������ѭ��˼��
 */

//Accepted 
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(addDigits(38));
	}

	public static int addDigits(int num) {
		int sum = 0;
		String strNum = String.valueOf(num); ;
		while (true) {
			for (int i = 0; i < strNum.length();i++) {
				sum += Integer.parseInt(strNum.substring(i, i+1));
				
			}
			
			if (sum < 10) {
				break;
			}
			else {
				strNum = String.valueOf(sum);
				sum = 0;
			}
			
		}
		return sum;
	}

}
