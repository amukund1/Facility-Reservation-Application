//this part of the system allows people to enter the date they'd like to make the reservation on for the selected facility

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScheduleAccessorGUI extends JFrame {
   
   public ScheduleAccessorGUI(JButton facilityButton) {
      
      JPanel schedulerAccessorPanel = new JPanel(new GridBagLayout());
      
      JLabel header = new JLabel("Facility: " + facilityButton.getText());
      
      schedulerAccessorPanel.add(header);
      
      GridBagConstraints scheduleDatePromptDesign = new GridBagConstraints();
      
      JLabel scheduleDatePrompt = new JLabel("Enter the date you'd like to make the reservation on:");
      scheduleDatePromptDesign.gridx = 0;
      scheduleDatePromptDesign.gridy = 1;
      scheduleDatePromptDesign.gridwidth = 10;
      scheduleDatePromptDesign.gridheight = 1;
      schedulerAccessorPanel.add(scheduleDatePrompt, scheduleDatePromptDesign);

      JTextField month = new JTextField("MM", 2);
      JTextField day = new JTextField("DD", 2);
      JTextField year = new JTextField("YYYY", 4);
      
      GridBagConstraints monthDesign = new GridBagConstraints();
      GridBagConstraints dayDesign = new GridBagConstraints();
      GridBagConstraints yearDesign = new GridBagConstraints();
      
      JTextField[] dateParameters = {year, month, day};
      GridBagConstraints[] dateDesign = {yearDesign, monthDesign, dayDesign};
      
      //loop allows positioning of the elements in the dateParameters array for easy entry
      for(int i = 0; i < 3; i++) {
         dateDesign[i].gridx = 2 * i;
         dateDesign[i].gridy = 2;
         dateDesign[i].gridwidth = 2;
         dateDesign[i].gridheight = 1;
         schedulerAccessorPanel.add(dateParameters[i], dateDesign[i]);
      }
      
      SubmitButton submitButton = new SubmitButton(schedulerAccessorPanel);
      
      //creates an interactive schedule to make reservations, via SchedulerGUI object
      submitButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new SchedulerGUI(facilityButton, Integer.parseInt(year.getText()), Integer.parseInt(month.getText()), Integer.parseInt(day.getText()));
         }
      });
      
      add(schedulerAccessorPanel);
      
      setTitle("Sports Facility Reservation System");
      setSize(600,600);
      setVisible(true);
   }

}
