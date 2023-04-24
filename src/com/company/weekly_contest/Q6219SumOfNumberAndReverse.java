package com.company.weekly_contest;

import java.util.ArrayList;
import java.util.HashMap;

public class Q6219SumOfNumberAndReverse {

    public boolean sumOfNumberAndReverse(int num) {

        var bytes = String.valueOf(num);

        var intArr = new int[bytes.length()];

        for (int i = 0; i < bytes.length(); i++) {
            var intTemp = Integer.parseInt(String.valueOf(bytes.substring(i,i+1)));
            intArr[i] = intTemp;
        }

        for (int i = 0; i <= intArr.length / 2; i++) {

            if (intArr[i] == intArr[intArr.length - i - 1]) {
                System.out.println(intTemp);
                continue;
            }
            if (i >= intArr.length -1 ) {
                return false;
            }
            intArr[i] = intArr[i] - 1;

            if (intArr[i] == intArr[intArr.length - i - 1]) {
                intArr[i+1] = intArr[i+1] + 10;
            } else {
                return false;
            }

        }

        if (intArr.length % 2 != 0){
            return intArr[intArr.length / 2 + 1] % 2 == 0;
        }
        return true;
    }
}
