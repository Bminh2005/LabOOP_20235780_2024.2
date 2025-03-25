import java.util.Scanner;
public class maker {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the value of n? - length of Triangle: ");
		int n = keyboard.nextInt();
		int i = 1;
		int j = 1;
		String str;
		while(i <= n) {
			str = new String("");
			j = 1;
			while(j <= n-i) {
				str += " ";
				j += 1; 
			}
			j = 1;
			while (j <= 2*(i-1) + 1) {
				str += "*";
				j += 1;
			}
			System.out.println(str);
			i += 1;
		}
		System.exit(0);
	}

}