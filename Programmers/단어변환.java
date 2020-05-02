package Programmers;

public class 단어변환 {
	static boolean visit[];
	static int res=1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String word[] = { "hot", "dot", "dog", "lot", "log", "cog" };
		boolean check = false;
		visit = new boolean[word.length];
		for (int i = 0; i < word.length; i++) {
			if (word[i].equals(target)) {
				check = true;
			}
		}
		if (!check) {
			System.out.println("0");
			return;
		}
		DFS(begin,target,word,0);
		System.out.println(res);
		
	}

	public static void DFS(String begin,String target, String word[], int n) {
		for (int i = 0; i < word.length; i++) {
			if (visit[i])
				continue;
			String str = word[i];
			int same=0;
			boolean wor[]=new boolean[str.length()];
			for (int j = 0; j < begin.length(); j++) {
				
				for (int k = 0; k < str.length(); k++) {
					if(wor[k])
						continue;
					if(begin.charAt(j) == str.charAt(k)) {
						same++;
						wor[k]=true;
						break;
					}
				}
			}
			if(begin.length()-1 == same) {
				if(target.equals(word[i])) {
					res=Math.min(n+1, res);
					return ;
				}else {
					visit[i]=true;
					DFS(word[i],target,word,n+1);
					visit[i]=false;
				}
			}
		}

	}

}
