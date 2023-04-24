public class Kaca extends NonMakanan {
    public Kaca(){
        super(10, 2, 1);
    }
    public void berkaca(){
        //sim.setStatus("Sim sedang berkaca");
        System.out.println("Sim sedang berkaca...");
        Thread t = new Thread(()->{
        try{
                Thread.sleep(1000); //1 detik berkaca
                //sim.getKesejahteraan().setMood(1); //namabah mood 1
                //sim.getKesejahteraan().setHunger(-1); //ngurang kenyang 1
                System.out.println("Proses berkaca selesai");
            }
            catch(InterruptedException e){
                System.out.println("Proses berkaca terganggu");
            }
        });
        t.start();
        try{
            t.join();
        }catch(InterruptedException e){
            System.out.println("Proses berkaca terganggu");
        }
    }
}

/**
 * RUN DI MAIN NYA GINI
 *      Kaca k1 = new Kaca();
 *      k1.berkaca();

 */