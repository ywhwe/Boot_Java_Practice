package practice1;
class TV{
	private int size;
	
	public TV() {}
	public TV(int size) {
		this.size = size;
	}
	protected int getSize() {
		return size;
	}
}
class ColorTV extends TV{
	private String addr;
	private int pixel;
	
	public ColorTV() {}
	public ColorTV(int size, int pixel) {
		super(size);
		this.pixel = pixel;
	}
	public ColorTV(String addr, int size, int pixel) {
		super(size);
		this.pixel = pixel;
		this.addr = addr;
	}
	protected int getPixel() {
		return pixel;
	}
	public String getAddr(){
		return addr;
	}
	public void printProperty(){
		System.out.println(getSize()+"인치 "+pixel+" Color TV");
	}
}
class IPTV extends ColorTV{
	public IPTV(String addr, int size, int pixel) {
		super(addr, size, pixel);
	}
	public void printProperty(){
		System.out.println(getAddr()+" 주소의 "+getSize()+"인치 "+getPixel()+"컬러 IPTV");
	}
}
public class Telly {
	public static void main(String[] args) {
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty();
		IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
		iptv.printProperty();
	}
}