
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="cookie";
		String s2="cooookieee";
		if(s1.length()>s2.length()) {
			System.out.println("false");
		}else {
			int cnt=0;
			int pre=0;
			for(int i=0;i<s1.length();i++) {
				if(pre !=0 && s1.charAt(i) ==s2.charAt(pre)) {
					
					continue;
				}
				
				if(s1.charAt(i) !=s2.charAt(cnt)) {
					System.out.println("false");
					return ;
				}
				for(int j=cnt;j<s2.length();j++) {
					if(s1.charAt(i) == s2.charAt(j)) {
						continue;
					}else {
						cnt=j;
						pre=j-1;
						break;
					}
						
				}
			}
		
		}
		
		
		System.out.println("true;");
		
		
		
	}

}
