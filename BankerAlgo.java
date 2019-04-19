import java.util.*;
public class BankerAlgo {
    public static void main(String[] args) {
    
        int[][] alloc = {{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};
        int[][] max = {{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}};
        int[][] need = {{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
        int[] avail = {3,3,2};
        int p=5;
        boolean[] flag = {false,false,false,false,false};
        int count = 0;
        int[] safseq = new int[5];

        System.out.println("");
        System.out.print("Initially available : "+ Arrays.toString(avail));
            for(int i=0;i<p;i++){
                for(int j=0;j<avail.length;j++){  
                    need[i][j]=max[i][j]-alloc[i][j];
                }
        }
        while(count < p){
            for(int i=0;i<p;i++){
                if(flag[i]==false){
                    int j;
                    for(j=0;j<avail.length;j++){
                        if(need[i][j]>avail[j] ){
                            break;
                        }
                    }
                    if(j == avail.length){
                        flag[i]=true;
                        for(int k=0;k<avail.length;k++)
                            avail[k] =avail[k]+alloc[i][k];
                        safseq[count] = i;
                        count++;
                    }
                }
            }   
        }

        System.out.println("");
        System.out.println("Alloc \t\t Max \t\t Need ");
        for(int i=0;i<p;i++){
            System.out.println(Arrays.toString(alloc[i])+"\t"+Arrays.toString(max[i])+"\t"+Arrays.toString(need[i]) );
        }
        System.out.println("Available : " + Arrays.toString(avail) );
        System.out.println("Safe Sequence : "+Arrays.toString(safseq) );
        
    }
}