import java.util.Arrays;

/**
 * Created by aloom on 11/21/2017.
 */
public class QuickSort {


    private int[]quickSort(int[]numsToSort){
        int pivot = numsToSort[(numsToSort.length - 1)/2];

        return numsToSort;
    }

    private int[] partition(int[]nums)
    {
        int pivotIndex = (nums.length - 1)/2;
        int pivot = nums[pivotIndex];
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        while(leftPointer < rightPointer) {
            while(nums[leftPointer] < pivot){
                leftPointer++;
            }
            System.out.println("LeftPointer------>: "+leftPointer);
            while(nums[rightPointer] > pivot) {
                rightPointer--;
            }
            System.out.println("RightPointer------>: "+rightPointer);
            nums = swap(nums, leftPointer, rightPointer);
        }
        System.out.println("After partition: "+ Arrays.toString(nums));
        return nums;
    }

    private int[]swap(int[]arr, int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
        return arr;
    }



    public static void main(String[]args){
        int[]nums = {4,7,8,9,2,3,5,6,10,1};
        QuickSort qs = new QuickSort();
        qs.partition(nums);
    }
}
