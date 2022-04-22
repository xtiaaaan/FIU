import java.util.Scanner;
import java.util.concurrent.Semaphore;
import javax.swing.JFrame;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chris
 */
class Shared{
    static int tickets = 250;
    static int user = 1;
}

class MyThread extends Thread{
    Semaphore sem; 
    String threadGroupName;
    JFrame frame = new JFrame();
    
    
    public MyThread(Semaphore sem, String threadGroupName, JFrame frame){
        super(threadGroupName);
        this.sem = sem;
        this.threadGroupName = threadGroupName;
        this.frame = frame;
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
                    for(int i = 0; i < 10; i++){
                        System.out.println("Guest " + Shared.user + " is currently purchasing a ticket. Available Tickets for purchase: " + Shared.tickets);
                        System.out.println("Enter amount of tickets you want to purchse: ");
                        if(Semaphores.getPurchase() > 3){
                            System.out.println("Cannot purchase more than 3 tickets.");
                        }
                        else if(Semaphores.getPurchase() > Shared.tickets){
                            System.out.println("There are only " + Shared.tickets + " available for purchase.");
                        }
                        else{
                            Shared.tickets = Shared.tickets - Semaphores.getPurchase();
                            System.out.println("Guest " + Shared.user + " has purchased " + Semaphores.getPurchase() + " ticket(s).");
                            Shared.user = Shared.user + Semaphores.getPurchase();
                            Thread.sleep(1000);
                            if(Shared.tickets == 0){
                                System.out.println("There are no more tickets available for purchsae.");
                                break;
                            }
                        }
                        sem.release();
                        
                        /*Shared.tickets--;
                        Shared.user++;
                        Thread.sleep(1000);
                        if(Shared.tickets == 0){
                            System.out.println("Ticket Group " + threadGroupName + " has completed purchasing tickets!");
                            System.out.println("Tickets available for purchase: " + Shared.tickets);
                            break;
                        }*/
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

public class Semaphores extends javax.swing.JFrame {

    /**
     * Creates new form Semaphore
     */
    public Semaphores() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        GroupA_Header = new javax.swing.JLabel();
        TicketsAvailable = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFrame2 = new javax.swing.JFrame();
        TicketsAvailable5 = new javax.swing.JLabel();
        GroupB_Header5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jFrame3 = new javax.swing.JFrame();
        TicketsAvailable2 = new javax.swing.JLabel();
        GroupC_Header2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFrame4 = new javax.swing.JFrame();
        TicketsAvailable3 = new javax.swing.JLabel();
        GroupD_Header3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFrame5 = new javax.swing.JFrame();
        TicketsAvailable4 = new javax.swing.JLabel();
        GroupE_Header4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFrame6 = new javax.swing.JFrame();
        GroupA_Header1 = new javax.swing.JLabel();
        TicketsAvailable1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TicketPurchase_Spinner = new javax.swing.JSpinner();
        Buy_Button = new javax.swing.JButton();
        Run_Button = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TicketPurchasing_Header = new javax.swing.JLabel();
        HitBuy_Header = new javax.swing.JLabel();

        GroupA_Header.setBackground(new java.awt.Color(128, 128, 128));
        GroupA_Header.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        GroupA_Header.setForeground(new java.awt.Color(0, 255, 128));
        GroupA_Header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GroupA_Header.setText("Group A Ticket Landing");

        TicketsAvailable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TicketsAvailable.setForeground(new java.awt.Color(0, 255, 128));
        TicketsAvailable.setText("Tickets Available For Purchase:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 128));
        jLabel5.setText(String.valueOf(Shared.tickets));

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GroupA_Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(TicketsAvailable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GroupA_Header, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TicketsAvailable)
                    .addComponent(jLabel5))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        TicketsAvailable5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TicketsAvailable5.setForeground(new java.awt.Color(0, 255, 128));
        TicketsAvailable5.setText("Tickets Available For Purchase:");

        GroupB_Header5.setBackground(new java.awt.Color(128, 128, 128));
        GroupB_Header5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        GroupB_Header5.setForeground(new java.awt.Color(0, 255, 128));
        GroupB_Header5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GroupB_Header5.setText("Group B Ticket Landing");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 128));
        jLabel1.setText(String.valueOf(Shared.tickets));

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GroupB_Header5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jFrame2Layout.createSequentialGroup()
                        .addComponent(TicketsAvailable5)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GroupB_Header5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TicketsAvailable5)
                    .addComponent(jLabel1))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        TicketsAvailable2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TicketsAvailable2.setForeground(new java.awt.Color(0, 255, 128));
        TicketsAvailable2.setText("Tickets Available For Purchase:");

        GroupC_Header2.setBackground(new java.awt.Color(128, 128, 128));
        GroupC_Header2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        GroupC_Header2.setForeground(new java.awt.Color(0, 255, 128));
        GroupC_Header2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GroupC_Header2.setText("Group C Ticket Landing");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 128));
        jLabel2.setText(String.valueOf(Shared.tickets));

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GroupC_Header2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(jFrame3Layout.createSequentialGroup()
                        .addComponent(TicketsAvailable2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GroupC_Header2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TicketsAvailable2)
                    .addComponent(jLabel2))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        TicketsAvailable3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TicketsAvailable3.setForeground(new java.awt.Color(0, 255, 128));
        TicketsAvailable3.setText("Tickets Available For Purchase:");

        GroupD_Header3.setBackground(new java.awt.Color(128, 128, 128));
        GroupD_Header3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        GroupD_Header3.setForeground(new java.awt.Color(0, 255, 128));
        GroupD_Header3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GroupD_Header3.setText("Group D Ticket Landing");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 128));
        jLabel4.setText(String.valueOf(Shared.tickets));

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GroupD_Header3, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(jFrame4Layout.createSequentialGroup()
                        .addComponent(TicketsAvailable3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GroupD_Header3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TicketsAvailable3)
                    .addComponent(jLabel4))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        TicketsAvailable4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TicketsAvailable4.setForeground(new java.awt.Color(0, 255, 128));
        TicketsAvailable4.setText("Tickets Available For Purchase:");

        GroupE_Header4.setBackground(new java.awt.Color(128, 128, 128));
        GroupE_Header4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        GroupE_Header4.setForeground(new java.awt.Color(0, 255, 128));
        GroupE_Header4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GroupE_Header4.setText("Group E Ticket Landing");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 128));
        jLabel3.setText(String.valueOf(Shared.tickets));

        javax.swing.GroupLayout jFrame5Layout = new javax.swing.GroupLayout(jFrame5.getContentPane());
        jFrame5.getContentPane().setLayout(jFrame5Layout);
        jFrame5Layout.setHorizontalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame5Layout.createSequentialGroup()
                        .addComponent(TicketsAvailable4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(GroupE_Header4, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
                .addContainerGap())
        );
        jFrame5Layout.setVerticalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GroupE_Header4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TicketsAvailable4)
                    .addComponent(jLabel3))
                .addContainerGap(218, Short.MAX_VALUE))
        );

        GroupA_Header1.setBackground(new java.awt.Color(128, 128, 128));
        GroupA_Header1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        GroupA_Header1.setForeground(new java.awt.Color(0, 255, 128));
        GroupA_Header1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GroupA_Header1.setText("Ticket Purchasing Landing Page");

        TicketsAvailable1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TicketsAvailable1.setForeground(new java.awt.Color(0, 255, 128));
        TicketsAvailable1.setText("Tickets Available For Purchase:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 128));
        jLabel6.setText(String.valueOf(Shared.tickets));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 128));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("How Many Tickets Would You Like To Purchase?");
        jLabel7.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 128));
        jLabel8.setText("Limit 3 Per Customer.");

        TicketPurchase_Spinner.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TicketPurchase_Spinner.setToolTipText("");

        Buy_Button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Buy_Button.setForeground(new java.awt.Color(0, 255, 128));
        Buy_Button.setText("BUY");
        Buy_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buy_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrame6Layout = new javax.swing.GroupLayout(jFrame6.getContentPane());
        jFrame6.getContentPane().setLayout(jFrame6Layout);
        jFrame6Layout.setHorizontalGroup(
            jFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GroupA_Header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame6Layout.createSequentialGroup()
                        .addComponent(TicketsAvailable1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TicketPurchase_Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Buy_Button)))
                .addContainerGap())
        );
        jFrame6Layout.setVerticalGroup(
            jFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GroupA_Header1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TicketsAvailable1)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(TicketPurchase_Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(Buy_Button)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Run_Button.setText("RUN");
        Run_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Run_ButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(128, 128, 128));
        jPanel1.setForeground(new java.awt.Color(128, 128, 128));

        TicketPurchasing_Header.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TicketPurchasing_Header.setForeground(new java.awt.Color(0, 255, 128));
        TicketPurchasing_Header.setText("Welcome to The Ticket Purchasing Portal!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(TicketPurchasing_Header)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TicketPurchasing_Header)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        HitBuy_Header.setBackground(new java.awt.Color(0, 255, 128));
        HitBuy_Header.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        HitBuy_Header.setForeground(new java.awt.Color(0, 255, 128));
        HitBuy_Header.setText("HIT RUN TO BUY TICKETS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(Run_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(HitBuy_Header)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(HitBuy_Header, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Run_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Run_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Run_ButtonActionPerformed
        Semaphore sem = new Semaphore(1);
        
        MyThread group1 = new MyThread(sem, "A", jFrame6);
        group1.start();
        MyThread group2 = new MyThread(sem, "B", jFrame6);
        group2.start();
        MyThread group3 = new MyThread(sem, "C", jFrame6);
        group3.start();
        MyThread group4 = new MyThread(sem, "D", jFrame6);
        group4.start();
        MyThread group5 = new MyThread(sem, "E", jFrame6);
        group5.start();
        
        jFrame1.setVisible(true);
        jFrame2.setVisible(true);
        jFrame3.setVisible(true);
        jFrame4.setVisible(true);
        jFrame5.setVisible(true);
        jFrame6.setVisible(true);
        
        
    }//GEN-LAST:event_Run_ButtonActionPerformed

    private void Buy_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buy_ButtonActionPerformed
        TicketPurchase_Spinner.setValue(0);
    }//GEN-LAST:event_Buy_ButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Semaphores().setVisible(true);
            }
        });
    }
    
    int purchase;
    
    public void purchase(int purchase){
        this.purchase = (int)TicketPurchase_Spinner.getValue();
    }
    
    public static int getPurchase(){
        return this.purchase;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buy_Button;
    private javax.swing.JLabel GroupA_Header;
    private javax.swing.JLabel GroupA_Header1;
    private javax.swing.JLabel GroupB_Header5;
    private javax.swing.JLabel GroupC_Header2;
    private javax.swing.JLabel GroupD_Header3;
    private javax.swing.JLabel GroupE_Header4;
    private javax.swing.JLabel HitBuy_Header;
    private javax.swing.JButton Run_Button;
    private javax.swing.JSpinner TicketPurchase_Spinner;
    private javax.swing.JLabel TicketPurchasing_Header;
    private javax.swing.JLabel TicketsAvailable;
    private javax.swing.JLabel TicketsAvailable1;
    private javax.swing.JLabel TicketsAvailable2;
    private javax.swing.JLabel TicketsAvailable3;
    private javax.swing.JLabel TicketsAvailable4;
    private javax.swing.JLabel TicketsAvailable5;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JFrame jFrame5;
    private javax.swing.JFrame jFrame6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}