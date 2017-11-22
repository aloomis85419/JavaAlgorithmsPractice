import java.util.Arrays;

/**
 * Created by aloom on 11/21/2017.
 */
public class BubbleSort {


    public int[] bubbleSort(int[]nums)
    {
        int swapCount = 0;
        int passCount = 0;
        int temp;
       for(int i = 1; i<nums.length; i++){
           if(nums[i] < nums[i-1]){
               temp = nums[i-1];
               nums[i-1] = nums[i];
               nums[i] = temp;
               swapCount++;
           }
           if(i == nums.length - 1){
               if(swapCount == 0){
                   break;
               }
               else{
                   passCount++;
                   System.out.println("Number of swaps on pass "+passCount+": "+swapCount);
                   swapCount = 0; i = 0;
                   continue;
               }
           }
       }
        return nums;
    }

    public static void main(String[]args){
        BubbleSort bs = new BubbleSort();
        int[]nums = {6,60,7,499,200,3,-1,-55,277,10000,600};
        System.out.println("Bubble Sorted List: "+ Arrays.toString(bs.bubbleSort(nums)));
    }
}
