import javax.swing.JOptionPane;

public class CalculateWith2DoubleNumbers {
	public static void main(String[] args) {
		String strNum1, strNum2;
		String strNotification = "Result:\n";
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first double number: ", "Calculator",
				JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "Please input the second double number: ", "Calculator",
				JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		double sum = num1 + num2;
		double difference = num1 - num2;
		double product = num1 * num2;
		if (num2 != 0) {
			double quotient = num1 / num2;
			strNotification = strNotification + "\tsum\t: " + sum + "\n\tdifference\t: " + difference
					+ "\n\tproduct\t: " + product + "\n\tquotient\t: " + quotient;
		}
		strNotification = strNotification + "\tsum\t: " + sum + "\n\tdifference\t: " + difference + "\n\tproduct\t: "
				+ product + "\n\tquotient\t: MATH ERROR";
		JOptionPane.showMessageDialog(null, strNotification, "Result", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}