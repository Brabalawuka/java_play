package leetcode.weekly_contest;

public class Q2243DigitalSum {

    public String digitSum(String s, int k) {
        String result = s;
        int ii = 0;
        while (result.length() > k) {
            System.out.println("Loop result:" + result);
            StringBuilder builder = new StringBuilder();
            var i = 0;
            while (i < result.length() - k + 1){
                builder.append(SumOfThree(result.substring(i,i+k)));
                i += k;
            }
            if (i < result.length() ) {
                builder.append(SumOfThree(result.substring(i)));
            }
            result = builder.toString();
            System.out.println("Loop result:" + result);
        }
        return result;

    }
    public int SumOfThree (String items){
        int result = 0;
        for (int i = 0; i < items.length(); i++) {
            result += items.charAt(i) - '0';
        }
        return result;
    }
}
