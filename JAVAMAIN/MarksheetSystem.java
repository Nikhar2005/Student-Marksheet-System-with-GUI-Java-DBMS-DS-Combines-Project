package JAVAMAIN;
import DS.*;
import DBMS.*;
import JAVAMAIN.*;

import java.io.*;
import java.sql.*;
import java.util.*;



public class MarksheetSystem {
    

    public static Connection con;
    public static PreparedStatement pst;
    static Scanner sc = new Scanner(System.in);
    static StudentLinkedList s1 = new StudentLinkedList();

    public static void main(String[] args)  {
        try {
            
            final StudentDatabase s2 = new StudentDatabase();
    
            Class.forName("com.mysql.cj.jdbc.Driver");
    
            String dbURL = "jdbc:mysql://localhost:3307/student_marksheet_generation";
            String dbUser= "root";
            String dbPass = "";
    
            con = DriverManager.getConnection(dbURL, dbUser, dbPass);
    
            if(con!=null)
            {
                String sql = "SELECT * FROM student_marksheet INNER JOIN student_details on student_marksheet.enrollment_no = student_details.enrollment_no";
                pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next())
                {
                    String sname = rs.getString("student_marksheet.name");
                    int srollno = rs.getInt("student_marksheet.rollno");
                    double sdsmark = rs.getDouble("ds");
                    double sfeemark = rs.getDouble("fee");
                    double smathsmarks = rs.getDouble("maths");
                    double sjavamarks = rs.getDouble("java");
                    double sdbmsmarks = rs.getDouble("dbms");
                    double smarks[] = {sdsmark,sfeemark,smathsmarks,sjavamarks,sdbmsmarks};
                    int enrollno = rs.getInt("student_marksheet.enrollment_no");
                    String sgender = rs.getString("student_marksheet.student_gender");
                    String semail = rs.getString("student_marksheet.student_email");
                    String sbranch = rs.getString("student_marksheet.branch");
                    String shod=rs.getString("hod_name");
                    String sdepartment=rs.getString("department");
                    Student s = new Student(sname, sgender, semail, shod, sbranch, sdepartment, srollno, enrollno, smarks);
                    s1.addStudent(s);
                }
                
            
                admin.main(args);
                int chhh=0;
                boolean a = true;
                while(a)
                {
                    System.out.println();
                    System.out.println("------------------------------------------------------");
                    System.out.println("|  press 1 for Admin use                             |");
                    System.out.println("|  press 2 for Student use                           |");
                    System.out.println("|  press 3 for exit                                  |");
                    System.out.println("------------------------------------------------------");
                    System.out.println();
                    boolean bchhh = true;
                    while (bchhh) {
                            
                        try {
                            System.out.print("enter your choice:");
                            chhh = sc.nextInt();
                            sc.nextLine();  
                            bchhh = false;
                        } catch (Exception e) {
                            System.out.println("input missmatch exception , please try again");
                            sc.nextLine();
                        }
                    }
                    switch(chhh)
                    {
                        case 1:
                            //Admin id:NIKHAR
                            //Admin password:12345
                            
                            boolean log = true; 
                            int chance = 3;
                            while (log) {
                                System.out.println();
                                System.out.println("-----login process-----");
                                System.out.print("Enter Admin Id : ");
                                String adminid = sc.nextLine();
                                System.out.print("Enter Admin Password : ");
                                String adminpass = sc.nextLine();
                                if(adminid.equals("NIKHAR") && adminpass.equals("12345"))
                                {
                                    System.out.println("login successfull");
                                    System.out.println();
                                    log=false;
                                    break;
                                    
                                }
                                else
                                {
                                    chance = chance-1;
                                    System.out.println("login failed ! , " + chance + " chance remaining");
                                    System.out.println("try again");
                                    System.out.println();
                                }
                                if(chance==0)
                                {
                                    System.out.println("Student Marksheet Generation System is lock ");
                                    System.exit(0);
                                }
                            }
                            boolean x = true;
                            while(x)
                            {
                                System.out.println();
                                System.out.println("------------------------------------------------------");
                                System.out.println("|  press 1 for GUI based Project                     |");
                                System.out.println("|  press 2 for Console based Project                 |");
                                System.out.println("|  press 3 for exit                                  |");
                                System.out.println("------------------------------------------------------");
                                System.out.println();
                                int chh=0;
                                boolean bchh = true;
                                while (bchh) {
                            
                                    try {
                                        System.out.print("enter your choice:");
                                        chh = sc.nextInt();
                                        bchh=false;
                                    } catch (Exception e) {
                                        System.out.println("input missmatch exception , please try again");
                                        sc.nextLine();
                                    }
                                }
                                switch(chh)
                                {
                                    case 1:
                                        admin.main(args);
                                    break;
    
                                    case 2:
                                        boolean b = true;
                                        while (b) 
                                        {
                                            System.out.println();
                                            System.out.println("------------------------------------------------------------");
                                            System.out.println("|  press 1 for add student marks in marksheet              |");
                                            System.out.println("|  press 2 for delete student                              |");
                                            System.out.println("|  press 3 for update student marks in marksheet           |");
                                            System.out.println("|  press 4 for display all students marksheet              |");
                                            System.out.println("|  press 5 for display students depatment wise             |");
                                            System.out.println("|  press 6 for display top 10 student                      |");
                                            System.out.println("|  press 7 for display particular student marksheet        |");
                                            System.out.println("|  press 8 for write Student detail in file                |");
                                            System.out.println("|  press 9 for display eligible students for next sem      |");
                                            System.out.println("|  press 10 for display not eligible students for next sem |");
                                            System.out.println("|  press 11 for return home menu                           |");
                                            System.out.println("------------------------------------------------------------");
                                            System.out.println();
                                            int ch = 0;
                                            boolean bch = true;
                                            while (bch) {
                            
                                                try {
                                                    System.out.print("enter your choice:");
                                                    ch=sc.nextInt();
                                                    sc.nextLine();
                                                    bch=false;
                                                        
                                                } catch (Exception e) {
                                                    System.out.println("input missmatch exception , please try again");
                                                    sc.nextLine();
                                                }
                                            }
                                            switch(ch)
                                            {
                                                case 1:
                                                    int enrollno=0;
                                                    boolean er = true;
                                                    while (er) {
                                                        try {
                                                            System.out.print("Enter the enrollment number of students: ");
                                                            
                                                            enrollno = sc.nextInt();
                                                            sc.nextLine();
                                                            er=false;
                                                        } catch (Exception e) {
                                                            System.out.println("input missmatch exception , plrase try again");
                                                            sc.nextLine();
                                                        }
                                                        
                                                    }
                                                    System.out.print("Enter the name of new students: ");
                                                    String name = sc.nextLine();
                                                    System.out.print("Enter the email of new students: ");
                                                    String email = sc.nextLine();
                                                    int rollno = 0;
                                                    boolean rn =true;
                                                    while (rn) {
                                                        System.out.print("Enter the rollno of students: ");
                                                        try {
                                                            rollno = sc.nextInt();
                                                            rn=false;
                                                        }
                                                        catch(Exception e)
                                                        {
                                                            System.out.println("input missmatch exception , plrase try again");
                                                            sc.nextLine();
                                                        }
                                                    }
                                                   
                                                    String gender="";
                                                    boolean bb =true;
                                                    while(bb)
                                                    {
                                                        System.out.print("enter student gender \t press 1 for Male \t press 2 for Female: ");
                                                        try {
                                                            int choice = sc.nextInt();
                                                            sc.nextLine();
                                                            switch (choice) {
                                                                case 1:
                                                                    gender="Male";
                                                                    bb=false;
                                                                    break;
                                
                                                                case 2:
                                                                    gender="Female";
                                                                    bb=false;
                                                                    break;
                                                            
                                                                default:
                                                                    System.out.println("invalid choice , Please enter valid choice");
                                                                    break;
                                                            }
                                                            
                                                        } catch (Exception e) {
                                                            System.out.println("input missmatch exception , please try again");
                                                            sc.nextLine();
                                                        }
                                                    }
                        
                                                    String department="";
                                                    String hod="";
                                                    String branch="";
                                                    boolean bb1 =true;
                                                    while(bb1)
                                                    {
                                                        System.out.println("enter student branch ");
                                                        System.out.println("press 1 for CE     press 2 for IT      press 3 for CSD"); 
                                                        System.out.println("press 4 for AIML   press 5 for AIDS    press 6 for CS&IT     press 7 for CEA"); 
                                                        System.out.print("press 8 for RAI    press 9 for CSE     press 10 for CST: "); 
                                                        try {
                                                            
                                                            int choice = sc.nextInt();
                                                        
                                                            sc.nextLine();
                                                            switch (choice) 
                                                            {
                                                                case 1:
                                                                    department="FY1";
                                                                    branch="CE";
                                                                    hod="Ms. Zalak Bhavasr";
                            
                                                                    bb1=false;
                                                                    break;
                                
                                                                case 2:
                                                                    department="FY1";
                                                                    branch="IT";
                                                                    hod="Ms. Zalak Bhavasr";
                                                                    bb1=false;
                                                                    break;
                                                                    
                                                                case 3:
                                                                    department="FY1";
                                                                    branch="CSD";
                                                                    hod="Ms. Zalak Bhavasr";
                                                                    bb1=false;
                                                                    break;
                            
                                                                case 4:
                                                                    department="FY2";
                                                                    branch="AIML";
                                                                    hod="Mr. Prayag Patel";
                                                                    bb1=false;
                                                                    break;
                            
                                                                case 5:
                                                                    department="FY2";
                                                                    branch="AIDS";
                                                                    hod="Mr. Prayag Patel";
                                                                    bb1=false;
                                                                    break;
                            
                                                                case 6:
                                                                    department="FY2";
                                                                    branch="CS&IT";
                                                                    hod="Mr. Prayag Patel";
                                                                    bb1=false;
                                                                    break;
                            
                                                                case 7:
                                                                    department="FY2";
                                                                    branch="CEA";
                                                                    hod="Mr. Prayag Patel";
                                                                    bb1=false;
                                                                    break;
                            
                                                                case 8:
                                                                    department="FY3";
                                                                    branch="RAI";
                                                                    hod="Mr. Hiren Makwana";
                                                                    bb1=false;
                                                                    break;
                            
                                                                case 9:
                                                                    department="FY3";
                                                                    branch="CSE";
                                                                    hod="Mr. Hiren Makwana";
                                                                    bb1=false;
                                                                    break;
                            
                                                                case 10:
                                                                    department="FY3";
                                                                    branch="CST";
                                                                    hod="Mr. Hiren Makwana";
                                                                    bb1=false;
                                                                    break;
                                                            
                                                                default:
                                                                    System.out.println("invalid choice , Please enter valid choice");
                                                                    break;
                                                            }
                                                        } catch (Exception e) {
                                                            System.out.println("input missmatch exception , please try again");
                                                            sc.nextLine();
                                                        }
                                                    }
                                                    double dsMarks=0;
                                                    double feeMarks=0;
                                                    double mathsMarks=0;
                                                    double javaMarks=0;
                                                    double dbmsMarks=0;
                                                    boolean bm = true;
                                                    while (bm) {
                            
                                                        try {
                                                            System.out.print("Enter the ds marks (out of 100) of students: ");
                                                            dsMarks=sc.nextInt();
                                                            System.out.print("Enter the fee marks (out of 100) of students: ");
                                                            feeMarks=sc.nextInt();
                                                            System.out.print("Enter the maths marks (out of 100) of students: ");
                                                            mathsMarks=sc.nextInt();
                                                            System.out.print("Enter the java marks (out of 100) of students: ");
                                                            javaMarks=sc.nextInt();
                                                            System.out.print("Enter the dbms marks (out of 100) of students: ");
                                                            dbmsMarks=sc.nextInt();
                                                            sc.nextLine();
                                                            bm=false;
                                                                
                                                        } catch (Exception e) {
                                                            System.out.println("input missmatch exception , please try again");
                                                            sc.nextLine();
                                                        }
                                                    }
                                                    
                                                    double marks[]={dsMarks,feeMarks,mathsMarks,javaMarks,dbmsMarks};
                                                    Student s = new Student(name, gender, email, hod, branch, department, rollno, enrollno, marks);
                        
                                                    s1.addStudent(s);
                                                    s2.insertData(name, rollno, marks,enrollno,gender,email,branch,hod,department, con);
                        
                            
                                                break;
                                //
                                                case 2:
                                                    int senrollno = 0;
                                                    boolean be = true;
                                                    while (be) {
                            
                                                        try {
                                                            System.out.print("Enter the enrollment number of students you want to delete: ");
                                                            senrollno = sc.nextInt();
                                                            sc.nextLine();
                                                            be=false;
                                                                
                                                        } catch (Exception e) {
                                                            System.out.println("input missmatch exception , please try again");
                                                            sc.nextLine();
                                                        }
                                                    }
                                                    s1.deleteStudent(senrollno,con);
                                                break;
                                
                                                case 3:
                                                    int enrollno2 = 0;
                                                    boolean beu = true;
                                                    while (beu) {
                            
                                                        try {
                                                            System.out.print("Enter the enrollment number of students you want to update: ");
                                                            enrollno2 = sc.nextInt();
                                                            beu = false;
                                                                
                                                        } catch (Exception e) {
                                                            System.out.println("input missmatch exception , please try again");
                                                            sc.nextLine();
                                                        }
                                                    }
                                                    sc.nextLine();
                                                    s1.update(enrollno2,con);
                                                break;
                                
                                                case 4:
                                                    s2.display(con);
                                                    
                                                break;

                                                case 5:
                                                    String sdepartment = "";
                                                    boolean y =true;
                                                    while(y)
                                                    {
                                                       
                                                        int choice = 0;
                                                        boolean bd = true;
                                                        while (bd) {
                            
                                                            try {
                                                                System.out.print("Enter department name \t press 1 for FY1 \t press 2 for FY2 \t press 3 for FY3 : ");
                                                                choice = sc.nextInt();
                                                                bd= false;
                                                                    
                                                            } catch (Exception e) {
                                                                System.out.println("input missmatch exception , please try again");
                                                                sc.nextLine();
                                                            }
                                                        }
                                                        sc.nextLine();
                                                        switch (choice) {
                                                            case 1:
                                                                sdepartment="FY1";
                                                                y=false;
                                                                break;
                            
                                                            case 2:
                                                                sdepartment="FY2";
                                                                y=false;
                                                                break;

                                                            case 3:
                                                                sdepartment="FY3";
                                                                y=false;
                                                                break;
                                                        
                                                            default:
                                                                System.out.println("invalid choice , Please enter valid choice");
                                                                break;
                                                        }
                                                    }
                                                    
                                                    s2.displayDepartmentWise(sdepartment, con);
                                                break;
                                
                                                case 6:
                                                    s2.top10Students(con);
                                                break;
                                
                                                case 7:
                                                    
                                                    int rollNo = 0;
                                                    boolean bes = true;
                                                    while (bes) {
                            
                                                        try {
                                                            System.out.print("Enter Student enrollment number:");
                                                            rollNo = sc.nextInt();
                                                            bes=false;
                                                                
                                                        } catch (Exception e) {
                                                            System.out.println("input missmatch exception , please try again");
                                                            sc.nextLine();
                                                        }
                                                    }
                                                    sc.nextLine();
                                                    s2.displayStudentMarksheet(rollNo,con);
                                                break;
                                
                                                case 8:
                                                    
                                                    int rollNo1 = 0;
                                                    boolean bew = true;
                                                    while (bew) {
                            
                                                        try {
                                                            System.out.print("Enter Student enrollment number you want to write student details in student files:");
                                                            rollNo1 = sc.nextInt();
                                                            bew = false;
                                                                
                                                        } catch (Exception e) {
                                                            System.out.println("input missmatch exception , please try again");
                                                            sc.nextLine();
                                                        }
                                                    }
                                                    sc.nextLine();
                                                    s2.writeStudentDetailInFile(rollNo1,con);
                                
                                                break;

                                                case 9:
                                                    s2.eligible_students(con);
                                                break;

                                                case 10:
                                                    s2.not_eligible_students(con);
                                                break;
    
                                                case 11:
                                                    b=false;
                                                break;
    
                                                
                                                default:
                                                System.out.println("invalid choice");
                                
                                            }
                                        }
                                    break;
    
                                    case 3:
                                        x=false;
                                        
                                    break;

                                    default:
                                    System.out.println("invalid choice");

                                        
                                }
                            }
                        break;



                        case 2:
                        
                            boolean c = true;
                            while (c) {
                                System.out.println();
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("|  press 1 for display all students marksheet             |");
                                System.out.println("|  press 2 for display students department wise           |");
                                System.out.println("|  press 3 for display top 10 student                     |");
                                System.out.println("|  press 4 for display particular student marksheet       |");
                                System.out.println("|  press 5 for write Student detail in file               |");
                                System.out.println("|  press 6 for display eligible students for next sem     |");
                                System.out.println("|  press 7 for display not eligible students for next sem |");
                                System.out.println("|  press 8 for return home menu                           |");
                                System.out.println("-----------------------------------------------------------");
                                System.out.println();
                                int ch=0;
                                boolean bch=true;
                                while (bch) {
                            
                                    try {
                                            
                                        System.out.print("enter your choice:");
                                        ch=sc.nextInt();
                                        sc.nextLine();
                                        bch=false;
                                    } catch (Exception e) {
                                        System.out.println("input missmatch exception , please try again");
                                        sc.nextLine();
                                    }
                                }
                                switch(ch)
                                {
                                    case 1:
                                        s2.display(con);
                                    break;

                                    case 2:
                                        String sdepartment = "";
                                        boolean y =true;
                                        while(y)
                                        {
                                            int choice=0;
                                            boolean bchoice = true;
                                            while (bchoice) {
                            
                                                try {
                                                    System.out.print("Enter department name \t press 1 for FY1 \t press 2 for FY2 \t press 3 for FY3 : ");
                                                    choice = sc.nextInt();
                                                    sc.nextLine();
                                                    bchoice=false;
                                                        
                                                } catch (Exception e) {
                                                    System.out.println("input missmatch exception , please try again");
                                                    sc.nextLine();
                                                }
                                            }
                                            switch (choice) {
                                                case 1:
                                                    sdepartment="FY1";
                                                    y=false;
                                                    break;
                
                                                case 2:
                                                    sdepartment="FY2";
                                                    y=false;
                                                    break;

                                                case 3:
                                                    sdepartment="FY3";
                                                    y=false;
                                                    break;
                                            
                                                default:
                                                    System.out.println("invalid choice , Please enter valid choice");
                                                    break;
                                            }
                                        }
                                        
                                        s2.displayDepartmentWise(sdepartment, con);
                                    break;
                    
                                    case 3:
                                        s2.top10Students(con);
                                    break;
                    
                                    case 4:
                                        
                                        int rollNo = 0;
                                        boolean bse = true;
                                        while (bse) {
                            
                                            try {
                                                System.out.print("Enter Student enrollment number:");
                                                rollNo = sc.nextInt();
                                                bse = false;
                                                    
                                            } catch (Exception e) {
                                                System.out.println("input missmatch exception , please try again");
                                                sc.nextLine();
                                            }
                                        }
                                        sc.nextLine();
                                        s2.displayStudentMarksheet(rollNo,con);
                                    break;
                    
                                    case 5:
                                        
                                        int rollNo1 = 0;
                                        boolean bw  =true;
                                        while (bw) {
                            
                                            try {
                                                System.out.print("Enter Student enrollment number you want to write student details in student files:");
                                                rollNo1 = sc.nextInt();
                                                bw=false;
                                                    
                                            } catch (Exception e) {
                                                System.out.println("input missmatch exception , please try again");
                                                sc.nextLine();
                                            }
                                        }
                                        sc.nextLine();
                                        s2.writeStudentDetailInFile(rollNo1,con);
                    
                                    break;

                                    case 6:
                                        s2.eligible_students(con);
                                    break;

                                    case 7:
                                        s2.not_eligible_students(con);
                                    break;

                                    case 8:
                                        c=false;
                                    break;

                                    default:
                                    System.out.println("invalid choice");
                    
                                }
                            }
                        break;

                        case 3:
                            System.out.println("Thankyou! , for using Marksheet System");
                            a=false;
                            System.exit(0);
                        break;

                        default:
                            System.out.println("invalid choice");
                        break;
                    }
                }
                
            }
            else
            {
                System.out.println("Connection Failed");
            }
            con.close();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Xampp is not connected");
        }

    }

    public void addGUIDataLL(Student s)
    {
        s1.addStudent(s);
    }

    public double percentageCalculator(double total)
    {
        double percentage = (total ) / 5;
        return percentage;
    }

    public double SPICalculator(double percentage)
    {
        double spi = ( percentage) / 10;
        return spi;
    }

    public String getGrade(double percentage)
    {
        if(percentage<=100 && percentage>=90)
        {
            return "A+";
        }
        else if(percentage<90 && percentage>=80)
        {
            return "A";
        }
        else if(percentage<80 && percentage>=70)
        {
            return "B+";
        }
        else if(percentage<70 && percentage>=60)
        {
            return "B";
        }
        else if(percentage<60 && percentage>=50)
        {
            return "C+";
        }
        else if(percentage<50 && percentage>=35)
        {
            return "C";
        }
        else if(percentage<35)
        {
            return "F";
        }
        else
        {
            return "";
        }
    }

    public String studentStatus(String grade)
    {
        if(grade == "F")
        {
            return "Failed";
        }
        else if(grade == "")
        {
            return "Not Decided";
        }
        else
        {
            return "Passed";
        }  
    }
    
    
}

