class Solution {
    public void rotate(int[] nums, int k) {
       int n = nums.length;
       k=k%n;
   
        reversePart(nums,0,n-1);
        reversePart(nums,0,k-1);
       reversePart(nums,k,n-1);

    }
         public void reversePart(int[] nums, int left, int right) {
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
}