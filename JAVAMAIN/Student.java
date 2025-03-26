package JAVAMAIN;

public class Student{
    public String name,gender,email,hod ,branch,department;
    public int rollno,enrollno;
    public double []marks;

    public Student (){

    }

    public Student(String name, String gender, String email, String hod, String branch,String department, int rollno,int enrollno, double[] marks) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.hod = hod;
        this.branch = branch;
        this.department=department;
        this.rollno = rollno;
        this.enrollno = enrollno;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getHod() {
        return hod;
    }

    public String getBranch() {
        return branch;
    }

    public String getDepartment() {
        return department;
    }

    public int getRollno() {
        return rollno;
    }

    public int getEnrollno() {
        return enrollno;
    }

    public double[] getMarks() {
        return marks;
    }

    
}
