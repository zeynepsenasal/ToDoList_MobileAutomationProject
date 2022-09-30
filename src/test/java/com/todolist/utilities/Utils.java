package com.todolist.utilities;

public class Utils {

    public static void sleep(int second){
      second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
