package no204.CountPrimes;

import javax.swing.text.StyledEditorKit.BoldAction;

/*
 Description:

 Count the number of prime numbers less than a non-negative number, n.

 Credits:
 Special thanks to @mithmatt for adding this problem and creating all test cases.

 */

/*
 ��Ŀ���ж�n���������ĸ��� ��ע���ǲ�����N,���׳���!!
 �Ѷȣ���
 ˼·��
 �����ⷨ: ������n�Ŀ���  Time Limit Exceeded  
 ����Ҫ�����Ż�....

 ������ν Sieve of Eratosthenes �㷨���뷨�ܵ�������ʵ�ֺܼ򵥣�
 public int countPrimes(int n) {
 boolean[] isPrime = new boolean[n];
 for (int i = 2; i < n; i++) {
 isPrime[i] = true;
 }
 // Loop's ending condition is i * i < n instead of i < sqrt(n)
 // to avoid repeatedly calling an expensive function sqrt().
 for (int i = 2; i * i < n; i++) {
 if (!isPrime[i]) continue;
 for (int j = i * i; j < n; j += i) {
 isPrime[j] = false;
 }
 }
 int count = 0;
 for (int i = 2; i < n; i++) {
 if (isPrime[i]) count++;
 }
 return count;
 }

 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(countPrimes2(11));

	}

	// Time Limit Exceeded
	public static int countPrimes1(int n) {
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}

		return count;

	}

	public static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	// --------------------------------------------------------------------]
	// ��ѹ��˷�

	// N������������
	public static int countPrimes2(int n) {
		// ���� �� 2-N ����������Ԫ�س���Ϊ������
		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}
		
		//�㷨��Ҫʵ��----˫ѭ�����ɾ��
		// Loop's ending condition is i * i < n instead of i < sqrt(n)
		// to avoid repeatedly calling an expensive function sqrt().
		for (int i = 2; i * i < n; i++) {
			if (!isPrime[i])
				continue;
			for (int j = i * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}
		
		//ͳ��
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i])
				count++;
		}
		return count;
	}

}
