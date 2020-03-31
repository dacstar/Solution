import java.util.Scanner;

public class Back17281 {
	static int N,result;
	static int map[][];
	static boolean check[];
	static int player[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		map = new int[N][9];
		player = new int[9];
		check = new boolean[9];
		for(int i=0;i<N;i++) {
			for(int j=0;j<9;j++) {
				map[i][j]=s.nextInt();
			}
		}
		result=0;
		player[3]=0;
		DFS(0);
		System.out.println(result);
	}
	
	
	static void DFS(int depth) {
		if(depth ==3) {
			DFS(depth+1);
			return ;
			
		}
		if(depth == 9) {

			play();
			
			return ;
		}
		
		for(int i=1;i<9;i++) {
			
			if(check[i])
				continue;
				check[i]=true;
				player[depth]=i;
				DFS(depth+1);
				check[i]=false;
		}
	}
	static void play() {
		int outcount;
		int number=0;
		int game;
		int sum=0;
		for(int i=0;i<N;i++) {
			int score[] = new int[9];
			outcount=0;
			while(true) {
				game=map[i][player[number]];
				if(game == 0) {
					outcount++;
					
				}else {
					if(score[player[number]]+game>=4) {
						sum++;
						score[player[number]]=0;
					}else {
						score[player[number]]+=game;
					}
					for(int j=0;j<9;j++) {
						if(score[j]!=0 && j != player[number]) {
							if(score[j]+game>=4) {
								score[j]=0;
								sum++;
							}else {
								score[j]+=game;
							}
						}
					}
				}
				number=(number+1)%9;
				if(outcount==3)
					break;
				
			}
		}
		result=Math.max(sum, result);
	}

}
