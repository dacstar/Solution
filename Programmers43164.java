import java.util.ArrayList;
import java.util.Collections;

public class Programmers43164 {
	static String str[][]={ { "ICN", "COO" }, { "COO", "ICN" },{ "COO", "ICN" }};
	static ArrayList<String> list;
	static boolean check[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list = new ArrayList<String>();
		
		for(int i=0;i<str.length;i++) {
			if(str[i][0].equals("ICN")) {
				check = new boolean[str.length];
				check[i]=true;
				DFS(str[i][1],"ICN"+" ",0);
				check[i]=false;
			}
		}
		Collections.sort(list);

		for(int j=0;j<list.size();j++){
			System.out.print(list.get(j)+" ");
		}
	}

	static void DFS(String word,String str2,int cnt) {
		if(cnt == str.length) {
			
			list.add(str2);
			return;
		}

		for(int i=0;i<str.length;i++) {
			if(str[i][0].equals(word) && !check[i]) {
				check[i]=true;
				DFS(str[i][1],str2+=str[i][1]+" ",cnt+1);
				check[i]=false;
			}
		}


	}

}
