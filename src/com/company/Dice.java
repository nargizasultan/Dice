package com.company;

import java.util.Random;
import java.util.Stack;

public class Dice {
    private int score;
    private int penalty;

    private int number;
    static Stack<Integer> usersStack = new Stack<>();
    static Stack<Integer> computersStack = new Stack<>();
    static Stack<Integer> thirdStageUsers = new Stack<>();
    static Stack<Integer> thirdStageComp = new Stack<>();

    public Dice() {
    }

    public  void throwADice(){
       switch (number){
           case 1:
               Sides.firstSide();
               score+=number;
               break;
           case 2:
               Sides.secondSide();
               score+=number;
               break;
           case 3:
               Sides.thirdSide();
               score+=number;
               break;
           case 4:
               Sides.forthSide();
               score+=number;
               break;
           case 5:
               Sides.fifthSide();
               score+=number;
               break;
           case 6:
               Sides.sixthSide();
               score+=number;
               break;
       }
    }




    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}