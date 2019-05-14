package 배열;

public class 배열연습5 {

	public static void main(String[] args) {
		
		float[] sight = {1.0f,1.3f,1.2f,1.1f,1.5f};
		for (int i = 0; i < sight.length; i++) {
			System.out.print(sight[i] + " ");
		}System.out.println("");
		
		char[] gender = {'남','여','남','여','남'};
		for (int i = 0; i < gender.length; i++) {
			System.out.print(gender[i] + " ");
		}
		System.out.println("");
		char[] grade = {'A','B','D','C','F'};
		for (int i = 0; i < grade.length; i++) {
			System.out.print(grade[i] + " ");
		}
		System.out.println(""); 
		String[] name = {"김","이","박","최","정"};
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i] + " ");
		}
		System.out.println("");
		int[] score = {100,60,70,90,80};
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i]+" ");
		}
		
		
	}

}
