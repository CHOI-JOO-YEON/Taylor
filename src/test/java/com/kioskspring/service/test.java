package com.kioskspring.service;

import java.util.HashSet;

public class test {

    int num;
    int result;
    boolean visit[];
    public int solution(int n) {
        num=n;
        result = 0;
        visit = new boolean[n];
        dfs(0);
        return result;

    }

    private void dfs(int i) {
        if (i == num) {
            result++;
        }
        else{
            for (int j = 0; j <num ; j++) {
                if(!visit[j])
                {
                    visit[j] = true;
                    dfs(i+1);
                    visit[j] = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        test a = new test();
        int b = a.solution(12);
        System.out.println("b = " + b);

    }
}

