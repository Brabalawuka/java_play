package leetcode.weekly_contest;

public class Q2259RemoveDigit {
    public String removeDigit(String number, char digit) {
        var len = number.length();
        var lastAppear = -1;
        for (int i = len-1; i >= 0; i--){
            if (number.charAt(i) == digit) {
                lastAppear = i;
                break;
            }
        }


        var stringBuilder = new StringBuilder();
        var removed = false;
        for (int i = 0; i < len; i++){
            if (number.charAt(i) != digit || removed){

                System.out.println("____" + i);
                stringBuilder.append(number.charAt(i));
            } else if (number.charAt(i) == digit){
                if (i == lastAppear){
                    removed = true;
                } else if (number.charAt(i) >= number.charAt(i+1)){
                    stringBuilder.append(number.charAt(i));
                } else {
                    removed = true;
                }
            }
            System.out.println("Builder:"+ stringBuilder.toString()+ " removed:" + removed);

        }
        return stringBuilder.toString();

    }

}
