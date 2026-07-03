import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(players[i], i);
        }
        
        for (String c : callings) {
            int ori = map.get(c); // 기존 등수
            String prev = players[ori - 1]; // 앞사람
            
            players[ori - 1] = c;
            players[ori] = prev;
            
            map.put(c, ori - 1);
            map.put(prev, ori);
        }
        
        return players;
    }
}