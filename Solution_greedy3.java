import java.util.Arrays;
import java.util.Stack;

public class Solution_greedy3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="4177252841";
		Stack<Integer> st = new Stack<Integer>();
		int k=4;
		for(int i=0;i<str.length();i++){
			if(i==0) {
				st.add(str.charAt(i)-'0');
				continue;
			}
			int value=st.peek();
			
			if(k>0 ) {
				while(!st.isEmpty()) {
					if(k == 0) {
						st.add(str.charAt(i)-'0');
						break;
					}
					if(st.peek() > str.charAt(i)-'0') {
						st.add(str.charAt(i)-'0');
						break;
					}else if(st.peek() < str.charAt(i)-'0') {
						st.pop();
						k--;
					}else if(str.charAt(i)-'0' == value) {
						st.add(value);
						break;
					}
					
					if(st.isEmpty()) {
						st.add(str.charAt(i)-'0');
						break;
					}
					
				}
			}else if(k==0) {
				st.add(str.charAt(i)-'0');
			}
			if(k==0 && st.size() == str.length()-k)
				break;
		}
		StringBuilder stt = new StringBuilder();
		for(int i=0;i<st.size();i++) {
			stt.append(st.get(i));
		}
		System.out.println(stt.toString());
		
		
	}

}
