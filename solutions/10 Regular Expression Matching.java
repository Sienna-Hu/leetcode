/* Dynamic programming: Break the problem to subproblems, and the answer of this
   problem depends on the answer to subproblems.
   Build a 2-D boolean array match to hold is substring of p matches substring of s.
   e.g. s = "aab", p = "c*a*b"
        null a a b
   null  T   F F F
   c     F   F F F
   *     T   F F F
   a     F   T F F
   *     T   T T F
   b     F   F F T

   ith row jth column represents if p[:j] matches s[:i]
   For example, 2nd row 3 column represents if p[:2] == "c*" matches s[:3]=="aab"
   Criteria to determine the value in match:
   1. If s == null && p == null, i.e. match[0][0] == true
   2. If s != null && p == null, i.e. match[0][i] == false (default value)
   3. If s == null && p != null, i.e. match[i][0]
         if (p.charAt(i-1)=='*'):
              we can ignore the character before
              所以在考虑p[:i]是否match null的时候可以忽略当前char和preceding char
              i.e. 如果p[:i-2] match  null, p[:i] match null
              所以 match[i][0] = match[i-2][0]
   4. If s != null && p != null, i.e. match[i][j], i,j not equal to 0
          if (s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '.'):
              说明当前character match
              如果s[:j-1] match p[:i-1], 那么s[:j] match p[:i]
              所以 match[i][j] == match[i-1][j-1]
          else if (p.charAt(i-1) == '*'):
              当p当前character是‘*’的时候考虑两种match方式：
              1. 忽略p的preceding char -> 判断p[:i-2]是否match s[:j]
                 match[i][j] = match[i-2][j]
              2. 多个p的preceding char
                    -> 如果p的preceding char match s当前的character
                       判断p[:i]是否match s[:j-1]
                    -> 如果p的preceding char 不match s当前的character
                       false
                 match[i][j] = match[i][j-1]
   */


class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] match = new boolean[lenP+1][lenS+1];
        match[0][0] = true;
        for (int i=1; i<=lenP; i++) {
            if (p.charAt(i-1)=='*') {
                match[i][0] = match[i-2][0];
            }
        }

        for (int j=1; j<=lenS; j++) {
            for (int k=1; k<=lenP; k++) {
                if (s.charAt(j-1) == p.charAt(k-1) || p.charAt(k-1) == '.'){
                    match[k][j] = match[k-1][j-1];
                }
                else if (p.charAt(k-1)=='*') {
                    if (p.charAt(k-2) == s.charAt(j-1) || p.charAt(k-2) == '.') {
                        match[k][j] = match[k-2][j] || match[k][j-1];
                    }else {
                        match[k][j] = match[k-2][j];
                    }
                }
            }
        }
        return match[lenP][lenS];
    }
}
