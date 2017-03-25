package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/3/25】 at 【13:59】.
 */
public class TestInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] input = new int[n];
            int sum = 0;

            //把输入的n个数存入数组
            for(int i =0; i < n; i++)
            {
                int temp  = in.nextInt();
                sum += temp;
                input[i] = temp;
            }
            Arrays.sort(input);
            int seed = 1;
            while(true)
            {
                int flag = 0;
                int sum2 = 0;

                for(int k =0; k < n; k++)
                {
                    if(input[k] == seed)
                    {
                        flag = 1;
                        break;
                    }
                    if(input[k] > seed)
                    {
                        flag = 2;
                        break;
                    }
                    sum2 += input[k];
                }

                if(flag == 0 && seed > sum)
                {
                    System.out.println(seed);
                    break;
                }
                else if(flag == 1)
                {
                    seed ++;
                }
                else
                {
                    if(sum2 < seed)
                    {
                        System.out.println(seed);
                        break;
                    }
                    seed ++;
                }
            }
        }
    }
}
