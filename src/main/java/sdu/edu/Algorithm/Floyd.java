package sdu.edu.Algorithm;

import java.util.Scanner;

public class Floyd {
    /**
     * d[i][j] 为i到j的最短路径的权值
     * p[i][j] 为i到j经过的第一个节点,下面的例子中p[1][6]为4，因为当k为8时，p[1][6] = p[1][8]，而p[1][8]的值在k = 5时已经确定为p[1][5]，而p[1][5]已经在k = 4时确定为p[1][4]，p[1][4]为4，所以之前的都为4
     *
     */
    /*
8 13
1 2 12
1 4 16
1 7 14
2 3 10
2 4 7
3 6 3
3 8 5
3 4 6
6 8 4
5 8 1
5 4 1
8 7 8
4 7 9
     */

    static int[][] d;
    static int[][] p;

    public static void createGraph(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        d = new int[n + 1][n + 1];
        p = new int[n + 1][n + 1];
        for(int i = 0;i < n + 1;i++){
            for(int j = 0;j < n + 1;j++){
                if(i == j){
                    d[i][j] = 0;
                }else{
                    d[i][j] = Integer.MAX_VALUE;
                }
                p[i][j] = j;
            }
        }
        for(int i = 0;i < m;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            d[x][y] = z;
            d[y][x] = z;
            p[x][y] = y;
            p[y][x] = x;
        }
    }

    public static void floyd(){
        int len = d.length;
        for(int k = 1;k < len;k++){
            for(int i = 1;i < len;i++){
                for(int j = 1;j < len;j++){
                    int select = d[i][k] == Integer.MAX_VALUE || d[k][j] == Integer.MAX_VALUE?Integer.MAX_VALUE:(d[i][k] + d[k][j]);
                    if(d[i][j] > select){
                        d[i][j] = d[i][k] + d[k][j];
                        p[i][j] = p[i][k];
                    }
                }
            }
        }
        for(int i = 1;i < len;i++){
            for(int j = i + 1;j < len;j++){
                String str = "v" + i +"-->";
                int k = p[i][j];
                while(k != j){
                    str += "v" + k + "-->";
                    k = p[k][j];
                }
                str += "v" + k + " = " + d[i][j];
                System.out.println(str);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        createGraph();
        floyd();
    }

}
