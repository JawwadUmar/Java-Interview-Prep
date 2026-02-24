package org.jawwad.leetcode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Leetcode1022 {
    List<StringBuffer> paths = new ArrayList<>();
    void preorder(TreeNode root, StringBuffer sb){
        if(root == null){
            return;
        }
        sb.append(root.val);
        preorder(root.left, sb);
        preorder(root.right, sb);

        if(root.left == null && root.right == null){
            paths.add(new StringBuffer(sb));
        }

        sb.deleteCharAt(sb.length()-1);
    }

    public int sumRootToLeaf(TreeNode root) {

        StringBuffer sb = new StringBuffer();
        preorder(root, sb);
        List<Integer> values = paths.stream().map(n->Integer.parseInt(n.toString(), 2)).toList();

        return values.stream().reduce(0, Integer::sum);

    }
}
