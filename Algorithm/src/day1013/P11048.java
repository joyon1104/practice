package day1013;

import java.util.Scanner;

public class P11048 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N+1][M+1]; // 좌표값 맞추기 위해 +1함.
		int[][] dp = new int[N+1][M+1]; // x,y좌표값이 1인경우 dp[x-1][y], dp[x][y-1]를 비교해야 하므로 
		
		//map배열에 각 좌표에 입력한 사탕의 개수를 저장
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= M; y++) {
				map[x][y] = sc.nextInt();
			}
		}
		
		sc.close();
		
		
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= M; y++) {
				dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]) + map[x][y];
				// x,y좌표 기준 좌측, 상단의 DP값 중 더 큰값에 현재의 사탕개수를 더하여 DP값에 저장
				// (r, c)에 있으면, (r+1, c), (r, c+1), (r+1, c+1)
				// (r+1, c+1) 비교가 없는 이유 : 대각선 이동을 하면 사탕의 최대값을 구해야 하는 입장에서 손해
				
			}
		}
		
		System.out.println(dp[N][M]);
	}
}
