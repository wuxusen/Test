package com.wxs.algorithm.week07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {


	public static void main(String[] args) {



		String beginWord = "hit", endWord = "cog";
		String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

		Solution solution = new Solution();

		int i = solution.ladderLength(beginWord, endWord, Arrays.asList(wordList));

		System.out.println(i);
	}





	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		if (!wordList.contains(endWord)) {
			return 0;
		}

		Set<String> dict = new HashSet<>(wordList);
		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();
		beginSet.add(beginWord);
		endSet.add(endWord);

		int step = 1;

		Set<String> visited = new HashSet<>();

		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}
			Set<String> temp = new HashSet<>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();
				for (int i = 0; i < chs.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);
						if (endSet.contains(target)) {
							return step + 1;
						}
						if (!visited.contains(target) && dict.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}
			beginSet = temp;
			step++;
		}
		return 0;
	}
}