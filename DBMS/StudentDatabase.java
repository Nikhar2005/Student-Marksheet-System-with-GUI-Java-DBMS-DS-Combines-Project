package DBMS;


import JAVAMAIN.*;
import DS.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;
import java.util.*;


public class StudentDatabase {

    static PreparedStatement pst;
    static Scanner sc = new Scanner(System.in);
    public MarksheetSystem ms = new MarksheetSystem();
    


    public StudentDatabase() {
    }

    public void insertData(String name , int rollno , double marks[] ,int enrollno,String gender,String email,String branch,String hod,String department,Connection con ) throws Exception
    {
        try {
            
            double total = marks[0]+marks[1]+marks[2]+marks[3]+marks[4];
            double percentage = ms.percentageCalculator(total);
            double spi = ms.SPICalculator(percentage);
            String grade = ms.getGrade(percentage);
            String status = ms.studentStatus(grade);
            String sql = "insert into student_marksheet (`enrollment_no`, `name`, `student_email`, `student_gender`, `rollno`, `branch`, `ds`, `fee`, `maths`, `java`, `dbms`, `total`, `percentage`, `SPI`, `grade`, `status`) values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ,? )";  
            pst = con.prepareStatement(sql);
            pst.setInt(1,enrollno );
            pst.setString(2 , name);
            pst.setString(3, email);
            pst.setString(4, gender);
            pst.setInt(5 , rollno);
            pst.setString(6, branch);
            pst.setDouble(7 , marks[0]);
            pst.setDouble(8 , marks[1]);
            pst.setDouble(9, marks[2]);
            pst.setDouble(10 , marks[3]);
            pst.setDouble(11 , marks[4]);
            pst.setDouble(12 , total);
            pst.setDouble(13 , percentage);
            pst.setDouble(14 , spi);
            pst.setString(15 , grade);
            pst.setString(16 , status);
            pst.executeUpdate();
            System.out.println("student " + name + " is inserted");
    
            sql = "INSERT INTO `student_details`( `enrollment_no`, `rollno`, `department`, `branch`, `student_name`, `student_email`, `student_gender`, `hod_name`) VALUES (? , ? , ? , ? , ? , ? , ? , ?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1,enrollno );
            pst.setInt(2 , rollno);
            pst.setString(3, department);
            pst.setString(4, branch);
            pst.setString(5, name);
            pst.setString(6, email);
            pst.setString(7, gender);
            pst.setString(8, hod);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Duplicate Enrollment number is not valid for insertion");
        }

    }

    public void deleteData(int enrollno,Connection con) throws Exception
    {
        String sql1 = "delete from student_marksheet where enrollment_no = ?";
        pst = con.prepareStatement(sql1);
        pst.setInt(1 , enrollno);
        pst.executeUpdate();

        String sql = "delete from student_details where enrollment_no = ?";
        pst = con.prepareStatement(sql);
        pst.setInt(1 , enrollno);
        pst.executeUpdate();

    }

   

    public void updateName(int enrollno,String name , Connection con) throws Exception
    {
        
        String sql1 = "update student_marksheet set name = ? where enrollment_no = ?";
        pst = con.prepareStatement(sql1);
        pst.setString(1, name);
        pst.setInt(2, enrollno);
        pst.executeUpdate();

        String sql = "update student_details set student_name = ? where enrollment_no = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, name);
        pst.setInt(2, enrollno);
        pst.executeUpdate();
        
    }

    public void updateMarks(int enrollno,double dsm,double feem,double mathsm,double javam,double dbmsm,Connection con) throws Exception
    {
        double totalm = dsm+feem+mathsm+javam+dbmsm;
        double percentage = ms.percentageCalculator(totalm);
        double spi = ms.SPICalculator(percentage);
        String grade = ms.getGrade(percentage);
        String status = ms.studentStatus(grade);

        String sql2 = "update student_marksheet set ds = ?, fee = ?, maths = ? , java = ? , dbms = ?, total = ? ,percentage = ? , SPI = ? , grade = ? , status = ? where enrollment_no = ? ";
        pst = con.prepareStatement(sql2);
        pst.setDouble(1, dsm);
        pst.setDouble(2, feem);
        pst.setDouble(3, mathsm);
        pst.setDouble(4, javam);
        pst.setDouble(5, dbmsm);
        pst.setDouble(6, totalm);
        pst.setDouble(7, percentage);
        pst.setDouble(8, spi);
        pst.setString(9, grade);
        pst.setString(10, status);
        pst.setInt(11, enrollno);
        pst.executeUpdate();
    }

