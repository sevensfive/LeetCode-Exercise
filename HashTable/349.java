class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        //Set<Integer> set2 = new HashSet<>();
        for (Integer i : nums1) set1.add(i);
        for (Integer i : nums2) {
            if (set1.contains(i)) {
                list.add(i);
                set1.remove(i);
            }
        }
            
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
}