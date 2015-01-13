package com.theappbusiness.resources;

public class ResourceUtils {

    public static final void delay() {
        delay(5000);
    }

    public static final void delay(int delayMilis) {
        try {
            Thread.sleep(delayMilis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
