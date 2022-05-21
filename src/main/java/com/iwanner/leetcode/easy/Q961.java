package com.iwanner.leetcode.easy;

/**
 * https://leetcode.cn/problems/n-repeated-element-in-size-2n-array
 *
 * @author wangtao
 * @since 2022/5/21
 */
public class Q961 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 5, 2};
        System.out.println(new Q961().repeatedNTimes(nums));
    }

    public int repeatedNTimes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
