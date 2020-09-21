package LeetCode;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="021";
		System.out.println(reverse(1534236469));
	}
	
	 public static int reverse(int x) {
	        String s=x+"";
	        String result="";
	        if(s.charAt(0) == '-') {
	        	result="-";
	        	for(int i=s.length()-1;i>=1;i--) {
	        		result+=(s.charAt(i)+"");
	        	}
	        }else {
	        	for(int i=s.length()-1;i>=0;i--) {
	        		result+=(s.charAt(i)+"");
	        	}
	        }
	        
	        
		 try {
			 int re=Integer.parseInt(result);
			 return re;
		 }catch(NumberFormatException e) {
			 return 0;
		 }
		 
	    }

}
