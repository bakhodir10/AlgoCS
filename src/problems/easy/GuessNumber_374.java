package problems.easy;

public class GuessNumber_374 {

    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

//    public class Solution extends GuessGame {
//        public int guessNumber(int n) {
//            return binarySearch(0, n, n);
//        }
//        private int binarySearch(int l, int r, int n){
//            if(l > r) return -1;
//            int mid = l + (r - l) / 2;
//            int num = this.guess(mid);
//            if(num == 0) return mid;
//            if(num == 1) return binarySearch(mid + 1, r, n);
//            else return binarySearch(l, mid - 1, n);
//        }
//    }
}
