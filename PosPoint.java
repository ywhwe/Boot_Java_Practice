package practice4;
class Point {
	   private int x, y;
	   public Point() { x = 0; y = 0;}
	   public Point(int x, int y) { this.x = x; this.y = y; }
	   public int getX() { return x; }
	   public int getY() { return y; }
	   protected void move(int x, int y) { this.x =x; this.y = y; }
	}
class PositivePoint extends Point{
	public PositivePoint() {
		super();
		super.move(getX(), getY());
		}
	public PositivePoint(int x, int y) {
		super.move(getX(), getY());
	}
	public String toString() {
		return ("("+getX()+","+getY()+")"+"의 점");
	}
	@Override
	protected void move(int x, int y) {
		if(x<0||y<0) {
			x = getX(); y = getY();
			super.move(x, y);
		}
		super.move(x, y);
	}
}
public class PosPoint {
	public static void main(String[] args) {
		   PositivePoint p = new PositivePoint();
		   p.move(10, 10);
		   System.out.println(p.toString()+"입니다.");
		   p.move(-5,5); // 객체 p는 음수 공간으로 이동되지 않음
		   System.out.println(p.toString()+"입니다.");
		   PositivePoint p2 = new PositivePoint(-10, -10);
		   System.out.println(p2.toString()+"입니다.");
		}
}
