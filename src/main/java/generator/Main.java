package generator;

import generator.Sender.Sender;
import generator.config.Config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main( String [] args ) throws InterruptedException {

        Config config = new Config();

        ExecutorService executorService = Executors.newFixedThreadPool(1000);


       for (int i=1; i<=1000;i++)
            executorService.execute(new Sender(i,config.getProperty()));

        executorService.shutdown();


    }




}
