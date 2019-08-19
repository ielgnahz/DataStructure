package sdu.edu.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SPFA {

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
    static int[] num;

    public static void createGraph(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int s = scan.nextInt();
        int m = scan.nextInt();

        mindist = new int[n];
        edges = new Edge[m];
        num = new int[n];

        for(int i = 0;i < m;i++){
            int begin = scan.nextInt();
            int end = scan.nextInt();
            int weight = scan.nextInt();
            edges[i] = new Edge(begin, end, weight);
        }

        for(int i = 0;i < mindist.length;i++){
            mindist[i] = Integer.MAX_VALUE;
        }
        if(SPFA(s, n)){
            for(int i = 0;i < mindist.length;i++){
                System.out.print(mindist[i] + " ");
            }
        }else{
            System.out.println("存在负环");
        }

    }

    public static boolean SPFA(int s,int n){
        mindist[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i = 0;i < edges.length;i++){
                if(node == edges[i].begin && mindist[edges[i].begin] != Integer.MAX_VALUE && mindist[edges[i].end] > mindist[edges[i].begin] + edges[i].weight){
                    mindist[edges[i].end] = mindist[edges[i].begin] + edges[i].weight;
                    if(!queue.contains(edges[i].end)){
                        queue.offer(edges[i].end);
                        num[edges[i].end]++;
                        if(num[edges[i].end] > n){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        createGraph();
    }

}
