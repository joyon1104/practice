package day1007;

import java.util.Scanner;

public class Hanoi {
	int count = 0;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		Hanoi towerOfHanoi = new Hanoi();
		
		towerOfHanoi.moveHanoiTower("1","2","3",n);
		towerOfHanoi.showResult();
	}
	
	public void moveHanoiTower(String tStart,String tCenter, String tDest, int n){
		if(n ==1){
			++count;
			System.out.println(tStart + " " + tDest);
		}else{
			moveHanoiTower(tStart,tDest,tCenter,n-1); // 
			++count;
			System.out.println(tStart + " " + tDest);
			moveHanoiTower(tCenter,tStart,tDest, n-1); // 
		}
	}
	
	public void showResult(){
		System.out.println("총 이동횟수 : "+count);
	}
	
}
