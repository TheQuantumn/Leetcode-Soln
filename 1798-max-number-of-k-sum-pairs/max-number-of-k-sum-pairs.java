class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int num : nums){
            int compliment = k-num;
            if(map.getOrDefault(compliment,0)>0){
                map.put(compliment ,map.get(compliment)-1);
                count++;
            }
            else{
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        return count;
    }
}