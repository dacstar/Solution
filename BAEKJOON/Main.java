package BAEKJOON;
import java.util.Scanner;

public class Main {
	static int R;
	static int C;
	static int []dx= {1,-1,0,0};
	static int []dy= {0,0,-1,1};
	static char [][]map;
	static int count;
    static int cnt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		R=s.nextInt();
		C=s.nextInt();
		map = new char[R][C];
		
		for(int i=0; i<R; i++)
			map[i] = s.next().toCharArray();

		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
                if(cnt==1){
                    System.out.println(1);
                 return ;}
				if(map[i][j]=='.')
					visit(i,j);
			}
		}
		
		System.out.println(0);
		
		
		
		
	}
	static void visit(int y,int x) {
		count=0;
		
		for(int d=0;d<4;d++) {
			int tmpy=dy[d]+y;
			int tmpx=dx[d]+x;
			if(check(tmpy,tmpx) && map[tmpy][tmpx]=='X') {
				count++;
				if(count>=3) {
					cnt=1;
                    return;
				  
				}
			}else {
				count++;
				if(count>=3) {
					cnt=1;
                    return;
				  
				}
			}
		}
		
		
		
	}
	
	
	static boolean check(int y,int x) {
		
		if(y>=0 && y<R && x>=0 && x<C) {
			return true;
		}
		return false;
		
	}

}