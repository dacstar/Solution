package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int n,m,r,c,l;
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // ����ũ��
            m = Integer.parseInt(st.nextToken()); // ����ũ��
            r = Integer.parseInt(st.nextToken()); // ��Ȧ �Ѳ� x
            c = Integer.parseInt(st.nextToken()); // ��Ȧ �Ѳ� y
            l = Integer.parseInt(st.nextToken()); // �ð�
            arr = new int[n][m];
            for(int j=0;j<n;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++)
                    arr[j][k] = Integer.parseInt(st.nextToken());
            }
            result = 0;
            visited = new boolean[n][m];
            solve();
            print();
            sb.append("#"+i+" "+result+"\n");
        }
        System.out.print(sb);
    }
 
 
 
 
 
 
 
    static int result;
    static boolean[][] visited;
    // �Ʒ�,  ������,  ��,  ��
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static void solve() {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r,c,1));
        visited[r][c] = true;
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            if(t.cnt>l) break;
            result++;
            switch(arr[t.x][t.y]) {
            case 1:    // 1 - +
                for(int i=0;i<4;i++) {
                    int tx = t.x+dir[i][0];
                    int ty = t.y+dir[i][1];
                    if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
                    if(visited[tx][ty] || arr[tx][ty]==0) continue;
                    if(check(tx,ty,i)) {
                        queue.add(new Pair(tx,ty,t.cnt+1));
                        visited[tx][ty] = true;
                    }
                }
                break;
            case 2:    // 2 - ��
                for(int i=0;i<4;i+=2) {
                    int tx = t.x+dir[i][0];
                    int ty = t.y+dir[i][1];
                    if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
                    if(visited[tx][ty] || arr[tx][ty]==0) continue;
                    if(check(tx,ty,i)) {
                        queue.add(new Pair(tx,ty,t.cnt+1));
                        visited[tx][ty] = true;
                    }
                }
                break;
            case 3:    // 3 - ��
                for(int i=1;i<4;i+=2) {
                    int tx = t.x+dir[i][0];
                    int ty = t.y+dir[i][1];
                    if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
                    if(visited[tx][ty] || arr[tx][ty]==0) continue;
                    if(check(tx,ty,i)) {
                        queue.add(new Pair(tx,ty,t.cnt+1));
                        visited[tx][ty] = true;
                    }
                }
                break;
            case 4:    // 4 - ��
                for(int i=1;i<3;i++) {
                    int tx = t.x+dir[i][0];
                    int ty = t.y+dir[i][1];
                    if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
                    if(visited[tx][ty] || arr[tx][ty]==0) continue;
                    if(check(tx,ty,i)) {
                        queue.add(new Pair(tx,ty,t.cnt+1));
                        visited[tx][ty] = true;
                    }
                }
                break;
            case 5:    // 5 - ��
                for(int i=0;i<2;i++) {
                    int tx = t.x+dir[i][0];
                    int ty = t.y+dir[i][1];
                    if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
                    if(visited[tx][ty] || arr[tx][ty]==0) continue;
                    if(check(tx,ty,i)) {
                        queue.add(new Pair(tx,ty,t.cnt+1));
                        visited[tx][ty] = true;
                    }
                }
                break;
            case 6:    // 6 - ��
                for(int i=0;i<4;i+=3) {
                    int tx = t.x+dir[i][0];
                    int ty = t.y+dir[i][1];
                    if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
                    if(visited[tx][ty] || arr[tx][ty]==0) continue;
                    if(check(tx,ty,i)) {
                        queue.add(new Pair(tx,ty,t.cnt+1));
                        visited[tx][ty] = true;
                    }
                }
                break;
            case 7:    // 7 - ��
                for(int i=2;i<4;i++) {
                    int tx = t.x+dir[i][0];
                    int ty = t.y+dir[i][1];
                    if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
                    if(visited[tx][ty] || arr[tx][ty]==0) continue;
                    if(check(tx,ty,i)) {
                        queue.add(new Pair(tx,ty,t.cnt+1));
                        visited[tx][ty] = true;
                    }
                }
                break;
            }
        }
    }
    public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j])
					System.out.print("T" + " ");
				else
					System.out.print("F" + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
    
    // ���� ������ �Ǿ��ִ����� Ȯ���ؾ���!!
    private static boolean check(int x,int y,int i) {
        int t = arr[x][y];
        // �ٽ� ���ư� �� �ִ���.
        switch(i) {
        case 0: // �Ʒ��� �°� -> �ٽ� ���� ���ư� �� �־����.
            if(t==3||t==5||t==6) return false;
            break;
        case 1: // ���������� �°� -> �ٽ� �������� 
            if(t==2||t==4||t==5) return false;
            break;
        case 2: // ���� �°� -> �ٽ� �Ʒ���
            if(t==3||t==4||t==7) return false;
            break;
        case 3: // �������� �°� -> �ٽ� ����������
            if(t==2||t==6||t==7) return false;
            break;
        }
        
        return true;
    }
    
    static class Pair{
        private int x,y,cnt;
        public Pair(int x,int y,int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}