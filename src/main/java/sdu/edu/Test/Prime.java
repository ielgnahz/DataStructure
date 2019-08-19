package sdu.edu.Test;

import java.util.Scanner;

public class Prime {

    static int[][] matrix;
    static boolean[] vis;
    static int[] mindist;

    public static void createGraph(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        matrix = new int[n][n];
        vis = new boolean[n];
        mindist = new int[n];

        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(i == j) matrix[i][j] = 0;
                else matrix[i][j] = Integer.MAX_VALUE;
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
        Prime(0);
    }

    public static void Prime(int vs){
        int minId = vs;
        int minWeight = 0;
        vis[vs] = true;
        int n = mindist.length;
        int sum = 0;
        for(int i = 1;i < n;i++){
            minId = vs;
            minWeight = Integer.MAX_VALUE;
            for(int j = 1;j < n;j++){
                if(!vis[j] && mindist[j] < minWeight){
                    minWeight = mindist[j];
                    minId = j;
                }
            }
            vis[minId] = true;
            System.out.println("到达" + minId + "的权值为" + minWeight);
            sum += minWeight;
            for(int j = 1;j < n;j++){
                if(!vis[j] && mindist[j] > matrix[minId][j]){
                    mindist[j] = matrix[minId][j];
                }
            }
        }
        System.out.println("总权值为" + sum);
    }

    public static void main(String[] args) {
        createGraph();
    }

}
