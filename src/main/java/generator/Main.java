package generator;

import generator.Sender.Sender;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main( String [] args ) throws InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(100);

       for (int i=1; i<=1000;i++)
        executorService.execute(new Sender(i));
//        executorService.execute(new Sender(2));
//        executorService.execute(new Sender(3));
//        executorService.execute(new Sender(4));
//        executorService.execute(new Sender(5));


        executorService.shutdown();


    }




}
