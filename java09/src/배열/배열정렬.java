package �迭;

import java.util.Arrays;

public class �迭���� {
	public static void main(String[] args) {
		int[] num = {33, 66, 44, 22, 11, 77, 99};
		Arrays.parallelSort(num);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i] + " ");
		}
	}

}
