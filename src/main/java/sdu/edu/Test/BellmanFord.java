package sdu.edu.Test;


import java.util.Scanner;

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

    static int[] mindist;
    static Edge[] edges;
    static int[] preNode;

    public static void createGraph(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int s = scan.nextInt();
        int m = scan.nextInt();

        mindist = new int[n];
        edges = new Edge[m];
        preNode = new int[n];

        for(int i = 0;i < m;i++){
            int begin = scan.nextInt();
            int end = scan.nextInt();
            int weight = scan.nextInt();
            edges[i] = new Edge(begin, end, weight);
        }
        for(int i = 1;i < mindist.length;i++){
            mindist[i] = Integer.MAX_VALUE;
        }
        BellmanFord(s);
    }

    public static void BellmanFord(int vs){
        for(int i = 1;i < mindist.length;i++){
            for(int j = 0;j < edges.length;j++){
                if(mindist[edges[j].begin] != Integer.MAX_VALUE && mindist[edges[j].end] > mindist[edges[j].begin] + edges[j].weight ){
                    mindist[edges[j].end] = mindist[edges[j].begin] + edges[j].weight;
                    preNode[edges[j].end] = edges[j].begin;
                }
            }
        }
        for(int i = 0;i < edges.length;i++){
            if(mindist[edges[i].end] > mindist[edges[i].begin] + edges[i].weight){
                return;
            }
        }

        for(int i = 0;i < mindist.length;i++){
            int si = i;
            String str = "v" + i;
            while(vs != preNode[si]){
                str = "v" + preNode[si] + "-->" +str;
                si = preNode[si];
            }
            System.out.println("v" + vs + "-->" + str +" = " + mindist[i]);
        }

    }

    public static void main(String[] args) {
        createGraph();
    }

}
