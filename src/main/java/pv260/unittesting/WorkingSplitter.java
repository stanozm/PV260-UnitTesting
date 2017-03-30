
package pv260.unittesting;

import java.util.ArrayList;
import java.util.List;

public class WorkingSplitter implements StringSplitter {

    @Override
    public List<String> split(char symbol, String phrase) {
        List<String> parts = new ArrayList<>();
        String left = phrase;
        while ((left = doNext(left, symbol, parts)) != null);
        return parts;
    }

    private String doNext(String left, char symbol, List<String> parts) {
        int splitAt = left.indexOf(symbol);
        if (splitAt == -1) {
            parts.add(left);
            return null;
        }
        parts.add(left.substring(0, splitAt));
        return left.substring(splitAt + 1);
    }
}
