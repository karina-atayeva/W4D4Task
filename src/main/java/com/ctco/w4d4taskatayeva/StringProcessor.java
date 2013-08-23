package com.ctco.w4d4taskatayeva;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor {

    private static final char BACKSLASH = '\\';
    private static final char NEWLINE = '\n';

    public String processString(String string) {
        char[] charArray = string.toCharArray();
        StringBuilder processedString = new StringBuilder();
        List currentElementAndSymbolString;
        String symbolString;

        if (string.isEmpty())
            throw new NullPointerException("String is Empty!");

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == BACKSLASH) {
                currentElementAndSymbolString = createSymbolString(i, charArray);
                i = (Integer) currentElementAndSymbolString.get(0);
                symbolString = (String) currentElementAndSymbolString.get(1);
                processedString.append(symbolString);
            } else {
                processedString.append(charArray[i]);
            }
        }

        return processedString.toString();
    }

    private List createSymbolString(int i, char[] charArray) {
        StringBuilder symbolString = new StringBuilder();
        List currentElementAndSymbolString = new ArrayList();

        for (; i < charArray.length; i++) {
            if (charArray[i] == BACKSLASH) {
                symbolString.append(charArray[i]);
            } else if (charArray[i] == NEWLINE) {
                symbolString.delete(0, symbolString.length());
                currentElementAndSymbolString.add(i);
                currentElementAndSymbolString.add(symbolString.toString());
                break;
            } else {
                i--;
                currentElementAndSymbolString.add(i);
                currentElementAndSymbolString.add(symbolString.toString());
                break;
            }

        }
        return currentElementAndSymbolString;
    }

}