package model;

import java.util.Date;

public class Student implements Comparable<Student> {
	private int studentId;
	private String studentName;
	private Province birthPlace;
	private Date dateOfBirth;
	private boolean sex;
	private float subject1, subject2, subject3;
	private double avgMark;

	public Student() {
	}

	public Student(int studentId, String studentName, Province birthPlace, Date dateOfBirth, boolean sex,
			float subject1, float subject2, float subject3) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.birthPlace = birthPlace;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.avgMark = (subject1 + subject2 + subject3) / 3;
	}

	public Province getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(Province birthPlace) {
		this.birthPlace = birthPlace;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public float getSubject1() {
		return subject1;
	}

	public void setSubject1(float subject1) {
		this.subject1 = subject1;
	}

	public float getSubject2() {
		return subject2;
	}

	public void setSubject2(float subject2) {
		this.subject2 = subject2;
	}

	public float getSubject3() {
		return subject3;
	}

	public void setSubject3(float subject3) {
		this.subject3 = subject3;
	}

	public double getAvgMark() {
		return avgMark;
	}

	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", birthPlace=" + birthPlace
				+ ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", subject1=" + subject1 + ", subject2=" + subject2
				+ ", subject3=" + subject3 + ", avgMark=" + avgMark + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgMark);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((birthPlace == null) ? 0 : birthPlace.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + (sex ? 1231 : 1237);
		result = prime * result + studentId;
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result + Float.floatToIntBits(subject1);
		result = prime * result + Float.floatToIntBits(subject2);
		result = prime * result + Float.floatToIntBits(subject3);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(avgMark) != Double.doubleToLongBits(other.avgMark))
			return false;
		if (birthPlace == null) {
			if (other.birthPlace != null)
				return false;
		} else if (!birthPlace.equals(other.birthPlace))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (sex != other.sex)
			return false;
		if (studentId != other.studentId)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (Float.floatToIntBits(subject1) != Float.floatToIntBits(other.subject1))
			return false;
		if (Float.floatToIntBits(subject2) != Float.floatToIntBits(other.subject2))
			return false;
		if (Float.floatToIntBits(subject3) != Float.floatToIntBits(other.subject3))
			return false;
		return true;
	}

	@Override
	public int compareTo(Student o) {
		return Double.compare(this.avgMark, o.avgMark);
	}
}