    public void display(Connection con) throws Exception
    {
        //int a=0;
        //String sql1 = "SELECT count(*) into a FROM student_marksheet INNER JOIN student_details on student_marksheet.enrollment_no = student_details.enrollment_no ";  

        String sql = "SELECT * FROM student_marksheet INNER JOIN student_details on student_marksheet.enrollment_no = student_details.enrollment_no ";  
      
        pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        // if(a>0)
        // {

            if(rs!=null)
            {
    
                while(rs.next())
                {
                    int enrollno = rs.getInt("student_marksheet.enrollment_no");  ///
                    String name = rs.getString("name");
                    int rollno = rs.getInt("student_marksheet.rollno");    /// 
                    double dsm = rs.getDouble("ds");
                    double feem = rs.getDouble("fee");
                    double mathsm = rs.getDouble("maths");
                    double javam = rs.getDouble("java");
                    double dbmsm = rs.getDouble("dbms");
                    double totalm = rs.getDouble("total");
                    
                    System.out.println("enrollment no.: " + enrollno);
                    System.out.println("name          : " +name);
                    System.out.println("roll no.      : "+ rollno);  /// 
                    System.out.println("Subject       :  ds\t  fee\t maths\t java\t dbms");
                    System.out.println("Marks         : " + dsm+ "\t " + feem + "\t " + mathsm + "\t " + javam + "\t " + dbmsm);
                    System.out.println("total         : " + totalm);
                    System.out.println("------------------------------------------------------");
                    
                }
            }
        // }
        // else
        // {
        //     System.out.println("No record found");
        // }
        

    }

    public void top10Students(Connection con) throws Exception
    {
        
        String sql = "call getTop10Students()";
        CallableStatement cst = con.prepareCall(sql);
        ResultSet rs = cst.executeQuery();
        int rank=1;
        if(rs!=null)
        {
            while(rs.next())
            {
                System.out.println("Rank        :"+rank);
                System.out.println("Name        :"+rs.getString("name"));
                System.out.println("Rollno      :"+rs.getInt("rollno"));
                System.out.println("Branch      :"+rs.getString("branch"));
                System.out.println("Total Marks :"+rs.getInt("total"));
                System.out.println("------------------------------------------------------");
                System.out.println();
                rank=rank+1;
            }
        }
        else
        {
            System.out.println("No record found");
        }
    }

    public void eligible_students(Connection con) throws Exception
    {
        // int a=0;
        // String sql1 = "select count(*) into a from student_eligible_for_next_sem";

        String sql = "select * from student_eligible_for_next_sem";
        pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        // if(a>0)
        // {
            if(rs!=null)
            {
                while(rs.next())
                {
                    System.out.println("Enroll no.  :" + rs.getInt("enrollment_no"));   
                    System.out.println("Name        :"+rs.getString("name"));
                    System.out.println("Rollno      :"+rs.getInt("rollno"));
                    System.out.println("Branch      :"+rs.getString("branch"));
                    System.out.println("Total Marks :"+rs.getInt("total"));
                    System.out.println("SPI         :" + rs.getDouble("spi"));
                    System.out.println("------------------------------------------------------");
                    System.out.println();
                    
                }
            }

        // }
        // else
        // {
        //     System.out.println("No record found");
        // }
    }


    public void not_eligible_students(Connection con) throws Exception
    {
        // int a=0;
        // String sql1 = "select count(*) into a from student_not_eligible_for_next_sem";
        // pst = con.prepareStatement(sql1);
        // pst.executeQuery();

        String sql = "select * from student_not_eligible_for_next_sem";
        pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        // if(a>0)
        // {
            if(rs!=null)
            {
                while(rs.next())
                {
                    System.out.println("Enroll no.  :" + rs.getInt("enrollment_no"));   
                    System.out.println("Name        :"+rs.getString("name"));
                    System.out.println("Rollno      :"+rs.getInt("rollno"));
                    System.out.println("Branch      :"+rs.getString("branch"));
                    System.out.println("Total Marks :"+rs.getInt("total"));
                    System.out.println("SPI         :" + rs.getDouble("spi"));
                    System.out.println("------------------------------------------------------");
                    System.out.println();
                    
                }
            }

    //    }
    //     else
    //     {
    //         System.out.println("No record found");
    //     }
    }

