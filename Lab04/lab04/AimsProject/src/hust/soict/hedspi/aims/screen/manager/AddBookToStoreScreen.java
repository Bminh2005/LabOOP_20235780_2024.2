package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;

import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends JFrame {
	private Book book;
	private Store store;
	private JTextField inTitle;
	private JTextField inCategory;
	private JTextField inCost;
	
	
	
	public AddBookToStoreScreen(Store store) {
		this.store = store;
		this.book = new Book(null);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		setTitle("Add Book to Store");
		setSize(1024, 512);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(5,2));
		center.add(new JLabel("Title: "));
		this.inTitle = new JTextField(30);
		center.add(inTitle);
		
		center.add(new JLabel("Category: "));
		this.inCategory = new JTextField(30);
		center.add(inCategory);
		
		center.add(new JLabel("Cost:"));
		this.inCost = new JTextField(30);
		center.add(inCost);
		
		JButton addButton = new JButton("Add");
		center.add(addButton);
		addButton.addActionListener(new TFInputListener());
		return center;
		
	}
	
	private JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("ADD A DIGITAL VIDEO DISC (book)");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.LIGHT_GRAY);
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	private JMenuBar createMenuBar() {
		// TODO Auto-generated method stub
		JMenu menu = new JMenu("Options");
		JMenuItem view = new JMenuItem("View Store");
		menu.add(view);
		view.addActionListener(new MenuListener());
		
		JMenu smUpdateStore = new JMenu("UpdateStore");
		JMenuItem addBook = new JMenuItem("Add Book");
		smUpdateStore.add(addBook);
		JMenuItem addCD = new JMenuItem("Add CD");
		smUpdateStore.add(addCD);
		JMenuItem addbook = new JMenuItem("Add book");
		smUpdateStore.add(addbook);
		menu.add(smUpdateStore);
		addbook.addActionListener(new MenuListener());
		addBook.addActionListener(new MenuListener());
		addCD.addActionListener(new MenuListener());
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	
	private class TFInputListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if(inTitle.getText().equals("") == false)
			book.setTitle(inTitle.getText());
			if(inCategory.getText().equals("") == false)
			book.setCategory(inCategory.getText());
			
			if(inCost.getText().equals("") == false)
			book.setCost(Float.parseFloat(inCost.getText()));
			store.addMedia(book);
			JOptionPane.showMessageDialog(null,
                   "Add successfully", "message",
                    JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String command = evt.getActionCommand();
			System.out.println(command);
			if(command.equals("Add DVD")) {
				new AddDigitalVideoDiscToStoreScreen(store);
				dispose();
			}
			if(command.equals("Add Book")) {
				new AddBookToStoreScreen(store);
				dispose();
			}
			if(command.equals("Add CD")) {
				new AddCompactDiscToStoreScreen(store);
				dispose();
			}
			if(command.equals("View Store")) {
				new StoreManagerScreen(store);
				dispose();
			}
		}
	}
}
