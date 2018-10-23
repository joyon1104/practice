package day1007;
import java.util.*;

public class QuadTree1 {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int N = scanner.nextInt();
      char arr[][];
      arr = new char [N][N];
      for(int i=0; i<N; i++)
         arr[i] = scanner.next().toCharArray();

      QuadTree(0,0,N,arr);         
   }

   private static void QuadTree(int x, int y, int size, char arr[][]) {

      int sum=0;
      int temp=0;
      int i, j;
      if(size == 1)
         System.out.printf("%c",arr[x][y]);
      else {
         for(i=x; i<x+size; i++)
            for(j=y; j<y+size; j++)
               if(arr[x][y] != arr[i][j])
                  temp = 1;         
         if(temp == 0)
            System.out.printf("%c", arr[x][y]);
         else {
            System.out.printf("(");   
            QuadTree(x,y,size/2,arr);
            QuadTree(x,y+size/2,size/2,arr);
            QuadTree(x+size/2,y,size/2,arr);
            QuadTree(x+size/2,y+size/2,size/2,arr);
            System.out.printf(")");
         }
      }
   }
}

// 백준 채점제출할 때 패키지 지우고 class 이름 Main으로 변경