package com.ctco.w4d4taskatayeva;

public class StringProcessor {

    final char BACKSLASH = '\\';
    final char NEWLINE = '\n';


    public String processString(String string) {
        char[] charArray = string.toCharArray();
        String symbolString = "";
        String processedString = "";

        if (string.isEmpty())
            throw new NullPointerException("String is Empty!");


        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == BACKSLASH) {
                for (; i < charArray.length; i++) {
                    if (charArray[i] == BACKSLASH) {
                        symbolString += charArray[i];
                    } else if (charArray[i] == NEWLINE) {
                        symbolString = "";
                        break;
                    } else {
                        i--;
                        break;
                    }
                }
                processedString += symbolString;
            } else {
                processedString += charArray[i];
            }
        }
        return processedString;

    }
}





