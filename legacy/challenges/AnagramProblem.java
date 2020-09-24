package arrays;

/*

Construct an algorithm to check whether two words (or phrases) are anagrams or not!

"An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once"

*/

//O(N)
public class AnagramProblem {

    public static boolean isAnagram(String str1, String str2) {

        if (str1 == str2) return true;

        if (str1.isEmpty() || str2.isEmpty() || str1.length() != str2.length()) return false;

        int N = str1.length();

        int[] spots = new int[256];

        for (int i = 0; i < N; i++) {
            char c = str1.charAt(i);
            char ch = str2.charAt(i);
            spots[c - 'a'] += 1;
            spots[ch - 'a'] += 1;

            if (spots[c] % 2 != 0) return false;
        }


        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram("casa", "scaa"));
    }

}
