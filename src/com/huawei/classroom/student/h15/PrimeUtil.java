package com.huawei.classroom.student.h15;

import java.util.ArrayList;
import java.util.List;

public class PrimeUtil {
    public PrimeUtil() {

    }

    public List<Long> getPrimeList(long start, long end, int threadCount) {
        List<Long> res = new ArrayList<>();
        PrimeThread[] threads = new PrimeThread[threadCount];
        for(int i = 0; i < threadCount; i++) {
            long start1 = (end - start) / threadCount * i + start;
            long end1 = (end - start) / threadCount * (i + 1) + start;
            threads[i] = new PrimeThread(start1, end1);
        }
        for(int i = 0; i < threadCount; i++) {
            threads[i].start();
        }
        for(int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
                res.addAll(threads[i].getPrime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
