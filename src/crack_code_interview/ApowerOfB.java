package crack_code_interview;

public class ApowerOfB {
    
    public static int aPowerOfB(int a, int b) {
        if (b < 0) return 0;
        if (b == 0) return 1;
        return a * aPowerOfB(a, b - 1);
    }
}
