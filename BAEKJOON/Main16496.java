package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main16496 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Word> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			list.add(new Word(st.nextToken()));
		}
		Collections.sort(list);
		String str="";
		for(int i=0;i<N;i++) {
			str+=list.get(i).value;
		}
		if(str.charAt(0) == '0')
			System.out.println("0");
		else
			System.out.println(str);
		
	}
	
	public static class Word implements Comparable<Word> {
		String value;
			Word(String value){
				this.value=value;
			}
			@Override
			public int compareTo(Word o) {
				// TODO Auto-generated method stub
				String val=o.value+this.value;
				String val1=this.value+o.value;
				return val.compareTo(val1);
			}
	}

}
