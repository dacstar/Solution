import java.util.Scanner;

public class Baek17211 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		int temp=s.nextInt();
		double arr[] = new double[4];
		for(int i=0;i<4;i++) {
			arr[i]=s.nextDouble();
		}
		double sad=arr[3];
		double happy=arr[2];
		for(int i=0;i<N;i++) {
			if(temp==1) {
				sad+=arr[3];
				happy+=arr[2];
			}else {
				happy+=arr[0];
				sad+=arr[1];
			}
		}
		sad*=1000;
		happy*=1000;
		System.out.println(Math.round(happy));
		System.out.println(Math.round(sad));
		
		
		}

}
