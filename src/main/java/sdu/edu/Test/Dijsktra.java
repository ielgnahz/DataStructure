package sdu.edu.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Dijsktra {

    static int[][] matrix;
    static int[] mindist;
    static int[] preNode;
    static boolean[] vis;

    public static void createGraph(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        matrix = new int[n][n];
        mindist = new int[n];
        preNode = new int[n];
        vis = new boolean[n];

        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0;i < m;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            matrix[x][y] = z;
            matrix[y][x] = z;
        }

        for(int i = 1;i < n;i++){
            mindist[i] = matrix[0][i];
        }

        dijkstra(0);

    }

    public static void dijkstra(int vs){
        int minId = vs;
        int minWeight = 0;
        vis[vs] = true;
        for(int i = 1;i < mindist.length;i++){
            minId = vs;
            minWeight = Integer.MAX_VALUE;
            for(int j = 1;j < mindist.length;j++){
                if(!vis[j] && minWeight > mindist[j]){
                    minWeight = mindist[j];
                    minId = j;
                }
            }
            vis[minId] = true;
            for(int k = 1;k < mindist.length;k++){
                if(!vis[k] && matrix[minId][k] != Integer.MAX_VALUE && mindist[k] > minWeight + matrix[minId][k]){
                    mindist[k] = minWeight + matrix[minId][k];
                    preNode[k] = minId;
                }
            }
        }
        for(int i = 0;i < mindist.length;i++){
            int si = i;
            String str = "v" + si;
            while(vs != preNode[si]){
                str = "v" + preNode[si] + "-->" + str;
                si = preNode[si];
            }
            System.out.println("v" + vs + "-->" + str + " = " + mindist[i]);
        }
    }

    public static void main(String[] args) {
        createGraph();
    }


}
