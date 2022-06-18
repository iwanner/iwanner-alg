package com.iwanner.leetcode.offer;

/**
 * https://leetcode.cn/problems/4ueAj6/
 *
 * @author wangtao
 * @since 2022/6/18
 */
public class Offer029 {
    public Node insert(Node head, int insertVal) {
        if (null == head) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        if (head.next == head) {
            head.next = new Node(insertVal);
            head.next.next = head;
            return head;
        }
        Node cur = head;
        Node p;
        while (true) {
            // 1.循环到头或者找到下降的点时，目标值可以大于当前点或者小于起始点
            // 2.目标值处于两个升序节点的中间
            if (((cur.next == head || cur.next.val < cur.val)
                    && (cur.val <= insertVal || cur.next.val >= insertVal))
                    || (cur.next.val >= insertVal && cur.val <= insertVal)) {
                p = cur.next;
                cur.next = new Node(insertVal);
                cur.next.next = p;
                return head;
            }
            cur = cur.next;
        }
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
