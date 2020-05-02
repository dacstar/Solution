package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers_Æ©ÇÃ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="{{4,2,3},{3},{2,3,4,1},{2,3}}";
		String str[]=s.split("},");
		int[] answer = {};
		boolean visit[] = new boolean[100001];
		for(int i=0;i<str.length;i++) {
			str[i]=str[i].replace("{","");
			str[i]=str[i].replace("}","");
		}
		Arrays.sort(str,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() > o2.length() ? 1 : -1;
			}
		});
		answer = new int[str.length];
		for(int i=0;i<str.length;i++) {
			String val[]=str[i].split(",");
			for(int j=0;j<val.length;j++) {
				int num=Integer.parseInt(val[j]);
				if(!visit[num]) {
					answer[i]=num;
					visit[num]=true;
				}
			}
		}

		
	}

}
