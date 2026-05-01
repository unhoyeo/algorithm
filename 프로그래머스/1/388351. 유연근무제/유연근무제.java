class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int winnerCount = 0;
        int n = schedules.length;

        for (int i = 0; i < n; i++) {
            // 1. 해당 직원의 출근 인정 데드라인 계산
            int deadline = calculateDeadline(schedules[i]);
            boolean isEligible = true;

            // 2. 7일간의 기록 확인
            for (int dayIdx = 0; dayIdx < 7; dayIdx++) {
                // 현재 체크하는 날의 요일 계산 (1~7)
                int currentDay = (startday + dayIdx - 1) % 7 + 1;

                // 토요일(6)이나 일요일(7)이면 건너뜀
                if (currentDay == 6 || currentDay == 7) {
                    continue;
                }

                // 평일인데 데드라인을 넘겼다면 탈락
                if (timelogs[i][dayIdx] > deadline) {
                    isEligible = false;
                    break;
                }
            }

            if (isEligible) {
                winnerCount++;
            }
        }

        return winnerCount;
    }

    // 시각에 10분을 더해주는 보조 함수
    private int calculateDeadline(int schedule) {
        int hour = schedule / 100;
        int minute = schedule % 100;

        minute += 10;
        if (minute >= 60) {
            hour += 1;
            minute -= 60;
        }

        return hour * 100 + minute;
    }
}