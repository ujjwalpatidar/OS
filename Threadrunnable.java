class Thread1 implements Runnable{
   public void run(){
       System.out.println("Thread by immplementing Runnable Interface");
   }
    public static void main(String args[]){
        Thread1 t = new Thread1();
        Thread t1 = new Thread(t);
        t1.start();
    }
}