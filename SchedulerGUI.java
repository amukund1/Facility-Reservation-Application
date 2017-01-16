//sets up a schedule object

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SchedulerGUI extends JFrame {
   private int year;
   private int month;
   private int day;
   
   public SchedulerGUI(JButton facilityButton, int year, int month, int day) {
      this.year = year;
      this.month = month;
      this.day = day;
      
      JPanel schedulerPanel = new JPanel();
      Schedule s = new Schedule(facilityButton, year, month, day, schedulerPanel); //actually creates the schedule based on the parameters via instance of the class
      
      add(schedulerPanel);

      setTitle("Sports Facility Reservation System");
      setSize(600,600);
      setVisible(true);
      
      
   }
   
   //test purposes only
   public static void main(String[] args) {
      new SchedulerGUI(new JButton("Tennis"), 02, 02, 02);
   }

}
