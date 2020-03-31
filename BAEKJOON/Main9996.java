package BAEKJOON;

import java.util.ArrayList;
import java.util.Scanner;

public class Main9996 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int N=s.nextInt();
		String str=s.next();
		ArrayList<String> left = new ArrayList<String>();
		ArrayList<String> right = new ArrayList<String>();
		int idx=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='*') {
				idx=i;
				break;
			}
		}
		
		for(int i=0;i<idx;i++) {
			left.add(str.charAt(i)+"");
		}
		for(int i=idx+1;i<str.length();i++) {
			right.add(str.charAt(i)+"");
		}
		for(int i=0;i<N;i++) {
			boolean check=false;
			String str2=s.next();
			for(int j=0;j<idx;j++) {
				String s2=left.get(j);
				if(s2.charAt(0) != str.charAt(j)) {
					check=true;
					System.out.println("NE");
				}
			}
			if(check)
				continue;
			
			int cnt=0;
			String ri=right.get(cnt);
			boolean visit=false;
			for(int a=idx+1;a<str2.length();a++) {
				if(str2.charAt(a) == ri.charAt(0)) {
					visit=true;
					int sum=str2.length()-a-1;
					if(sum>right.size()-cnt) {
						System.out.println("NE");
						break;
					}else {
						cnt++;
						if(cnt <right.size()) {
						ri=right.get(cnt);
						}else {
							break;
						}
					}
				}
		}if(visit)
		System.out.println("DA");
		else {
			System.out.println("NE");
		}
		}
		
		
	}

}
