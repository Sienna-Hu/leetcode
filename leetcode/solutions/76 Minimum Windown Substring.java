class MinSubstring {
  public String minWindow(String s, String t) {
    // map[i] represents how many i need to appear in substring
    int[] map = new int[128];

    for (char c : t.toCharArray()) {
      map[c]++;
    }

    int start = 0;
    int end = 0;
    int min = Integer.MAX_VALUE;
    int minStart = 0;
    int minEnd = s.length() - 1;
    // counter represents how many characters still need to appear in substring
    int counter = t.length();

    // first find the substring satisfying the constraints
    while (end < s.length()) {
      char ce = s.charAt(end);
      if (map[ce] > 0) {
        counter--;
      }
      map[ce]--;
      end++;

      // when constraints are satisfied, reduce to minimum
      while (counter == 0) {
        if (min > end - start) {
          min = end - start;
          minStart = start;
          minEnd = end;
        }
        char cs = s.charAt(start);
        map[cs]++;
        if (map[cs] > 0) {
          counter++;
        }
        start++;
      }
    }

    return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd);

  }
}