package day1007;

import java.util.Scanner;

public class QuadTree {
	
	static int[][] makeTable(int[][] nArray, int n, int i, int j){
		int[][] nArray2 = new int[n/2][n/2];
		for (int p=0; p<n/2; p++){
			for(int q=0; q<n/2; q++){
				nArray2[p][q] = nArray[(n/2)*i+p][(n/2)*j+q];
			}
		}
		return nArray2;
	}
	
	static int zeroOne(int[][] nArray, int n){
		if (nArray[0][0] == 0){
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(nArray[i][j] != 0)
						return 2;
				}
			}
			return 0;
		}
		else {
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(nArray[i][j] !=1)
						return 2;
				}
			}
			return 1;
		}
		
		
	}
	
	static String result=""; 
	
	static String makeQuad(int[][] nArray, int n){
		
		if(n<=1){
			return String.valueOf(nArray[0][0]);
		}
		
		else {
			
			if(zeroOne(nArray,n) == 0 | zeroOne(nArray,n) ==1){
				result = String.valueOf(zeroOne(nArray,n));
			}
			else {
				result = result+"(";
				for(int i=0; i<2 ; i++){
					for(int j=0; j<2; j++){
						result =  result + makeQuad(makeTable(nArray,n,i,j),n/2);
					}
				}
			}
			result = result + ")";
			return result;
		}
		
	}
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("숫자를 입력하세요.");
		int n = scanner.nextInt();
		
		int[][] nArray = 
				{{1,1,1,1,0,0,0,0},
				{1,1,1,1,0,0,0,0},
				{0,0,0,1,1,1,0,0},
				{0,0,0,1,1,1,0,0},
				{1,1,1,1,0,0,0,0},
				{1,1,1,1,0,0,0,0},
				{1,1,1,1,0,0,1,1},
				{1,1,1,1,0,0,1,1}};

		
		/*System.out.println(n+"차 행렬을 입력하세");
		
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				nArray[i][j] = scanner.nextInt();
			}
		}
		
		for(int i=0; i<n; ++i){
				 for(int j=0; j<n; ++i){
					 System.out.print(nArray[i][j]);//출력하는 곳
				 }
				System.out.println("");
		} */
		
		System.out.println(makeQuad(nArray, n));
		
	}

}
