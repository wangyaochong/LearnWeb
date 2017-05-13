package test;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/5/13】 at 【14:41】.
 */
public class QuickSort {
    @Test
    public void test(){
        int []input=new int[]{1,2,3,55,23,9};
        quickSort(input,0,input.length-1);
        for (int i : input) {
            System.out.print(i+" ");
        }
    }
    public void quickSort(int [] input,int i,int j){
        if(i<j){
            int mid=sortCore(input,i,j);
            quickSort(input,i,mid-1);
            quickSort(input,mid+1,j);
        }
    }
    public int sortCore(int [] input,int start,int end){
        int flag=input[start];
        while(start<end){
            while(start<end&&input[end]>=flag){
                end--;
            }
            input[start]=input[end];
            while(start<end&&input[start]<=flag){
                start++;
            }
            input[end]=input[start];
        }
        input[start]=flag;
        return start;
    }
}
