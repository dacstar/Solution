package Programmers;

public class 비밀번호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p="82195";
		String s="64723";
		System.out.println(count(p,s));
	}
	
	public static int count(String p,String s){
		int cnt=0;
		for(int i=0;i<p.length();i++) {
			int min=Integer.MAX_VALUE;
			int number=p.charAt(i)-'0';
			int answer=s.charAt(i)-'0';
			int sum=0;
			//정방향
			while(true) {
				if(number == answer) {
					min=Math.min(min, sum);
					break;
				}
				number=(number+1)%10;
				sum++;
			}
			number=p.charAt(i)-'0';
			answer=s.charAt(i)-'0';
			sum=0;
			//역방향
			while(true) {
				if(number == answer) {
					min=Math.min(min, sum);
					break;
				}
				number=(number-1+10)%10;
				sum++;
			}
			cnt+=min;
		}
		
		
		
		return cnt;
	}

}
