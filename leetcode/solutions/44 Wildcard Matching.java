class Solution {
    public boolean isMatch(String s, String p) {
        int sPosition= 0;
        int pPosition= 0;
        // Record the position of '*' in pattern
        int starPosition= -1;
        // Initial restart position in s corresponds to the star position in p
        int restart= -1;

        while (sPosition < s.length()) {
            // Case 1. character matches
            if (pPosition < p.length() && (s.charAt(sPosition) == p.charAt(pPosition) || p.charAt(pPosition) == '?')) {
                sPosition++;
                pPosition++;
            }
            /* Case 2. pattern character is '*'
                Need to store star position in p and restart position in s for
                other cases.
                Because we first increment pPosition by 1, suggesting that '*'
                match empty string, but actually '*' can match >= 0 characters */
            else if (pPosition < p.length() && p.charAt(pPosition) == '*') {
                starPosition= pPosition;
                restart= sPosition;
                pPosition++;
            }
            /* Case 3. Neither match nor '*' character but '*' occurs previously
                Need to consider whether the senario arises because we match
                fewer character to '*' than it supposes to
                Therefore, let sPosition go back to restart position + 1 and
                pPosition to starPosition + 1 to go through the process again. */
            else if (starPosition != -1) {
                pPosition= starPosition + 1;
                restart++;
                sPosition= restart;
            }
            else {
                return false;
            }
        }

        while (pPosition < p.length() && p.charAt(pPosition) == '*') {
            pPosition++;
        }

        return pPosition == p.length();
    }
}
