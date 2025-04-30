package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame{
	private Store store;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
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
		JMenuItem addDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(addDVD);
		menu.add(smUpdateStore);
		addDVD.addActionListener(new MenuListener());
		addBook.addActionListener(new MenuListener());
		addCD.addActionListener(new MenuListener());
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	
	private JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
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
