import java.util.Scanner;

public class Solution6603 {
	static boolean check[];
	static int arr[];
	static int num[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		while(true) {
			int k=s.nextInt();
			if(k==0)
				break;
			arr = new int[k];
			num = new int[6];
			for(int i=0;i<k;i++) {
				arr[i]=s.nextInt();
			}
			check =new boolean[k];
			DFS(0,-1);
			System.out.println();
		}
	}
	static void DFS(int start,int idx) {
		if(start == num.length) {
			for(int i=0;i<num.length;i++) {
				System.out.print(num[i]+" ");

			}
			System.out.println();
			return ;
		}else {
			for(int i=idx+1;i<arr.length;i++) {
				num[start]=arr[i];
				DFS(start+1,i);
			}
		}

	}

}
