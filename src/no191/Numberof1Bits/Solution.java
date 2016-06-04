package no191.Numberof1Bits;

import javax.print.attribute.standard.RequestingUserName;

import org.omg.CORBA.IRObject;

/*
 Write a function that takes an unsigned integer （注意是无符号）
 and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11'
 has binary representation 00000000000000000000000000001011,
 so the function should return 3.*/

/*
 题目：统计无符号整数的二进制表示中1的个数
 难度：简单
 思路：不断右移，将右移后的结果mod2，能整除则该位位一，直到商为0*/

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(hammingWeight(0));
		// System.out.println(hammingWeight(1));
		System.out.println(hammingWeight(5));
		System.out.println(hammingWeight(8));
		System.out.println(hammingWeight(11));

	}

	// you need to treat n as an unsigned value
	// Accepted 
	public static int hammingWeight(int n) {
		long unsignedValue = n & 0xffffffffl; // 将n当做无符号整数

		int count = 0;
		while (unsignedValue != 0) {
			if ((unsignedValue % 2) != 0) {
				count++;
			}
			unsignedValue = unsignedValue >>> 1;
		}

		return count;
	}

}
