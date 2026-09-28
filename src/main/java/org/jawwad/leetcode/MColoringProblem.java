package org.jawwad.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {

    private boolean safeToColor(int node, int color, ArrayList<Integer>[] adj, int[] vis){

        for(int adjacentNode: adj[node]){
            if(vis[adjacentNode] == color){
                return false;
            }
        }

        return true;
    }

    private boolean graphColoring(int node, int n, ArrayList<Integer>[] adj, int[] vis, int m){
        if(node == n){
            return true;
        }

        for(int color = 1; color<=m; color++){
            if(safeToColor(node, color, adj, vis)){
                vis[node] = color;
                boolean flag = graphColoring(node+1, n, adj, vis, m);
                if(flag){
                    return true;
                }
                vis[node] = 0;
            }

        }

        return false;
    }

    boolean graphColoring(int n, int[][] edges, int m) {

        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i =0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].add(v);
            adj[v].add(u);
        }

        int[] vis = new int[n];

        for(int node = 0; node<n; node++){
            if(vis[node] == 0){
                boolean flag = graphColoring(node, n, adj, vis, m);
                if(!flag){
                    return false;
                }
            }
        }

        return true;

    }
}
