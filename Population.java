package ch07;
import java.util.*;

public class Population {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		String search=null, co=null, check;
		int po;

		System.out.println("나라 이름과 인구를 입력하세요.(예: Korea 5000)");
		while(true) {
			System.out.print("나라 이름, 인구 >>");
			check = scanner.next();
			if(check.equals("stop")) break;
			else {
				co = check;
				po = scanner.nextInt();
				hm.put(co, po);
			}
		}
		while(true) {
			System.out.print("인구 검색 >>");
			check = scanner.next();
			if(check.equals("stop")) break;
			else {
				search = check;
				if(hm.containsKey(search))
					System.out.println(search+"의 인구는 "+hm.get(search));
				else System.out.println(search+" 나라는 없습니다.");
			}
		}
		scanner.close();
	}	
}