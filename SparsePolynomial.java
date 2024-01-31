package list00;
import java.util.*;
interface ListInterface<E>{
	public void append(E x, E y);
	public E remove(int index);
	public boolean removeItem(E x, E y);
	public E get(int index);
	public void set(int index, E x, E y);
	public int indexOf(E x, E y);
	public int size();
	public boolean isEmpty();
	public void clear();
}

class Node<E>{
	public E coeff;
	public E power;
	public Node<E>next;
	public Node(E newCoeff, E newPower) {
		coeff=newCoeff; power=newPower; next=null;
	}
	public Node(E newCoeff, E newPower, Node<E> nextNode) {
		coeff=newCoeff; power=newPower; next=nextNode;
	}
}
class LinkedList<E> implements ListInterface<E>{
	private Node<E> head;
	private int numItems;
	private E[] arr;
	public LinkedList() {
		numItems = 0;
		head = new Node<>(null, null, null);
	}
	public void add(LinkedList<Integer> list1, LinkedList<Integer> list2) {
	        LinkedList<Integer> result = new LinkedList<>();
	        Node<E> current1 = head; current1 = current1.next;
	        Node<E> current2 = head; current2 = current2.next;

	        while (current1 != null || current2 != null) {
	            int coef1 = (current1 != null) ? (int) current1.coeff : 0;
	            int pow1 = (current1 != null) ? (int) current1.power : Integer.MIN_VALUE;

	            int coef2 = (current2 != null) ? (int) current2.coeff : 0;
	            int pow2 = (current2 != null) ? (int) current2.power : Integer.MIN_VALUE;

	            if (pow1 > pow2) {
	                result.append(coef1, pow1);
	                current1 = current1.next;
	            } else if (pow1 < pow2) {
	                result.append(coef2, pow2);
	                current2 = current2.next;
	            } else {
	                int sum = coef1 + coef2;
	                if (sum != 0) {
	                    result.append(sum, pow1);
	                }
	                current1 = current1.next;
	                current2 = current2.next;
	            }
	        }
	    }
	public void sum(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		Node<E>currNode1 = head;
		Node<E>currNode2 = head;
		Node<E>newNode = head;
		for(int i=0;i<numItems;i++) {
			currNode1 = currNode1.next;
			for(int j=0;j<numItems;j++) {
				currNode2 = currNode2.next;
				if(currNode2.power==currNode1.power) {
					newNode = newNode.next;
					//TODO newNode.coeff = currNode1.coeff + currNode2.coeff;
					newNode.power = currNode1.power;
				}
			}
		}
	}
	@Override
	public void append(E x, E y) {
		Node<E> prevNode = head;
		while(prevNode.next!=null) {
			prevNode = prevNode.next;
		}
		Node<E>newNode = new Node<>(x, y, null);
		prevNode.next = newNode;
		numItems++;
	}
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if(index>=0&&index<=numItems-1) {
			Node<E> prevNode = getNode(index-1);
			Node<E> currNode = prevNode.next;
			prevNode.next = currNode.next;
			numItems--;
			arr[0]=currNode.coeff;
			arr[1]=currNode.power;
			return (E) arr;
		}
		else return null;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean removeItem(E x, E y) {
		Node<E>currNode=head;//dummy node
		for(int i=0;i<=numItems-1;i++) {
			Node<E>prevNode = currNode;
			currNode = prevNode.next;
			if(((Comparable)(currNode.coeff)).compareTo(x)==0&&((Comparable)(currNode.power)).compareTo(y)==0) {
				prevNode.next = currNode.next;
				numItems--;
				return true;
			}
		}return false;	
	}
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if(index>=0&&index<=numItems-1) {
			arr[0]=getNode(index).coeff;
			arr[1]=getNode(index).power;
			return (E) arr;
		}
		else return null;
	}
	private Node<E> getNode(int index) {
		if(index>=-1&&index<=numItems-1) {
			Node<E>currNode = head;
			for(int i=0;i<index;i++) {
				currNode = currNode.next;
			}
			return currNode;
		}
		else return null;
	}
	@Override
	public void set(int index, E x, E y) {
		if(index>=0&&index<=numItems-1)
			getNode(index).coeff=x;
			getNode(index).power=y;
	}
	private final int NOT_FOUND = -1;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int indexOf(E x, E y) {
		Node<E>currNode = head;
		for(int i=0;i<=numItems;i++) {
			currNode = currNode.next;
			if(((Comparable)(currNode.coeff)).compareTo(x)==0&&((Comparable)(currNode.power)).compareTo(y)==0)
				return i;
		}
		return NOT_FOUND;
	}
	@Override
	public int size() {
		return numItems;
	}
	@Override
	public boolean isEmpty() {
		return numItems==0;
	}
	@Override
	public void clear() {
		numItems = 0;
		head = new Node<E>(null, null, null);
	}
	public void print() {
		Node<E>currNode = head;
		if(isEmpty()) System.out.println("List is empty");
		System.out.print("다항식 덧셈 결과>>");
		for(int i=0;i<numItems;i++) {
			currNode = currNode.next;
			System.out.print(currNode.coeff+" "+currNode.power+" ");
		}
		System.out.println();
	}
}

public class SparsePolynomial {
	public static void main(String[] args) {
		int c, p;
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer>list1 = new LinkedList<>();
		System.out.print("첫번째 다항식 입력>>");
		do {
			if(scanner.hasNextInt()) {
				c=scanner.nextInt();
				p=scanner.nextInt();
				list1.append(c, p);
			}else {
				scanner.nextLine();
				break;
			}
		}while(scanner.next().isEmpty());
		
		LinkedList<Integer>list2 = new LinkedList<>();
		System.out.print("두번째 다항식 입력>>");
		do {
			if(scanner.hasNextInt()) {
				c=scanner.nextInt();
				p=scanner.nextInt();
				list2.append(c, p);
			}else {
				scanner.nextLine();
				break;
			}
		}while(scanner.next().isEmpty());
		
		LinkedList<Integer> result = new LinkedList<Integer>();
		result.sum(list1, list2);
		result.print();
		scanner.close();
	}
}
