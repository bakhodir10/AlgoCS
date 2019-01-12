package problems.medium;

import java.util.*;

public class FourSum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Quadruplet> quadruplets = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            Quadruplet q = new Quadruplet(nums[i], nums[j], nums[k], nums[l]);
                            if (!quadruplets.contains(q)) {
                                quadruplets.add(q);
                                ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    private class Quadruplet {
        public int a, b, c, d;

        public Quadruplet(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + this.a;
            result = 31 * result + this.b;
            result = 31 * result + this.c;
            result = 31 * result + this.d;
            return result;
        }

        @Override
        public boolean equals(Object object) {
            if (object == null) return false;
            if (object == this) return true;
            if (this.getClass() != object.getClass()) return false;
            Quadruplet quadruplet = (Quadruplet) object;
            if (a == quadruplet.a && b == quadruplet.b && c == quadruplet.c && d == quadruplet.d) return true;
            return false;
        }
    }
}
