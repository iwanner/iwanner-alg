package com.iwanner.algorithms.sort;

import java.util.Arrays;

/**
 * <p>不同排序算法的运行模板</p>
 *
 * @author wangtao
 * @since 2022/6/18
 */
public class BaseSort<T extends Comparable<T>> {

    public static void main(String[] args) {
        Integer[] a = {4, 5, 2, 8, 2, 4, 1, 3, 0, 34};
        Selection<Integer> selection = new Selection<>();
        selection.sort(a);
        assert selection.isSorted(a);
        selection.show(a);
    }

    void sort(T[] a) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("sort() must be override");
    }

    boolean lessThan(T v, T u) {
        return v.compareTo(u) < 0;
    }

    void show(T[] a) {
        System.out.println(Arrays.toString(a));
    }

    boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (lessThan(a[i], a[i - 1])) return false;
        }
        return true;
    }

    void exchange(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
