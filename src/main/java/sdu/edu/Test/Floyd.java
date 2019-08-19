package sdu.edu.Test;

import java.util.Scanner;

public class Floyd {

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
                d[i][j] = Integer.MAX_VALUE;
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
        Floyd(0);
    }

    public static void Floyd(int vs){
        for(int k = 1;k < d.length;k++){
            for(int i = 1;i < d.length;i++){
                for(int j = 1;j < d.length;j++){
                    int select = d[i][k] == Integer.MAX_VALUE || d[k][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE:(d[i][k] + d[k][j]);
                    if(d[i][j] > select){
                        d[i][j] = select;
                        p[i][j] = p[i][k];
                    }
                }
            }
        }

        for(int i = 1;i < d.length;i++){
            for(int j = i + 1;j < d.length;j++){
                int k = p[i][j];
                String str = "v" + i + "-->";
                while(k != j){
                    str += "v" + k + "-->";
                    k = p[k][j];
                }
                System.out.println(str + "v" + k + " = " + d[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        createGraph();
    }

}
