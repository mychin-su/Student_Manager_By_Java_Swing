package model;

import java.util.ArrayList;

public class StudentManagerModel {
	private ArrayList<Student> listStudent;
	private String fileName;

	public StudentManagerModel(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}

	public StudentManagerModel() {
		this.listStudent = new ArrayList<Student>();
		this.fileName = "";
	}

	public ArrayList<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void insert(Student student) {
		this.listStudent.add(student);
	}

	public void delete(Student student) {
		this.listStudent.remove(student);
	}

	public void update(Student student) {
		this.listStudent.remove(student);
		this.listStudent.add(student);
	}

	public boolean kiemTraTonTai(Student student) {
		for (Student st : listStudent) {
			if (st.getStudentId() == student.getStudentId()) {
				return true;
			}
		}
		return false;
	}

}
