import java.util.Scanner;
abstract class Converter {
	abstract protected double convert(double src);
	abstract protected String getSrcString(); 
	   abstract protected String getDestString(); 
	   protected double ratio; // 비율
	   public Converter() {	   }
	   public void run() {
	      Scanner scanner = new Scanner(System.in);
	      System.out.println(getSrcString()+"을 "+getDestString()+"로 바꿉니다.");
	      System.out.print(getSrcString()+"을 입력하세요>> ");
	      int val = scanner.nextInt();
	      double res = convert(val);
	      System.out.println("변환 결과: "+res+getDestString()+"입니다");
	      scanner.close();
	   }
}
class Won2Dollar extends Converter{
	int n;
	double src;
	public Won2Dollar(int n){
		this.n = n;
		ratio = this.n;
	}
	@Override
	protected double convert(double src) {
		this.src = src;
		return (int) (this.src/ratio);
	}
	@Override
	protected String getSrcString() {
		return "원";
	}
	@Override
	protected String getDestString() {
		return "달러";
	}
}
class Km2Mile extends Converter{
	double n, src;
	public Km2Mile(double n){
		this.n = n;
		ratio = this.n;
	}
	@Override
	protected double convert(double src) {
		this.src = src;
		return this.src/ratio;
	}
	@Override
	protected String getSrcString() {
		return "Km";
	}
	@Override
	protected String getDestString() {
		return "Mile";
	}
}
public class Convert {
	public static void main(String args[]) {
		   Won2Dollar toDollar = new Won2Dollar(1200);// 1달러는 1200원		       
		   toDollar.run();
		   //Km2Mile toMile = new Km2Mile(1.6);//1마일은 1.6Km
		   //toMile.run();
		}
}
