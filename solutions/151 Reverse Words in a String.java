// Given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will
// be separated by at least one space.

// Return a string of the words in reverse order concatenated by a single space.

// Note that s may contain leading or trailing spaces or multiple spaces between
// two words. The returned string should only have a single space separating
// the words. Do not include any extra spaces.

// Example 1:
// Input: s = "the sky is blue"
// Output: "blue is sky the"

import java.util.Deque;
import java.util.ArrayDeque;

class Solution2 {
  public String reverseWords(String s) {
    s = s.trim();
    int l = 0;
    int r = s.length();

    Deque<String> d = new ArrayDeque<>();
    StringBuilder word = new StringBuilder();

    while (l < r) {
      char c = s.charAt(l);

      if (word.length() != 0 && c == ' ') {
        d.offerFirst(word.toString());
        word.setLength(0);
      } else if (c != ' ') {
        word.append(c);
      }
      l++;
    }

    d.offerFirst(word.toString());

    return String.join(" ", d);
  }
}