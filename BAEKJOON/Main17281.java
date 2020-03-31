package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17281 {
	static int score[][],player[];
	static int N,max;
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		max=-1;
		score = new int[N][10];
		player = new int[9];
		check = new boolean[10];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++) {
				score[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		check[1]=true;
		player[3]=1;
		DFS(0,0);
		System.out.println(max);
	}
	
	static void DFS(int depth,int idx) {
		
		if(depth==9){
			play();
			return ;
			
		}
		
		if(depth==3) {
			DFS(depth+1,idx+1);
			return ;
		}else {
			for(int i=2;i<=9;i++) {
				if(check[i])
					continue;
				check[i]=true;
				player[depth]=i;
				DFS(depth+1,i);
				check[i]=false;
			}
		}
	}
	
	static void play() {
		int res=0;
		int index=0;
	
		for(int i=0;i<N;i++) {
			int outcount=0;
			boolean visit[]  = new boolean[10];
			int ground[] = new int[10];
			while(outcount<3) {
				
					int ball=score[i][player[index]];
					if(ball==0) {
						outcount++;
						index=(index+1)%9;
						continue;
					}else {
						for(int d=1;d<=9;d++) {

							if(d==player[index]) {
								if(ball==4) {
									res++;
									continue;
								}else {
									visit[player[index]]=true;
									ground[player[index]]+=ball;
									continue;
								}
							}
							if(visit[d]) {
								if(ground[d]+ball>3) {
									res++;
									ground[d]=0;
									visit[d]=false;
									continue;
								}else if(ground[d]+ball<=3) {
										ground[d]+=ball;
								}
							}
						}
					}
					index=(index+1)%9;
			}
		}
		max=Math.max(max, res);
		
		
	}
	
	
}
