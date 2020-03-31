import java.util.Stack;

public class Programmers_level2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean check=false;
		String str=")()(";
		char ch[] = str.toCharArray();
		Stack<Character> st = new Stack<>();
		if(ch[0]==')') {
			System.out.println(check);
				
			return ;
		}
		else
			st.add(ch[0]);
		
		for(int i=1;i<ch.length;i++) {
			if(ch[i]=='(')
				st.add(ch[i]);
			else
				st.pop();
		}
		
		if(st.size()==0)
			check=true;
		
		System.out.println(check);
		
		
	}

}
