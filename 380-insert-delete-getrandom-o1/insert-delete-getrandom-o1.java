import java.util.*;
class RandomizedSet {
    private HashSet<Integer> set;
    private Random rand;

    public RandomizedSet() {
        set = new HashSet<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(set.contains(val))return false;
        else {
            set.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        }else return false;
    }
    public int getRandom() {
        List<Integer> list = new ArrayList<>(set);
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */