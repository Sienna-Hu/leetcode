/* When problem involves concatenation of strings, remember that it requires
   copy original string. Therefore, try to use StringBuilder and append() instead
   to save time. */

   class Solution {
       public String countAndSay(int n) {
           if (n==1) return "1";

           StringBuilder sb= new StringBuilder();

           String prev= countAndSay(n-1);
           int count= 1;
           char initial= prev.charAt(0);

           for (int i=1; i<prev.length(); i++) {
               if (initial==prev.charAt(i)) {
                   count++;
               } else {
                   sb.append(String.valueOf(count)).append(initial);
                   initial= prev.charAt(i);
                   count= 1;
               }
           }

           // When the loop end, the StringBuilder does not have information of
           // the last same char in prev
           sb.append(String.valueOf(count)).append(initial);

           return sb.toString();
       }
   }
