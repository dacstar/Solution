package BAEKJOON;

import java.util.Scanner;

public class Main2941 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		Scanner s = new Scanner(System.in);
		String st=s.next();
		for(int i=0;i<str.length;i++) {
			st=st.replace(str[i], "1");
		}
		System.out.println(st.length());
	}

}
