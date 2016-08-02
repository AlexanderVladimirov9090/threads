package com.clouway.counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zumba on 29.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *
 */
public class Main {


    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            ThreadMonitor threadMonitor = new ThreadMonitor();
            System.out.println("Thread count to:");
            Thread thread = new Thread(new Counter(Integer.valueOf(bufferedReader.readLine())));
            System.out.println("Enter delay in milli seconds:");
            int waitTime = Integer.valueOf(bufferedReader.readLine());
            long threadStartTime = System.currentTimeMillis();
            thread.start();
            System.out.println(threadMonitor.kill(thread, threadStartTime, waitTime));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

