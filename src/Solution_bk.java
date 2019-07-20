import java.util.TreeSet;

public class Solution_bk {

    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> active = new TreeSet();
        int day = 0;
        for (int flower: flowers) {
            day++;
            active.add(flower);
            Integer lower = active.lower(flower);
            Integer higher = active.higher(flower);
            if (lower != null && flower - lower - 1 == k ||
                    higher != null && higher - flower - 1 == k)
                return day;
        }
        return -1;
    }

    public static void main(String[] args){
        Solution_bk solution = new Solution_bk();
        System.out.println(solution.kEmptySlots(new int[]{1, 3, 2}, 1));
    }
}
