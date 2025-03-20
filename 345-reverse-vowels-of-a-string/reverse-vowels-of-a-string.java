class Solution {
    public String reverseVowels(String str) {
        int i =0 , j = str.length()-1;
        char[] s = str.toCharArray();
        while(i<j){
            if(isVowel(s[i]) && isVowel(s[j])){
                char temp =s[i];
                s[i]=s[j];
                s[j]=temp;
                i++;
                j--;
            }
            else if (isVowel(s[i]) && !isVowel(s[j])){
                j--;
            }
            else if (!isVowel(s[i]) && isVowel(s[j])){
                i++;
            }
            else{
                i++;
                j--;
            }
        }
    return new String (s);
    
    }
     public static boolean isVowel(char a) {
        return "AEIOUaeiou".indexOf(a) != -1; // Efficient vowel check
    }
        
}