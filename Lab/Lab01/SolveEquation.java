import javax.swing.JOptionPane;

public class SolveEquation {
        public static void main(String[] args) {
                String selection;
                selection = JOptionPane.showInputDialog(null,
                                "Option:\n1. Solve the first-degree equation\n2. Solve the second-degree equation\nx. Input any other value to exit\n\nPlease input your selection: ",
                                "Select Mode", JOptionPane.INFORMATION_MESSAGE);
                if (selection.equals("1")) {
                        selection = JOptionPane.showInputDialog(null,
                                        "1. Solve one-variable\n2. Solve with two-variable",
                                        "Select Mode", JOptionPane.INFORMATION_MESSAGE);
                        if (selection.equals("1")) {
                                double a, b, x;
                                String tempString;
                                tempString = JOptionPane.showInputDialog(null,
                                                "Input value for a and b:\n\ta*x + b = 0\n\nInput a: ",
                                                "Input", JOptionPane.INFORMATION_MESSAGE);
                                a = Double.parseDouble(tempString);
                                if (a == 0.0) {
                                        JOptionPane.showMessageDialog(null, "Can't Solve because a = 0");
                                        System.exit(0);
                                }
                                tempString = JOptionPane.showInputDialog(null,
                                                "Input value for a and b:\n\ta*x + b = 0\n\nInput b: ",
                                                "Input", JOptionPane.INFORMATION_MESSAGE);
                                b = Double.parseDouble(tempString);
                                x = -b / a;
                                JOptionPane.showMessageDialog(null, "x = " + x, "Result",
                                                JOptionPane.INFORMATION_MESSAGE);
                                System.exit(0);
                        } else if (selection.equals("2")) {
                                double a1, a2, b1, b2, c1, c2, x, y;
                                String tempString;
                                tempString = JOptionPane.showInputDialog(null,
                                                "Input values:\n\ta1*x + b1*y = c1\n\ta2*x + b2*y = c2\nInput a1: ",
                                                "Input", JOptionPane.INFORMATION_MESSAGE);
                                a1 = Double.parseDouble(tempString);
                                tempString = JOptionPane.showInputDialog(null,
                                                "Input values:\n\ta1*x + b1*y = c1\n\ta2*x + b2*y = c2\nInput b1: ",
                                                "Input", JOptionPane.INFORMATION_MESSAGE);
                                b1 = Double.parseDouble(tempString);
                                tempString = JOptionPane.showInputDialog(null,
                                                "Input values:\n\ta1*x + b1*y = c1\n\ta2*x + b2*y = c2\nInput c1: ",
                                                "Input", JOptionPane.INFORMATION_MESSAGE);
                                c1 = Double.parseDouble(tempString);
                                tempString = JOptionPane.showInputDialog(null,
                                                "Input values:\n\ta1*x + b1*y = c1\n\ta2*x + b2*y = c2\nInput a2: ",
                                                "Input", JOptionPane.INFORMATION_MESSAGE);
                                a2 = Double.parseDouble(tempString);
                                tempString = JOptionPane.showInputDialog(null,
                                                "Input values:\n\ta1*x + b1*y = c1\n\ta2*x + b2*y = c2\nInput b2: ",
                                                "Input", JOptionPane.INFORMATION_MESSAGE);
                                b2 = Double.parseDouble(tempString);
                                tempString = JOptionPane.showInputDialog(null,
                                                "Input values:\n\ta1*x + b1*y = c1\n\ta2*x + b2*y = c2\nInput c2: ",
                                                "Input", JOptionPane.INFORMATION_MESSAGE);
                                c2 = Double.parseDouble(tempString);
                                double d1 = a1 * b2 - a2 * b1;
                                double d2 = a1 * c2 - a2 * c1;
                                double d3 = c1 * b2 - c2 * b1;
                                if (d1 == 0 && d2 == 0) {
                                        JOptionPane.showMessageDialog(null, "infinitely many solutions");
                                } else if (d1 == 0 && d2 != 0) {
                                        JOptionPane.showMessageDialog(null, "no solutions");
                                } else {
                                        y = d2 / d1;
                                        x = d3 / d1;
                                        JOptionPane.showMessageDialog(null, "solution:\n\tx = " + x + "\n\ty = " + y);
                                }
                                System.exit(0);
                        }
                } else if (selection.equals("2")) {
                        double a, b, c;
                        String tempString;
                        tempString = JOptionPane.showInputDialog(null,
                                        "Input values:\na*x^2 + b*x + c = 0\n\nInput a: ",
                                        "Input", JOptionPane.INFORMATION_MESSAGE);
                        a = Double.parseDouble(tempString);
                        tempString = JOptionPane.showInputDialog(null,
                                        "Input values:\na*x^2 + b*x + c = 0\n\nInput b: ",
                                        "Input", JOptionPane.INFORMATION_MESSAGE);
                        b = Double.parseDouble(tempString);
                        tempString = JOptionPane.showInputDialog(null,
                                        "Input values:\na*x^2 + b*x + c = 0\n\nInput c: ",
                                        "Input", JOptionPane.INFORMATION_MESSAGE);
                        c = Double.parseDouble(tempString);
                        double delta = b * b - 4 * a * c;
                        if (delta < 0) {
                                JOptionPane.showMessageDialog(null, "Have no real solution");
                        } else if (delta == 0) {
                                double x = -b / (2 * a);
                                JOptionPane.showMessageDialog(null, "Have 1 solution:\n\tx = " + x);
                        } else {
                                double x1 = (-b - (Math.sqrt(delta))) / (2 * a);
                                double x2 = (-b + (Math.sqrt(delta))) / (2 * a);
                                JOptionPane.showMessageDialog(null, "Have 2 solution:\n\tx = " + x1 + "\n\tx = " + x2);
                        }
                        System.exit(0);
                }

        }
}