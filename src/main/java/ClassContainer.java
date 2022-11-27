import java.util.*;

public class ClassContainer {
    TreeMap<String, Class> ourMap;

    public ClassContainer(TreeMap<String, Class> ourMap) {
//        this.ourMap = ourMap;

    }

    public ClassContainer() {
        this.ourMap = new TreeMap<>();
    }

    public void addClass(String groupName, int amount) {
        Class myClass = new Class(groupName, amount);
        ourMap.put(groupName, myClass);
    }

    public void removeClass(String name) {
        ourMap.remove(name);
    }

    public List<Class> findEmpty() {
        List<Class> emptyGroups = new ArrayList<>();

        for (Map.Entry<String, Class> entry : ourMap.entrySet()) {
            if(entry.getValue().getActualNumberOfStudents() == 0){
                emptyGroups.add(entry.getValue());
            }
        }
        return emptyGroups;
    }

    public void summary() {
        for (Map.Entry<String, Class> entry : ourMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
        }
    }
}
