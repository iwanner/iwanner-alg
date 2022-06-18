package com.iwanner.algorithms.sort;

/**
 * <p>选择排序：在数组中找到最小的元素，然后将其与第一个位置交换，其次，在剩下的元素中找到最小的元素与第二个位置交换，如此往复直至整个数据有序。</p>
 *
 * @author wangtao
 * @since 2022/6/18
 */
public class Selection<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    void sort(T[] a) throws UnsupportedOperationException {
        int i = 0;
        int target;
        while (i < a.length) {
            target = i;
            for (int j = i; j < a.length; j++) {
                if (lessThan(a[j], a[target])) target = j;
            }
            exchange(a, i, target);
            i++;
        }
    }
}
