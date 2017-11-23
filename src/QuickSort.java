import java.util.Arrays;

/**
 * Created by aloom on 11/21/2017.
 */
public class QuickSort {

    int[]nums;

    public static void main(String[]args){
        //quicksort object instance to allow for non static access.
        QuickSort qs = new QuickSort();
        //provide for better data testing by providing lists of random numbers
        int[]nums = qs.generateRandomList(10);
        System.out.println("Presort Nums: "+Arrays.toString(nums));
        //sort will recursively partition the list until it is in increasing order.
        qs.sort(nums, 0, nums.length - 1);
        System.out.println("Nums: "+Arrays.toString(qs.nums));
        //isSorted will return a message telling whether the list is sorted or not.
        if(qs.isSorted())
        {
            System.out.println("completely sorted");
        }
        else
        {
            System.out.println("not sorted");

        }
    }

    /*
        Swaps the elements at the specified indexs.
     */
    private int[]swap(int[]arr, int firstIndex, int secondIndex)
    {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
        return arr;
    }

    /*
        Generates a random number in the specified range.
     */
    public int generateRandomNum(int maxRange, int minRange){
        int randomNum = minRange + (int)(Math.random()*maxRange);
        return randomNum;
    }

    /*
        Generates a list of randomly generated numbers.
     */
    public int[]generateRandomList(int size)
    {
           int[]nums = new int[size];
           for(int i = 0; i < nums.length; i++)
           {
               nums[i] = generateRandomNum(100,0);
           }
           return nums;
    }

    /*
        How the sort works step by step:
            1. The first pass rearranges the elements of the list around the pivot.
            The pivot is (for this implementation Hoares implementation) an element that is at the median point of the list.
            Elements less than the pivot are placed before the pivot and elements greater than the pivot are placed after the pivot.
            2. Upon completion of the new index of the pivot is returned. This is because the pivots index will change during the swaping of elements in the partition stage.
            3.The second stage seeks to recursively sort all elements less than the pivot in ascending order.
                notes:
                    The pivot index
            4. The third stage seeks to sort all elements greater (to the right of) the pivot in ascending order.
     */
    public int[]sort(int[]nums, int leftPointer, int rightPointer){
        int pivotIndex = partition(nums, leftPointer,rightPointer);
        System.out.println("Pivot index: "+pivotIndex);
        if(leftPointer < pivotIndex - 1)sort(nums,leftPointer,pivotIndex - 1);
        if(pivotIndex < rightPointer)sort(nums, pivotIndex,rightPointer);
        return nums;
    }

    public int partition(int[]nums, int leftPointer, int rightPointer) {
        int pivot = nums[leftPointer + (rightPointer - leftPointer) / 2];// if left pointer = 0 and right pointer = 9 then 0 + (9-0)/2 = 4
        int lp = leftPointer;//create a counter for the left pointer
        int rp = rightPointer;//create a counter for the right pointer
        while (lp <= rp)
        {
            while (nums[lp] < pivot)
            {
                lp++;
            }
            while (nums[rp] > pivot)
            {
                rp--;
            }
            if(lp <= rp)
            {
                swap(nums, lp, rp);
                lp++;
                rp--;
            }
        }
        this.nums = nums;
        return lp;
    }

    public boolean isSorted(){
        int index = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] < nums[i - 1])
            {
                return false;
            }
        }
        return true;
    }

    public int[]getSortedList(){
        return this.nums;
    }
}
