package JAVAMAIN;
import JAVAMAIN.*;
import DS.*;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DHVANIT
 */
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();
        connect();
         User_load();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs ;
    DefaultTableModel d;
    public void connect() 
    {
        
           
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
    
            String dbURL = "jdbc:mysql://localhost:3307/student_marksheet_generation";
            String dbUser= "root";
            String dbPass = "";
    
            con = DriverManager.getConnection(dbURL, dbUser, dbPass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void User_load()
    {
        int c;
        
        try {
            String sql = "SELECT * FROM student_marksheet INNER JOIN student_details on student_marksheet.enrollment_no = student_details.enrollment_no ;";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c= rsd.getColumnCount();
            
            d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                for(int i = 1;i<=c;i++)
                {
                    v2.add(rs.getInt("student_marksheet.enrollment_no"));
                    v2.add(rs.getString("name"));
                    v2.add( rs.getString("student_marksheet.student_email"));
                    v2.add(rs.getString("student_marksheet.student_gender"));
                    v2.add(rs.getString("hod_name"));
                    v2.add(rs.getInt("rollno"));
                    v2.add(rs.getString("department"));
                    v2.add(rs.getString("student_marksheet.branch"));
                    v2.add(rs.getDouble("ds"));
                    v2.add(rs.getDouble("fee"));
                    v2.add(rs.getDouble("maths"));
                    v2.add(rs.getDouble("java"));
                    v2.add(rs.getDouble("dbms"));
                    v2.add(rs.getDouble("total"));
                    v2.add(rs.getDouble("percentage"));
                    v2.add(rs.getDouble("SPI"));
                    v2.add(rs.getString("grade"));
                    v2.add(rs.getString("status"));
                    
                }
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtenroll = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtroll = new javax.swing.JTextField();
        txtds = new javax.swing.JTextField();
        txtmaths = new javax.swing.JTextField();
        txtfee = new javax.swing.JTextField();
        txtdbms = new javax.swing.JTextField();
        txtjava = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtbranch = new javax.swing.JComboBox<>();
        txtmale = new javax.swing.JRadioButton();
        txtfemale = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        txtpercent = new javax.swing.JTextField();
        txtspi = new javax.swing.JTextField();
        txtgrade = new javax.swing.JTextField();
        txtstatus = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Enrollment Number");

        jLabel2.setText("Student Name");

        jLabel3.setText("Student Email");

        jLabel4.setText("Student Gender");

        jLabel5.setText("Roll Number");

        jLabel6.setText("Branch Name");

        jLabel7.setText("DS Mark");

        jLabel8.setText("FEE Mark");

        jLabel9.setText("Maths Mark");

        jLabel10.setText("Java Mark");

        jLabel11.setText("DBMS Mark");

        txtbranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CE", "IT", "CSD", "AIML", "AIDS", "CS&IT", "CEA", "RAI", "CSE", "CST" }));

        buttonGroup1.add(txtmale);
        txtmale.setText("Male");
        txtmale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaleActionPerformed(evt);
            }
        });

        buttonGroup1.add(txtfemale);
        txtfemale.setText("Female");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtenroll)
                        .addComponent(txtdbms)
                        .addComponent(txtjava)
                        .addComponent(txtmaths)
                        .addComponent(txtfee)
                        .addComponent(txtds)
                        .addComponent(txtroll)
                        .addComponent(txtemail)
                        .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addComponent(txtbranch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtmale, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfemale, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtenroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtmale)
                    .addComponent(txtfemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtbranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtmaths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtjava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtdbms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enrollment no", "Name", "Email", "Gender", "HOD", "Roll no", "Department", "Branch", "DS", "FEE", "Maths", "Java", "DBMS", "Total", "Percentage", "SPI", "Grade", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 51, 0));
        jLabel12.setText("STUDENT MARKSHEET GENERATION SYSTEM");

        jButton6.setText("Calculate Result");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel13.setText("      Total");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setText("  Percentage");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setText("        SPI");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("      Grade");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setText("     Status");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton1)
                                .addGap(32, 32, 32)
                                .addComponent(jButton2)
                                .addGap(40, 40, 40)
                                .addComponent(jButton3)
                                .addGap(33, 33, 33)
                                .addComponent(jButton4)
                                .addGap(31, 31, 31)
                                .addComponent(jButton5)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttotal, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtpercent)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtspi, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtgrade, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(jButton6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 992, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtspi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int enroll=0,roll = 0;
        String name = "" , email = "", gender = "" , branch = "";
        String department="";
        String hod="";
        double dsm = 0;
        double feem = 0;
        double mathsm=0;
        double javam =0;
        double dbmsm =0;
        double totalm = 0;
        double percentage=0;
        double spi = 0;
        String grade = "";
        String status = "";
        boolean ba = true;
        while (ba) 
        {
            
            try 
            {
            
                enroll = Integer.parseInt(txtenroll.getText());
                name = txtname.getText();
                email = txtemail.getText();
                gender ="";
                if(txtmale.isSelected())
                {
                    gender = "Male";
                }
                else if(txtfemale.isSelected())
                {
                    gender = "Female";
                }
                roll = Integer.parseInt(txtroll.getText());
                branch = txtbranch.getSelectedItem().toString();
                
                switch (branch) 
                {
                    case "CE":
                        department="FY1";
    
                        hod="Ms. Zalak Bhavasr";
    
    
                        break;
    
                    case "IT":
                        department="FY1";
    
                        hod="Ms. Zalak Bhavasr";
    
                        break;
    
                    case "CSD":
                        department="FY1";
    
                        hod="Ms. Zalak Bhavasr";
    
                        break;
    
                    case "AIML":
                        department="FY2";
    
                        hod="Mr. Prayag Patel";
    
                        break;
    
                    case "AIDS":
                        department="FY2";
    
                        hod="Mr. Prayag Patel";
    
                        break;
    
                    case "CS&IT":
                        department="FY2";
    
                        hod="Mr. Prayag Patel";
    
                        break;
    
                    case "CEA":
                        department="FY2";
    
                        hod="Mr. Prayag Patel";
    
                        break;
    
                    case "RAI":
                        department="FY3";
    
                        hod="Mr. Hiren Makwana";
    
                        break;
    
                    case "CSE":
                        department="FY3";
    
                        hod="Mr. Hiren Makwana";
    
                        break;
    
                    case "CST":
                        department="FY3";
    
                        hod="Mr. Hiren Makwana";
    
                        break;
    
                    default:
                        System.out.println("invalid choice , Please enter valid choice");
                        break;
                }
                dsm = Double.parseDouble(txtds.getText());
                feem = Double.parseDouble(txtfee.getText());
                mathsm = Double.parseDouble(txtmaths.getText());
                javam = Double.parseDouble(txtjava.getText());
                dbmsm = Double.parseDouble(txtdbms.getText());
                
                totalm = (dsm+feem+mathsm+javam+dbmsm);
                percentage = percentageCalculator(totalm);
                spi = SPICalculator(percentage);
                grade = getGrade(percentage);
                status = studentStatus(grade);
                ba=false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "input mismatch exception , please try again");
                
                txtname.setText("");
                txtenroll.setText("");
                txtemail.setText("");
                txtroll.setText("");
                txtbranch.setSelectedIndex(-1);
                txtds.setText("");
                txtfee.setText("");
                txtmaths.setText("");
                txtjava.setText("");
                txtdbms.setText("");
                return;
                
            }
        }
        
        try {
            
            String sql = "insert into student_marksheet (`enrollment_no`, `name`, `student_email`, `student_gender`,  `rollno`,  `branch`, `ds`, `fee`, `maths`, `java`, `dbms`, `total`, `percentage`, `SPI`, `grade`, `status`) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ,? )";
            pst = con.prepareStatement(sql);
            pst.setInt(1,enroll );
            pst.setString(2 , name);
            pst.setString(3, email);
            pst.setString(4, gender);
            pst.setInt(5 , roll);
            pst.setString(6, branch);
            pst.setDouble(7 , dsm);
            pst.setDouble(8 , feem);
            pst.setDouble(9, mathsm);
            pst.setDouble(10 , javam);
            pst.setDouble(11 , dbmsm);
            pst.setDouble(12 , totalm);
            pst.setDouble(13 , percentage);
            pst.setDouble(14 , spi);
            pst.setString(15 , grade);
            pst.setString(16 , status);
            pst.executeUpdate();
            
            
            sql = "INSERT INTO `student_details`( `enrollment_no`, `rollno`, `department`, `branch`, `student_name`, `student_email`, `student_gender`, `hod_name`) VALUES (? , ? , ? , ? , ? , ? , ? , ?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1,enroll );
            pst.setInt(2 , roll);
            pst.setString(3, department);
            pst.setString(4, branch);
            pst.setString(5, name);
            pst.setString(6, email);
            pst.setString(7, gender);
            pst.setString(8, hod);
            pst.executeUpdate();
            
            double marks[]={dsm,feem,mathsm,javam,dbmsm};
            MarksheetSystem ms = new MarksheetSystem();
            Student s = new Student(name, gender, email, hod, branch, department, roll, enroll, marks);
            ms.addGUIDataLL(s);
            
            
            JOptionPane.showMessageDialog(this, "User added");
            
            txtname.setText("");
            txtenroll.setText("");
            txtemail.setText("");
            txtroll.setText("");
            txtbranch.setSelectedIndex(0);
            txtds.setText("");
            txtfee.setText("");
            txtmaths.setText("");
            txtjava.setText("");
            txtdbms.setText("");
            
            User_load();
            
            
        
        } catch (SQLException ex) {
            //Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Can not add duplicate value");
            
            txtname.setText("");
            txtenroll.setText("");
            txtemail.setText("");
            txtroll.setText("");
            txtbranch.setSelectedIndex(-1);
            txtds.setText("");
            txtfee.setText("");
            txtmaths.setText("");
            txtjava.setText("");
            txtdbms.setText("");
            
        }
            
        
    }                                        

    private void txtmaleActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        
        
        d = (DefaultTableModel)jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        
        int enroll =  (int)d.getValueAt(selectedIndex,0);
        txtenroll.setText( d.getValueAt(selectedIndex, 0).toString());
        txtname.setText((String) d.getValueAt(selectedIndex, 1));
        txtemail.setText((String) d.getValueAt(selectedIndex, 2));
        if(d.getValueAt(selectedIndex , 3).equals("Male"))
        {
            txtmale.setSelected(true);
        }
        else
        {
        
            txtfemale.setSelected(true);
        }
        txtroll.setText( d.getValueAt(selectedIndex, 5).toString());
        txtbranch.setSelectedItem(d.getValueAt(selectedIndex, 7).toString());
        txtds.setText( d.getValueAt(selectedIndex, 8).toString());
        txtfee.setText( d.getValueAt(selectedIndex, 9).toString());
        txtmaths.setText( d.getValueAt(selectedIndex, 10).toString());
        txtjava.setText( d.getValueAt(selectedIndex, 11).toString());
        txtdbms.setText( d.getValueAt(selectedIndex, 12).toString());
        
        jButton1.setEnabled(false);
    }                                    

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
        d = (DefaultTableModel)jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        
        int enroll1 =  (int)d.getValueAt(selectedIndex,0);
        
        
        int enroll = Integer.parseInt(txtenroll.getText());
        String name = txtname.getText();
        String email = txtemail.getText();
        String gender ="";
        if(txtmale.isSelected())
        {
            gender = "Male";
        }
        else if(txtfemale.isSelected())
        {
            gender = "Female";
        }
        int roll = Integer.parseInt(txtroll.getText());
        String branch = txtbranch.getSelectedItem().toString();
        String department="";
        String hod="";
        switch (branch) 
        {
            case "CE":
                department="FY1";

                hod="Ms. Zalak Bhavasr";


                break;

            case "IT":
                department="FY1";

                hod="Ms. Zalak Bhavasr";

                break;

            case "CSD":
                department="FY1";

                hod="Ms. Zalak Bhavasr";

                break;

            case "AIML":
                department="FY2";

                hod="Mr. Prayag Patel";

                break;

            case "AIDS":
                department="FY2";

                hod="Mr. Prayag Patel";

                break;

            case "CS&IT":
                department="FY2";

                hod="Mr. Prayag Patel";

                break;

            case "CEA":
                department="FY2";

                hod="Mr. Prayag Patel";

                break;

            case "RAI":
                department="FY3";

                hod="Mr. Hiren Makwana";

                break;

            case "CSE":
                department="FY3";

                hod="Mr. Hiren Makwana";

                break;

            case "CST":
                department="FY3";

                hod="Mr. Hiren Makwana";

                break;

            default:
                System.out.println("invalid choice , Please enter valid choice");
                break;
        }
        double dsm = Double.parseDouble(txtds.getText());
        double feem = Double.parseDouble(txtfee.getText());
        double mathsm = Double.parseDouble(txtmaths.getText());
        double javam = Double.parseDouble(txtjava.getText());
        double dbmsm = Double.parseDouble(txtdbms.getText());
        
        double totalm = (dsm+feem+mathsm+javam+dbmsm);
        double percentage = percentageCalculator(totalm);
        double spi = SPICalculator(percentage);
        String grade = getGrade(percentage);
        String status = studentStatus(grade);
        
        try {
            
            String sql = "update student_marksheet set `enrollment_no` = ? , `name` =? , `student_email` = ? , `student_gender` = ? , `rollno` = ?  , `branch` = ? , `ds` = ? , `fee` = ?, `maths` = ? , `java` = ? , `dbms`= ? , `total` = ? , `percentage` = ? , `SPI` = ? , `grade` = ? , `status` = ? where enrollment_no = ? ";
            pst = con.prepareStatement(sql);
            pst.setInt(1,enroll );
            pst.setString(2 , name);
            pst.setString(3, email);
            pst.setString(4, gender);
            pst.setString(5, hod);
            pst.setInt(5 , roll);
            pst.setString(7, department);
            pst.setString(6, branch);
            pst.setDouble(7 , dsm);
            pst.setDouble(8 , feem);
            pst.setDouble(9, mathsm);
            pst.setDouble(10 , javam);
            pst.setDouble(11 , dbmsm);
            pst.setDouble(12 , totalm);
            pst.setDouble(13 , percentage);
            pst.setDouble(14 , spi);
            pst.setString(15 , grade);
            pst.setString(16 , status);
            pst.setInt(17, enroll1);
            pst.executeUpdate();
            
            
            sql = "update `student_details` set `enrollment_no` = ? , `rollno` = ? , `department` = ? , `branch` = ? , `student_name` = ? , `student_email` = ? , `student_gender` = ? , `hod_name` = ? where enrollment_no = ? ";
            pst = con.prepareStatement(sql);
            pst.setInt(1,enroll );
            pst.setInt(2 , roll);
            pst.setString(3, department);
            pst.setString(4, branch);
            pst.setString(5, name);
            pst.setString(6, email);
            pst.setString(7, gender);
            pst.setString(8, hod);
            pst.setInt(9, enroll1);
            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this, "User update");
            
            jButton1.setEnabled(true);
            
            txtname.setText("");
            txtenroll.setText("");
            txtemail.setText("");
            txtroll.setText("");
            txtbranch.setSelectedIndex(-1);
            txtds.setText("");
            txtfee.setText("");
            txtmaths.setText("");
            txtjava.setText("");
            txtdbms.setText("");
            
            User_load();
            
            
            
        
        } catch (SQLException ex) {
            //Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Can not update duplicate value");
            
            txtname.setText("");
            txtenroll.setText("");
            txtemail.setText("");
            txtroll.setText("");
            txtbranch.setSelectedIndex(-1);
            txtds.setText("");
            txtfee.setText("");
            txtmaths.setText("");
            txtjava.setText("");
            txtdbms.setText("");
            
        }
        
        
        
        
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
         jButton1.setEnabled(true);
            
            txtname.setText("");
            txtenroll.setText("");
            txtemail.setText("");
            txtroll.setText("");
            txtbranch.setSelectedIndex(-1);
            txtds.setText("");
            txtfee.setText("");
            txtmaths.setText("");
            txtjava.setText("");
            txtdbms.setText("");
            
            User_load();
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        d = (DefaultTableModel)jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        
        int enroll1 =  (int)d.getValueAt(selectedIndex,0);
        
        
        
        
        try {
            
            String sql = "delete from student_marksheet  where enrollment_no = ? ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, enroll1);
            pst.executeUpdate();
            
            
            sql = "delete from  `student_details`  where enrollment_no = ? ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, enroll1);
            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this, "User deleted");
            
            jButton1.setEnabled(true);
            
            txtname.setText("");
            txtenroll.setText("");
            txtemail.setText("");
            txtroll.setText("");
            txtbranch.setSelectedIndex(-1);
            txtds.setText("");
            txtfee.setText("");
            txtmaths.setText("");
            txtjava.setText("");
            txtdbms.setText("");
            
            User_load();
            
            
            
        
        } catch (SQLException ex) {
            //Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Can not update duplicate value");
            
            txtname.setText("");
            txtenroll.setText("");
            txtemail.setText("");
            txtroll.setText("");
            txtbranch.setSelectedIndex(-1);
            txtds.setText("");
            txtfee.setText("");
            txtmaths.setText("");
            txtjava.setText("");
            txtdbms.setText("");
            
        }
        
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
        this.setVisible(false);
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
        
        double dsm = Double.parseDouble(txtds.getText());
        double feem = Double.parseDouble(txtfee.getText());
        double mathsm = Double.parseDouble(txtmaths.getText());
        double javam = Double.parseDouble(txtjava.getText());
        double dbmsm = Double.parseDouble(txtdbms.getText());
        
        double totalm = (dsm+feem+mathsm+javam+dbmsm);
        double percentage = percentageCalculator(totalm);
        float spi = (float)SPICalculator(percentage);
        String grade = getGrade(percentage);
        String status = studentStatus(grade);
       
        
        txttotal.setText(String.valueOf(totalm));
        txtpercent.setText(String.valueOf(percentage));
        txtspi.setText(String.valueOf(spi));
        txtgrade.setText(grade);
        txtstatus.setText(status);
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> txtbranch;
    private javax.swing.JTextField txtdbms;
    private javax.swing.JTextField txtds;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtenroll;
    private javax.swing.JTextField txtfee;
    private javax.swing.JRadioButton txtfemale;
    private javax.swing.JTextField txtgrade;
    private javax.swing.JTextField txtjava;
    private javax.swing.JRadioButton txtmale;
    private javax.swing.JTextField txtmaths;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpercent;
    private javax.swing.JTextField txtroll;
    private javax.swing.JTextField txtspi;
    private javax.swing.JTextField txtstatus;
    private javax.swing.JTextField txttotal;
    // End of variables declaration                   
}

