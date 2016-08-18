package com.clouway.counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zumba on 29.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class Main {


    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Thread count to:");
            Thread thread = new Thread(new Counter(Integer.valueOf(bufferedReader.readLine())));
            System.out.println("Enter word for thread kill:");
            ThreadMonitor threadMonitor = new ThreadMonitor(bufferedReader.readLine());
            System.out.println("Enter word to kill thread:");
            thread.start();
            threadMonitor.kill(thread, String.valueOf(bufferedReader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

