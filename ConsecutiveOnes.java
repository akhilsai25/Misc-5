// This solution uses a sliding window approach along with deque to keep track of all the encountered zeros
// We keep adding the zeros until k reaches 0 and when it hits zero, we can remove element from first and add it as last pointer
// At each point we can maintain running 1 count and keep updating the ultra maximum 
class Solution {
    public int longestOnes(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList();
        int max = 0, last = 0, ultra = 0;
        for(int i=0;i<nums.length;i++) {
            ultra = Math.max(max, ultra);
            if(nums[i]==1) {
                max++;
                continue;
            }
            else {
                deque.addLast(i);
                if(k>0) {
                    k--;
                    max++;
                    continue;
                } else {
                    last = deque.pollFirst()+1;
                    max = i-last+1;
                }
            }
        }
        return Math.max(ultra, max);
    }
}
