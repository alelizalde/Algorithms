package com.practices.threads;

import java.util.Random;
import java.util.concurrent.*;

public class Semaphores {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        semaphore.acquire();
        System.out.println("Available permits: " + semaphore.availablePermits());
        semaphore.release();
        System.out.println("Available permits: " + semaphore.availablePermits());

    }
}
