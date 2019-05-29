package controller;

import java.util.stream.Collectors;

public class Decoder {
    Integer key = 0;

    public Decoder() {
    }

    Decoder(Integer key) {
        this.key = key;
    }

    String decodeLine(String line) {
        return line.chars()
                .mapToObj(c -> (int) c)
                .collect(Collectors.toList())
                .stream().map(num -> decodeNum(num, key))
                .map(num -> (char) num.intValue())
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private Integer decodeNum(Integer in, Integer key) {
        if (in >= Utils.BIG_LETTER_MIN && in <= Utils.BIG_LETTER_MAX)
            return ((in + key) < Utils.BIG_LETTER_MAX) ? in + key + Utils.ABC_LEN : in + key;
        else if (in >= Utils.SMALL_LETTER_MIN && in <= Utils.SMALL_LETTER_MAX)
            return ((in + key) < Utils.BIG_LETTER_MAX) ? in + key + Utils.ABC_LEN : in + key;
        return in;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}
