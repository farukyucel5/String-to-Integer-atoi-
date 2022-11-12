package Myatoi;

import java.util.Arrays;
import java.util.List;

public class Extract_Integer {
    public static void main(String[] args) {
        /*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'.
Read this character in if it is either. This determines if the final result is negative or positive respectively.
Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached.
The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).

Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.


Example 1:

Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
Example 2:

Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
            ^
Step 2: "   -42" ('-' is read, so the result should be negative)
             ^
Step 3: "   -42" ("42" is read in)
               ^
The parsed integer is -42.
Since -42 is in the range [-231, 231 - 1], the final result is -42.
Example 3:

Input: s = "4193 with words"
Output: 4193
Explanation:
Step 1: "4193 with words" (no characters read because there is no leading whitespace)
         ^
Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
             ^
The parsed integer is 4193.
         */

        String input= "  -4193-+!é-?*{ with words";

        myAtoi(input);

    }

    private static void myAtoi(String input) {

        System.out.println(input);

        for (int i = 0; i < input.length(); i++) {

            if (!(input.charAt(i)>=48 && input.charAt(i)<=57)&&(input.charAt(i)!='-')) {
                input= input.replace(input.charAt(i),' ');
            }

        }//burada - ve sayı ve bosluk haricinde ne varsa atılır.

        if (input.contains(" "))
            input=input.replace(" ","");//burada bosluklar varsa yok edilir.
        System.out.println(input);

        String[] arr=input.split("");
        List<String> str_list=Arrays.asList(arr);
        for (int i = 1; i < str_list.size(); i++) {  //sayının önündeki eksi işaretinin haricindeki eksi
            if (str_list.get(i).equals("-"))         // operatörleri kaldırılır.
                str_list.set(i,"");
        }

        String str="";
        for (String s : str_list) {     //burada parçalara ayrılmıs string birlestirilir.
            str += s;
        }

        int parsed_int=Integer.parseInt(str);//son olarak burada string formattaki sayı tam sayı'ya çevrilir.
        System.out.println("The integer inside the sentence: "+parsed_int);

    }
    }
