package com.practices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupThePeople {

    static public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> groups = new ArrayList<>();
        Map<Integer, List<Integer>> sizeToGroup = new HashMap<>();
        for (int i = 0; i < groupSizes.length; ++i) {
            int groupSize = groupSizes[i];
            sizeToGroup.computeIfAbsent(groupSize, l -> new ArrayList<>()).add(i);
            if (sizeToGroup.get(groupSize).size() == groupSize) // the id list reaches their group size.
                groups.add(sizeToGroup.remove(groupSize)); // remove the id list from HashMap and add it to the solution.
        }
        return groups;
    }

    public static void main(String[] args) {
        //System.out.println(groupThePeople(new int[]{3,3,3,3,3,1,3}));
        System.out.println(groupThePeople(new int[]{2,1,3,3,3,2}));

    }
}