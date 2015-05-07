//--------------------------------------------------------------------
// Rashmi Sehgal rasehgal
// CS12B April 27 2015
// Dictionary.java
// Implementation file for Dictionary ADT
//--------------------------------------------------------------------

public class Dictionary implements DictionaryInterface {
   private class Node {
      String key;
      String value;
      Node next;
     // Node prev;

      Node(String k, String val) {
         key = k;
         value = val;
         next = null;
         //prev = null;
      }
   }
   
   // Fields for the Dictionary class
   private Node head;     // reference to first Node in list
   private int numPairs;   // number of pairs in this Dictionary

   // Dictionary()
   // constructor for the Dictionary class
   public Dictionary() {
      head = null;
      numPairs = 0;
   }

   // private helper function----------------------------------------
   
   // findKey()
   // returns a reference to the Node at position index in this Dictionary
   private Node findKey(String k) {
      Node N = head;
      for ( ; N!= null; N=N.next) {
         if(k.compareTo(N.key) == 0) {
            return N;           
         }
      }
    return null;
   }
   
   // ADT operations-------------------------------------------------
   

   // isEmpty()
   // pre: none
   // post: returns true if this Dictionary is empty, false otherwise
   public boolean isEmpty() {
      return(numPairs == 0);
   }

   // size()
   // pre: none
   // post: returns the number of entries in this Dictionary
   public int size() {
      return numPairs;
   }

   // lookup()
   // pre: none
   // post: returns value associated key, or null reference if no such key exists
   public String lookup(String k) {
      Node N = findKey(k);
      if (N == null) {
         return null;
      } else {
         return N.value;
      }
   }

   // insert()
   // inserts new entry (key, value) pair into this Dictionary
   // pre: lookup(key)!=null
   // post: !isEmpty()
   public void insert(String k, String val) 
   throws KeyCollisionException{
     //Node L = findLast(); 
     for (Node N = head; N!= null; N=N.next) {
         if(k.compareTo(N.key) == 0) {
            throw new KeyCollisionException(
              "cannot insert duplicate keys");
            //System.out.println("Error: cannot repeat keys.");
            //return;
           // System.exit(0);
         }
      } 
      Node N = new Node (k, val);
      N.next = head;
      head = N;
      numPairs++;
   }

   // delete()
   // deletes pair with given key from this Dictionary
   // pre: lookup(key)!=null
   public void delete(String k) throws KeyNotFoundException{
       Node K = findKey(k);
       if (K == null) {
          //System.out.println("NO"); 
          throw new KeyNotFoundException (
             "cannot delete non-existent key");
       } else if (numPairs == 1) {
          Node N = head;
          head = head.next;
          N.next = null;
          numPairs = 0;
       } else {         
          //System.out.println("I'm working");
          Node F = head;
          Node L = null;
          while (F!= null) {
          //System.out.println("while loop" + F.key + K.key);
             if(F.key == K.key) {
                //System.out.println("if loop");
                if(F == head) {
                   head = F.next;
                   F = null;
                   numPairs--;
                } else { 
                   L.next = F.next;
//System.out.println("L.next = F.next");
                   F.next = null;
//System.out.println("F.next = null");
                   numPairs--;
                }
               
                break;
             } else {
                //System.out.println("else loop");
                L = F;
                F = F.next;
             }            
          }
       } 
   }
      



   // makeEmpty()
   // pre: none 
   // post: isEmpty()
   public void makeEmpty() {
      head = null;
      numPairs = 0;
   }

   // toString()
   // pre: none
   // post: prints String's representation of this Dictionary
   // Overrides Object's toString() method
 
   private String myString(Node H) {
      if (H == null) {
         return "";
      } else {
         return (myString(H.next) + H.key + " " + H.value + "\n");
      }
   }
   public String toString() {
      return myString(head);
      
   }
 
}
