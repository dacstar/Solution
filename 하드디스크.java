
public class 하드디스크 {

	static boolean check[];
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 2;
		int capacity = 5;
		result=0;
		int files[] = { 1, 2, 3, 4, 5 };
		check = new boolean[files.length];
		int disk[] = new int[N];
		DFS(0,files,capacity,0,disk);
		System.out.println(result);
	}

	public static void DFS(int depth, int files[], int capacity, int cnt, int disk[]) {
		if (depth == check.length) {
			result=Math.max(cnt, result);
			return;
		}

		for (int i = 0; i < disk.length; i++) {
			if (disk[i] + files[depth] <= capacity) {
				check[depth] = true;
				disk[i] += files[depth];
				DFS(depth + 1, files, capacity, cnt + 1, disk);
				check[depth] = false;
				disk[i] -=files[depth];
			}
			DFS(depth + 1, files, capacity, cnt , disk);

		}
	}

}
