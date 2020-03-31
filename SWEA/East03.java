package SWEA;

public class East03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {3,4,5,3,7};
		boolean visit[] = new boolean[A.length];
		int arr[] = new int[A.length-1];
		boolean check=false;
		if(ch(A)) {
			check=true;
		}
		int res=0;
		if(check) {
			System.out.println("0");
			return ;
		}else {
			for(int i=0;i<A.length;i++) {
				visit[i]=true;
				int cnt=0;
				for(int j=0;j<A.length;j++) {
					if(visit[j]) {
						continue;
					}else {
						arr[cnt++]=A[j];
					}
				}
				if(ch(arr)) {
					res++;
				}
				arr = new int[A.length-1];
				visit[i]=false;
			}
			System.out.println(res);
			
		}
		
		
		
	}
	
	
	
	public static boolean ch(int arr[]) {
		boolean high=false;
		boolean row=false;
		boolean check=false;
		for(int i=0;i<arr.length-1;i++) {
			if(!high && !row) {
				if(arr[i]<arr[i+1]) {
					high=true;
				}else if(arr[i]==arr[i+1]) {
					return false;
				}else if(arr[i]>arr[i+1]) {
					row=true;
				}
				continue;
			}
			if(high) {
				if(arr[i] > arr[i+1] ) {
					high=false;
					row=true;
				}else {
					return false;
				}
			}else if(row) {
				if(arr[i]<arr[i+1]) {
					row=false;
					high=true;
				}else {
					return false;
				}
			}
		}
		
		
		
		return true;
	}

}
