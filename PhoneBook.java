import java.util.*;
class Phone{
	String name;
	String tel;
	
	public void err(String name) {
		if(this.name != name)
			System.out.println(name+"이(가) 없습니다.");
	}
}
public class PhoneBook {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		String search = null;
		Phone[] phone = new Phone[10];
		
		for(int i=0;i<phone.length;i++)
			phone[i] = new Phone();
		
		System.out.print("인원수>>");
		n = scanner.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.print("이름과 전화번호 입력>>");
			phone[i].name = scanner.next();
			phone[i].tel = scanner.next();
		}
		System.out.println("저장되었습니다.");
		
		do {
			System.out.print("검색할 이름>>");
			search = scanner.next();
			for(int i=0;i<phone.length;i++) {
				if(phone[i].name.equals(search)) {
					System.out.println(phone[i].name+"의 전화번호는 "+phone[i].tel+" 입니다.");
					break;
				}
			}
				
		}while(search != "그만");
		
		
		scanner.close();
	}
}
