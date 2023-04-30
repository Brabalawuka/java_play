package com.company.daily_challenge;

import com.sun.source.tree.Tree;

import java.util.*;

/*
Date: 24th Apr 2023
Note: First question
 */
public class Q2336SmallestNumberInfiniteSet {

    private TreeSet<Integer> poppedItem;
    private TreeSet<Integer> addedBackItem;


    public Q2336SmallestNumberInfiniteSet() {
        poppedItem = new TreeSet<>();
        addedBackItem = new TreeSet<>();
    }


    public int popSmallest() {
        if (addedBackItem.isEmpty()){
            if (poppedItem.isEmpty()) {
                poppedItem.add(1);
                return 1;
            }
            var nextItem = poppedItem.last() +1;
            poppedItem.add(nextItem);
            return nextItem;
        }
        var smallest = addedBackItem.pollFirst();
        poppedItem.add(smallest);
        return smallest;
    }

    public void addBack(int num) {
        if (poppedItem.remove(num)){
            addedBackItem.add(num);
        }
    }



}
