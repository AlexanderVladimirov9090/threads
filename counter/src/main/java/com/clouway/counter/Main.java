package com.clouway.counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.clouway.counter.ThreadTool.kill;

/**
 * Created by zumba on 29.07.16.
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Count to:");
        Thread thread = new Thread(new Counter(Integer.valueOf(bufferedReader.readLine())));
        System.out.println("Enter delay in milli seconds:");
        int killTime = Integer.valueOf(bufferedReader.readLine());
        long threadStartTime = System.currentTimeMillis();
        thread.start();
        kill(thread, threadStartTime, killTime);
    }
}

