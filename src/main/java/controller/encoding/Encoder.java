package controller.encoding;

import utils.Constants;

import java.util.stream.Collectors;

public class Encoder {
    Integer key = 0;

    Encoder() {
    }

    Encoder(Integer key) {
        this.key = key;
    }

    public String encodeLine(String line) {
        return line.chars()
                .mapToObj(c -> (int) c)
                .collect(Collectors.toList())
                .stream().map(num -> encodeNum(num, key))
                .map(num -> (char) num.intValue())
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private Integer encodeNum(Integer in, Integer key) {
        if (in >= Constants.BIG_LETTER_MIN && in <= Constants.BIG_LETTER_MAX)
            return ((in + key) > Constants.BIG_LETTER_MAX) ? in + key - Constants.ABC_LEN : in + key;
        else if (in >= Constants.SMALL_LETTER_MIN && in <= Constants.SMALL_LETTER_MAX)
            return ((in + key) > Constants.SMALL_LETTER_MAX) ? in + key - Constants.ABC_LEN : in + key;
        return in;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}
