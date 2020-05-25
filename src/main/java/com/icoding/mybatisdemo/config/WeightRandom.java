package com.icoding.mybatisdemo.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class WeightRandom {

    private static int totalWeight = 0;

    public static void main(String[] args) {

        Map<Integer, Integer> lotteryMap = new HashMap<>(10);
        lotteryMap.put(1, 10);
        lotteryMap.put(2, 30);
        lotteryMap.put(3, 15);
        lotteryMap.put(4, 5);
        lotteryMap.put(5, 13);
        lotteryMap.put(6, 27);


        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Set<Map.Entry<Integer, Integer>> entrySet = lotteryMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            totalWeight += entry.getValue();
            treeMap.put(totalWeight, entry.getKey());
        }

        getRandom(treeMap);

    }

    public static Map.Entry<Integer, Integer> getRandom(TreeMap<Integer, Integer> treeMap) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        Map.Entry<Integer, Integer> entry = treeMap.tailMap(threadLocalRandom.nextInt(totalWeight), false).firstEntry();
        return entry;
    }



}
