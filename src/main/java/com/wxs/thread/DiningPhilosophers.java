package com.wxs.thread;

import java.util.concurrent.Semaphore;

class DiningPhilosophers {


    private Semaphore[] sem = new Semaphore[5];

    public DiningPhilosophers() {

        for (int i = 0; i <= 4; i++) {
            sem[i] = new Semaphore(1);
        }
    }


    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        Semaphore left = sem[philosopher];

        Semaphore right = philosopher == 0 ? sem[4] : sem[philosopher - 1];


        if (philosopher % 2 == 0) {

            left.acquire();
            pickLeftFork.run();

            right.acquire();
            pickRightFork.run();

            eat.run();

            putLeftFork.run();
            left.release();
            putRightFork.run();
            right.release();
        } else {
            right.acquire();
            pickRightFork.run();

            left.acquire();
            pickLeftFork.run();

            eat.run();

            putRightFork.run();
            right.release();

            putLeftFork.run();
            left.release();

        }

    }
}