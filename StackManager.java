package ch07;
import java.util.*;

interface IStack<T>{
	T pop();
	boolean push(T ob);
}
class MyStack<T> implements IStack<T>{
	Vector<T> v = new Vector<>();
	int n;
	@Override
	public T pop() {
		if(n==0) return null;
		n--;
		return v.get(n);
	}
	@Override
	public boolean push(T ob) {
		if(n==10)
			return false;
		v.add(ob);
		n++;
		return true;
	}
}
public class StackManager {
	public static void main(String[] args) {
		IStack<Integer> stack = new MyStack<Integer>();
		for(int i=0;i<10;i++) stack.push(i);
		
		while(true) {
			Integer n = stack.pop();
			if(n==null) break;
			System.out.print(n+" ");
		}
	}
}
