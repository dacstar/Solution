
public class 회전 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean answer=false;
		int arrA[]= {4,3,2,1};
		int arrB[]= {5,4,1,2};
		int cnt=arrA.length;
		int rotate[]=new int[arrA.length];
		for(int i=0;i<arrA.length;i++) {
			rotate[i]=arrA[i];
		}
		while(cnt -- > 0) {
		
		boolean visit=false;
		for(int i=0;i<arrB.length;i++) {
			if(arrB[i] != rotate[i]) {
				visit=true;
				break;
			}
		}
		if(!visit) {
			answer=true;
			break;
		}else {
			for(int i=arrA.length-1;i<=(arrA.length*2-2);i++) {
				rotate[(i+1)%arrA.length]=arrA[i%arrA.length];
			}
			
			for(int i=0;i<arrA.length;i++) {
				arrA[i]=rotate[i];
			}
			
		}
		
		}
	
		System.out.println(answer);
	}

}
