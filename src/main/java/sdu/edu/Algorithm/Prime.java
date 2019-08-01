package sdu.edu.Algorithm;

import java.util.Scanner;

/**
 * Prim是计算最小生成树的算法，比如为N个村庄修路，怎么修花销最少。
 * Prim算法的更新操作更新的dist[]是已访问集合到未访问集合中各点的距离；
 */
public class Prime {

    static int[][] matrix;
    static int[] mindist;
    static boolean[] vis;

    public static void createGraph(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        matrix = new int[n][n];
        mindist = new int[n];
        vis = new boolean[n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                matrix[i][j] = Integer.MAX_VALUE;
                if(i == j) matrix[i][j] = 0;
            }
        }
        for(int i = 0;i < m;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            matrix[x][y] = z;
            matrix[y][x] = z;
        }
        for(int i = 0;i < n;i++){
            mindist[i] = matrix[0][i];
        }
    }

    public static void prime(){
        vis[0] = true;
        int sum = 0;
        for(int i = 1;i <matrix.length;i++){
            int minId = 0;
            int minWeight = Integer.MAX_VALUE;
            for(int j = 1;j <matrix.length;j++){
                if(!vis[j] && mindist[j] < minWeight){
                    minWeight = mindist[j];
                    minId = j;
                }
            }
            vis[minId] = true;
            System.out.println("连接到"+minId+"权值为"+minWeight);
            sum += minWeight;
            for(int j = 1;j < matrix.length;j++){
                if(!vis[j] && matrix[minId][j] < mindist[j]){
                    mindist[j] = matrix[minId][j];
                }
            }
        }
        System.out.println("总花费为" + sum);
    }
}
