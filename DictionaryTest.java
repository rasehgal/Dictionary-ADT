//------------------------------------------------------------
// Rashmi Sehgal rasehgal
// CS12B April 29, 2015
// DictionaryTest.java
// Tests Dictionary ADT more rigorously
//------------------------------------------------------------ 

public class DictionaryTest{
   public static void main(String[] args) {
      Dictionary mySchedule = new Dictionary();
      setSchedule(mySchedule);
      System.out.println("Schedule: \n" + mySchedule);
      addBlock(mySchedule, "Tango (night)", "W 7:30PM");
      addBlock(mySchedule, "Tango (morning)", "Sun 11:30AM");
      System.out.println("Schedule: \n" + mySchedule);
      recall(mySchedule, "MSI"); 
      // delete(mySchedule, "MSI"); //returns keynotfoundexception
      addBlock(mySchedule, "MSI", "W 7:30PM");
      recall(mySchedule, "Tango (night)");
      removeBlock(mySchedule, "Tango (night)");
      System.out.println("You have " + mySchedule.size() + " classes:\n");
      System.out.println("Schedule: \n" + mySchedule);
   }

   public static void setSchedule(Dictionary a) {
      String[] classes = {"Vector Calculus", "Total Fitness Conditioning", 
                              "Ballet I", "Data Structures"};
   
      String[] times = {"MWF 8AM", "TTh 10:30AM", "TTh 2PM", "TTh 6PM"};

      /*for loop will not work because it creates a KeyCollisionException
      for (int i = 0; i<classes.length; i++) {
         for (int j = 0; j<times.length; j++) {
            System.out.println(classes[i] + " " + times[j]);
            a.insert(classes[i], times[j]);
         }
      }*/
      if (((classes.length)>0) && ((times.length)>0) && (times.length == classes.length)) {
         for (int i = 0; i < classes.length; i++) {
            a.insert(classes[i], times[i]);
         }
      } else {
         System.out.println("Error: insufficient data. Check classes and class times.");
      }
   }

   public static void addBlock(Dictionary a, String activity, String time) {
      System.out.println("Adding " + activity + "... \n");
      a.insert(activity, time);
   }

   public static void removeBlock(Dictionary a, String activity) {
      System.out.println("Removing " + activity + "... \n");
      a.delete(activity);
   }

   public static void recall(Dictionary a, String activity) {
      if (a.lookup(activity) == null) {
         System.out.println("You do not have " + activity + " in your schedule.\n");
      } else {      
         System.out.println("You have " + activity + " at " + a.lookup(activity));
      }
   }
}

