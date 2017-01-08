package com.lhb;

import com.alibaba.fastjson.JSON;

/**
 * java排序算法测试
 * Created by LHB on 2016/10/29.
 */
public class SortTest {

    public static void main(String[] args) {
        int[] num = {46, 74, 53, 14, 26, 38, 86, 65, 27, 34};
//        bubblingSort(num);
        SimpleChoiceSort(num);
    }

    /**
     * 冒泡排序
     *
     * @param a
     */
    private static void bubblingSort(int[] a) {
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        //冒泡排序
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                //这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.println(i + "：" + JSON.toJSONString(a));
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 简单选择排序
     */
    private static void SimpleChoiceSort(int[] a) {
        System.out.println("排序之前：");
        //简单的选择排序
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int n = i; //最小数的索引
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {  //找出最小的数
                    min = a[j];
                    n = j;
                }
            }
            a[n] = a[i];
            a[i] = min;
            System.out.println(i + "：" + JSON.toJSONString(a));
        }
        System.out.println();
        System.out.println("排序之后：");
    }
}
