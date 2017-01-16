//this part of the system allows reservation for specific facilities
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ReservationGUI extends JFrame {
   private JLabel reservationPrompt;
   
   public ReservationGUI() {
      JPanel reservationPanel = new JPanel(new GridBagLayout());
      
      GridBagConstraints reservationPromptDesign = new GridBagConstraints();
      
      //prompt at beginning
      reservationPrompt = new JLabel("Select the facility you'd like to reserve:");
      reservationPromptDesign.gridx = 0;
      reservationPromptDesign.gridy = 0;
      reservationPromptDesign.gridwidth = 4;
      reservationPromptDesign.gridheight = 1;
      reservationPanel.add(reservationPrompt, reservationPromptDesign);
      
      GridBagConstraints tennisButtonDesign = new GridBagConstraints();
      GridBagConstraints basketballButtonDesign = new GridBagConstraints();
      GridBagConstraints fieldButtonDesign = new GridBagConstraints();
      GridBagConstraints stadiumButtonDesign = new GridBagConstraints();
      
      GridBagConstraints[] buttonConstraints = {tennisButtonDesign, basketballButtonDesign, fieldButtonDesign, stadiumButtonDesign};
      
      JButton tennisButton = new JButton("TENNIS");
      JButton basketballButton = new JButton("BASKETBALL");
      JButton fieldButton = new JButton("FIELD");
      JButton stadiumButton = new JButton("STADIUM");
      
      JButton[] facilityButtons = {tennisButton, basketballButton, fieldButton, stadiumButton};
      
      //loop that allows positioning and activation of the various buttons, made possible by the two arrays above
      for(int i = 0; i < 4; i++) {
         buttonConstraints[i].gridx = 2 * i;
         buttonConstraints[i].gridy = 1;
         buttonConstraints[i].gridwidth = 2;
         buttonConstraints[i].gridheight = 1;
         reservationPanel.add(facilityButtons[i], buttonConstraints[i]);   
      }
      
      //note: not possible to use for loop for following action listeners because of the following error: 'local variables referenced from an inner class must be final or effectively final'
      
      tennisButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            new ScheduleAccessorGUI(tennisButton);
         }
      });
      
      basketballButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            new ScheduleAccessorGUI(basketballButton);
         }
      });
      
      fieldButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            new ScheduleAccessorGUI(fieldButton);
         }
      });
      
      stadiumButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            new ScheduleAccessorGUI(stadiumButton);
         }
      });
      
      
      add(reservationPanel);
      
      setTitle("Sports Facility Reservation System");
      setSize(600,600);
      setVisible(true);
   }
   
}