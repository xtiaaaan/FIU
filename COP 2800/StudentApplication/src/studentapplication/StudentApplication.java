/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapplication;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Chris
 */
class Student{
    private double gpa;
    private int ID;
    private String name;

    public Student(double gpa, int ID, String name) {
        this.gpa = gpa;
        this.ID = ID;
        this.name = name;
    }
    
    public Student(int ID){
        this.ID = ID;
    }
    
    @Override
    public String toString(){
        return "Student{ gpa = " + gpa + ", ID = " + ID +", name = " + name + "}";
    }
    
    public double getGPA(){
        return gpa;
    }
    
    private String major;
    
    public void declareMajor(){
        System.out.println("Enter the major:");
        Scanner scan = new Scanner(System.in);
        major = scan.nextLine();
    }
    
    public void showMajor(){
        System.out.println("Major = " + major);
    }
    
}

public class StudentApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Student> arrayList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean t = true;
        
        
        //Student s1 = new Student(3.5, 1, "Billy Jones");
        //arrayList.add(s1);
        //s1.declareMajor();
        //s1.showMajor();
        //arrayList.add(new Student(2));
        
        do{
            System.out.println("Enter student's name: ");
            String name = scan.nextLine();
            System.out.println("Enter student's ID: ");
            int ID = scan.nextInt();
            System.out.println("Enter student's GPA: ");
            double gpa = scan.nextDouble();
            
            Student s = new Student(gpa, ID, name);
            arrayList.add(s);
            
            System.out.println("1 to continue, 0 to stop");
            int i = scan.nextInt();
            if(i == 0){
                t = false;
            }
            scan.nextLine();
        }
        while(t);
        
        
        for(Student s : arrayList){
            if(s.getGPA() <= 1.0){
                System.out.println(s);
            }
        }
    }
    
}
