package sdu.edu.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {

    static class Edge implements Comparable<Edge> {
        int begin;
        int end;
        int weight;

        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parentNode;
    static Edge[] edges;

    public static void createGraph(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        edges = new Edge[m];
        parentNode = new int[n];
        for(int i = 0;i < m;i++){
            int begin = scan.nextInt();
            int end = scan.nextInt();
            int weight = scan.nextInt();
            edges[i] = new Edge(begin, end, weight);
        }

        for(int i = 0;i < n;i++){
            parentNode[i] = i;
        }
        Kruskal();
    }

    public static int findParent(int node){
        while(node != parentNode[node]){
            node = parentNode[node];
        }
        return node;
    }

    public static void Kruskal(){
        Arrays.sort(edges);
        for(int i = 0;i < edges.length;i++){
            int beginNode = findParent(edges[i].begin);
            int endNode = findParent(edges[i].end);
            if(beginNode != endNode){
                System.out.println("v" + edges[i].begin + "-->" + edges[i].end + " = " + edges[i].weight);
                parentNode[beginNode] = endNode;
            }
        }
    }

    public static void main(String[] args) {
        createGraph();
    }

}
