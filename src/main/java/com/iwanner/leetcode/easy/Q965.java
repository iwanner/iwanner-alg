package com.iwanner.leetcode.easy;

/**
 * https://leetcode.cn/problems/univalued-binary-tree/
 *
 * @author wangtao
 * @since 2022/5/24
 */

public class Q965 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode(1);
        System.out.println(new Q965().isUnivalTree(root));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

    }

    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, -1);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) return true;
        if (val == -1) return isUnivalTree(root, root.val);
        if (root.val == val) {
            return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
        }
        return false;
    }
}
