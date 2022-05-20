package com.iwanner.leetcode.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/find-right-interval
 *
 * @author wangtao
 * @since 2022/5/20
 */
public class Q436 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 4}, {2, 3}, {3, 4}
        };
        System.out.println(Arrays.toString(new Q436().findRightInterval(intervals)));
    }

    public int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        int[] result = new int[length];
        // 保存所有的 start
        int[] starts = new int[length];
        // 保存所有的 end
        int[] ends = new int[length];
        // 记录某个 start 开始出现的最小位置
        Map<Integer, Integer> startMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (!startMap.containsKey(intervals[i][0])) {
                startMap.put(intervals[i][0], i);
            }
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // 记录某个 end 右侧区间的 start 索引
        Map<Integer, Integer> endsResultMap = new HashMap<>();
        int i = 0, j = 0;
        while (i < length) {
            while (j < length && starts[j] < ends[i]) {
                j++;
            }
            if (j >= length) {
                break;
            }
            endsResultMap.put(ends[i], startMap.get(starts[j]));
            i++;
        }
        // 写入结果
        for (int k = 0; k < length; k++) {
            result[k] = endsResultMap.getOrDefault(intervals[k][1], -1);
        }
        return result;
    }
}
