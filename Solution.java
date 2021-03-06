import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution {
    
    static int T,X;
    static int[] buttons = new int[10];
    static int dp[];
    static final int IMPOSSIBLE = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        int t = 1;
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < 10; i++) {
                buttons[i] = Integer.parseInt(st.nextToken());
            }
            
            X = Integer.parseInt(br.readLine());
            
            // X가 10 이하일 수 있으므로... 
            dp = new int[X+10];
            
            for (int i = 0; i < 10; i++) {
                if(buttons[i] == 1) {
                    dp[i] = 1;
                }
            }
            
            solve(X);
            System.out.printf("#%d %d\n",t++,dp[X] == IMPOSSIBLE ? -1 : dp[X]+1);
        }
    }
    
    static int solve(int num) {
        if(dp[num] != 0) return dp[num];
        
        // num을 직접 눌러본다, 만약 고장난 숫자가 포함되어 있어 누르지 못한면 Integer.MAX_VALUE 를 return 한다.
        dp[num] = count(num);
        
        // 인수분해하여 num = a * b 의 형태로 변환
        System.out.println((int)Math.sqrt(num));
        for (int i = 1; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                int num1 = solve(i);
                int num2 = solve(num/i);
                // 직접 번호를 누른 숫자와, 인수분해한 a * b 를 각각 다시 탐색 
                // *를 눌렀기 때문에 +1 해준다.
                dp[num] = Math.min(dp[num], num1 == IMPOSSIBLE || num2 == IMPOSSIBLE ? IMPOSSIBLE : num1+num2 + 1);
            }
        }
        
        return dp[num];
    }
    
    static int count(int num) {
        int cnt = 0;
        
        while(num > 0) {
        	System.out.println(num +" "+cnt);
            int temp = num % 10;
            if(buttons[temp] == 0) return IMPOSSIBLE;
            
            num /= 10;
            cnt++;
        }
        return cnt;
    }
}