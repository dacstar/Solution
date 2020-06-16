package Programmers;

import java.util.Stack;

public class 괄호_변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "()))((()";
		String answer = Chang(p);
		System.out.println(answer);
	}

	public static String Chang(String str) {

		if(check(str) || str.equals("")) {
			return str;
		}
		
		Stack<String> stack = new Stack<String>();
		int left = 0;
		int right = 0;
		int idx = 0;
		StringBuilder u = new StringBuilder();
		StringBuilder v = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			String s = str.substring(i, i + 1);
			if (s.equals("(")) {
				left++;
				stack.add("(");
			} else {
				right++;
				stack.add(")");
			}

			if (left == right) {
				idx = i;
				break;
			}
		}
		for (String st : stack) {
			u.append(st);
		}
		v = new StringBuilder(str.substring(idx + 1, str.length()));
		if (check(u.toString())) {
			v = new StringBuilder(Chang(v.toString()));
		} else {
			v = new StringBuilder(Chang(v.toString()));
			u = new StringBuilder(u.toString().substring(1, u.length() - 1));
			String ch="";
			for(int i=0;i<u.length();i++) {
				if(u.charAt(i) == '(') {
					ch+=")";
				}else {
					ch+="(";
				}
			}
			StringBuilder uv = new StringBuilder("(");
			uv.append(v);
			uv.append(")");
			uv.append(ch);
			return uv.toString();
		}
		return u.append(v.toString()).toString();
	}

	public static boolean check(String p) {

		Stack<String> st = new Stack<String>();
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == ')') {
				if (st.isEmpty()) {
					return false;
				} else {
					st.pop();
				}
			} else {
				st.add("(");
			}
		}

		return true;
	}
	
	

}
