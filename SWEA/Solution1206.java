package SWEA;

import java.util.Scanner;

public class Solution1206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int width=s.nextInt();
			int view[]= new int[width];
			for(int i=0;i<width;i++) {
				view[i]=s.nextInt();
			}
			int max=0;
			int res=0;
			for(int i=2;i<width-2;i++) {
				max=0;
				boolean visit=false;
				for(int j=i-1;j>=i-2;j--) {
					if(view[i]<=view[j]) {
						visit=false;
						break;
					}
					else {
						visit=true;
						max=Math.max(max, view[j]);
					}
				}
				if(!visit)
					continue;
				for(int j=i+1;j<=i+2;j++) {
					if(view[i]<=view[j]) {
						visit=false;
						break;
					}
					else {
						visit=true;
						max=Math.max(max, view[j]);
					}
				}
				
				if(visit) {
					res+=Math.abs(view[i]-max);
				}
			}
			System.out.println("#"+t+" "+res);

		}
	}

}
