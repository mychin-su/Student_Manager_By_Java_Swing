package model;

import java.util.ArrayList;

import dao.StudentManagerDao;

public class StudentManagerModel {
	public ArrayList<Student> listStudent;
	private String fileName;

	public StudentManagerModel(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}

	public StudentManagerModel() {
		this.listStudent = StudentManagerDao.getInstance().selectAll();
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
		StudentManagerDao.getInstance().insert(student);
	}

	public void delete(Student student) {
		this.listStudent.remove(student);
		StudentManagerDao.getInstance().delete(student);
	}

	public void deleteAll() {
		this.listStudent.clear();
		StudentManagerDao.getInstance().deleteAll();
	}

	public void update(int i, Student student) {
		this.listStudent.set(i, student);
		StudentManagerDao.getInstance().update(student);
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
