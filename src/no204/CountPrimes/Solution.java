package no204.CountPrimes;

import javax.swing.text.StyledEditorKit.BoldAction;

/*
 Description:

 Count the number of prime numbers less than a non-negative number, n.

 Credits:
 Special thanks to @mithmatt for adding this problem and creating all test cases.

 */

/*
 题目：判断n以内素数的个数 （注意是不包含N,容易出错）!!
 难度：简单
 思路：
 正常解法: 迭代到n的开方  Time Limit Exceeded  
 所以要继续优化....

 这是所谓 Sieve of Eratosthenes 算法。想法很吊，代码实现很简单！
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
	// 最佳过滤法

	// N以内素数个数
	public static int countPrimes2(int n) {
		// 创建 从 2-N 的数表，所有元素初设为非素数
		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}
		
		//算法主要实现----双循环间隔删除
		// Loop's ending condition is i * i < n instead of i < sqrt(n)
		// to avoid repeatedly calling an expensive function sqrt().
		for (int i = 2; i * i < n; i++) {
			if (!isPrime[i])
				continue;
			for (int j = i * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}
		
		//统计
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i])
				count++;
		}
		return count;
	}

}
