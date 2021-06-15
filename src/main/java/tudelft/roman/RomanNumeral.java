package tudelft.roman;

import javax.print.attribute.IntegerSyntax;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    private static Map<Character, Integer> map;

    static {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    private boolean checkValidSubtractive(int current, int next){
        /*
        Numerals V (5), L (50), D (500), (V) (5,000), (L) (50,000), (D) (500,000) are NOT allowed to be used as
        numerals of lesser value in subtractive notation groups of Roman numerals.
         */
        if(current == 5 || current == 50 || current == 500){
            //invalid subtractive
            return false;
        }
        return true;
    }

    public int convert(String s) {

        int convertedNumber = 0;
        for(int i = 0; i < s.length(); i++) {
            int currentNumber = map.get(s.charAt(i));
            int next = i+1 < s.length() ? map.get(s.charAt(i+1)) : 0;

            if(currentNumber >= next)
                convertedNumber += currentNumber;
            else if(checkValidSubtractive(currentNumber, next)){

                convertedNumber -= currentNumber;
            }else{
                //invalid number
                return -1;
            }
        }

        return convertedNumber;

    }
}
