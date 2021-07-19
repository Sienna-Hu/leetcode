/* Idea:
   Two strings are anagrams when they look the same after being sorted.
   In this question, we need to maintain a group for strings that are anagrams.
   Therefore, we used the sorted version of this group of strings as the Key
   and maintain a list of string as the Value. */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams= new HashMap<>();
        for (String str : strs) {
            char[] ca= str.toCharArray();
            Arrays.sort(ca);
            // Use sorted version of the anagram as the key of this group
            String key= String.valueOf(ca);
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }
            anagrams.get(key).add(str);
        }
        return new ArrayList<>(anagrams.values());

    }

}
