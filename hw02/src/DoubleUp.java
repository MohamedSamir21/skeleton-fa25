public class DoubleUp {
   /**
     * Returns a new string where each character of the given string is repeated twice.
     * Example: doubleUp("hello") -> "hheelllloo"
     */
   public static String doubleUp(String s) {
      // 1. The recursive solution:
//      if (s.length() == 1)
//         return s.charAt(0) + "" + s.charAt(0);
//      return s.charAt(0) + "" + s.charAt(0) + doubleUp(s.substring(1));
      // 2. The iterative solution:
      String newString = "";
      for (int i = 0; i < s.length(); i++) {
         char letter = s.charAt(i);
         newString += letter + "" + letter; // This is bad, since we use String concatenation inside loop.
         //  We create a new String object each time! Instead, we should use the StringBuilder.
         // I didn't use since it hasn't been explained yet!
      }
      return newString;
   }
   
   public static void main(String[] args) {
      String s = doubleUp("hello");
      System.out.println(s);
      
      System.out.println(doubleUp("cat"));
   }
}