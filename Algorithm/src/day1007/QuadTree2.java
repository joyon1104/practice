package day1007;

import java.util.Scanner;
public class QuadTree2 {
   
   static int dot[][];
   
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // 영상의 크기
        //int n = sc.nextInt();
   
        dot = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
        	char[] line = sc.next().toCharArray();
            //char[] line = sc.nextLine().toCharArray(); //error 위의 nextLine()을 받아서...
            for (int j = 1; j <= n; j++) {
                dot[i][j] = Integer.parseInt(line[j - 1] + "");
            }
        }
        sc.close();
        String result = compress(1, 1, n);
        System.out.println(result);
    }

   static String compress(int startX, int startY, int size) {
        boolean isCompress = true;
        //x = 1 
        for (int i = startX; i <= startX + size - 1; i++) { 
            // j = 1
           for (int j = startY; j <= startY + size - 1; j++) {
                if (dot[startX][startY] != dot[i][j]) { //요소가 같지 않을 때
                    isCompress = false; // 압축 불가
                    break;
                }
            }
        }
        if (isCompress) { //압축 o
            return dot[startX][startY] + "";
        } else { //압축 x
            return "(" +
                compress(startX, startY, size / 2) +
                compress(startX, startY  + size / 2, size / 2) +
                compress(startX + size / 2, startY, size / 2) +
                compress(startX + size / 2 , startY + size / 2, size / 2) +
                ")";
        }
    }
   
   
   
}