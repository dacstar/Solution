package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1251 {
	static XY line[];
	static XY xy[];
	static int parents[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			line = new XY[N * N];
			xy = new XY[N];
			parents = new int[N];
			String tempY[] = br.readLine().split(" ");
			String tempX[] = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				xy[i]=new XY(Integer.parseInt(tempY[i]),Integer.parseInt(tempX[i]));
			}
			double e = Double.parseDouble(br.readLine());
			int count=0;
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					line[count]=new XY(i,j);
					line[count++].value=(long)(xy[i].y-xy[j].y) * (xy[i].y-xy[j].y) + (long)(xy[i].x-xy[j].x) *(xy[i].x-xy[j].x);
				}
			}
			double ans=0;
			Arrays.sort(line);
			Arrays.fill(parents, -1);
			for(int i=0;i<line.length;i++) {
				XY xy=line[i];
				if(xy.value==0) continue;
				if(union(xy.x,xy.y)) {
					ans +=xy.value;
				}
			}
			ans *=e;
			System.out.println("#"+t+" "+Math.round(ans));
		}
	}
	
	public static int find(int idx) {
		if(parents[idx] <0) {
			return idx;
		}
		
		return parents[idx]=find(parents[idx]);
	}
	public static boolean union(int y,int x) {
		int left=find(y);
		int right=find(x);
		if(left != right) {
			parents[right]=left;
			return true;
		}
		return false;
	}

	public static class XY implements Comparable<XY> {
		int y;
		int x;
		long value;

		XY(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(XY o) {
			// TODO Auto-generated method stub
			return Long.compare(this.value, o.value);
		}
	}

}
