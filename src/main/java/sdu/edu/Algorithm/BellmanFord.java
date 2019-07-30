package sdu.edu.Algorithm;

import java.util.Scanner;
/*
5 0 10
0 1 6
0 4 7
1 4 8
1 2 5
1 3 -4
2 1 -2
3 0 2
3 2 7
4 2 -3
4 3 9

 */
public class BellmanFord {

    static class Edge{
        int begin;
        int end;
        int weight;

        public Edge(int begin,int end,int weight){
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

    }

    static Edge[] edge;
    static int[] mindist;
    static int[] preNode;

    public static void createGraph(){
        Scanner scan = new Scanner(System.in);
        //定点数
        int n = scan.nextInt();
        //源点
        int s = scan.nextInt();
        //边数
        int m = scan.nextInt();

        edge = new Edge[m];
        mindist = new int[n];
        preNode = new int[n];
        for(int i = 0;i < n;i++){
            mindist[i] = Integer.MAX_VALUE;
        }
        for(int i = 0;i < m;i++){
            int begin = scan.nextInt();
            int end = scan.nextInt();
            int weight = scan.nextInt();
            edge[i] = new Edge(begin, end, weight);
        }

        mindist[0] = 0;
        BellmanFord(s);
    }

    public static void BellmanFord(int vs){
        for(int i = 0;i < mindist.length - 1;i++){
            for(int j = 0;j < edge.length;j++){
                if(mindist[edge[j].begin] != Integer.MAX_VALUE && mindist[edge[j].end] > mindist[edge[j].begin] + edge[j].weight){
                    mindist[edge[j].end] = mindist[edge[j].begin] + edge[j].weight;
                    preNode[edge[j].end] = edge[j].begin;
                }
            }
        }

        for(int i = 0;i < edge.length;i++){
            if(mindist[edge[i].end] > mindist[edge[i].begin] + edge[i].weight){
                //有负环
                return;
            }
        }

        for(int i = 0;i < mindist.length;i++){
            int si = i;
            String str = "v" + si;
            while(preNode[si] != vs){
                str = "v" + preNode[si] + "-->" + str;
                si = preNode[si];
            }
            System.out.println("v" + vs + "-->" + str + "=" + mindist[i]);
        }
    }

    public static void main(String[] args) {
        createGraph();
    }


}
