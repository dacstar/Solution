import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Back13458 {
	static int N,B,C;
	static int arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int res=0;
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());

		for(int i=0;i<N;i++) {
			arr[i]-=B;
			res++;
		}
		for(int i=0;i<N;i++) {
			if(arr[i]>0) {
				res+=arr[i]/C;
				if(arr[i] % C !=0)
					res++;
			}
				
		}

		System.out.println(res);

	}

}
