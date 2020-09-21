package LeetCode;

public class Mountainarray {

	public int findInMountainArray(int target, MountainArray mountainArr) {
		int peek = binaryPeekSearch(1, mountainArr.length() - 1, mountainArr);
		int left_index = binaryLeft(0, peek, mountainArr, target);
		int right_index = binaryRight(peek, mountainArr.length() - 1, mountainArr, target);

		if (left_index != -1) {
			return left_index;
		} else if (right_index != -1) {
			return right_index;
		} else {
			return -1;
		}
	}

	public int binaryPeekSearch(int left, int right, MountainArray mountainArr) {
		int middle = (left + right) / 2;

		int peek = mountainArr.get(middle);
		int down = mountainArr.get(middle - 1);
		int up = mountainArr.get(middle + 1);

		if (down < peek && peek > up) {
			return middle;
		} else if (down < peek && peek < up) {
			return binaryPeekSearch(middle + 1, right, mountainArr);
		} else if (down > peek && peek > up) {
			return binaryPeekSearch(left, middle - 1, mountainArr);
		} else {
			return -1;
		}

	}

	public int binaryLeft(int left, int right, MountainArray mountainArr, int target) {
		if (left > right) {
			return -1;
		}

		int middle = (left + right) / 2;
		int value = mountainArr.get(middle);

		if (value == target) {
			return middle;
		} else if (value > target) {
			return binaryLeft(left, middle - 1, mountainArr, target);
		} else {
			return binaryLeft(middle + 1, right, mountainArr, target);
		}
	}

	public int binaryRight(int left, int right, MountainArray mountainArr, int target) {
		if (left > right) {
			return -1;
		}

		int middle = (left + right) / 2;
		int value = mountainArr.get(middle);

		if (value == target) {
			return middle;
		} else if (value > target) {
			return binaryRight(middle + 1, right, mountainArr, target);
		} else {
			return binaryRight(left, middle - 1, mountainArr, target);
		}
	}

	public static void main(String[] args) {
		int target = 0;
		Mountainarray s = new Mountainarray();
		int[] array = { 3, 5, 3, 2, 0 };

		MountainArray mountainArray = new MountainArray(array);
		int result = s.findInMountainArray(target, mountainArray);
		System.out.println(result);
	}

	static class MountainArray {
		int[] array;

		public MountainArray(int[] array) {
			super();
			this.array = array;
		}

		public int get(int k) {
			return array[k];
		}

		public int length() {
			return array.length;
		}

	}
}