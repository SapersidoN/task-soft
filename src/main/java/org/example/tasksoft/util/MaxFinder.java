package org.example.tasksoft.util;

import java.util.List;

public class MaxFinder {


    public static int findNth(List<Integer> nums, int n) {
        if (n < 0 || n > nums.size()) {
            throw new IllegalArgumentException("N должно быть от 1 до " + nums.size());
        }
        for (int i = 0; i < n; i++) {
            int max = i;
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(j) > nums.get(max)) {
                    max = j;
                }
            }
            int temp = nums.get(i);
            nums.set(i, nums.get(max));
            nums.set(max, temp);
        }
        return nums.get(n - 1);
    }
}
