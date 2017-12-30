package timus;

public class Scholarship_2056 {
    public static String getScholarship(int n, int a[]){
        double sum = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 3) return "None";
            else sum += a[i];
        }
        if ((int)(sum / n) == 5) return "Named";
        return sum / n >= 4.5 ? "High" : "Common";
    }
}
