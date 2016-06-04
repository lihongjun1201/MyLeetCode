package no191.Numberof1Bits;

import javax.print.attribute.standard.RequestingUserName;

import org.omg.CORBA.IRObject;

/*
 Write a function that takes an unsigned integer ��ע�����޷��ţ�
 and returns the number of ��1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ��11'
 has binary representation 00000000000000000000000000001011,
 so the function should return 3.*/

/*
 ��Ŀ��ͳ���޷��������Ķ����Ʊ�ʾ��1�ĸ���
 �Ѷȣ���
 ˼·���������ƣ������ƺ�Ľ��mod2�����������λλһ��ֱ����Ϊ0*/

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
		long unsignedValue = n & 0xffffffffl; // ��n�����޷�������

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
