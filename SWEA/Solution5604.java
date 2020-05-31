package SWEA;

import java.util.Scanner;

public class Solution5604 {
    private static long[] numArr;
    private static long position;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T=s.nextInt();
		for(int t=1;t<=T;t++) {
			 long start = s.nextLong();

			 long end = s.nextLong();
		         numArr = new long[10];
		        position=1;
		        while(start <= end) {
		        	if(start ==0 && end ==0)
		        		break;
		            
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
		        long sum=0;
		        for(int i=0;i<10;i++) {
		        	if(numArr[i]!=0) {
		        		long value=i*numArr[i];
		        		sum+=value;
		        	}
		        }
		        System.out.println("#"+t+" "+sum);
		}
	}
	   
    public static void cal(long num){ // 각 숫자가 몇 번씩 나오는지 더함
        while(num > 0){
            numArr[(int)num%10] += position;
            num /= 10;
        }
    }

}
