package problems.easy;

public class StudentAttendance_551 {

    public static boolean checkRecord(String s) {
        boolean existA = false;
        for (char c : s.toCharArray())
            if (c == 'A') {
                if (existA) return false;
                else existA = true;
            }
        return !s.contains("LLL");
    }
}
