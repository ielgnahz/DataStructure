package sdu.edu.Structure.FourthStructure.coins;

public class Main1 {
	public int coins1(int[] arr,int aim){
		if(arr == null){
			return 0;
		}
		return process(arr,0,aim);
	}
	public int process(int[] arr,int index,int aim){
		int res = 0;
		if(index == arr.length){
			res = aim == 0?1:0;
		}else{
			for(int i = 0;i*arr[index]<=aim;i++){
				res+=process(arr, index+1, aim-i*arr[index]);
			}
		}
		return res;
	}
	public int coins2(int[] arr,int aim){
		if(arr == null){
			return 0;
		}
		int[][] map = new int[arr.length][aim+1];
		return process1(arr,0,aim,map);
	}
	/*
	 * 没访问过     	-1
	 * 访问过但是为0  	0
	 * 访问过不为0   	值
	 */
	public int process1(int[] arr,int index,int aim,int[][] map){
		int res = 0;
		if(index == arr.length){
			res = aim == 0?1:0;
		}else{
			int mapValue = 0;
			for(int i = 0;i*arr[index]<=aim;i++){
				mapValue = map[index+1][aim-i*arr[index]]==-1?0:map[index+1][aim-i*arr[index]];
				if(mapValue != 0){
					res+=mapValue;
				}else{
					res+=process1(arr, index+1, aim-i*arr[index], map);
				}
			}
		}
		map[index][aim] = res==0?-1:res;
		return res;
	}
	
	public  int coins3(int[] arr,int aim){
		int n = arr.length;
		int[][] dp = new int[n][aim+1];
		for(int i = 0;i<n;i++){
			dp[i][0] = 1;
		}
		for(int j = 1;j*arr[0]<=aim;j++){
			dp[0][j*arr[0]] = 1;
		}
		for(int i = 1;i<arr.length;i++){
			for(int j = 1;j<aim+1;j++){
				for(int k = 0;j-k*arr[i]>=0;k++){
					dp[i][j]+=dp[i-1][j-k*arr[i]];
				}
			}
		}
		return dp[n-1][aim];
	}
	
	public int coins4(int[] arr,int aim){
		int n = arr.length;
		int[][] dp = new int[arr.length][aim+1];
		for(int i = 0;i<arr.length;i++){
			dp[i][0] = 1;
		}
		for(int j = 0;j*arr[0]<=aim;j++){
			dp[0][j*arr[0]] = 1;
		}
		for(int i = 1;i<arr.length;i++){
			for(int j =1;j<aim+1;j++){
				dp[i][j] = dp[i-1][j];
				dp[i][j]+=j-arr[i]>=0?dp[i][j-arr[i]]:0;
			}
		}
		return dp[n-1][aim];
	}
	
	public static void main(String[] args) {
		System.out.println(new Main1().coins4(new int[] { 5, 10, 25, 1 }, 15));
	}
}
