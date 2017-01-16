//stores all reservations into the Array List masterAppointmentList for record keeping

import java.util.*;

public final class AppointmentStorage {
   private static ArrayList<Appointment> masterAppointmentList = new ArrayList<Appointment>();
   
   public static void addAppointment(Appointment a) {
      masterAppointmentList.add(a);
   }
   
   public static ArrayList<Appointment> getMasterAppointmentList() {
      return masterAppointmentList;
   }
   
}