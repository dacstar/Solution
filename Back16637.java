import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Back16637 {
	static ArrayList<String> list;
	static int N;
	static long max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		max =-100;
		list = new ArrayList<>();
		String str=s.next();
		for(int i=0;i<N;i++) {
			list.add(str.charAt(i)+"");
		}
		DFS(0);
		System.out.println(max);
	}
	
	
	static void DFS(int depth) {
//		for(String s: list) System.out.print(s);
//		System.out.println();
		
		max=Math.max(max, cal(list));
		if(depth >=N+4) {
			return ;
		}
		
		
		for(int i=0;i<N-2;i+=2) {
			if(!list.get(i).equals("(") && !list.get(i).equals(")")) {
				boolean flag=true;
				for(int j=i;j<i+3;j++) {
					if(list.get(j).equals("(") || list.get(j).equals(")"))
						flag=false;
				}
				
				if(flag) {
					list.add(i,"(");
					list.add(i+4,")");
					DFS(i+3);
					list.remove(i);
					list.remove(i+3);
				}
			}
		}
	}
	
	static long cal(ArrayList<String>input) {
		Stack<String> st = new Stack<>();
		long result=0,temp;
		String pop="", cur="";
		for(int i=0;i<input.size();i++) {
			cur = input.get(i);
			if(cur.equals(")")) {
				temp = 0;
				ArrayList<String> sub = new ArrayList<String>();
				while(!st.peek().equals("(")) {
						pop = st.pop();
						sub.add(0,pop);
				}
				if(st.peek().equals("(")) {
					st.pop();
					temp = cal(sub);
					st.push(temp+"");
				}
			}else {
				st.push(cur);
			}
		}
		/*괄호를 미리 계산한 수식 계산*/
		Stack<String> forResult = new Stack<String>();
		while(!st.isEmpty()) forResult.push(st.pop());
		while(!forResult.isEmpty()) {
			String str=forResult.pop();
			if(str.equals("+")) {
				result+=Integer.parseInt(forResult.pop());
			}else if(str.equals("-")) {
				result-=Integer.parseInt(forResult.pop());
			}else if(str.equals("*")) {
				result*=Integer.parseInt(forResult.pop());
			}else{
				result=Integer.parseInt(str);
			}
		}
		return result;
		
	}

}
