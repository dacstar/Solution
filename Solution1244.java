import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution1244 {

	static int arr[];
	static int max;
	static int count;
	static boolean check[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			arr = new int[str.length()];
			max=Integer.parseInt(str);
			count=Integer.parseInt(st.nextToken());
			for(int i=0;i<str.length();i++) {
				arr[i]=str.charAt(i)-'0';
			}
			check = new boolean[count][arr.length];
			DFS(0,0);
			System.out.println("#"+test_case+" "+max);

		}
	}


	static void DFS(int cnt,int start) {
		if(cnt==count) {
			String str = "";
			for(int i=0;i<arr.length;i++) {
				str+=arr[i];
			}
			max=Math.max(max, Integer.parseInt(str));
			return ;
		}
		
		if(start==arr.length) {
			return ;
		}

		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				swap(i,j);
				DFS(cnt+1,0);
				swap(i,j);
			}
		}




	}
	
	static int change() {
		
		String str = "";
		for(int i=0;i<arr.length;i++) {
			str+=arr[i];
		}
		
		return Integer.parseInt(str);
		
	}

	static void swap(int start,int end) {
		int temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;

	}

}
