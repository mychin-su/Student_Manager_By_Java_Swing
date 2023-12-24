package view;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.StudentManagerListener;
import model.Province;
import model.Student;
import model.StudentManagerModel;

public class StudentManagerView extends JFrame {

	private static final long serialVersionUID = 1L;
	public StudentManagerModel model;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_Name;
	private JTextField textField_subject1;
	private JTextField textField_subject2;
	private JTextField textField_subject3;
	private JRadioButton radioButton_Male;
	private JRadioButton radioButton_Female;
	private ButtonGroup btn_gioiTinh;
	private JComboBox<String> jCombo_box_BirthPlace;
	private JMenu menuFile;
	private JMenuItem openFile;
	private JMenuItem saveFile;
	private JMenuItem exitFile;
	private JMenuItem aboutMe;
	private JButton filter;
	private JButton cancelFilter;
	private JComboBox<String> comboBox_form;
	private JButton btn_Insert;
	private JButton btn_Delete;
	private JButton btn_Update;
	private JButton btn_Save;
	private JButton btn_Cancel;
	private JTextField textField_Id;
	private JTextField textField_Date;
	private DefaultTableModel model_table;
	private JTextField studentIdFilter;

	public StudentManagerView() {
		this.model = new StudentManagerModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 617);

		StudentManagerListener action = new StudentManagerListener(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuFile = new JMenu("File");
		menuFile.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(menuFile);

		openFile = new JMenuItem("Open");
		openFile.addActionListener(action);
		openFile.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuFile.add(openFile);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		saveFile = new JMenuItem("SaveFile");
		saveFile.addActionListener(action);
		saveFile.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuFile.add(saveFile);

		JSeparator separator_1 = new JSeparator();
		menuFile.add(separator_1);

		exitFile = new JMenuItem("Exit");
		exitFile.addActionListener(action);
		exitFile.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuFile.add(exitFile);

		JMenu mnNewMenu = new JMenu("About\r\n");
		mnNewMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(mnNewMenu);

		aboutMe = new JMenuItem("About Me!");
		aboutMe.addActionListener(action);
		aboutMe.setFont(new Font("Tahoma", Font.BOLD, 15));
		mnNewMenu.add(aboutMe);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Box studentFilter = Box.createVerticalBox();
		studentFilter.setBorder(
				new TitledBorder(null, "Student Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		studentFilter.setBounds(0, 10, 678, 54);
		contentPane.add(studentFilter);

		jCombo_box_BirthPlace = new JComboBox<String>();
		ArrayList<Province> listProvince = Province.getListProvince();

		jCombo_box_BirthPlace.setBounds(100, 20, 122, 36);
		jCombo_box_BirthPlace.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(jCombo_box_BirthPlace);
		for (Province province : listProvince) {
			jCombo_box_BirthPlace.addItem(province.getProvinceName());
		}

		JLabel jLabelStudentId = new JLabel("StudentId");
		jLabelStudentId.setFont(new Font("Tahoma", Font.BOLD, 15));
		jLabelStudentId.setBounds(232, 22, 84, 29);
		contentPane.add(jLabelStudentId);

		filter = new JButton("Filter");
		filter.addActionListener(action);
		filter.setFont(new Font("Tahoma", Font.BOLD, 15));
		filter.setBounds(448, 18, 104, 36);
		contentPane.add(filter);

		cancelFilter = new JButton("CancelF");
		cancelFilter.addActionListener(action);
		cancelFilter.setFont(new Font("Tahoma", Font.BOLD, 15));
		cancelFilter.setBounds(570, 18, 104, 36);
		contentPane.add(cancelFilter);

		JLabel jLableBirthPlace = new JLabel("BirthPlace");
		jLableBirthPlace.setBounds(12, 27, 78, 19);
		contentPane.add(jLableBirthPlace);
		jLableBirthPlace.setFont(new Font("Tahoma", Font.BOLD, 15));

		Box list_Student = Box.createVerticalBox();
		list_Student
				.setBorder(new TitledBorder(null, "List Student", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list_Student.setBounds(12, 84, 662, 226);
		contentPane.add(list_Student);

		table = new JTable();
		model_table = (DefaultTableModel) table.getModel();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Name", "Place", "DateOfBirth", "Sex", "Subject1", "Subject2", "Subject3" }));
		table.setRowHeight(25);
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		JScrollPane scrollPane = new JScrollPane(table);
		list_Student.add(scrollPane);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(
				new TitledBorder(null, "Student Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		verticalBox.setBounds(12, 309, 656, 199);
		contentPane.add(verticalBox);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(22, 336, 45, 13);
		contentPane.add(lblNewLabel);

		textField_Id = new JTextField();
		textField_Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Id.setBounds(114, 320, 139, 29);
		contentPane.add(textField_Id);
		textField_Id.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(22, 376, 45, 13);
		contentPane.add(lblName);

		JLabel lblNewLabel_1_1 = new JLabel("BirthPlace");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(22, 410, 85, 29);
		contentPane.add(lblNewLabel_1_1);

		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Name.setBounds(114, 369, 139, 31);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);

		comboBox_form = new JComboBox<String>();
		for (Province province : listProvince) {
			comboBox_form.addItem(province.getProvinceName());
		}
		comboBox_form.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_form.setBounds(114, 408, 139, 29);
		contentPane.add(comboBox_form);

		JLabel lbDate = new JLabel("Date");
		lbDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbDate.setBounds(22, 454, 45, 13);
		contentPane.add(lbDate);

		textField_Date = new JTextField();
		textField_Date.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Date.setBounds(114, 447, 139, 31);
		contentPane.add(textField_Date);
		textField_Date.setColumns(10);

		JLabel lbSex = new JLabel("Sex");
		lbSex.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbSex.setBounds(379, 332, 45, 21);
		contentPane.add(lbSex);

		radioButton_Male = new JRadioButton("Male");
		radioButton_Male.addActionListener(action);
		radioButton_Male.setFont(new Font("Tahoma", Font.BOLD, 15));
		radioButton_Male.setBounds(457, 332, 61, 21);
		contentPane.add(radioButton_Male);

		radioButton_Female = new JRadioButton("Female");
		radioButton_Female.addActionListener(action);
		radioButton_Female.setFont(new Font("Tahoma", Font.BOLD, 15));
		radioButton_Female.setBounds(536, 332, 93, 21);
		contentPane.add(radioButton_Female);

		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_Male);
		btn_gioiTinh.add(radioButton_Female);

		JLabel lblSubject1 = new JLabel("Subject1");
		lblSubject1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSubject1.setBounds(368, 376, 84, 13);
		contentPane.add(lblSubject1);

		JLabel lblSubject2 = new JLabel("Subject2"); // Changed from "Subject1" to "Subject2"
		lblSubject2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSubject2.setBounds(368, 418, 84, 13);
		contentPane.add(lblSubject2);

		JLabel lblSubject3 = new JLabel("Subject3"); // Changed from "Subject1" to "Subject3"
		lblSubject3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSubject3.setBounds(368, 459, 84, 13);
		contentPane.add(lblSubject3);

		textField_subject1 = new JTextField();
		textField_subject1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_subject1.setColumns(10);
		textField_subject1.setBounds(468, 369, 139, 29);
		contentPane.add(textField_subject1);

		textField_subject2 = new JTextField();
		textField_subject2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_subject2.setColumns(10);
		textField_subject2.setBounds(468, 410, 139, 29);
		contentPane.add(textField_subject2);

		textField_subject3 = new JTextField();
		textField_subject3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_subject3.setColumns(10);
		textField_subject3.setBounds(468, 453, 139, 29);
		contentPane.add(textField_subject3);

		btn_Insert = new JButton("Insert");
		btn_Insert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Insert.addActionListener(action);
		btn_Insert.setBounds(20, 517, 104, 29);
		contentPane.add(btn_Insert);

		btn_Delete = new JButton("Delete");
		btn_Delete.addActionListener(action);
		btn_Delete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Delete.setBounds(162, 517, 104, 29);
		contentPane.add(btn_Delete);

		btn_Update = new JButton("Update");
		btn_Update.addActionListener(action);
		btn_Update.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Update.setBounds(299, 517, 104, 29);
		contentPane.add(btn_Update);

		btn_Save = new JButton("Save");
		btn_Save.addActionListener(action);
		btn_Save.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Save.setBounds(448, 517, 104, 29);
		contentPane.add(btn_Save);

		btn_Cancel = new JButton("Cancel");
		btn_Cancel.addActionListener(action);
		btn_Cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Cancel.setBounds(570, 517, 104, 29);
		contentPane.add(btn_Cancel);

		studentIdFilter = new JTextField();
		studentIdFilter.setBounds(314, 20, 124, 36);
		contentPane.add(studentIdFilter);
		studentIdFilter.setColumns(10);

		for (Student student : this.model.getListStudent()) {
			this.insertStudentInTable(student);
		}
	}

	/* Function */
	public void deleteForm() {
		textField_Id.setText("");
		textField_Name.setText("");
		textField_subject1.setText("");
		textField_subject2.setText("");
		textField_subject3.setText("");
		textField_Date.setText("");
		btn_gioiTinh.clearSelection();
		comboBox_form.setSelectedIndex(0);
	}

	public void insertStudentInTable(Student student) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { student.getStudentId() + "", student.getStudentName(),
				student.getBirthPlace().getProvinceName(),
				new SimpleDateFormat("yyyy-MM-dd").format(student.getDateOfBirth()),
				(student.isSex() ? "Male" : "Female"), student.getSubject1() + "", student.getSubject2() + "",
				student.getSubject3() + "",

		});
	}

	public void insertOrUpdateStudent(Student student) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		try {
			if (!this.model.kiemTraTonTai(student)) {
				this.model.insert(student);
				this.table.repaint();
				table.revalidate();
				this.insertStudentInTable(student);
			} else {
				int soLuongDong = model_table.getRowCount();
				System.out.println(soLuongDong);
				if (soLuongDong > 0) {
					for (int i = 0; i < soLuongDong; i++) {
						String id = model_table.getValueAt(i, 0) + "";
						if (id.equals(student.getStudentId() + "")) {
							this.model.update(i, student);
							model_table.setValueAt(student.getStudentId() + "", i, 0);
							model_table.setValueAt(student.getStudentName() + "", i, 1);
							model_table.setValueAt(student.getBirthPlace().getProvinceName() + "", i, 2);
							model_table.setValueAt(new SimpleDateFormat("yyyy-MM-dd").format(student.getDateOfBirth()),
									i, 3);
							model_table.setValueAt(student.isSex() ? "Male" : "Female", i, 4);
							model_table.setValueAt(student.getSubject1() + "", i, 5);
							model_table.setValueAt(student.getSubject2() + "", i, 6);
							model_table.setValueAt(student.getSubject3() + "", i, 7);
							table.repaint();
							table.revalidate();
						}
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Student getDataForm() throws ParseException {
		int studentId = Integer.parseInt(this.textField_Id.getText());
		String studentName = this.textField_Name.getText();
		int provinceId = this.comboBox_form.getSelectedIndex();
		Province province = Province.getProvinceById(provinceId);
		Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(this.textField_Date.getText());
		boolean sex = this.radioButton_Male.isSelected();
		float subject1 = Float.parseFloat(this.textField_subject1.getText());
		float subject2 = Float.parseFloat(this.textField_subject2.getText());
		float subject3 = Float.parseFloat(this.textField_subject3.getText());
		return new Student(studentId, studentName, province, dateOfBirth, sex, subject1, subject2, subject3);
	}

	public void SaveStudent() {
		try {
			Student newStudent = getDataForm();
			this.insertOrUpdateStudent(newStudent);
			JOptionPane.showMessageDialog(this, "Student added/updated successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error adding/updating student: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public Student getStudentSelect() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int studentId = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String studentName = model_table.getValueAt(i_row, 1) + "";
		Province province = Province.getProvinceByName(model_table.getValueAt(i_row, 2) + "");
		String dateOfBirthStr = model_table.getValueAt(i_row, 3) + "";
		Date dateOfBirth = null;
		try {
			dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirthStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String textSex = model_table.getValueAt(i_row, 4) + "";
		boolean isSex = textSex.equals("Male");
		float subject1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float subject2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float subject3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		Student student = new Student(studentId, studentName, province, dateOfBirth, isSex, subject1, subject2,
				subject3);
		return student;
	}

	public void setFormInformationStudent() {
		Student student = this.getStudentSelect();
		this.textField_Id.setText(student.getStudentId() + "");
		this.textField_Name.setText(student.getStudentName() + "");
		this.comboBox_form.setSelectedItem(student.getBirthPlace().getProvinceName());
		String date = new SimpleDateFormat("yyyy-MM-dd").format(student.getDateOfBirth());
		this.textField_Date.setText(date);
		if (student.isSex()) {
			this.radioButton_Male.setSelected(true);
		} else {
			this.radioButton_Female.setSelected(true);
		}
		this.textField_subject1.setText(student.getSubject1() + "");
		this.textField_subject2.setText(student.getSubject2() + "");
		this.textField_subject3.setText(student.getSubject3() + "");
	}

	public void deleteStudent() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Ban co chac chan xoa dong da chon?");
		if (luaChon == JOptionPane.YES_OPTION) {
			Student student = getStudentSelect();
			this.model.delete(student);
			model_table.removeRow(i_row);
		}
	}

	public void studentFilter() {
		this.cancelStudentFilter();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int birthPlaceFilter = this.jCombo_box_BirthPlace.getSelectedIndex();
		String studentId = this.studentIdFilter.getText();
		List<Integer> list = new ArrayList<Integer>();
		int soLuongDong = model_table.getRowCount();
		for (int i = soLuongDong - 1; i >= 0; i--) {
			boolean removeRow = false;

			if (birthPlaceFilter > 0 && !model_table.getValueAt(i, 2)
					.equals(Province.getProvinceById(birthPlaceFilter).getProvinceName())) {
				removeRow = true;
			} else {
				try {
					// Only parse and check the studentId if it's not empty
					if (!studentId.isEmpty()) {
						int parsedStudentId = Integer.parseInt(studentId);
						if (!studentId.equals(model_table.getValueAt(i, 0).toString())) {
							removeRow = true;
						}
					}
				} catch (NumberFormatException e) {
					// Handle the case where studentId is not an integer
					// Maybe log an error, inform the user, or ignore this filter condition
				}
			}

			if (removeRow) {
				list.add(i);
			}
		}
		for (Integer i : list) {
			model_table.removeRow(i);
		}
	}

	public void cancelStudentFilter() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		while (model_table.getRowCount() > 0) {
			model_table.removeRow(0);
		}
		for (Student student : this.model.getListStudent()) {
			this.insertStudentInTable(student);
		}
	}
}
