package com.iwanner.leetcode.middle;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/find-kth-largest-xor-coordinate-value/
 *
 * @author wangtao
 * @since 2022/6/17
 */
public class Q1738 {

    /**
     * 1 1 1 1
     * 1 1 1 1
     * 1 1 1 1
     * 1 1 1 1
     */
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = matrix[i][j];
                if (j - 1 >= 0) {
                    dp[i][j] = dp[i][j] ^ dp[i][j - 1];
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int cur = dp[0][i];
            for (int j = 1; j < matrix.length; j++) {
                cur = cur ^ dp[j][i];
                queue.add(cur);
            }
        }
        while (k > 1) {
            queue.poll();
            k--;
        }
        return queue.isEmpty() ? -1 : queue.peek();
    }

}
