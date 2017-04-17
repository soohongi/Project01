package practice;
//도형별 등수

//0.입력 순서 1.전체등수 2. 도형별등수

import java.util.Scanner;

class ShapeDhdh12 {
	int type, area, rank;
	String[] name = { "삼각형", "사각형", "원" };
	int sort;

	ShapeDhdh12 sam(int x, int y) {
		this.type = 0;
		this.area = x * y / 2;
		return this;

	}

	ShapeDhdh12 sa(int x, int y) {
		this.type = 1;
		this.area = x * y;
		return this;
	}

	ShapeDhdh12 won(int x) {
		double pi = 3.14;
		this.type = 2;
		this.area = (int) (x * x * pi);
		return this;
	}

	void print() {
		String str = name[type] + "\t" + area + "\t" + rank + "\t";
		
		System.out.println(str);
	}

}

class ShapeDhdh12Logic {
	String[] index = { "입력순서 등수", "전체 등수", "도형별 등수" };
	ShapeDhdh12[] arr;
	int[] ShapeDhdh12Type;
	int maxType = -1;
	int kind;

	void init(ShapeDhdh12[] arr) {
		this.arr = arr;
		
		input();
		cal();
		rank();
		print();

	}

	void input() {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < index.length; i++) {
			System.out.print(i + ". " + index[i]);

			if (i < index.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("\n입력하시오");
		kind = sc.nextInt();

	}

	void cal() {
		for (ShapeDhdh12 sp : arr) {
			if (maxType < sp.type)
				maxType = sp.type;
		}

		ShapeDhdh12Type = new int[maxType + 1];
		for (ShapeDhdh12 sp : arr) {
			ShapeDhdh12Type[sp.type]++;
		}
	}

	void rank() {
		for (ShapeDhdh12 me : arr) {
			me.rank = 1;
			if (kind == 2) {
				for (int i = 0; i < me.type; i++) {
					me.sort += ShapeDhdh12Type[i];
				}
			}

			for (ShapeDhdh12 you : arr) {
				if (me.area < you.area) {
					if (kind == 2) {
						if (me.type == you.type) {
							me.rank++;
							me.sort++;

						}
					}

					else {
						me.rank++;
						if (kind == 1)
							me.sort++;
					}
				}
			}
		}

	}

	void print() {
		
		System.out.println(arr[1].area);
		/*for (int i = 0; i > arr.length; i++) {
			for (ShapeDhdh12 sp : arr) {
				if (i == sp.sort)
					sp.print();*/
		//System.out.println(arr.length);
		
		for (int r = 0; r < arr.length; r++) {
			for (int i = 0; i < arr.length; i++) {
				if(r == arr[i].sort)
					arr[i].print();
			}

		}

	}

}

public class Dhdhdh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShapeDhdh12[] arr = { 
				new ShapeDhdh12().sam(3, 3), 
				new ShapeDhdh12().sam(5, 5), 
				new ShapeDhdh12().sam(8, 8),
				new ShapeDhdh12().sa(6, 6), 
				new ShapeDhdh12().sa(2, 2), 
				new ShapeDhdh12().sa(4, 4),
				new ShapeDhdh12().won(9), 
				new ShapeDhdh12().won(2), 
				new ShapeDhdh12().won(10) 
				};

		new ShapeDhdh12Logic().init(arr);

	}
}