import java.util.Scanner;

public class Baek9465 {
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		boolean check2[][] =new boolean[2][N];
		int arr[][] = new int[2][N];
		for(int i=0;i<2;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=s.nextInt();
			}
		}
		int res=0;
		int sum=0;
		for(int i=0;i<2;i++) {
			for(int j=0;j<N;j++) {
				if(!check2[i][j]) {
					sum+=arr[i][j];
					for(int d=0;d<4;d++) {
						int y=i+dy[d];
						int x=j+dx[d];
						if(check(y, x)) {
							check2[y][x]=true;
						}
					}
				}
			}
		}
		
	}
	
	static boolean check(int i,int j) {
		if(i>=2 || i<0 || j>=N || j<0)
			return false;
		
		return true;
	}

}
