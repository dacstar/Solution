import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main1113_DFS {
    private static int[][] map;
    private static boolean[][] visited;
    private static int m;
    private static int n;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    private static int N;
    private static int M;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
        M = Integer.parseInt(st.nextToken());
 
        N = Integer.parseInt(st.nextToken());
 
        map = new int[M][N];
 
        visited = new boolean[M][N];
 
        st = new StringTokenizer(br.readLine(), " ");
 
        m = Integer.parseInt(st.nextToken());
 
        n = Integer.parseInt(st.nextToken());
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
 
        }
        dfs(0,0,0,-1);
        System.out.println(minNum);
    }// end of main
    static int minNum = Integer.MAX_VALUE;
    public static void dfs(int x, int y, int cnt, int dir) {
        visited[x][y] = true;
        
        if(x == m && y ==n) {//종료 조건
            minNum = minNum > cnt ? cnt : minNum;
            return;
        }
        
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >=0 && ny >=0 && nx < M && ny < N && !visited[nx][ny] && map[nx][ny] ==1) {
                if(dir == -1 || dir ==i) {
                    dfs(nx, ny, cnt, i); //방향전환이 이루어지지 않을때 그냥 재귀호출
                }else {
                    dfs(nx, ny ,cnt+1 , i); // 방향전환 이루어 졌을때 cnt+1 재귀 호출
                } 
                visited[nx][ny] = false; //그 전자리로 돌아가야되기 때문에 visited체크 풀어줌
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
}//e