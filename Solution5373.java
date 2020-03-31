import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution5373 {
	static int N;
	static int cube[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		cube = new int[6][5];

		for(int i=0;i<6;i++) {
			for(int j=0;j<4;j++) {
				cube[i][j]=i;
			}
		}

		for(int i=0;i<N;i++) {
			int count=Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<count;j++) {
				String str=st.nextToken();
				rotate(str.charAt(0),str.charAt(1));

			}
			print();
		}
	}

	static void rotate(char paper,char dir) {

		if(paper == 'U'){
			if(dir == '+') {
				cube[4][4] = cube[4][2];
				cube[4][2]=cube[3][2];
				cube[3][2]=cube[5][2];
				cube[5][2]=cube[2][2];
				cube[2][2]=cube[4][4];
			}else if(dir == '-') {
				cube[4][4] = cube[4][2];
				cube[4][2]=cube[2][2];
				cube[2][2]=cube[5][2];
				cube[5][2]=cube[3][2];
				cube[3][2]=cube[4][4];
			}

		}else if(paper == 'D') {
			if(dir == '+') {
				cube[4][4] = cube[4][0];
				cube[4][0]=cube[3][0];
				cube[3][0]=cube[5][0];
				cube[5][0]=cube[2][0];
				cube[2][0]=cube[4][4];

			}else if(dir == '-') {
				cube[4][4] = cube[4][0];
				cube[4][0]=cube[2][0];
				cube[2][0]=cube[5][0];
				cube[5][0]=cube[3][0];
				cube[3][0]=cube[4][4];
			}

		}else if(paper == 'F') {
			if(dir == '+') {
				cube[4][4]=cube[2][0];
				cube[2][0]=cube[1][3];
				cube[1][3]=cube[0][0];
				cube[0][0]=cube[3][3];
				cube[3][3]=cube[4][4];
			}else if(dir == '-') {
				cube[4][4]=cube[2][0];
				cube[2][0]=cube[3][3];
				cube[3][3]=cube[0][0];
				cube[0][0]=cube[1][3];
				cube[1][3]=cube[4][4];

			}
		}else if(paper == 'B') {
			if(dir == '+') {
				cube[4][4]=cube[2][2];
				cube[2][2]=cube[3][1];
				cube[3][1]=cube[0][2];
				cube[0][2]=cube[1][1];
				cube[1][1]=cube[4][4];
	
			}else if(dir == '-') {
			
				
				cube[4][4]=cube[2][2];
				cube[2][2]=cube[1][2];
				cube[1][2]=cube[0][2];
				cube[0][2]=cube[3][1];
				cube[3][1]=cube[4][4];
			}
		}else if(paper == 'L') {
			if(dir == '+') {
				cube[4][4]=cube[2][1];
				cube[2][1]=cube[5][3];
				cube[5][3]=cube[0][1];
				cube[0][1]=cube[4][1];
				cube[4][1]=cube[4][4];
				
	

			}else if(dir == '-') {
				cube[4][4]=cube[2][1];
				cube[2][1]=cube[4][1];
				cube[4][1]=cube[0][1];
				cube[0][1]=cube[5][3];
				cube[5][3]=cube[4][4];
			}
		}else if(paper == 'R') {
			if(dir == '+') {
				cube[4][4]=cube[2][3];
				cube[2][3]=cube[4][3];
				cube[4][3]=cube[0][3];
				cube[0][3]=cube[5][1];
				cube[5][1]=cube[4][4];

			}else if(dir == '-') {
				cube[4][4]=cube[2][3];
				cube[2][3]=cube[5][1];
				cube[5][1]=cube[0][3];
				cube[0][3]=cube[4][3];
				cube[4][3]=cube[4][4];
			}
		}
	}
	static void print() {
		System.out.println(cube[2][1]+" "+cube[2][2]+" "+cube[2][3]);
		System.out.println(cube[2][1]+" "+"2"+" "+cube[2][3]);
		System.out.println(cube[2][1]+" "+cube[2][0]+" "+cube[2][3]);
	}
}
