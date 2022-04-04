package com.company;

import java.util.Random;

public class Dice {
    private int score;
    private int penalty;
     Random random=new Random();
     int  number= random.nextInt(1, 7);
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
//    public  void toCheat(int cheatingNumber){
//        switch (cheatingNumber){
//            case 1:
//                Sides.firstSide();
//                score+=number;
//                break;
//            case 2:
//                Sides.secondSide();
//                score+=number;
//                break;
//            case 3:
//                Sides.thirdSide();
//                score+=number;
//                break;
//            case 4:
//                Sides.forthSide();
//                score+=number;
//                break;
//            case 5:
//                Sides.fifthSide();
//                score+=number;
//                break;
//            case 6:
//                Sides.sixthSide();
//                score+=number;
//                break;
//            case 7:
//                Sides.firstSide();
//                System.out.println();
//                Sides.sixthSide();
//                score+=number;
//                break;
//            case 8:
//                Sides.forthSide();
//                System.out.println();
//                Sides.secondSide();
//                score+=number;
//                break;
//            case 9:
//                Sides.thirdSide();
//                System.out.println();
//                Sides.sixthSide();
//                score+=number;
//                break;
//            case 10:
//                Sides.fifthSide();
//                System.out.println();
//                Sides.fifthSide();
//                score+=number;
//                break;
//            case 11:
//                Sides.fifthSide();
//                System.out.println();
//                Sides.sixthSide();
//                score+=number;
//                break;
//            case 12:
//                Sides.sixthSide();
//                System.out.println();
//                Sides.sixthSide();
//                score+=number;
//                break;
//        }
//
//    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}