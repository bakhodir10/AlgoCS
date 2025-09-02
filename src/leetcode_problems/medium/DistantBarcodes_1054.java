package leetcode_problems.medium;

import java.util.PriorityQueue;

public class DistantBarcodes_1054 {

    // Time complexity: O(nlogn)
    // Space complexity: O(n)
    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes.length <= 2) return barcodes;

        int[] counts = new int[10001];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int barcode : barcodes) counts[barcode]++;

        for(int i = 0; i < counts.length; i++) {
            if(counts[i] != 0) pq.offer(new int[]{i, counts[i]});
        }

        int i = 0;
        while(pq.size() > 1) {
            int[] f = pq.poll();
            int[] s = pq.poll();
            barcodes[i++] = f[0];
            barcodes[i++] = s[0];
            f[1]--;
            s[1]--;
            if(f[1] > 0) pq.offer(f);
            if(s[1] > 0) pq.offer(s);
        }

        if(!pq.isEmpty()) barcodes[i] = pq.poll()[0];
        return barcodes;
    }
}
