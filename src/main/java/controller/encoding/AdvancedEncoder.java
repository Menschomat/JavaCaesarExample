package controller.encoding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvancedEncoder extends Encoder {
    public AdvancedEncoder(){

    }
    public AdvancedEncoder(Integer key) {
        super(key);
    }
    private List<String> encodeGermanWithoutKey(List<String> inList) { //NOT FINISHED YET!
        Map<Integer,Integer> charCount = new HashMap<>();
        inList.forEach(line -> line.chars().mapToObj(c -> (int)c).forEach(cn -> {
            charCount.put(key, charCount.get(key) + 1);
        }));

        return inList;
    }

}
