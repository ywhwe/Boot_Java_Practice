package ch07;
import java.util.*;
public class ScholarShip {
	public static void main(String[] args) {
		HashMap<String, Double> map = new HashMap<>();
		String[] array= new String[5];
		String name;
		double score;
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			System.out.print("이름과 학점 >> ");
			name = scanner.next();
			array[i] = name;
			score = scanner.nextDouble();
			map.put(name, score);
		}
		System.out.print("장학생 선발 학점 기준 입력 >> ");
		score = scanner.nextDouble();
		System.out.print("장학생 명단: ");
		for(int i=0;i<map.size();i++) {
			if(score<map.get(array[i])) {
				System.out.print(array[i]+" ");
			}
		}
		scanner.close();
	}
}
