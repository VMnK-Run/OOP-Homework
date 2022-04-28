package com.huawei.classroom.student.h15;

import java.util.ArrayList;
import java.util.List;

public class PrimeThread extends Thread{
    private final Long start;
    private final Long end;
    private List<Long> res = new ArrayList<>();
    public PrimeThread(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public boolean isPrime(Long num) {
        for(long i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Long> getPrime() {
        return this.res;
    }

    @Override
    public void run(){
        for(long i = this.start; i < this.end; i++) {
            if(isPrime(i)) {
                res.add(i);
            }
        }
    }
}
