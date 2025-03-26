package DS;
import JAVAMAIN.*;
import DBMS.*;

import java.io.*;
import java.sql.*;
import java.util.*;

public class StudentLinkedList {
    final StudentDatabase s2 = new StudentDatabase();

    static Scanner sc = new Scanner(System.in);

    MarksheetSystem ms = new MarksheetSystem();
    
    

    public StudentLinkedList() {
    }

    public class Student1{
        Student student;
        public Student1 next;
        public Student1(Student student)
        {
            this.student = student;
            this.next = null;
        }

    }
    public Student1 head=null;

    public void addStudent(Student s) 
    {
        if(searchStudent(s.enrollno))
        {
            System.out.println("Student already exists");
        }
        else
        {

            Student1 newStudent = new Student1(s);
            if(head==null)
            {
                head = newStudent;
            }
            else
            {
                Student1 temp = head;
                while(temp.next!=null)
                {
                    temp = temp.next;
                }
                temp.next = newStudent;
            }
        }

       
       
    }

    public void deleteStudent(int enrollno,Connection con) throws Exception
    {
        
        if(head==null)
        {
            System.out.println("List is empty");
        }
        else
        {
            int flag=0;
            Student1 temp1=head;
            while(temp1!=null)
            {
                if(temp1.student.enrollno==enrollno)
                {
                    flag=1;
                    break;
                }
                temp1=temp1.next;
            }
            if(flag==1)
            {
                if(head.student.enrollno==enrollno)
                {
                    head=head.next;
                }
                else
                {
                    Student1 temp=head;
                    while(temp.next.student.enrollno!=enrollno)
                    {
                        temp=temp.next;
                    }
                    temp.next=temp.next.next;
                }
                System.out.println(enrollno + " is deleted");
                s2.deleteData(enrollno, con);
            }
            else
            {
                System.out.println("Enrollment no not found");
            }

        }
        
    }

    public void update(int enrollno,Connection con) throws Exception
    {
        if(searchStudent(enrollno))
        {

            System.out.println("enter what you want to update");
            System.out.println("press 1 for update name");
            System.out.println("press 2 for update marks");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("enter new name");
                    String name = sc.next();
                    updateStudentName(enrollno,name,con);
                    break;

                case 2:
                    System.out.print("enter new marks for ds:");
                    double dsm = sc.nextDouble();
                    System.out.print("enter new marks for fee:");
                    double feem = sc.nextDouble();
                    System.out.print("enter new marks for maths:");
                    double mathsm = sc.nextDouble();
                    System.out.print("enter new marks for java:");
                    double javam = sc.nextDouble();
                    System.out.print("enter new marks for dbms:");
                    double dbmsm = sc.nextDouble();
                    updateStudentMark(enrollno,dsm,feem,mathsm,javam,dbmsm,con);
                    break;

                default:
                    System.out.println("invalid choice");
            }

        }
        else
        {
            System.out.println("student not found");
        }
        
    }

    public void updateStudentName(int enrollno , String sname ,Connection con) throws Exception
    {
        if(head==null)
        {
            System.out.println("List is empty");
        }
        else
        {
            int flag=0;
            Student1 temp1=head;
            while(temp1!=null)  
            {
                if(temp1.student.enrollno==enrollno)
                {
                   temp1.student.name=sname;
                   flag=1;
                }
                temp1=temp1.next;
            }
            if(flag==0)
            {
                System.out.println("Roll no not found");
            }
            else{
                System.out.println("Name is updated sucessfully!");
                s2.updateName(enrollno,sname,con);
                
            }
        }
                    

    }

    public void updateStudentMark(int enrollno , double dsm , double feem , double mathsm ,double javam,double dbmsm, Connection con) throws Exception
    {
        if(head==null)
        {
            System.out.println("List is empty");
        }
        else
        {
            int flag=0;
            Student1 temp1=head;
            while(temp1!=null)  
            {
                if(temp1.student.enrollno==enrollno)
                {
                   temp1.student.marks[0]=dsm;
                   temp1.student.marks[1]=feem;
                   temp1.student.marks[2]=mathsm;
                   temp1.student.marks[3]=javam;
                   temp1.student.marks[4]=dbmsm;
                   flag=1;
                }
                temp1=temp1.next;
            }
            if(flag==0)
            {
                System.out.println("Roll no not found");
            }
            else{
               System.out.println("Marks are updated sucessfully!");
               s2.updateMarks(enrollno,dsm,feem,mathsm,javam,dbmsm,con);
            }
        }
                    

    }


    

    public boolean searchStudent(int enrollno)
    {
        if(head==null)
        {
            return false;
        }
        else
        {
            int flag=0;
            Student1 temp1=head;
            while(temp1!=null)
            {
                if(temp1.student.enrollno==enrollno)
                {
                    flag=1;
                    break;
                }
                temp1=temp1.next;
            }
            if(flag==1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }



    // BST

    public class StudentBSTNode {
        Student student;
        StudentBSTNode left, right;

        public StudentBSTNode(Student student) {
            this.student = student;
            left = right = null;
        }
    }
    public StudentBSTNode root = null;

    
    public StudentBSTNode insertBST(StudentBSTNode node, Student s) {
        if (node == null) {
            return new StudentBSTNode(s);
        }
        if (s.enrollno < node.student.enrollno) {
            node.left = insertBST(node.left, s);
        } else if (s.enrollno > node.student.enrollno) {
            node.right = insertBST(node.right, s);
        }
        return node;
    }

    
    public StudentBSTNode deleteBST(StudentBSTNode root, int enrollno) {
        if (root == null) {
            return root;
        }
        if (enrollno < root.student.enrollno) {
            root.left = deleteBST(root.left, enrollno);
        } else if (enrollno > root.student.enrollno) {
            root.right = deleteBST(root.right, enrollno);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.student = minValue(root.right);
            root.right = deleteBST(root.right, root.student.enrollno);
        }
        return root;
    }

    public Student minValue(StudentBSTNode root) {
        Student min = root.student;
        while (root.left != null) {
            root = root.left;
            min = root.student;
        }
        return min;
    }

   
    public boolean searchStudentBST(int enrollno) {
        return searchBST(root, enrollno) != null;
    }

    public StudentBSTNode searchBST(StudentBSTNode root, int enrollno) {
        if (root == null || root.student.enrollno == enrollno)
            return root;

        if (root.student.enrollno > enrollno)
            return searchBST(root.left, enrollno);

        return searchBST(root.right, enrollno);
    }
   
}
