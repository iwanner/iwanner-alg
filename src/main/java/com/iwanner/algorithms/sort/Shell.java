package com.iwanner.algorithms.sort;

/**
 * <a href="https://baike.baidu.com/item/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F/3229428">希尔排序</a>
 *
 * @author wangtao
 * @since 2022/6/18
 */
public class Shell<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    void sort(T[] a) throws UnsupportedOperationException {
        int len = a.length;
        int h = 1;
        while (h < len / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j > 0 && lessThan(a[j], a[j - h]); j--) {
                    exchange(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

}
