import java.util.*;

class ThroneInheritance {
    private String king;
    private Map<String, List<String>> family;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        family = new HashMap<>();
        dead = new HashSet<>();
    }
    
    public void birth(String parentName, String childName) {
        // add child to parent's children list in insertion order
        family.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }
    
    public void death(String name) {
        dead.add(name); // just mark dead, don’t remove from tree
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }
    
    private void dfs(String name, List<String> order) {
        if (!dead.contains(name)) {
            order.add(name);
        }
        for (String child : family.getOrDefault(name, Collections.emptyList())) {
            dfs(child, order);
        }
    }
}
