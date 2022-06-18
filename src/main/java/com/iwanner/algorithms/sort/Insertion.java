package com.iwanner.algorithms.sort;

/**
 * <p>插入排序：从第一个元素开始，依次将每个元素插入到左侧适合的位置，遍历过程中保证当前位置左侧序列为有序</p>
 *
 * @author wangtao
 * @since 2022/6/18
 */
public class Insertion<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    void sort(T[] a) throws UnsupportedOperationException {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0 && lessThan(a[j], a[j - 1]); j--) {
                exchange(a, j - 1, j);
            }
        }
    }
}
