class myThread3 extends Thread
{
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
    }
  
}
class myThread4 extends Thread
{
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
    }
}
class myThread5 extends Thread
{
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
    }
}
class myMain
{
    public static void main(String[] args) throws InterruptedException 
    {
        myThread3 m3=new myThread3();
        myThread4 m4=new myThread4();
        myThread5 m5=new myThread5();
        m3.setName("t1");
        m4.setName("t2");
        m5.setName("t3");
        m3.start();
        m4.start();
        m5.start();
    }
}