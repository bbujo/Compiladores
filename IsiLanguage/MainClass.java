import java.util.Scanner;

public class MainClass {
	public static void main(String args[]) {
		Scanner _key = new Scanner(System.in);
		double a;
		double b;
		double c;
		String d;
		System.out.println("Digite A");
		a = _key.nextDouble();
		System.out.println("Digite B");
		b = _key.nextDouble();
		if (a < b) {
			c = a + b;
		} else {
			c = a - b;
		}
		if (a < b) {
			c = a * b;
		}
		while (a > b) {
			b = b / 1;
		}
		System.out.println("C e igual a ");
		System.out.println(c);
		d = "exemplo";
		c = 4.95;
		switch (d) {
		case "exemplo":
			c = 3;
			break;
		default:
			c = 2;
		}
		switch (c) {
		case 1:
			c = 3;
			break;
		case 2:
			c = 2;
			break;
		case 3:
			c = 1;
			break;
		}
		System.out.println("D e igual a ");
		System.out.println(d);
	}
}