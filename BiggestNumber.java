package ch07;

import java.util.*;
public class BiggestNumber {
	public static void main(String[] args) {
		Vector <Integer> v = new Vector<>();
		int i, max;
		Scanner scanner = new Scanner(System.in);

		System.out.print("정수(-1이 입력될 때까지)>>");
		while(true) {
			i = scanner.nextInt();
			if(i==-1)
				break;
			else
				v.add(i);
		}
		max = Collections.max(v);
		System.out.println("가장 큰 수는 "+max);
		scanner.close();
	}
}