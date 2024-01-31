package list00;
import java.util.Scanner;


class Nodee {
    int coefficient;
    int exponent;
    Nodee next;

    public Nodee(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

class Polynomial {
    Nodee head;

    public Polynomial() {
        this.head = null;
    }

    // 다항식에 새로운 항을 추가하는 메서드
    public void addTerm(int coefficient, int exponent) {
        Nodee newNode = new Nodee(coefficient, exponent);
        if (head == null || exponent > head.exponent) {
            newNode.next = head;
            head = newNode;
        } else {
            Nodee current = head;
            while (current.next != null && current.next.exponent >= exponent) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // 두 다항식을 더하는 메서드
    public static Polynomial addPolynomials(Polynomial poly1, Polynomial poly2) {
        Polynomial result = new Polynomial();
        Nodee current1 = poly1.head;
        Nodee current2 = poly2.head;

        while (current1 != null || current2 != null) {
            int coef1 = (current1 != null) ? current1.coefficient : 0;
            int exp1 = (current1 != null) ? current1.exponent : Integer.MIN_VALUE;

            int coef2 = (current2 != null) ? current2.coefficient : 0;
            int exp2 = (current2 != null) ? current2.exponent : Integer.MIN_VALUE;

            if (exp1 > exp2) {
                result.addTerm(coef1, exp1);
                current1 = current1.next;
            } else if (exp1 < exp2) {
                result.addTerm(coef2, exp2);
                current2 = current2.next;
            } else {
                int sum = coef1 + coef2;
                if (sum != 0) {
                    result.addTerm(sum, exp1);
                }
                current1 = current1.next;
                current2 = current2.next;
            }
        }

        return result;
    }

    // 다항식을 문자열로 출력하는 메서드
    public String toString() {
        StringBuilder result = new StringBuilder();
        Nodee current = head;
        while (current != null) {
            result.append(current.coefficient);
            result.append("x^");
            result.append(current.exponent);
            if (current.next != null) {
                result.append(" + ");
            }
            current = current.next;
        }
        return result.toString();
    }
}

public class PolynomialE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();

        // 첫 번째 다항식 입력 받기
        System.out.println("첫 번째 다항식을 입력하세요.");
        while (true) {
            System.out.print("계수와 지수 입력 (종료하려면 -1 -1을 입력하세요): ");
            int coef = scanner.nextInt();
            int exp = scanner.nextInt();
            
            if (coef == -1 && exp == -1) {
                break;
            }

            poly1.addTerm(coef, exp);
        }

        // 두 번째 다항식 입력 받기
        System.out.println("두 번째 다항식을 입력하세요.");
        while (true) {
            System.out.print("계수와 지수 입력 (종료하려면 -1 -1을 입력하세요): ");
            int coef = scanner.nextInt();
            int exp = scanner.nextInt();

            if (coef == -1 && exp == -1) {
                break;
            }

            poly2.addTerm(coef, exp);
        }

        // 두 다항식 더하기
        Polynomial result = Polynomial.addPolynomials(poly1, poly2);

        // 결과 출력
        System.out.println("다항식1: " + poly1.toString());
        System.out.println("다항식2: " + poly2.toString());
        System.out.println("두 다항식의 합: " + result.toString());

        scanner.close();
    }
}