
import java.util.Arrays;
class fcfs {
  public static void main(String[] args)
    {
        String process[]=new String[]{"p1","p2","p3","p4"}; 
        int At[]=new int[]{0,0,0,0};
        int Bt[]=new int[]{2,3,4,2};
        int Ct[]=new int[Bt.length];
        int TAT[]=new int[Bt.length];
        int Wt[]=new int[Bt.length];
        int i;
       
        float TATavg = 0,Wtavg=0;
        for(i=1;i<Bt.length;i++)
        {   
            Ct[0]=Bt[0];
            Ct[i]=Bt[i]+Ct[i-1];
        }
        for ( i = 0; i <Bt.length; i++) {
            TAT[i]=Ct[i]-At[i];
            TATavg+=TAT[i];
            Wt[i]=TAT[i]-Bt[i];
            Wtavg+=Wt[i];
        }
        System.out.println("Process  At  Bt  Ct  TAT  Wt");
        for(i=0;i<Bt.length;i++)
        {
            System.out.println(process[i]+"       "+At[i]+"   "+Bt[i]+"   "+Ct[i]+"    "+TAT[i]+"   "+Wt[i]);
        }
        System.out.println("Average TAT = "+TATavg/Bt.length);
        System.out.println("Average Wt = "+Wtavg/Bt.length);
    }
}
