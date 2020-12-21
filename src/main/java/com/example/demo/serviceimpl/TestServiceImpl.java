package com.example.demo.serviceimpl;

import com.example.demo.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public ResponseEntity<?> RunCPUTest() throws InterruptedException {
        int numThreads = 8;



        LongAdder counter = new LongAdder();

        List<CalculationThread> runningCalcs = new ArrayList<>();
        List<Thread> runningThreads = new ArrayList<>();

        System.out.printf("Starting %d threads\n", numThreads);

        for (int i = 0; i < numThreads; i++)
        {
            CalculationThread r = new CalculationThread(counter);
            Thread t = new Thread(r);
            runningCalcs.add(r);
            runningThreads.add(t);
            t.start();
        }
        double count=0;
        for (int i = 0; i < 30; i++)
        {
            counter.reset();
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                break;
            }
            count+=(double)(counter.longValue()) / numThreads;
            System.out.printf("[%d] Calculations per second: %d (%.2f per thread)\n",
                    i,
                    counter.longValue(),
                    (double)(counter.longValue()) / numThreads
            );
        }
        count=count/30;
        for (int i = 0; i < runningCalcs.size(); i++)
        {
            runningCalcs.get(i).stop();
            runningThreads.get(i).join();
        }
        return new ResponseEntity<>(String.valueOf(count), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> RunCPULongTest() throws InterruptedException {
        int numThreads = 16;



        LongAdder counter = new LongAdder();

        List<CalculationThread> runningCalcs = new ArrayList<>();
        List<Thread> runningThreads = new ArrayList<>();

        System.out.printf("Starting %d threads\n", numThreads);

        for (int i = 0; i < numThreads; i++)
        {
            CalculationThread r = new CalculationThread(counter);
            Thread t = new Thread(r);
            runningCalcs.add(r);
            runningThreads.add(t);
            t.start();
        }
        double count=0;
        for (int i = 0; i < 300; i++)
        {
            counter.reset();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                break;
            }
            count+=(double)(counter.longValue()) / numThreads;
            System.out.printf("[%d] Calculations per second: %d (%.2f per thread)\n",
                    i,
                    counter.longValue(),
                    (double)(counter.longValue()) / numThreads
            );
        }
        count=count/300;
        for (int i = 0; i < runningCalcs.size(); i++)
        {
            runningCalcs.get(i).stop();
            runningThreads.get(i).join();
        }
        return new ResponseEntity<>(String.valueOf(count), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> RunCPUSingleTest() throws InterruptedException {
        int numThreads = 1;



        LongAdder counter = new LongAdder();

        List<CalculationThread> runningCalcs = new ArrayList<>();
        List<Thread> runningThreads = new ArrayList<>();

        System.out.printf("Starting %d threads\n", numThreads);

        for (int i = 0; i < numThreads; i++)
        {
            CalculationThread r = new CalculationThread(counter);
            Thread t = new Thread(r);
            runningCalcs.add(r);
            runningThreads.add(t);
            t.start();
        }
        double count=0;
        for (int i = 0; i < 1; i++)
        {
            counter.reset();
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                break;
            }
            count+=(double)(counter.longValue()) / numThreads;
            System.out.printf("[%d] Calculations per second: %d (%.2f per thread)\n",
                    i,
                    counter.longValue(),
                    (double)(counter.longValue()) / numThreads
            );
        }
        for (int i = 0; i < runningCalcs.size(); i++)
        {
            runningCalcs.get(i).stop();
            runningThreads.get(i).join();
        }
        return new ResponseEntity<>(String.valueOf(count), HttpStatus.OK);
    }

    public static class CalculationThread implements Runnable
    {
        private final Random rng;
        private final LongAdder calculationsPerformed;
        private boolean stopped;
        private double store;

        public CalculationThread(LongAdder calculationsPerformed)
        {
            this.calculationsPerformed = calculationsPerformed;
            this.stopped = false;
            this.rng = new Random();
            this.store = 1;
        }

        public void stop()
        {
            this.stopped = true;
        }

        @Override
        public void run()
        {
            while (! this.stopped)
            {
                double r = this.rng.nextFloat();
                double v = Math.sin(Math.cos(Math.sin(Math.cos(r))));
                this.store *= v;
                this.calculationsPerformed.add(1);
            }
        }
    }
}
