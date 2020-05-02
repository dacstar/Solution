package Programmers;

import java.util.Arrays;

public class Selection_swap {
   static int[] standard, clone;
   static int interval, result;

   public static void main(String[] args) {
      int[] numbers = { 10,40,30,20};
      int k = 20;

      solution(numbers, k);
   }

   public static void init(int[] numbers, int k) {
      standard = numbers.clone(); //���� ����
      
      interval = k;
      result = Integer.MAX_VALUE;
   }

   public static void solution(int[] numbers, int k) {
      init(numbers, k); //�������� �ʱ�ȭ
      dfs(numbers, 0); // ������� �� ���ϱ�
      
      if(result == Integer.MAX_VALUE) { // ������� ������ �ʾҴٴ� ���� ������ ����� ���� �����ٴ� ��
         System.out.println(-1);
      }
      else {
         System.out.println(result);
      }
   }

   public static void dfs(int[] numbers, int depth) {
      if (depth == numbers.length) {
         if (Interval(numbers)) { // ������ K�����ΰ�?
            clone = numbers.clone(); // SelectSwap �� numbers�� ���� ������Ǽ��� ���ϴµ� ȥ���� �ü� �ֱ⶧���� �������縦 ���� ������ ������� �迭�� ����
            result = Math.min(result, SelectSwap());
         }
         return;
      }

      for (int i = depth; i < numbers.length; i++) {
         swap(numbers, i, depth);
         dfs(numbers, depth + 1);
         swap(numbers, i, depth);
      }
   }

   public static void swap(int[] numbers, int a, int b) {
      int temp = numbers[a];
      numbers[a] = numbers[b];
      numbers[b] = temp;
   }

   public static int SelectSwap() { // �������� clone �� standard �� ���Ͽ� ���ý���
      int res = 0;
      boolean two_check = false;
      
      
      for (int i = 0; i < clone.length; i++) {
         if(clone[i] == standard[i]) { //��ġ�Ұ�� �Ѿ
            continue;
         }
         else { 
            two_check = false;
            for (int j = i + 1; j < clone.length; j++) {
               if(clone[i] == standard[j] && standard[i] == clone[j]) { //�ڸ��� �مf���� ���ڸ� ��� ��ġ�ϴ� ��츦 �켱�ؼ� Ž��
                  res++;
                  swap(clone,i,j);
                  two_check = true;
                  break;
               }
            }
            if(!two_check) { // ������ �ΰ��� ��� ��ġ�ϴ� ��찡 ��������� �ϳ��� ��ġ�ϴ°�츦 ã�� ����
               for (int j = i + 1; j < clone.length; j++) {
                  if(clone[j] == standard[i]) { // �ϳ��� ��ġ��ų��� i��°�ڸ��� ��ġ���Ѿ���, j��°�ڸ��� ��ġ��ų��� i�� �н��ϰ� �Ѿ�Ƿ� ����� ������������ 
                     res++;
                     swap(clone,i,j);
                     break;
                  }
               }
            }
            
         }
      }
      return res;
   }
   
   public static boolean Interval(int[] numbers) {
      for (int i = 1; i < numbers.length; i++) {
         if (Math.abs(numbers[i] - numbers[i - 1]) > interval) {
            return false;
         }
      }
      return true;
   }
}