package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 기둥과_보 {
	static int n;
	static int map[][];
	static int box, gi;
	static ArrayList<XY> list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int build_xy[][] = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };
		n = 5;
		list = new ArrayList<>();
		for (int i = 0; i < build_xy.length; i++) {
			int x = build_xy[i][0];
			int y = build_xy[i][1];
			int a = build_xy[i][2];
			int b = build_xy[i][3];
			XY xy = new XY(x, y, a);
			if (b == 1) {
				list.add(xy);
				if (bridge())
					continue;
				list.remove(xy);
			} else {
				list.remove(xy);
				if (bridge())
					continue;
				list.add(xy);
			}
		}
		Collections.sort(list, new Comparator<XY>() {

			@Override
			public int compare(XY o1, XY o2) {

				if (o1.x < o2.x)
					return -1;
				else if (o1.x == o2.x) {

					if (o1.y < o2.y)
						return -1;
					else if (o1.y == o2.y) {

						if (o1.v < o2.v)
							return -1;
						else
							return 1;
					}
				}

				return 1;
			}

		});
		int answer[][] = new int[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			answer[i][0] = list.get(i).x;
			answer[i][1] = list.get(i).y;
			answer[i][2] = list.get(i).v;
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i][0] + " " + answer[i][1] + " " + answer[i][2]);
		}

	}

	public static boolean bridge() {

		for (XY xy : list) {
			if (xy.v == 0) {
				if(xy.y == 0 || list.contains(new XY(xy.x,xy.y-1,0)) || list.contains(new XY(xy.x-1,xy.y,1)) || list.contains(new XY(xy.y,xy.x,1))) {
					continue;
				}else {
					return false;
				}

			} else {
				if(list.contains(new XY(xy.x,xy.y-1,0)) || list.contains(new XY(xy.x+1,xy.y-1,0)) || (list.contains(new XY(xy.x-1,xy.y,1)) && list.contains(new XY(xy.x+1,xy.y,1)))) {
					continue;
				}else {
					return false;
				}
				
			}
		}

		return true;

	}

	public static void print(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static class XY {
		int y;
		int x;
		int v;

		XY(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			XY other = (XY) obj;
			if (v != other.v)
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

}
