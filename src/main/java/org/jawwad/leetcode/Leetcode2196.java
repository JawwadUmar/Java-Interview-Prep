package org.jawwad.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Leetcode2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
        Map<Integer, TreeNode> mp = new HashMap<>();
        Set<Integer> st = new HashSet<>();

        for(int i = 0; i<n; i++){
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int isLeft = descriptions[i][2];
            TreeNode parentNode;
            TreeNode childNode;

            if(mp.containsKey(parent)){
                parentNode = mp.get(parent);
            }
            else{
                parentNode = new TreeNode(parent);
            }

            if(mp.containsKey(child)){
                childNode = mp.get(child);
            }
            else{
                childNode = new TreeNode(child);
            }

            if(isLeft == 1){
                parentNode.left = childNode;
            }
            else{
                parentNode.right = childNode;
            }


            mp.put(parent, parentNode);
            mp.put(child, childNode);
            st.add(child);
        }

        for(int key:mp.keySet()){
            if(!st.contains(key)){
                return mp.get(key);
            }
        }

        return null;
    }
}