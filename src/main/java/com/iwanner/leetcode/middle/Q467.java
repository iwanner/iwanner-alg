package com.iwanner.leetcode.middle;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/unique-substrings-in-wraparound-string
 *
 * @author wangtao
 * @since 2022/5/25
 */
public class Q467 {

    public static void main(String[] args) {
        System.out.println(new Q467().findSubstringInWraproundString("zabfgt"));
    }

    public int findSubstringInWraproundString(String p) {
        int len = p.length();
        if (len == 1) return 1;
        // 以26个字母为末尾的满足条件的最长子串长度
        int[] count = new int[26];
        // 循环找到相邻的字母
        int index = 1;
        int matchLen = 1;
        int last = p.charAt(len - 1) - 'a';
        while (index < len) {
            int i = p.charAt(index - 1) - 'a';
            if (close(p.charAt(index - 1), p.charAt(index))) {
                matchLen++;
                count[i] = Math.max(matchLen - 1, count[i]);
            } else {
                count[i] = Math.max(matchLen, count[i]);
                matchLen = 1;
            }
            index++;
        }
        count[last] = Math.max(matchLen, count[last]);
//        System.out.println(Arrays.toString(count));
        return Arrays.stream(count).sum();
    }

    private boolean close(char a, char b) {
        int abs = b - a;
        return abs == 1 || abs == -25;
    }

}
