public class Solution {
    public String solution(int month, int day) {
        int monthArr[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String dayArr[] = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int total = day;
        String answer = "";

        for (int i = 0; i < month - 1; i++) {
            total += monthArr[i];
            System.out.println(total);
        }

        total %= 7;

        for (int i = 0; i < total; i++) {
            answer = dayArr[i];
            System.out.println("answer " + i);
        }


        return answer;
    }

    public String solution2(String[] participant, String[] completion) {
        String answer = "";

        for (int i = 0; i < participant.length ; i++) {
            for (int j = 0; j < completion.length ; j++) {
                if (participant[i] == completion[j]) {
                    participant[i] = "";
                    completion[j] = "";
                }
            }
        }
        for (int i = 0; i < participant.length; i++) {
            if (participant[i] != "") {
                answer = participant[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution(5, 28);
        System.out.println(solution1);

//        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"stanko", "ana", "mislav"};
//        String s = solution.solution2(participant, completion);
//        System.out.println("정답 " + s);
    }
}
