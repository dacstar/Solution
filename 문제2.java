import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 문제2 {
	/*
	 * 
| expression             | result |
| ---------------------- | ------ |
| `"100-200*300-500+20"` | 60420  |
| `"50*6-3*2"`           | 300    |
	 * 
	 * 
	 */
	static ArrayList<String> Operater = new ArrayList<String>();
	static boolean check[];
	static int max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression="50*6-3*2";
		Queue<String> q = new LinkedList<String>();
		max=-1;
		String str="";
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '+') {
				Operater.add(expression.charAt(i)+"");
				q.add(str);
				q.add(expression.charAt(i)+"");
				str="";
			}else {
				str+=(expression.charAt(i)+"");
			}
		}
		q.add(str);
		check = new boolean[Operater.size()];
		DFS(0,q);
		System.out.println(max);
		
		
	}
	
	public static void DFS(int depth,Queue<String> q) {
		if(check.length == depth) {
			max=Math.max(max, Math.abs(Integer.parseInt(q.poll())));
			return ;
		}
		
		for(int i=0;i<check.length;i++) {
			if(check[i])
				continue;
			check[i]=true;
			Queue<String> copyQue = new LinkedList<String>();
			while (copyQue.size() < q.size()) {
				String temp = q.poll();
				q.add(temp);
				copyQue.add(temp);
			}
			cal(copyQue,i);
			DFS(depth+1,copyQue);
			check[i]=false;
		}
		
	}
	
	public static void cal(Queue<String> copyQue,int idx) {
		String op = Operater.get(idx);
		Stack<String> stack = new Stack<String>();
		int sum=0;
		while(!copyQue.isEmpty()) {
			String str=copyQue.poll();
			if(str.equals(op)) {
				String num1=copyQue.poll();
				String num2=stack.pop();
				if(op.equals("*")) {
					sum=Integer.parseInt(num2)*Integer.parseInt(num1);
				}else if(op.equals("-")) {
					sum=Integer.parseInt(num2)-Integer.parseInt(num1);
				}else {
					sum=Integer.parseInt(num2)+Integer.parseInt(num1);
				}
				stack.add(sum+"");
				continue;
			}
			stack.add(str);
		}
		for(String str : stack)
			copyQue.add(str);
		
		
	}

}
