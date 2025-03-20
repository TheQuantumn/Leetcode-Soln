class Solution {
    public String reverseWords(String s) {
        String[] arr= s.split("\\s+");
        int left=0, right=arr.length-1;
        while(left<right){
            String temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        String ans = String.join(" ", arr);
        return ans.trim();
        
    }
}