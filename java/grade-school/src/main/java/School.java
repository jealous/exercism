import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cedric Zhuang
 */
public class School {
    private Map<Integer, List<String>> _db;

    public School() {
        _db = new HashMap<>();
    }

    public void add(String name, Integer grade) {
        get(grade).add(name);
    }

    private List<String> get(Integer grade) {
        if (!_db.containsKey(grade)) {
            _db.put(grade, new ArrayList<>());
        }
        return _db.get(grade);
    }

    public List<String> grade(Integer grade) {
        return get(grade);
    }

    public Map<Integer, List<String>> sort() {
        _db.values().forEach(Collections::sort);
        return _db;
    }

    public Map<Integer, List<String>> db() {
        return _db;
    }
}
