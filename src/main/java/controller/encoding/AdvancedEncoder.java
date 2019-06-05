package controller.encoding;

import utils.Constants;

import java.util.*;
import java.util.stream.Collectors;

public class AdvancedEncoder extends Encoder {
    public AdvancedEncoder() {

    }

    public AdvancedEncoder(Integer key) {
        super(key);
    }

    public List<String> encodeGermanWithoutKey(List<String> inList) {
        key = calculateKey(buildCharMap(inList));
        return inList.stream().map(this::encodeLine).collect(Collectors.toList());
    }

    private Map<Integer, Integer> buildCharMap(List<String> inList) {
        Map<Integer, Integer> charCount = new HashMap<>();
        inList.forEach(line -> line.chars().boxed().forEach(cn -> {
            if (cn <= Constants.BIG_LETTER_MAX && cn >= Constants.BIG_LETTER_MIN || cn <= Constants.SMALL_LETTER_MAX && cn >= Constants.SMALL_LETTER_MIN) {
                charCount.merge(cn, 1, Integer::sum);
            }
        }));
        return charCount;
    }

    private Integer calculateKey(Map<Integer, Integer> charMap) {
        int encodedE = Collections.max(charMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        if (encodedE <= Constants.BIG_LETTER_MAX && encodedE >= Constants.BIG_LETTER_MIN) {
            return (encodedE - Constants.BIG_E) * -1;
        } else {
            return (encodedE - Constants.SMALL_E) * -1;
        }

    }

}
