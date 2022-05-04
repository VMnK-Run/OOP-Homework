package com.huawei.classroom.student.h15;

import java.util.ArrayList;
import java.util.List;

public class PrimeUtil {
    public PrimeUtil() {

    }

    public List<Long> getPrimeList(long start, long end, int threadCount) {
        List<Long> res = new ArrayList<>();
        PrimeThread[] threads = new PrimeThread[threadCount]; //分成多个线程
        for(int i = 0; i < threadCount; i++) {
            long start1 = (end - start) / threadCount * i + start;
            long end1 = (end - start) / threadCount * (i + 1) + start;
            threads[i] = new PrimeThread(start1, end1); //设置每个线程的区间，使每个线程在一个区间范围内计算
        }
        for(int i = 0; i < threadCount; i++) {
            threads[i].start();
        }
        for(int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();//需要依次等待所有线程结束
                res.addAll(threads[i].getPrime());//加入每个线程的结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
