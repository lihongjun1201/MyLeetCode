package no338.CountingBits;

/*
 Given a non negative integer number num. 
 For every numbers i in the range 0 ≤ i ≤ num 
 calculate the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:

 It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
 But can you do it in linear time O(n) /possibly in a single pass?
 Space complexity should be O(n).
 Can you do it like a boss?
 Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 0: 
 0000  0
 
 1:    1
 0001  

 2-3:   
 0010  1
 0011  2
 
 4-7:   
 0100  1
 0101  2
 0110  2
 0111  3

8-15:  
8  1000  1
9  1001  2
10 1010  2
11 1011  3
12 1100  2
13 1101  3
14 1110  3
15 1111  4

 */

//思路： 划分区间 ， 2-3 ，4-7， 8-15

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] result = countBits(10);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	
	/**
	 * Accepted 
	 * @param num
	 * @return
	 */
	public static int[] countBits(int num) {
		  int[] answer = new int[num+1];
	        int offset = 1;
	        for(int i = 1; i < answer.length; i++){
	            if(offset * 2 == i) offset *= 2;
	            answer[i] = 1 + answer[i - offset];
	        }
	        return answer;
	}

}
