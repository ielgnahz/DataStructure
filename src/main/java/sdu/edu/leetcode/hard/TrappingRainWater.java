package sdu.edu.leetcode.hard;

public class TrappingRainWater {

    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int max = 0;
        int maxIndex = 0;
        int ans = 0;
        for(int i = 0;i < height.length;i++){
            if(height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }
        max = height[0];
        for(int i = 1;i < maxIndex;i++){
            if(height[i] > max){
                max = height[i];
            }else{
                ans += max - height[i];
            }
        }
        max = height[height.length - 1];
        for(int i = height.length - 2;i > maxIndex;i--){
            if(height[i] > max){
                max = height[i];
            }else{
                ans += max - height[i];
            }
        }
        return ans;
    }

}
