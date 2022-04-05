package com.company;

import java.util.Random;

public class Computer extends Dice {
    Random random = new Random();
    int randomComputerNumber = random.nextInt(12);

    public int getRandomComputerNumber() {
        return randomComputerNumber;
    }

    public void setRandomComputerNumber(int randomComputerNumber) {
        this.randomComputerNumber = randomComputerNumber;
    }


}

