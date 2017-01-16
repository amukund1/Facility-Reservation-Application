//creates an appointment object with the info in the constructor
public class Appointment {
   private String client;
   private String date;
   private String facility;
   private String startTime;
   private String endTime;
      
   public Appointment(String client, String date, String facility, String startTime, String endTime) {
      this.client = client;
      this.date = date;
      this.facility = facility;
      this.startTime = startTime;
      this.endTime = endTime;
   }
   
   public String getClient() {
      return client;
   }
   
   public String getDate() {
      return date;
   }
   
   public String getFacility() {
      return facility;
   } 
   
   public String getStartTime() {
      return startTime;
   }
   
   public String getEndTime() {
      return endTime;
   }
}