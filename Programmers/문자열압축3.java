package Programmers;

public class 문자열압축3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbaccc";
		int answer= s.length();
		for(int i=1;i<=s.length()/2;i++) {
			StringBuilder now = new StringBuilder();
			StringBuilder next = new StringBuilder();
			StringBuilder result = new StringBuilder();
			int hit=1;
			for(int j=0;j<=s.length()/i;j++) {
				int start= j*i;
				int end = i * (j+1) > s.length() ? s.length() : i*(j+1);
				now = new StringBuilder(next.toString());
				next = new StringBuilder(s.substring(start, end));
				if(now.toString().equals(next.toString())) {
					hit++;
				}else {
					result.append(processHit(hit)+""+now.toString());
					hit=1;
				}
			}
			
			result.append(processHit(hit)+""+next.toString());
			answer = Math.min(answer, result.length());
		}
		System.out.println(answer);
		
		
		
	}
	private static String processHit(int hit) {
	    return hit > 1 ? String.valueOf(hit) : "";
	}

}
