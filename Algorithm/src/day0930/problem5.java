package day0930;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class problem5 {
	
	static int factorial(int n) {
		if (n <= 1) {
			return n;
		}
		else {
			return factorial(n-1) * n;
		}
	}

	static long findSimilar(long a, long b) {
		
		String s1 = String.valueOf(a);
		String s2 = String.valueOf(b);
		
		String[] array_s1 = s1.split("");
		String[] array_s2 = s2.split("");
		
		ArrayList<String> list_s2 = new ArrayList<String>(Arrays.asList(array_s2));
		
		for(int i=0; i<array_s1.length;i++){
			for(int j=0; j<list_s2.size();j++){
					if(array_s1[i].equals(list_s2.get(j))){
						list_s2.remove(j);
						break;
					}
			}
		}
		
		String[] array_res;
		
		if(list_s2.size() == 0){
			System.out.println("similar!");
			array_res = array_s1;
		}
		else {
			System.out.println("not similar!");
			array_res = array_s2;
		}
		
		int[] num = new int[9];
		int res = factorial(array_res.length);
		
		for(int i=1; i<10 ; i++){
			for(int j=0; j<array_res.length; j++){
				if(i == Integer.parseInt(array_res[j])){
					num[i-1] = num[i-1]+1;
				}
			}
			if(num[i-1] != 0)
				res = res / factorial(num[i-1]);
		}
		
		return res;
		
	}
	

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException{
		System.out.print("첫번째 숫자를 입력하세요.");
		long a = scanner.nextLong();
		System.out.print("두번째 숫자를 입력하세요.");
		long b = scanner.nextLong();
			
		long res = findSimilar(a,b);
		
		System.out.print(res);

			
	}
		/*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("outpath.txt"));
		
		long a = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
		
		long b = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
		
		long res = findSimilar(a, b);
		
		bufferedWriter.write(String.valueOf(res));
		//bufferedWriter.newLine();
		
		bufferedWriter.close();
		
		scanner.close();*/


}
