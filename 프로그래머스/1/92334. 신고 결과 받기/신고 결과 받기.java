import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> nameToIdx = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            nameToIdx.put(name, i);
        }
        
        Map<String, Set<String>> rep = new HashMap<>();
        Map<String, Integer> rc = new HashMap<>();
        
        for (String r : report) {
            StringTokenizer st = new StringTokenizer(r);
            String a = st.nextToken();
            String b = st.nextToken();
            
            rep.putIfAbsent(a, new HashSet<>());
            
            if (!rep.get(a).contains(b)) {
                rep.get(a).add(b);
                rc.put(b, rc.getOrDefault(b, 0) + 1);
            }
        }
        
        Set<String> stop = new HashSet<>();
        for (String key : rc.keySet()) {
            if (rc.get(key) >= k) {
                stop.add(key);
            }
        }
        
        int[] ans = new int[id_list.length];
        
        for (String name : rep.keySet()) {
            int cnt = 0;
            Set<String> r = rep.get(name);
            for (String s : stop) {
                if (r.contains(s)) {
                    cnt++;
                }
            }
            ans[nameToIdx.get(name)] = cnt;
        }
        
        return ans;
    }
}