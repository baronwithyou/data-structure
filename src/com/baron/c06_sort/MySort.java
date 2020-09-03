package com.baron.c06_sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MySort {
    private final SimpleDateFormat format;
    public MySort(String name) {
        System.out.println(name);
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public void beforeSort() {
        printTime("before");
    }

    public void afterSort() {
        printTime("after");
        System.out.println();
    }

    private void printTime(String s) {
        Date data = new Date();
        System.out.printf("time %s sort: %s\n", s, format.format(data));
    }
}

interface SortInterface{
    void sort(int[] nums);
}
