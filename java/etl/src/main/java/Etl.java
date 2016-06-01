import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        HashMap<String, Integer> map = new HashMap<>();
        old.forEach((k, v) ->
                v.stream().forEach(x ->
                        map.put(x.toLowerCase(), k)));
        return map;
    }
}
