package com.company;

//Leetcode 771. Jewels and Stones
//link: https://leetcode.com/problems/jewels-and-stones/description/
public class StoneAndJewels {

    public static void main(String[] args) {
        StoneAndJewels m = new StoneAndJewels();
        m.numJewelsInStones("aA", "aAAbbbb");
    }

    public int numJewelsInStones(String J, String S) {
        int[] myJewels = new int[256];
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            int c = S.charAt(i);
            myJewels[c]++;
        }

        for (int j = 0; j < J.length(); j++) {
            int c2 = J.charAt(j);
            if (myJewels[c2] > 0) {
                count = count + myJewels[c2];
            }
        }

        return count;
    }
}