    public void displayStudentMarksheet(int enrollno , Connection con) throws Exception
    {
        // int a=0;
        // String sql1 = "SELECT count(*) into a FROM student_marksheet INNER JOIN student_details on student_marksheet.enrollment_no = student_details.enrollment_no  where student_marksheet.enrollment_no = ?";   /// 

        String sql = "SELECT * FROM student_marksheet INNER JOIN student_details on student_marksheet.enrollment_no = student_details.enrollment_no  where student_marksheet.enrollment_no = ?";   /// 
        pst = con.prepareStatement(sql);
        pst.setInt(1, enrollno);
        ResultSet rs = pst.executeQuery();
        // if(a>0)
        // {

            if(rs!=null)
            {
    
                while(rs.next())
                {
                    int senrollno = rs.getInt("student_marksheet.enrollment_no");  ///
                    String name = rs.getString("name");
                    int rollno = rs.getInt("student_marksheet.rollno");  ///
                    double dsm = rs.getDouble("ds");
                    double feem = rs.getDouble("fee");
                    double mathsm = rs.getDouble("maths");
                    double javam = rs.getDouble("java");
                    double dbmsm = rs.getDouble("dbms");
                    double totalm = rs.getDouble("total");
                    double percentage = ms.percentageCalculator(totalm);
                    double spi = ms.SPICalculator(percentage);
                    String grade = ms.getGrade(percentage);
                    String status = ms.studentStatus(grade);
                    System.out.println("****************************************************************");
                    System.out.println("*                      STUDENT   MARKSHEET                     *");
                    System.out.println("****************************************************************");
                    System.out.printf("* %-60s *\n" , "College Name    : LJ INSTITUTE OF ENGINEERING AND TECHNOLOGY");
                    System.out.printf("* %-60s *\n" , "Enrollment No.  : " + senrollno);   //
                    System.out.printf("* %-60s *\n" , "Roll No.        : " + rollno);      ///
                    System.out.printf("* %-60s *\n" , "Name            : " + name);
                    System.out.printf("* %-60s *\n" , "Gender          : " + rs.getString("student_marksheet.student_gender"));
                    System.out.printf("* %-60s *\n" , "Semester        : 2nd");
                    System.out.printf("* %-60s *\n" , "Course Name     : B Tech");
                    System.out.printf("* %-60s *\n" , "Department      : " + rs.getString("department"));  // 
                    System.out.printf("* %-60s *\n" , "HOD             : " + rs.getString("hod_name"));   // 
                    System.out.printf("* %-60s *\n" , "Branch          : " + rs.getString("student_marksheet.branch"));
                    System.out.printf("* %-60s *\n" , "------------------------------------------------------------");
                    System.out.printf("* %-60s *\n" , "DS              : " + dsm);
                    System.out.printf("* %-60s *\n" , "Fee             : " + feem);
                    System.out.printf("* %-60s *\n" , "Maths           : " + mathsm);
                    System.out.printf("* %-60s *\n" , "Java            : " + javam);
                    System.out.printf("* %-60s *\n" , "DBMS            : " + dbmsm);
                    System.out.printf("* %-60s *\n" , "------------------------------------------------------------");
                    System.out.printf("* %-60s *\n" , "Total           : " + totalm);
                    System.out.printf("* %-60s *\n" , "Percentage      : " + percentage + "%");
                    System.out.printf("* %-60s *\n" , "SPI             : " + spi);
                    System.out.printf("* %-60s *\n" , "Grade           : " + grade);
                    System.out.printf("* %-60s *\n" , "Status          : "+ status);
                    System.out.println("****************************************************************");
                }
            }
        // }
        // else
        // {
        //     System.out.println("No record found");
        // }
    }


