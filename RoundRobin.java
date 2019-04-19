
public class RoundRobin {

    public static void main(String[] args) {
        int[] Process = {0, 1, 2, 3};
        int[] At = {2, 0, 3, 1};
        int[] Bt = {4, 1, 2, 3};
        int[] Ct = new int[Bt.length];
        int[] TAT = new int[Bt.length];
        int[] Wt = new int[Bt.length];
        int[] Rem = new int[Bt.length];
        float AvgWt = 0, AvgTAT = 0;
        int TS = 2, Rt = 0, CuT = 0;
        for (int i = 0; i < Bt.length; i++) {
            Rem[i] = Bt[i];
            Rt = Rt + Bt[i];
        }
        for (int k = 1; k < Bt.length; k++) {
            for (int i = 1; i < Bt.length; i++) {
                if (At[i - 1] > At[i]) {
                    int temp = At[i - 1];
                    At[i - 1] = At[i];
                    At[i] = temp;
                    temp = Process[i - 1];
                    Process[i - 1] = Process[i];
                    Process[i] = temp;
                    temp = Rem[i - 1];
                    Rem[i - 1] = Rem[i];
                    Rem[i] = temp;
                    temp = Bt[i - 1];
                    Bt[i - 1] = Bt[i];
                    Bt[i] = temp;
                }
            }
        }
        int i = 0;
        while (Rt > 0) {
            if (At[i] <= CuT) {
                if (Rem[i] > 0) {
                    if (Rem[i] > TS) {
                        Rem[i] = Rem[i] - TS;
                        CuT = CuT + TS;
                        Rt = Rt - TS;
                    } else {
                        CuT = CuT + Rem[i];
                        Rt = Rt - Rem[i];
                        Rem[i] = 0;
                        Ct[i] = Ct[i] + CuT;
                    }
                }
                i++;
                if ((i == Process.length)) {
                    i = 0;
                }
                if ((At[i] > CuT)) {
                    i = i - 1;
                }
                if (i < Bt.length - 1) {
                    if (Rem[i] == 0 && At[i + 1] > CuT) {
                        CuT = CuT + 1;
                    }
                }
            } else {
                if ((At[i] != CuT)) {
                    CuT = CuT + 1;
                }
            }
        }
        for (int k = 1; k < Bt.length; k++) {
            for (i = 1; i < Bt.length; i++) {
                if (Process[i - 1] > Process[i]) {
                    int temp = At[i - 1];
                    At[i - 1] = At[i];
                    At[i] = temp;
                    temp = Process[i - 1];
                    Process[i - 1] = Process[i];
                    Process[i] = temp;
                    temp = Ct[i - 1];
                    Ct[i - 1] = Ct[i];
                    Ct[i] = temp;
                    temp = Bt[i - 1];
                    Bt[i - 1] = Bt[i];
                    Bt[i] = temp;
                }
            }
        }
        for (int j = 0; j < Process.length; j++) {
            TAT[j] = Ct[j] - At[j];
            Wt[j] = TAT[j] - Bt[j];
            AvgTAT = AvgTAT + TAT[j];
            AvgWt = AvgWt + Wt[j];
        }
        AvgTAT = AvgTAT / (Process.length);
        AvgWt = AvgWt / (Process.length);
        System.out.println();
        System.out.println("Process\tAT\tBT\tCT\tTAT\tWT");
        for (int j = 0; j < Bt.length; j++) {
            System.out.println(Process[j] + "\t" + At[j] + "\t" + Bt[j] + "\t" + Ct[j] + "\t" + TAT[j] + "\t" + Wt[j]);
        }
        System.out.println();
        System.out.println("Average TAT \t" + AvgTAT);
        System.out.println("Average WT \t" + AvgWt);
    }
}
