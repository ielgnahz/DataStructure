package sdu.edu.Structure.FStructure.getMaxWindow;

import java.util.LinkedList;

public class Main {
	public int[] getMaxWindow(int[] map,int w) {
		int height[] = new int[map.length - w + 1];
		int j = 0;
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i =0;i<map.length;i++){
			while(!queue.isEmpty() && map[queue.peekLast()] <= map[i]){
				queue.pollLast();
			}
			queue.addLast(i);
			if(queue.peekFirst() == i - w){
				queue.pollFirst();
			}
			if(i >= w-1){
				height[j++] = map[queue.peekFirst()];
			}
		}
		return height;
	}
}
