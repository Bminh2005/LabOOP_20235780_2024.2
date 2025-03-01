import java.util.Scanner;
public class InputFromKeyBoard {

	public static void main(String[] args) {
		Scanner keyBoard = new Scanner(System.in);
		
		System.out.println("What's your name?");
		String strName = keyBoard.nextLine();
		System.out.println("How old are you?");
		int iAge = keyBoard.nextInt();
		System.out.println("How tall are you (m)?");
		double dHeight = keyBoard.nextDouble();
		System.out.println("Mrs/Ms. " + strName + ", " + iAge + " years old. " + "Your height is " + dHeight + " m.");
	}

}
