package com.practices.trees;

import java.util.*;

class AllPossibleFullBinaryTrees {

    static public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if(N==1){
            res.add(new TreeNode(0));
            return res;
        }
        N=N-1;
        for(int i = 1; i < N; i += 2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N-i);
            for(TreeNode nl: left){
                for(TreeNode nr:right){
                    TreeNode cur = new TreeNode(0);
                    cur.left=nl;
                    cur.right=nr;
                    res.add(cur);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

        LinkedList<TreeNode> q = new LinkedList<>();

        allPossibleFBT(7).forEach(n ->
                {
                    q.add(n);
                    System.out.print("root (0) -> ");
                    int level = 0;
                    while (!q.isEmpty()) {
                        level++;
                        TreeNode cur = q.pollLast();
                        if (cur.left != null) {
                            System.out.print("left ("+level+") -> ");
                            q.add(cur.left);
                        }
                        if (cur.right != null) {
                            System.out.print("right ("+level+") -> ");
                            q.add(cur.right);
                        }
                    }
                    System.out.println("");
                }
        );
    }
}