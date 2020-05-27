package Programmers;

public class 사탕크러쉬팡 {
	static int map[][] = { { 1, 1, 3, 3 }, { 4, 1, 3, 4 }, { 1, 2, 1, 1 }, { 2, 1, 3, 2 } };
	static boolean rotate;
	static int res = 0;
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp[][] = new int[map.length][map[0].length];

		for (int i = 0; i < map.length - 1; i++) {
			for (int j = 0; j < map[0].length; j++) {
				copy(temp);
				result=1;
				temp[i][j] = 0;
				while (true) {
					rotate = false;
					move(temp);
//					print(temp);
					play(temp);
					if (!rotate)
						break;
				}
				res=Math.max(res, result);
			}
		}
		System.out.println(res);

	}

	public static void play(int arr[][]) {
		boolean visit[][] = new boolean[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0)
					continue;
				if (visit(arr, i, j, arr[i][j], 1)) {
					rotate = true;
					for (int a = j; a < arr[0].length; a++) {
						if (arr[i][j] == arr[i][a])
							visit[i][a] = true;
					}
				}
				if (visit(arr, i, j, arr[i][j], 0)) {
					rotate = true;
					for (int a = i; a < arr.length; a++) {
						if (arr[i][j] == arr[a][j])
							visit[a][j] = true;
					}
				}
			}
		}
		if (rotate) {
//			print2(visit);
//			System.out.println();
			delete(visit, arr);

		}

	}

	public static void delete(boolean visit[][], int arr[][]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (visit[i][j]) {
					arr[i][j] = 0;
					result++;
				}
			}
		}

	}

	public static boolean visit(int arr[][], int ny, int nx, int candy, int d) {
		int sum = 1;
		if (d == 0) {
			while (true) {
				sum++;
				ny++;
				if (!check(ny, nx) || arr[ny][nx] != candy) {
					sum--;
					break;
				}
			}
		} else {
			while (true) {
				sum++;
				nx++;
				if (!check(ny, nx) || arr[ny][nx] != candy) {
					sum--;
					break;
				}
			}

		}

		if (sum >= 3) {
			return true;
		} else {
			return false;
		}
	}

	public static void copy(int arr[][]) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				arr[i][j] = map[i][j];
			}
		}

	}

	public static void print(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void print2(boolean arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void move(int arr[][]) {
		for (int i = map.length - 1; i >= 0; i--) {
			for (int j = 0; j < map[0].length; j++) {
				if (arr[i][j] == 0)
					continue;
				int ny = i;
				int color = arr[i][j];
				while (true) {
					if (!check(ny + 1, j) || arr[ny + 1][j] != 0)
						break;
					ny++;
				}
				arr[i][j] = 0;
				arr[ny][j] = color;
			}
		}
	}

	static boolean check(int y, int x) {

		if (y >= map.length || y < 0 || x >= map[0].length || x < 0)
			return false;

		return true;
	}

}
