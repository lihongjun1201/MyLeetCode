package no242.ValidAnagram;

import java.awt.Frame;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.spi.FormatConversionProvider;

/*Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?

 * 
 *
 */

/*题目：判断两个字符串 是否是 同字母不同组成 ？
 难度：easy
 思路：将s，t单词中的各个字母及其频率 存入两个hashmap，判断这两个映射是否相同即可
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram", t = "nagaram";
		
		System.out.println(isAnagram(s,t));
	}
	
	
	

	public static boolean isAnagram(String s, String t) {
		if (s == null || t == null) {
			return false;
		}

		Map<Character, Integer> charMapA = new HashMap<Character, Integer>();
		Map<Character, Integer> charMapB = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (!charMapA.containsKey(s.charAt(i))) {
				charMapA.put(s.charAt(i), 1);
			} else {
				int showUpTimes = charMapA.get(s.charAt(i));
				charMapA.put(s.charAt(i), ++showUpTimes);
			}
		}

		for (int i = 0; i < t.length(); i++) {
			if (!charMapB.containsKey(t.charAt(i))) {
				charMapB.put(t.charAt(i), 1);
			} else {
				int showUpTimes = charMapB.get(t.charAt(i));
				charMapB.put(t.charAt(i), ++showUpTimes);
			}
		}

		return charMapA.equals(charMapB);

	}

}
