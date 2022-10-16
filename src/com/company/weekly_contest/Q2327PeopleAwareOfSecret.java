package com.company.weekly_contest;

import java.util.Arrays;

public class Q2327PeopleAwareOfSecret {

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long production = 0;
        long result = 0;
        var productionArr = new long[n * 2 + 5];
        var removeArr = new long[n * 2 + 5];


        for (int i = 1; i <= n; i++){
            if (i == 1){
                result = 1;
                production = 0;
                productionArr[i+delay] = 1;
                removeArr[i+forget] = 1;
            } else {
                production = production + productionArr[i] - removeArr[i];
                productionArr[i+delay] = production;
                removeArr[i+forget] = production;

            }


            result = (result + production - removeArr[i]) % (1000000000 + 7);
            System.out.println(production);
            System.out.println(Arrays.toString(productionArr));
            System.out.println(Arrays.toString(removeArr));
            System.out.println(result);
            System.out.println("--------");

        }
        return (int)result;

    }

}
