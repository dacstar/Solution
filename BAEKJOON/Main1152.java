package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main1152 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		ArrayList<String> hash = new ArrayList<String>();
		for(int i=0;i<str.length;i++) {
			if(!str[i].equals(""))
			hash.add(str[i]);
		}
		System.out.println(hash.size());
		
	}

}
