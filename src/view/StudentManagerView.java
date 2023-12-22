package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

public class StudentManagerView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public StudentManagerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 617);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(menuFile);
		
		JMenuItem openFile = new JMenuItem("Open");
		openFile.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuFile.add(openFile);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save_File");
		mntmNewMenuItem_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuFile.add(mntmNewMenuItem_1);
		
		JSeparator separator_1 = new JSeparator();
		menuFile.add(separator_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mntmNewMenuItem_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuFile.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu = new JMenu("About\r\n");
		mnNewMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About Me!");
		mntmNewMenuItem.setFont(new Font("Tahoma", Font.BOLD, 15));
		mnNewMenu.add(mntmNewMenuItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BirthPlace");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(23, 26, 104, 13);
		contentPane.add(lblNewLabel);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new TitledBorder(null, "Student Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		verticalBox.setBounds(10, 146, 594, 54);
		contentPane.add(verticalBox);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 24, 96, 21);
		contentPane.add(comboBox);
	}
}
