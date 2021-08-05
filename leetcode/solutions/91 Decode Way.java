class DecodeWay {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    } else if (s.length() == 1) {
      return 1;
    }

    // dp[i] represents how many ways to decode s[:i]
    int[] dp = new int[s.length()];
    dp[0] = 1;

    for (int i = 1; i < s.length(); i++) {
      int digit = Integer.parseInt(s.substring(i, i + 1));
      int num = Integer.parseInt(s.substring(i - 1, i + 1));

      if (digit >= 1) {
        dp[i] = dp[i - 1];
      }
      if (num >= 10 && num <= 26) {
        dp[i] = i - 2 >= 0 ? dp[i] + dp[i - 2] : dp[i] + 1;
      }
    }

    return dp[s.length() - 1];
  }
}