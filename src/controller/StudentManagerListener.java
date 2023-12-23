package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.StudentManagerView;

public class StudentManagerListener implements ActionListener {
	private StudentManagerView studentManagerView;

	public StudentManagerListener(StudentManagerView studentManagerView) {
		this.studentManagerView = studentManagerView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Insert")) {
			this.studentManagerView.deleteForm();
		} else if (cm.equals("Save")) {
			try {
				this.studentManagerView.SaveStudent();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (cm.equals("Update")) {
			this.studentManagerView.setFormInformationStudent();
		} else if (cm.equals("Delete")) {
			this.studentManagerView.deleteStudent();
		} else if (cm.equals("Cancel")) {
			this.studentManagerView.deleteForm();
		} else if (cm.equals("Filter")) {
			this.studentManagerView.studentFilter();
		} else if (cm.equals("CancelF")) {
			this.studentManagerView.cancelStudentFilter();
		}
	}
}
