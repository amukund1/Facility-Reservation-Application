import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Schedule {
   private String date;
   private String facility;
   
   public Schedule(JButton facilityButton, int year, int month, int day, JPanel panel) {
      JLabel facilityHeader = new JLabel("Facility: " + facilityButton.getText());
      
      String date = month + "/" + day + "/" + year;
      this.date = date;
      this.facility = facilityButton.getText();
      
      JLabel dateHeader = new JLabel("Schedule for " + date);

      panel.add(facilityHeader);
      panel.add(dateHeader);
      
      String[] columns = {"Start Time", "End Time", "Client", "Status"};
      String[][] details = new String[6][4]; //contains info for the above four headers; status is whether the facility is available or not
      
      //loop to fill table with fixed time slots and available slots (begins with all available)
      //loop assigns times, like 2:00 PM, 3:00 PM, etc.
      for(int i = 0; i < 6; i++) {
         details[i][0] = (new JLabel((i + 2) + ":00 PM")).getText(); //start time
         details[i][1] = (new JLabel((i + 3) + ":00 PM")).getText(); //end time
         details[i][2] = (new JTextField("", 10)).getText(); //available spot for client reservation
         details[i][3] = (new JLabel("AVAILABLE")).getText(); //availability status, begins with all available
      }
      
      //loop to fill in any existing appointments for the given date and facility
      ArrayList<Appointment> masterAppointmentList = AppointmentStorage.getMasterAppointmentList(); //copy of history of appointments reserved
      if(!(masterAppointmentList.isEmpty())) {
         for(int i = 0; i < masterAppointmentList.size(); i++) {
            //ensures that the appointment refers to the appropriate facility and date
            if(((masterAppointmentList.get(i)).getFacility()).equals(this.facility) && ((masterAppointmentList.get(i)).getDate()).equals(this.date)) {
               //loop to put the current appointments in the correct time slots; the number '6' is the number of time slots available
               for(int j = 0; j < 6; j++) {
                  if(((masterAppointmentList.get(i)).getStartTime()).equals((j + 2) + ":00 PM")) {
                     details[j][2] = (masterAppointmentList.get(i)).getClient(); //fills in the already-reserved slots with the appropriate client
                     details[j][3] = "RESERVED"; //change status from "AVAILABLE" to "RESERVED" for already-reserved slots
                  }
               }
            }
         }
      }
        
      JTable schedule = new JTable(details, columns); //representation of the schedule - check this, headers aren't showing up

      panel.add(new JScrollPane(schedule));
      
      SubmitButton submitButton = new SubmitButton(panel);

      submitButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            for(int i = 0; i < 6; i++) {
               if(!((details[i][2]).equals(""))) { //makes sure something is actually entered as the name so reservation can be processed
                  AppointmentStorage.addAppointment(new Appointment(details[i][2], date, facilityButton.getText(), details[i][0], details[i][1])); //fix static context mess
                  details[i][3] = "RESERVED"; //changes status to indicate slot is not available
               }
            }
         }
      });
   }  
}