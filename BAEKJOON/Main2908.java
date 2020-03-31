package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2908 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a=st.nextToken();
		String b=st.nextToken();
		int first=Integer.parseInt(sb.append(a).reverse().toString());
		int second=Integer.parseInt(sb.append(b).reverse().toString());
		if(first>second) {
			System.out.println(first);
		}else {
			System.out.println(second);
		}
	}

}
