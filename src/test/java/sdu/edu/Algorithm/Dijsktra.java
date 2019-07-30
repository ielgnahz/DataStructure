package sdu.edu.Algorithm;

import java.util.Arrays;
import java.util.Scanner;

/*
 *
编号从１开始(有向图)
请输入节点数
6
请输入边数
8
请输入边的详细信息
0 2 10
0 4 30
0 5 100
1 2 5
2 3 50
3 5 10
4 5 60
4 3 20
v0-->v0=0
v0-->v2-->v1=15
v0-->v2=10
v0-->v4-->v3=50
v0-->v4=30
v0-->v4-->v3-->v5=60

请输入节点数(无向图)
9
请输入边数
15
请输入边的详细信息
0 1 1
0 2 5
1 2 3
1 3 7
1 4 5
2 4 1
2 5 7
3 4 2
3 6 3
4 6 6
4 7 9
4 5 3
5 7 5
6 7 2
6 8 7
v0-->v0=0
v0-->v1=1
v0-->v1-->v2=4
v0-->v1-->v2-->v4-->v3=7
v0-->v1-->v2-->v4=5
v0-->v1-->v2-->v4-->v5=8
v0-->v1-->v2-->v4-->v3-->v6=10
v0-->v1-->v2-->v4-->v3-->v6-->v7=12
v0-->v1-->v2-->v4-->v3-->v6-->v7-->v8=16
 */
public class Dijsktra {

    static int[][] matrix;
    static int[] preNode;
    static int[] mindist;
    static boolean[] vis;

    public static void createGraph(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        matrix = new int[n][n];
        preNode = new int[n];
        mindist = new int[n];
        vis = new boolean[n];

        for(int i = 0;i < n;i++){
            for(int j = 0;j <n;j++){
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

        for(int i = 0;i < n;i++){
            mindist[i] = Integer.MAX_VALUE;
        }
    }

    public static void dijsktra(int vs){

        int minId = vs;
        int minWeight = 0;

        for(int i = 1;i < mindist.length;i++){
            mindist[i] = matrix[0][i];
            preNode[i] = 0;
        }

        vis[vs] = true;
        for(int i = 1;i < mindist.length;i++){
            minId = 0;
            minWeight = Integer.MAX_VALUE;
            for(int j = 1;j <mindist.length;j++){
                if(!vis[j] && minWeight > mindist[j]){
                    minId = j;
                    minWeight = mindist[j];
                }
            }
            vis[minId] = true;

            for(int k = 1; k <mindist.length; k++){
                if(!vis[k] && matrix[minId][k] != Integer.MAX_VALUE && mindist[k] > minWeight + matrix[minId][k]){
                    mindist[k] = minWeight +matrix[minId][k];
                }
            }
        }

        for(int i = 0;i < mindist.length;i++){
            int si = i;
            String str = "v" + si;
            while(preNode[si] != vs){
                str = "v" + si + "-->" + str;
            }
            System.out.println("v" + vs + "-->" + str + "=" + mindist[i]);
        }
    }


    public static void main(String[] args) {
        Dijsktra.createGraph();
        Dijsktra.dijsktra(0);
    }


}
