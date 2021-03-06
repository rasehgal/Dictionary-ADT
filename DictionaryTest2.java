//------------------------------------------------------------------
// Rashmi Sehgal rasehgal
// CS12B April 2015
// DictionaryTest2.java 
// An edited DictionaryClient.java used to test the creation of
// Dictionary.java. Previously deleted and supplemented with a different
// test; see README.
// ----------------------------------------------------------------

public class DictionaryTest2 {
   public static void main(String[] args) {
   
      String v;
      Dictionary A = new Dictionary();
      A.insert("1", "a");
      //System.out.println(A);
      //A.delete("1");
      //System.out.println(A.isEmpty());
      //System.out.println(A.size());
      A.insert("2", "b");
      A.insert("3","c");
      A.insert("4","d");
      A.insert("5","e");
      //System.out.println(A.size());
      //System.out.println(A);
      A.insert("6","f");
      A.insert("7","g");
      System.out.println(A);
      
      v = A.lookup("1");
      System.out.println("key=1 "+(v==null?"not found":("value="+v)));
      v = A.lookup("3");
      System.out.println("key=3 "+(v==null?"not found":("value="+v)));
      v = A.lookup("7");
      System.out.println("key=7 "+(v==null?"not found":("value="+v)));
      v = A.lookup("8");
      System.out.println("key=8 "+(v==null?"not found":("value="+v)));
      //v = A.lookup("2");
      //System.out.println("key=2 "+(v==null?"not found":("value="+v)));
      System.out.println();

      // A.insert("2","f");  // causes KeyCollisionException

      A.delete("1");
      //System.out.println(A);
      //A.insert("1");
      //System.out.println(A.size());
      //System.out.println(A);
      //A.delete("1");
      //System.out.println(A.size());
      A.delete("3");
      //System.out.println(A);
      A.delete("7");
      //System.out.println(A);
      System.out.println(A);

      // A.delete("8");  // causes KeyNotFoundException

      System.out.println(A.isEmpty());
      System.out.println(A.size());
      A.makeEmpty();
      System.out.println(A.isEmpty());
      System.out.println(A);

   }
}
