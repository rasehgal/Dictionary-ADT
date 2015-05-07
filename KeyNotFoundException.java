//-------------------------------------------------------
// Rashmi Sehgal rasehgal
// CS12B April 29, 2015
// creates KeyNotFoundException to be thrown in the delete
// function of Dictionary.
// KeyNotFoundException.java
//-------------------------------------------------------

public class KeyNotFoundException extends RuntimeException {
   public KeyNotFoundException(String s) {
      super(s);
   }
}
