/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphores;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Chris
 */
class Shared{
    static int tickets = 20000;
    static int user = 1;
    static String strTickets = String.valueOf(tickets);
}

class MyThread extends Thread{
    Semaphore sem; 
    String threadGroupName;
    
    public MyThread(java.util.concurrent.Semaphore sem, String threadGroupName){
        super(threadGroupName);
        this.sem = sem;
        this.threadGroupName = threadGroupName;
    }
    
    Scanner scan = new Scanner(System.in);

    @Override
    public void run(){
        try{
            System.out.println("Ticket Group " + threadGroupName + " in waiting room...");
            System.out.println("Ticket available for purchase: " + Shared.tickets);

            sem.acquire();

            if(Shared.tickets >  0){
                try{
                    System.out.println("Ticket Group " + threadGroupName + " can now purchase tickets!");
                    for(int i = 0; i < 500; i++){
                        /*System.out.println("Guest " + Shared.user + " is currently purchasing a ticket. Available Tickets for purchase: " + Shared.tickets);
                        System.out.println("Enter amount of tickets you want to purchse: ");
                        int purchase = scan.nextInt();
                        if(purchase > 3){
                            System.out.println("Cannot purchase more than 3 tickets.");
                        }
                        else if(purchase > Shared.tickets){
                            System.out.println("There are only " + Shared.tickets + " available for purchase.");
                        }
                        else{
                            Shared.tickets = Shared.tickets - purchase;
                            System.out.println("Guest " + Shared.user + " has purchased " + purchase + " ticket(s).");
                            Shared.user = Shared.user + purchase;
                            Thread.sleep(1000);
                            if(Shared.tickets == 0){
                                System.out.println("There are no more tickets available for purchsae.");
                                break;
                            }
                        }*/
                        
                        Shared.tickets--;
                        Shared.user++;
                        Thread.sleep(10);
                        System.out.println("Guest " + Shared.user + " has purchased a ticket. " + Shared.tickets + " tickets available for purchase.");
                        if(Shared.tickets == 0){
                            System.out.println("Ticket Group " + threadGroupName + " has completed purchasing tickets!");
                            System.out.println("Tickets available for purchase: " + Shared.tickets);
                            break;
                        }
                    }
                }finally{
                    sem.release();
                }
            }else{
                sem.release();
        }
        }catch(InterruptedException intex){
                    System.out.println(intex);
        }
        System.out.println("Ticket Group " + threadGroupName + " has completed purchasing tickets!");
        System.out.println("Tickets available for purchase: "  + Shared.tickets);
    }
    
}

public class Semaphores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore sem = new java.util.concurrent.Semaphore(3);
        
        MyThread group1 = new MyThread(sem, "A");
        group1.start();
        MyThread group2 = new MyThread(sem, "B");
        group2.start();
        MyThread group3 = new MyThread(sem, "C");
        group3.start();
        MyThread group4 = new MyThread(sem, "D");
        group4.start();
        MyThread group5 = new MyThread(sem, "E");
        group5.start();
    }
    
}
