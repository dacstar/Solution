import java.util.Scanner;

public class Solution14499 {

	static int N,M,K;
	static int map[][];
	static int D[];
	static int cube[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		D = new int[2];
		N=s.nextInt();
		M=s.nextInt();
		D[0]=s.nextInt();
		D[1]=s.nextInt();
		K=s.nextInt();
		cube = new int[7];
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=s.nextInt();
			}
		}
		if(map[D[0]][D[1]] !=0) {
			cube[0]=map[D[0]][D[1]];
			map[D[0]][D[1]]=0;
		}else {
			map[D[0]][D[1]]=cube[0];
		}
		for(int i=0;i<K;i++) {
			int order=s.nextInt();
			if(order ==1) {
				if(D[1]+1>=M)
					continue;
				else {
					//悼率
					D[1]++;
					cube[6]=cube[0];
					cube[0]=cube[2];
					cube[2]=cube[5];
					cube[5]=cube[1];
					cube[1]=cube[6];
					if(map[D[0]][D[1]] !=0) {
						cube[0]=map[D[0]][D[1]];
						map[D[0]][D[1]]=0;
					}else {
						map[D[0]][D[1]]=cube[0];
					}
					System.out.println(cube[5]);
				}
			}
			else if(order == 2) {
				if(D[1]-1<0)
					continue;
				else {
					//辑率
					D[1]--;
					cube[6]=cube[0];
					cube[0]=cube[1];
					cube[1]=cube[5];
					cube[5]=cube[2];
					cube[2]=cube[6];
					if(map[D[0]][D[1]] !=0) {
						cube[0]=map[D[0]][D[1]];
						map[D[0]][D[1]]=0;
					}else {
						map[D[0]][D[1]]=cube[0];
					}
					System.out.println(cube[5]);
				}
			}
			else if(order ==3) {
				if(D[0]-1<0)
					continue;
				else {
					//合率
					D[0]--;
					cube[6]=cube[0];
					cube[0]=cube[4];
					cube[4]=cube[5];
					cube[5]=cube[3];
					cube[3]=cube[6];
					if(map[D[0]][D[1]] !=0) {
						cube[0]=map[D[0]][D[1]];
						map[D[0]][D[1]]=0;
					}else {
						map[D[0]][D[1]]=cube[0];
					}
					System.out.println(cube[5]);
				}
			}else {
				if(D[0]+1>=N)
					continue;
				else {
					//巢率
					D[0]++;
					cube[6]=cube[0];
					cube[0]=cube[3];
					cube[3]=cube[5];
					cube[5]=cube[4];
					cube[4]=cube[6];
					if(map[D[0]][D[1]] !=0) {
						cube[0]=map[D[0]][D[1]];
						map[D[0]][D[1]]=0;
					}else {
						map[D[0]][D[1]]=cube[0];
					}

					System.out.println(cube[5]);
				}
			}


		}



	}



}
