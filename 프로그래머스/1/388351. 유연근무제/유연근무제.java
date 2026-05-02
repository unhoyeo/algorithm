class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            boolean late = false;
            
            int maxH = schedules[i] / 100;
            int maxM = schedules[i] % 100 + 10;
            if (maxM >= 60) {
                maxH++;
                maxM -= 60;
            }
            int limit = maxH * 100 + maxM;
            
            for (int j = 0; j < 7; j++) {
                int day = (startday + j - 1) % 7 + 1;
                if (day == 6 || day == 7) continue;
                
                if (timelogs[i][j] > limit) {
                    late = true;
                    break;
                }
            }
            
            if (!late) ans++;
        }
        
        return ans;
    }
}