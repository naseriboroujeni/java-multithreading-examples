package org.example11;

import java.util.Random;

public abstract class Train implements Runnable{

    Train(Intersection intersection) {
        this.intersection = intersection;
        this.random = new Random();
    }

    Intersection intersection;
    Random random;
}
