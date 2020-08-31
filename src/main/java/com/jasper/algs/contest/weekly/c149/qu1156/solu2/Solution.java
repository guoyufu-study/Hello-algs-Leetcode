package com.jasper.algs.contest.weekly.c149.qu1156.solu2;

/**
 * 1156. 单字符重复子串的最大长度
 * 
 * <p> 滑动窗口
 */
class Solution {
	public int maxRepOpt1(String text) {
        char[] word = text.toCharArray();
        int[] winCount = new int[26]; //统计窗口内的各个字符出现的次数
        int[] charCount = new int[26];//统计在text中各个字符出现的次数
        for(char c:word) charCount[c - 'a']++;
        int maxChar = 0;
        int start = 0,maxWin = 0,maxCount = 0;
        for(int i = 0;i < word.length;i++){
            int c = word[i] - 'a';
            winCount[c]++;
            if(winCount[c] > maxCount){//判断是否扩大当前窗口
                maxChar = c;
                maxCount = winCount[c];
                maxWin = maxCount + 1;
            }
            //判断窗口是否需要滑动
            //如果是"ab"、"aab"这种，遍历到"b"时，由于"b"在窗口范围内，所以不用滑动
            //如果是"aabcaa"，虽然窗口在滑动过程中，会出现窗口内容是"abc",但显然不影响结果
            else if(i - start + 1 > maxWin){
                winCount[word[start] - 'a']--;
                start++;
            }
        }
        //避免"aa"、"aba"这种无法进行字符替换的
        return Math.min(maxWin,charCount[maxChar]);
    }
}