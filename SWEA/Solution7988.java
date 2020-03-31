package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7988 {
	static HashMap<String,Integer> player;
	static ArrayList<Integer>[] synergy;
	static int visit[];
	static boolean check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int K = Integer.parseInt(br.readLine());
			player = new HashMap<String, Integer>();
	        player.clear();
			synergy = new ArrayList[200];
			visit = new int[200];
			check=true;
			int idx=0;
			 for (int i = 0; i < synergy.length; i++) {
		            synergy[i] = new ArrayList<>();
		        }
			for(int i=0;i<K;i++) {
				int idx1,idx2;
				StringTokenizer st = new StringTokenizer(br.readLine());
				String p1=st.nextToken();
				String p2=st.nextToken();
				if(player.containsKey(p1)) {
					idx1=player.get(p1);
				}else {
					idx1=idx;
					player.put(p1, idx++);
				}
				if(player.containsKey(p2)) {
					idx2=player.get(p2);
				}else {
					idx2=idx;
					player.put(p2,idx++);
				}
				synergy[idx1].add(idx2);
				synergy[idx2].add(idx1);
			}
			Arrays.fill(visit, -1);
			  for(int i=0;i<idx;i++) {
				  BFS(i);
				  if(!check)
					  break;
			  }
			  if(!check)
				  System.out.println("#"+t+" "+"NO");
			  else
				  System.out.println("#"+t+" "+"YES");
		}
	}
	static void BFS(int idx) {
		Queue<Integer> q= new LinkedList<>();
		q.add(idx);
		if(visit[idx]==-1)
			visit[idx]=1;
		else
			return ;
		while(!q.isEmpty()) {
			int cnt_idx=q.poll();
			for(int i : synergy[cnt_idx]) {
				if(visit[i] !=-1 && visit[cnt_idx]==visit[i] ) {
					check=false;
					return ;
				}else if(visit[i]==-1) {
					visit[i]=visit[cnt_idx]==1 ? 0 : 1;
					q.add(i);
				}
			}
			
		}
	}

}
