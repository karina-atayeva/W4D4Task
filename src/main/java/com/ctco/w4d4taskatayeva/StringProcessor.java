package com.ctco.w4d4taskatayeva;

import java.util.HashMap;

public class StringProcessor {

    private static final char BACKSLASH = '\\';
    private static final char NEWLINE = '\n';

    public String processString(String string) {

        if (string.isEmpty())
            throw new NullPointerException("String is Empty!");

        char[] charArray = string.toCharArray();
        StringBuilder processedString = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == BACKSLASH) {
                HashMap<Integer, String> currentElementAndSymbolString = createHashMapWithCurrentIndexAndString(i, charArray);
                i = (int) currentElementAndSymbolString.keySet().toArray()[0];
                String symbolString = currentElementAndSymbolString.get(i);
                processedString.append(symbolString);
            } else {
                processedString.append(charArray[i]);
            }
        }

        return processedString.toString();
    }

    private HashMap<Integer, String> createHashMapWithCurrentIndexAndString(int i, char[] charArray) {
        StringBuilder symbolString = new StringBuilder();
        HashMap<Integer, String> currentElementAndSymbolString = new HashMap<>();

        for (; i < charArray.length; i++) {
            if (charArray[i] == BACKSLASH) {
                symbolString.append(charArray[i]);
            } else if (charArray[i] == NEWLINE) {
                symbolString.delete(0, symbolString.length());
                currentElementAndSymbolString.put(i, symbolString.toString());
                break;
            } else {
                i--;
                currentElementAndSymbolString.put(i, symbolString.toString());
                break;
            }

        }
        return currentElementAndSymbolString;
    }


}