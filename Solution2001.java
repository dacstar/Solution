import java.util.Scanner;

public class Solution2001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T =s.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int N=s.nextInt();
			int M=s.nextInt();
			int map[][]= new int[N][N];

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=s.nextInt();
				}
			}
			int sum=-1;
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					int cnt=0;
					for(int a=i;a<i+M;a++) {
						for(int b=j;b<j+M;b++) {
							cnt+=map[a][b];
						}
					}
					sum=Math.max(cnt, sum);
				}
			}
			System.out.println("#"+test_case+" "+sum);

		}
	}

}
