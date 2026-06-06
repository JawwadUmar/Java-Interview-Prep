package org.jawwad.leetcode;

public class Leetcode3121 {
    private boolean isCapital(char ch){
        return ch>='A';
    }

    private char toLower(char ch){
        int diff = 'A' - 'a';

        return (char)(ch + diff);
    }

    private char toUpper(char ch){
        int diff = 'A' - 'a';

        return (char)(ch - diff);
    }

    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] smallChar = new int[26];
        int[] bigChar = new int[26];
        int [] isSpecial = new int[26];

        for(int i = 0; i<n; i++){
            char ch = word.charAt(i);
            if(isCapital(ch)){
                char lowerCaseCh = toLower(ch);
                if(isSpecial[lowerCaseCh - 'a'] != -1 && smallChar[lowerCaseCh - 'a']>0){
                    isSpecial[lowerCaseCh - 'a'] = 1;
                }
                bigChar[ch-'A']++;
            }
            else if(isSpecial[ch - 'a'] != -1 ){
                smallChar[ch-'a']++;
                char uppperChar = toUpper(ch);
                if(bigChar[uppperChar - 'A'] > 0){
                    isSpecial[ch - 'a'] = 1;
                }
            }
        }

        int count = 0;

        for(int i = 0; i<26; i++){
            if(isSpecial[i] == 1){
                count++;
            }
        }

        return count;
    }
}
