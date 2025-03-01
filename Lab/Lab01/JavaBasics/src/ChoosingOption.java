import javax.swing.JOptionPane;
public class ChoosingOption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] Ops = new String[2];
		Ops[0] = "I do";
		Ops[1] = "I don't";
		int option = JOptionPane.showOptionDialog(null, "Do you want",null, 0,0, null, Ops, Ops[0]);
		JOptionPane.showMessageDialog(null, "You've chosen: " + (option==JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
	}
}
