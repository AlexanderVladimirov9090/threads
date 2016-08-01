package com.clouway.counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zumba on 29.07.16.
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ThreadMonitor threadMonitor = new ThreadMonitor();
        long threadStartTime = System.currentTimeMillis();

        System.out.println("Count to:");
        Thread thread = new Thread(new Counter(Integer.valueOf(bufferedReader.readLine())));

        System.out.println("Enter delay in milli seconds:");
        int waitTime = Integer.valueOf(bufferedReader.readLine());

        thread.start();
        threadMonitor.kill(thread, threadStartTime, waitTime);
    }
}

