package practice;

public class Hbhbhb {

	public static void main(String[] args) {

		//// 생년월일

		/// 성별

		/// 국적

		/// 나이(한국 나이)

		/// 다가올생일

		/// D-Day (생일까지)

		try {

			String input = "920130-5000000";

			String[] inArr = input.split("-");

			int[] cut = { 0, 2, 4, 8 };

			int[] bir = new int[cut.length - 1];

			String[] gd = { "여", "남" };

			int yr = 0;

			int m = 0;

			int d = 0;

			int age = 0;

			int year = 0;

			String str = "";

			int gender = inArr[1].charAt(0) - '0';

			str = gd[gender % 2];

			if (gender > 4 && gender < 9)

				str += " 외국인 ";

			System.out.println("성별 및 국적 : " + str);

			for (int i = 0; i < cut.length - 1; i++) {

				for (int j = cut[i]; j < cut[i + 1]; j++) {

					bir[i] *= 10;

					bir[i] += inArr[0].charAt(j) - '0';

				}

				if (gender == 3 || gender == 4 || gender == 7 || gender == 8) {

					yr = 2000;

				}

				else if (gender == 9 || gender == 0) {

					yr = 1800;

				}

				else {

					yr = 1900;

				}

				year = yr + bir[0];

				m = bir[1];

				d = bir[2];

				age = 2017 - year + 1;

				System.out.println(year + "년" + m + "월" + d + "일" + "\n" + age + "세");

			}

			System.out.println("0000"+bir[0]);
		}
		
		
		catch (Exception e) {

			// TODO: handle exception

			System.out.println(e.getMessage());

		}

	}

}