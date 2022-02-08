/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdb;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class StudentDB {
    
    private int selection;
    private int id;
    private int updateChoice;
    private String updateValue;
    private String studentName;
    private int age;
    private double gpa;
    
    public StudentDB(int selection){
        this.selection = selection;
    }
    
    public StudentDB(int selection, int id, int updateChoice, String updateValue){
        this.selection = selection;
        this.id = id;
        this.updateChoice = updateChoice;
        this.updateValue = updateValue;
    }

    public StudentDB(int selection, String studentName, int age, double gpa) {
        this.selection = selection;
        this.studentName = studentName;
        this.age = age;
        this.gpa = gpa;
    }
    
    public void runMe()
            throws Exception{
        
        try (Connection conMe = makeCon()) {
            exeQuery(conMe, selection);
        }
        
    }
    
    protected Connection makeCon ()
          throws Exception {
            String user = "dbjava";
            String password = "mypassword";
            String host = "dbjava.c96ahlzpethg.us-east-1.rds.amazonaws.com";
            String database = "dbjava";
            String url = "";
            try {
                url = "jdbc:mysql://" + host + ":3306/" + database;
                  Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established to " + url + "...");
            return con;
            } catch (java.sql.SQLException e) {
            System.out.println("Connection couldn't be established to " + url);
            throw (e);
            }
    }
    
    public void exeQuery(Connection con, int selection)
            throws Exception{
        
        Statement stmt = con.createStatement();
        
        switch(selection){
            case 1:
                //String insertQuery = "VALUES('" + studentName + "', '" + age + "', '" + gpa + "')";
                String sql1 = "INSERT INTO Students (studentName, age, gpa)" + "VALUES('" + studentName + "', '" + age + "', '" + gpa + "')";
                stmt.executeUpdate(sql1);
                
                System.out.println("Inserted records into table ...");
                break;
            case 2:
                switch(updateChoice){
                    case 1:
                        String sql2 = "UPDATE Students " + "SET studentName = '" + updateValue + "' WHERE idStudents = '" + id + "'";
                        stmt.executeUpdate(sql2);
                        break;
                    case 2:
                        String sql3 = "UPDATE Students " + "SET age = '" + updateValue + "' WHERE idStudents = '" + id + "'";
                        stmt.executeUpdate(sql3);
                        break;
                    case 3:
                        String sql4 = "UPDATE Students " + "SET gpa = '" + updateValue + "' WHERE idStudents = '" + id + "'";
                        stmt.executeUpdate(sql4);
                        break;
                }
                System.out.println("Successfully updated records ...");
                break;
            case 3:
                ResultSet sqls = stmt.executeQuery("SELECT * FROM Students");
                        
                while (sqls.next()) {
                    int id = sqls.getInt("idStudents");
                    String name = sqls.getString("studentName");
                    int age = sqls.getInt("age");
                    double gpa = sqls.getDouble("gpa");
                    System.out.println(id + " " + name + " " + age + " " + gpa);
                    
                }
                break;
        }
    }

    public static void main (String args[]) throws Exception {
        boolean t = true;
        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("Enter 1 to INSERT a Student, 2 to UPDATE, 3 to SELECT and 4 to EXIT");
            int selection = scan.nextInt();
            
            switch(selection){
                case 1:
                    scan.nextLine();
                    System.out.println("Enter student name:");
                    String studentName = scan.nextLine();
                    System.out.println("Enter student age:");
                    int age = scan.nextInt();
                    System.out.println("Enter student GPA:");
                    double gpa = scan.nextDouble();
                    
                    StudentDB s1 = new StudentDB(selection, studentName, age, gpa);
                    s1.runMe();
                    break;
                case 2:
                    System.out.println("What do you want to UPDATE?");
                    System.out.println("Enter Student ID:");
                    int id = scan.nextInt();
                    System.out.println("1 for Student's Name, 2 for Student's Age, 3 for Student's GPA");
                    int updateChoice = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter updated value:");
                    String updateValue = scan.nextLine();
                    
                    StudentDB s2 = new StudentDB(selection, id, updateChoice, updateValue);
                    s2.runMe();
                    break;
                case 3:
                    StudentDB s3 = new StudentDB(selection);
                    s3.runMe();
                    break;
                case 4:
                    System.out.println("Good bye!");
                    t = false;
            }
            scan.nextLine();

        }while(t);
        
    }
}