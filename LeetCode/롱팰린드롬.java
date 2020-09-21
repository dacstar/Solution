package LeetCode;

public class 롱팰린드롬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("abcdefga"));
		
	}
	
	public static String longestPalindrome(String s) {
		if(s.length() <= 1 )
			return s;
		
	    String result = "";
	    for(int i=0;i<s.length();i++) {
	    	
	    	String odd = expandRange(s, i, i);
	    	if(odd.length() > result.length()) {
	    		result = odd;
	    	}
	    	
	    	String even = expandRange(s, i, i+1);
	    	
	    	if(even.length() > result.length()) {
	    		result = even;
	    	}
	    	
	    }
		
		return result;
	}
	
	
	public static String expandRange(String s, int left, int right) {
		
		String string =s;
		
		while(left >=0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		
		return string.substring(left+1,right);
	}
	
	
	

}
