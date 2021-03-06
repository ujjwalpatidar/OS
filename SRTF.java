
public class SRTF {

    public static void main(String[] args) {
        int[] P = {0, 1, 2, 3};
        int[] At = {3, 1, 3, 5};
        int[] Bt = {2, 2, 1, 4};
        int[] Ct = new int[Bt.length];
        int[] TAT = new int[Bt.length];
        int[] Wt = new int[Bt.length];
        int[] Rem = new int[Bt.length];
        float AvgWt = 0, AvgTAT = 0;
        int Count = 0, CuT = 0;
        System.arraycopy(Bt, 0, Rem, 0, At.length);
        while (true) {
            if (Count == At.length) {
                break;
            }
            int min = 99, index = At.length;
            for (int i = 0; i < At.length; i++) {
                if (At[i] <= CuT && Rem[i] != 0 && Rem[i] < min) {
                    min = Rem[i];
                    index = i;
                }
            }
            if (index == At.length) {
                CuT++;
            } else {
                Rem[index]--;
                CuT++;
                if (Rem[index] == 0) {
                    Ct[index] = CuT;
                    Count++;
                }
            }
        }
        for (int j = 0; j < P.length; j++) {
            TAT[j] = Ct[j] - At[j];
            Wt[j] = TAT[j] - Bt[j];
            AvgTAT = AvgTAT + TAT[j];
            AvgWt = AvgWt + Wt[j];
        }
        AvgTAT = AvgTAT / (P.length);
        AvgWt = AvgWt / (P.length);
        System.out.println();
        System.out.println("Process\tAT\tBT\tCT\tTAT\tWT");
        for (int j = 0; j < At.length; j++) {
            System.out.println(P[j] + "\t" + At[j] + "\t" + Bt[j] + "\t" + Ct[j] + "\t" + TAT[j] + "\t" + Wt[j]);
        }
        System.out.println();
        System.out.println("Average TAT \t" + AvgTAT);
        System.out.println("Average WT \t" + AvgWt);
    }
}
