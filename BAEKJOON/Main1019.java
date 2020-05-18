package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main1019 {
    
    private static int[] numArr = new int[10];
    private static int position = 1;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine()); // 36
        int start = 1;
        int end = N;
        
        while(start <= end) {
            
            while(start%10!=0 && start<=end){
                cal(start);
                start++; // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
            }
            
            if(start > end)
                break; // 계산 종료
            
            while(end%10!=9 && start<=end){
                cal(end);
                end--; // 36, 35, 34, 33, 32, 31, 30, 29
            }
            
            start /= 10;  // 10 -> 1 
            end /= 10;  // 29 -> 2
            
            for(int i=0 ; i<10 ; i++)
                numArr[i] += (end-start+1) * position;  // 일의 자리에 0~9가 총 2번씩 등장
            
            position *= 10;  // 자리수 계산
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i=0 ; i<10 ; i++)
            builder.append(numArr[i] + " ");
        
        System.out.println(builder.toString());
    }
    
    public static void cal(int num){ // 각 숫자가 몇 번씩 나오는지 더함
        while(num > 0){
            numArr[num%10] += position;
            num /= 10;
        }
    }
}
