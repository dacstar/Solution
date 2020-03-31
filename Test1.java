import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s1[]= {4,99,2,6,7,13,88,76};
		int s2[]= {6,88,13,4,99,2,7};
		Arrays.sort(s1);
		Arrays.sort(s2);
		for(int i=0;i<s1.length;i++) {
			for(int j=0;j<s2.length;j++) {
				if(s1[i]==s2[j]) {
					s1[i]=0;
					break;
				}
			}
		}
		for(int i=0;i<s1.length;i++) {
			if(s1[i]!=0) {
				System.out.println(s1[i]);
				return;
			}
		}
	}

}
