package leetcode.weekly_contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q6038MinimiseResult {
    public static String minimizeResult(String expression) {
        //a*(b+c)*d -----> a can be 0 and d can be zero
        int max = Integer.MAX_VALUE;
        List<Integer> resultCombination = new ArrayList<>();
        var nums = expression.split("\\+");
        //No safety check
        var beforeNum = nums[0];
        var afterNum = nums[1];
        for (int i = 0; i < beforeNum.length(); i++) {
            for (int j = 0; j < afterNum.length(); j++) {
                var combination = new ArrayList<Integer>();
                var a = beforeNum.substring(0,i).length() == 0? -1 : Integer.parseInt(beforeNum.substring(0,i));
                var b = Integer.parseInt(beforeNum.substring(i));
                var c = Integer.parseInt(afterNum.substring(0,j+1));
                var d = afterNum.substring(j+1).length() == 0 ? -1 : Integer.parseInt(afterNum.substring(j+1));
                var result = Math.abs(a * (b+c) * d);
                System.out.println(a +","+b +","+c+","+d + "==>"+result);
                if (result <= max){
                    resultCombination = Arrays.asList(a,b,c,d);
                    max = result;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        if (resultCombination.get(0) != -1){
            builder.append(resultCombination.get(0));
        }
        builder.append("(")
                .append(resultCombination.get(1))
                .append("+")
                .append(resultCombination.get(2))
                .append(")");
        if (resultCombination.get(3) != -1){
            builder.append(resultCombination.get(3));
        }
        return builder.toString();
    }
}