    public void displayDepartmentWise(String department , Connection con) throws Exception
    {
        // int a = 0;
        // String sql1 = "SELECT count(*) into a FROM student_marksheet INNER JOIN student_details on student_marksheet.enrollment_no = student_details.enrollment_no where department = ? ";  
        
        String sql = "SELECT * FROM student_marksheet INNER JOIN student_details on student_marksheet.enrollment_no = student_details.enrollment_no where department = ? ";  
        pst = con.prepareStatement(sql);
        pst.setString(1, department);
        ResultSet rs = pst.executeQuery();
        // if(a>0)
        // {

            if(rs!=null)
            {
    
                while(rs.next())
                {
                    int enrollno = rs.getInt("student_marksheet.enrollment_no");  ///
                    String name = rs.getString("name");
                    int rollno = rs.getInt("student_marksheet.rollno");    /// 
                    double dsm = rs.getDouble("ds");
                    double feem = rs.getDouble("fee");
                    double mathsm = rs.getDouble("maths");
                    double javam = rs.getDouble("java");
                    double dbmsm = rs.getDouble("dbms");
                    double totalm = rs.getDouble("total");
                    
                    System.out.println("enrollment no.: " + enrollno);
                    System.out.println("name    : " +name);
                    System.out.println("roll no.: "+ rollno);  /// 
                    System.out.println("Department : " + department );
                    System.out.println("Branch  : " + rs.getString("student_marksheet.branch"));
                    System.out.println("HOD     : " + rs.getString("hod_name"));
                    System.out.println("Subject :  ds\t  fee\t maths\t java\t dbms");
                    System.out.println("Marks   : " + dsm+ "\t " + feem + "\t " + mathsm + "\t " + javam + "\t " + dbmsm);
                    System.out.println("total   : " + totalm);
                    System.out.println("------------------------------------------------------");
                    
                }
            }
        // }
        // else
        // {
        //     System.out.println("No record found");
        // }
        

    }

    public void writeStudentDetailInFile(int enrollno , Connection con) throws Exception
    {
        // int a=0;
        // String sql1 = "SELECT count(*) into a FROM student_marksheet INNER JOIN student_details on student_marksheet.enrollment_no = student_details.enrollment_no where student_marksheet.enrollment_no = ?";   ///

        String sql = "SELECT * FROM student_marksheet INNER JOIN student_details on student_marksheet.enrollment_no = student_details.enrollment_no where student_marksheet.enrollment_no = ?";   ///
        pst = con.prepareStatement(sql);
        pst.setInt(1, enrollno);
        ResultSet rs = pst.executeQuery();
        

            if(rs!=null)
            {
    
                while(rs.next())
                {
                    int senrollno = rs.getInt("student_marksheet.enrollment_no");  // 
                    String name = rs.getString("name");
                    int rollno = rs.getInt("student_marksheet.rollno");           //
                    double dsm = rs.getDouble("ds");
                    double feem = rs.getDouble("fee");
                    double mathsm = rs.getDouble("maths");
                    double javam = rs.getDouble("java");
                    double dbmsm = rs.getDouble("dbms");
                    double totalm = rs.getDouble("total");
                    double percentage = ms.percentageCalculator(totalm);
                    double spi = ms.SPICalculator(percentage);
                    String grade = ms.getGrade(percentage);
                    String status = ms.studentStatus(grade);
    
                    FileWriter fw = new FileWriter(name + ".txt");
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("************************************************************\n");
                    bw.write("*                     STUDENT  DETAILS                     *\n");
                    bw.write("************************************************************\n");
                    bw.write("College Name    : LJ INSTITUTE OF ENGINEERING AND TECHNOLOGY\n");
                    bw.write("Enrollment No.  : " + senrollno + "\n");
                    bw.write("Roll No.        : " + rollno +"\n");
                    bw.write("Name            : " + name +"\n");
                    bw.write("Gender          : " + rs.getString("student_marksheet.student_gender") +"\n");
                    bw.write("Semester        : 2nd\n");
                    bw.write("Course Name     : B Tech\n");
                    bw.write("Department      : " + rs.getString("department") +"\n"); //
                    bw.write("HOD             : " + rs.getString("hod_name") +"\n");   //
                    bw.write("Branch          : " + rs.getString("student_marksheet.branch") +"\n");
                    bw.write("------------------------------------------------------------\n");
                    bw.write("DS              : " + dsm +"\n");
                    bw.write("Fee             : " + feem +"\n");
                    bw.write("Maths           : " + mathsm +"\n");
                    bw.write("Java            : " + javam +"\n");
                    bw.write("DBMS            : " + dbmsm +"\n");
                    bw.write("------------------------------------------------------------\n");
                    bw.write("Total           : " + totalm +"\n");
                    bw.write("Percentage      : " + percentage + "%" +"\n");
                    bw.write("SPI             : " + spi +"\n");
                    bw.write("Grade           : " + grade +"\n");
                    bw.write("Status          : "+ status +"\n");
                    bw.write("************************************************************\n");
                    bw.close();
                    fw.close();
                }
            }
        
    }
}
