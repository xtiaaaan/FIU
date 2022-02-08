/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dfreer
 */
public class Course {

    String courseName;
    ArrayList<String> arr = new ArrayList<>();
    
    public Course(String courseName){
       this.courseName = courseName;
    }
    
    public void addStudent(String student){
       if(arr.size() < 100){
        arr.add(student);
       }
    }
    
    public int getNumberStudents(){
      return arr.size();
    }
    
    public void showStudents(){
        for(String s : arr){
            System.out.println(s);
        }
    }
    
    public String getCourseName(){
       return courseName;
    }
    
    public void dropStudent(String student){
        arr.remove(student);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Course course1 = new Course("MAC2311");
        while(true){
            int choices;
            System.out.println("Enter 1 to add a student:");
            System.out.println("Enter 2 to drop a student:");
            System.out.println("Enter 3 to view the students in the course:");
            System.out.println("Enter 4 to see the number of students in the course:");
            System.out.println("Enter 5 to quit the program.");
            choices = scanner.nextInt();
            
            switch (choices) {
                case 1:
                    {
                        System.out.println("Enter the name of the student:");
                        scanner.nextLine(); //necessary to read the name in properly
                        String stuName = scanner.nextLine();
                        course1.addStudent(stuName);
                        break;
                    }
                case 2:
                    {
                        System.out.println("Enter student to drop:");
                        scanner.nextLine(); //necessary to read the name in properly
                        String stuName = scanner.nextLine();
                        course1.dropStudent(stuName);
                        break;
                    }
                case 3:
                    course1.showStudents();
                    break; 
                case 4:
                    System.out.println(course1.getNumberStudents());
                    break;
                case 5: 
                    System.exit(0);
                default:
                    break;
            }
        }
    }
    
}
