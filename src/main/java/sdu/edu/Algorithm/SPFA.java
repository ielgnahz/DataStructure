package sdu.edu.Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
请输入节点数
5
请输入起点下标
0
请输入边数
8
请输入具体的边的数据
0 1 -1
0 2 4
1 2 3
1 3 2
1 4 2
3 2 5
3 1 1
4 3 -3
0 -1 2 -2 1
 */
/*
请输入定点数
6
请输入起点下标
1
请输入边总数
18
请输入具体的边的数据
0 1 6
0 2 3
1 2 2
1 3 5
2 3 3
2 4 4
3 4 2
3 5 3
4 5 5
1 0 6
2 0 3
2 1 2
3 1 5
3 2 3
4 2 4
4 3 2
5 3 3
5 4 5
5 0 2 5 6 8
 */
public class SPFA {

    static class Edge{
        int begin;
        int end;
        int weight;
        public Edge(int begin, int end, int weight){
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }
    }

    static int[] result;
    static Edge[] edge;
    static int[] num;

    public static void createGraph(){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入节点数");
        int n = scan.nextInt();
        System.out.println("请输入起点下标");
        int s = scan.nextInt();
        System.out.println("请输入边数");
        int m = scan.nextInt();
        System.out.println("请输入具体的边的数据");
        result = new int[n];
        num = new int[n];
        edge = new Edge[m];

        for(int i = 0;i < m;i++){
            int begin = scan.nextInt();
            int end = scan.nextInt();
            int weight = scan.nextInt();
            edge[i] = new Edge(begin, end, weight);
        }
        for(int i = 0;i < n;i++){
            result[i] = Integer.MAX_VALUE;
        }
        if(getShortPath(s, n)){
            for(int i = 0;i < result.length;i++){
                System.out.print(result[i] + " ");
            }
        }else{
            System.out.println("存在负权环");
        }


    }

    public static boolean getShortPath(int s, int n){
        Queue<Integer> queue = new LinkedList<>();
        result[s] = 0;
        queue.offer(s);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i = 0;i < edge.length;i++){
                if(edge[i].begin == node && result[edge[i].end] > result[node] + edge[i].weight){
                    result[edge[i].end] = result[node] + edge[i].weight;
                    if(!queue.contains(edge[i].end)){
                        queue.add(edge[i].end);
                        num[edge[i].end]++;
                        if(num[edge[i].end] > n){
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
