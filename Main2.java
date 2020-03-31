import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main2 {
	static int arrMin;
	static int[] order;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		arrMin = Integer.MAX_VALUE;
		String[] input = br.readLine().split(" ");
		int n= Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		int[][] arr = new int[n][m];
		int sum = 0;
		for(int i=0; i<n; ++i) {
			input = br.readLine().split(" ");
			sum = 0;
			for(int j=0; j<m; ++j) {
				arr[i][j] = Integer.parseInt(input[j]);
				sum += arr[i][j];
			}
			arrMin = sum;
		}
		int[][] command = new int[k][3];
		order = new int[k];
		for(int i=0; i<k; ++i) {
			input = br.readLine().split(" ");
			for(int j=0; j<3; ++j) {
				command[i][j] = Integer.parseInt(input[j]);
			}
		}
		selectOrder(k, 0, new boolean[k], arr, command);
		bw.write(""+arrMin+"\n");
		bw.close();
		br.close();
	}
	
	
	static void selectOrder(int k, int depth, boolean[] select, int[][] arr, int[][] command) {
		if(depth == k) {
			conduct(arr, command);
			return;
		}
		for(int i=0; i<k; ++i) {
			if(select[i]) continue;
			select[i] = true;
			order[depth] = i;
			selectOrder(k, depth+1, select, arr, command);
			select[i] = false;
		}
	}

	static void conduct(int[][] arr, int[][] command) {
		int[][] temp = new int[arr.length][arr[0].length];
		for(int i=0; i<arr.length; ++i) {
			for(int j=0; j<arr[i].length; ++j) {
				temp[i][j] = arr[i][j];
			}
		}
		// 원본은 보존해야하니 복사본 만듬
		
		for(int i=0; i<order.length; ++i) {
			temp = turnArr(command[order[i]], temp);
		}
		
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i=0; i<temp.length; ++i) {
			sum = 0;
			for(int j=0; j<temp[i].length; ++j) {
				sum+= temp[i][j];
			}
			if(sum < min) {
				min = sum;
			}
		}
		if(min < arrMin) {
			arrMin = min;
		}
		
		
	}
	
	static int[][] turnArr(int[] command, int[][] arr){
		int r = command[0]-1;
		int c = command[1]-1;
		int s = command[2];
		int rowStart = r-s;
		int rowEnd = r+s;
		int colStart = c-s;
		int colEnd = c+s;
		int rightIdx = 0;
		int leftIdx = 0;
		int upIdx = 0;
		int downIdx = 0;
		int[] rowTemp = new int[s*2];
		for(int i=rowStart; i<r; ++i) {
			rowTemp[rightIdx] = arr[i][colEnd-rightIdx];
			for(int j=colEnd-rightIdx; j>colStart+rightIdx; --j) {
				arr[i][j] = arr[i][j-1];
			}
			++rightIdx;
		}
		for(int i=r+1; i<=rowEnd; ++i) {
			rowTemp[s+leftIdx] = arr[i][colStart + s - leftIdx - 1];
			for(int j=colStart + s - leftIdx - 1; j<colEnd - s + leftIdx + 1; ++j) {
				arr[i][j] = arr[i][j+1];
			}
			++leftIdx;
		}
		for(int j=colEnd; j>c; --j) {
			for(int i=rowEnd-downIdx; i>rowStart+downIdx; --i) {
				arr[i][j] = arr[i-1][j];
			}
			arr[rowStart+downIdx+1][j] = rowTemp[downIdx];
			++downIdx;
		}
		
		for(int j=c-1; j>=colStart; --j) {
			for(int i = rowStart + s - upIdx - 1; i< rowEnd - s + upIdx + 1; ++i) {
				arr[i][j] = arr[i+1][j];
			}
			arr[rowEnd - s + upIdx][j] = rowTemp[upIdx + s];
			++upIdx;
		}
		
		
//		for(int i=0; i<arr.length; ++i) {
//			for(int j=0; j<arr[i].length; ++j) {
//				System.out.print(arr[i][j]+"\t");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		return arr;
	}

}