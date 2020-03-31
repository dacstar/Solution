import java.util.Arrays;
import java.util.TreeMap;

public class Solution3333 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {60,50,5};
		
		String str2[] =new String[arr.length];
		String str[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		int answer[]=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			int num = arr[i];
			str2[i]="";
			if(num>9) {
				String str3=num+"";
				for(int j=0;j<str3.length();j++) {
					str2[i]+=str[str3.charAt(j)-'0'];
				}
			}else {
				str2[i]=str[num];
			}
		}
		Arrays.sort(str2);
		StringBuilder sb2;
		for(int i=0;i<str2.length;i++) {
			if(str2[i].length()>5) {
				String sb ="";
				sb2 =new StringBuilder();
				for(int j=0;j<str2[i].length();j++) {
					sb+=(str2[i].charAt(j)+"");
					if(sb.equals("one")) {
						sb2.append("1");
						sb ="";
					}
				}
				answer[i]=Integer.parseInt(sb2.toString());
			}else {
				if(str2[i]=="one") {
					answer[i]=1;
				}else if(str2[i]=="five") {
					answer[i]=5;
				}else if(str2[i]=="four") {
					answer[i]=4;
				}
			}
		}
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
		
		
	}

}
