import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Client extends JFrame {
   public Client() {
      JPanel clientPanel = new JPanel(new GridBagLayout());
      
      GridBagConstraints a = new GridBagConstraints(); //design tool for greeting label below
      
      JLabel greeting = new JLabel("Welcome! Click on the 'RESERVE' button to get started with your reservation.");
      a.gridx = 0;//column
      a.gridy = 0;//row
      a.gridwidth = 4;//column
      a.gridheight = 1;//row
      
      GridBagConstraints b = new GridBagConstraints(); //design tool for reservationButton below
     
      JButton reservationButton = new JButton("RESERVE");
      b.gridx = 3;
      b.gridy = 1;
      b.gridwidth = 2;
      b.gridheight = 1;
      
      reservationButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            new ReservationGUI();
         }
      });
            
      clientPanel.add(greeting, a);
      clientPanel.add(reservationButton, b);

      add(clientPanel);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Sports Facility Reservation System");
      setSize(600,600);
      setVisible(true);
   }
   
   
   public static void main(String[] args) {
      new Client();
   }
}
