package sdu.edu.Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {

    static class Edge implements Comparable<Edge>{
        int begin;
        int end;
        int weight;
        public Edge(int begin, int end, int weight){
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static Edge[] edges;
    static int[] parents;

    public static void createGraph(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        edges = new Edge[m];
        parents = new int[n];
        for(int i = 0;i <m;i++){
            int begin = scan.nextInt();
            int end = scan.nextInt();
            int weight = scan.nextInt();
            edges[i] = new Edge(begin, end, weight);
        }
        Arrays.sort(edges);
    }

    public int findParent(int node){
        while(parents[node] > 0){
            node = parents[node];
        }
        return node;
    }

    public void kruskal(){
        for(int i = 0;i < edges.length;i++){
            int beginNode = findParent(edges[i].begin);
            int endNode = findParent(edges[i].end);
            if(beginNode != endNode){
                System.out.println("v" + edges[i].begin + "-->" + "v" + edges[i].end + "=" + edges[i].weight);
                parents[beginNode] = endNode;
            }
        }
    }

    public static void main(String[] args) {
        Kruskal k = new Kruskal();
        k.createGraph();
        k.kruskal();
    }
}
