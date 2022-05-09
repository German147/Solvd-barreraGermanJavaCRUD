package org.example.entity;




public class Student extends Person{
    private int idStudent;

    public Student() {
    }

    public Student( int idStudent) {
        this.idStudent = idStudent;
    }

    public Student(int idStudent, String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
        this.idStudent = idStudent;
    }

    public Student(String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent= " + idStudent + ", name: " + getName() + ", surname: " + getSurname()
                + ", Phone number: " + getPhoneNumber() +
                '}';
    }

}
