
class Priority {

    public static void main(String[] args) throws Exception {
        String process[] = new String[]{"p1", "p2", "p3", "p4"};
        int At[] = new int[]{2, 4, 3, 1};
        int Bt[] = new int[]{4, 5, 2, 3};
        int Pt[] = new int[]{1, 1, 2, 3};
        int Ct[] = new int[Bt.length];
        int TAT[] = new int[Bt.length];
        int Wt[] = new int[Bt.length];
        sort(At, Bt, process, Pt);
         int i;
        float TATavg = 0;
        float Wtavg = 0;
  
       
            for (i = 1; i < Bt.length; i++) {

                Ct[0] = Bt[0]+At[0];
                Ct[i] = Bt[i] + Ct[i - 1];

            
        }
        for (i = 0; i < Bt.length; i++) {
            TAT[i] = Ct[i] - At[i];
            TATavg += TAT[i];
            Wt[i] = TAT[i] - Bt[i];
            Wtavg += Wt[i];
        }
        System.out.println("Process  At  Bt Priority Ct  TAT  Wt");
        for (i = 0; i < Bt.length; i++) {
            System.out.println(process[i] + "       " + At[i] + "   " + Bt[i] + "   " + Pt[i] + "       " + Ct[i] + "    " + TAT[i] + "   " + Wt[i]);
        }
        System.out.println("Average TAT = " + TATavg / Bt.length);
        System.out.println("Average Wt = " + Wtavg / Bt.length);
        
    }

    private static void sort(int[] At, int[] Bt, String[] process, int[] Pt) throws Exception {
        int count = 0;
        String temp;
        for (int j = 0; j < Bt.length - 1; j++) {
            for (int k = j + 1; k < Bt.length; k++) {
                if (At[j] == At[k]) {
                    if (Pt[j] > Pt[k]) {
                        Pt[j] = Pt[j] ^ Pt[k];
                        Pt[k] = Pt[j] ^ Pt[k];
                        Pt[j] = Pt[j] ^ Pt[k];
                        count = 1;
                    }
                    if (count == 1) {
                        At[j] = At[j] ^ At[k];
                        At[k] = At[j] ^ At[k];
                        At[j] = At[j] ^ At[k];
                        Bt[j] = Bt[j] ^ Bt[k];
                        Bt[k] = Bt[j] ^ Bt[k];
                        Bt[j] = Bt[j] ^ Bt[k];
                        temp = process[j];
                        process[j] = process[k];
                        process[k] = temp;
                        count = 0;
                    }
                } else if (At[j] > At[k]) {
                    At[j] = At[j] ^ At[k];
                    At[k] = At[j] ^ At[k];
                    At[j] = At[j] ^ At[k];
                    count = 1;
                }
                if (count == 1) {
                    Bt[j] = Bt[j] ^ Bt[k];
                    Bt[k] = Bt[j] ^ Bt[k];
                    Bt[j] = Bt[j] ^ Bt[k];
                    temp = process[j];
                    process[j] = process[k];
                    process[k] = temp;
                    Pt[j] = Pt[j] ^ Pt[k];
                    Pt[k] = Pt[j] ^ Pt[k];
                    Pt[j] = Pt[j] ^ Pt[k];
                    count = 0;
                }

            }
        }
       
    }
}
