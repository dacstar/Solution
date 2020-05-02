package Programmers;

import java.util.Arrays;
import java.util.HashSet;

public class Programmers_불량사용자 {
	static boolean visit[];
	static int N;
	static int res;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id= {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id= {"fr*d*", "*rodo", "******", "******"};
		HashSet<String> asd = new HashSet<String>();
		visit =new boolean[user_id.length];
		N=banned_id.length;
		Arrays.sort(user_id);
		res=0;
		DFS(0,"",0,user_id,banned_id,asd);
		System.out.println(res);
	}


	public static void DFS(int depth,String str,int idx,String[] user_id,String[] banned_id,HashSet<String> hash) {
		if(idx == N) {
		    res++;
			return ;
		}

		for(int i=0;i<user_id.length;i++) {
			if(visit[i])
				continue;
			if(ch(str,user_id[i]) && wordcheck(user_id[i],banned_id[idx])) {
				visit[i]=true;
				DFS(i,str+=user_id[i]+" ",idx+1,user_id,banned_id,hash);
				visit[i]=false;
			}
		}


	}
	
	public static boolean ch(String str,String str2) {
		
		String re[]=str.split(" ");
		for(int i=0;i<re.length;i++) {
			if(str2.equals(re[i]))
				return false;
		}
		
		return true;
	}





	public static boolean wordcheck(String user,String ban) {
		if(user.length() != ban.length())
			return false;

		for(int i=0;i<user.length();i++) {
			char a = ban.charAt(i);
			if(a == '*')
				continue;
			else {
				if(a != user.charAt(i))
					return false;
			}
		}

		return true;
	}

}
