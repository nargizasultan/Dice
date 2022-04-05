package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);
        Stack<Integer> usersStack = new Stack<>();
        Stack<Integer> computersStack = new Stack<>();
        Stack<Integer> thirdStageUsers = new Stack<>();
        Stack<Integer> thirdStageComp = new Stack<>();

        for (int i = 0; i < 5; i++) {

            if (i == 0) {
                System.out.println("-------Start game--------");
                System.out.println("        Round 1          ");
            }
            if (i ==1) {
                System.out.println("-------Start game--------");
                System.out.println("        Round 2          ");
            }
            if (i ==2) {
                System.out.println("-------Start game--------");
                System.out.println("        Round 3          ");
            }


            System.out.print("Predict amount of points(2..12): ");
            int input = scanner.nextInt();

            Dice dice1 = new Dice();
            Dice dice2 = new Dice();
            if (i < 2) {
                usersStack.push(input);
                System.out.println("User rolls the dices...");


                System.out.println();
            } else {
                thirdStageUsers.push(input);

            }

            Dice dice = new Dice();
            dice.throwADice();

            dice1.throwADice();
            int total = dice.getScore() + dice1.getScore();
            if (i < 2) {
                usersStack.push(total);
                System.out.printf("On the dice fell %d points.\n", total);
            } else {
                thirdStageUsers.push(total);
            }

            int x = total - Math.abs(total - input) * 2;
            if (i < 2) {
                usersStack.push(x);
                System.out.printf("Result is %d - abs(%d-%d)*2: %d points\n ", total, total, input, x);

                System.out.println(x > 0 ? "User win!" : "User lose!");
                System.out.println();
            } else {
                thirdStageUsers.push(x);
            }


            Computer computer = new Computer();
            if(i<2){
                System.out.printf("Computer predicted %d points \n", computer.getRandomComputerNumber());
                computersStack.push(computer.getRandomComputerNumber());
            }else{
                thirdStageComp.push(computer.getRandomComputerNumber());
            }


            System.out.println("Computer rolls the dices...");

            dice2.throwADice();
            System.out.println();

            Dice dice3 = new Dice();
            dice3.throwADice();
            int total1 = dice2.getScore() + dice3.getScore();
            computersStack.push(total1);
            if(i<2){
                System.out.printf("On the dice fell %d points\n", total1);
            }

            int x1 = total1 - Math.abs(total1 - computer.getRandomComputerNumber()) * 2;
            if(x<2){
                computersStack.push(x1);
                System.out.printf("Result is %d - abs(%d-%d)*2: %d points\n ", total1, total1, computer.getRandomComputerNumber(), x1);
                if (x > x1) {
                    System.out.printf("User win %d points more!\n", x - x1);

                } else if (x == x1) {
                    System.out.println("Points are equal");
                } else {
                    System.out.printf("User win %d points more!\n", x1 - x);
                }
            }else{
                thirdStageComp.push(x1);
            }


            System.out.println();


//                System.out.println("Congratulations");
//                System.out.println();
//                System.out.println("----------Current score------------");
//                System.out.printf("User: %d points\n", x);
//                System.out.printf("Computer: %d points\n", x1);
//                System.out.printf(x > x1 ? "User is ahead by " + (x - x1) + "points" : "Computer is ahead by " + (x1 - x) + "points\n");
//                System.out.println("------------------------------------");


        }
        int users = usersStack.get(2) + usersStack.get(5) + usersStack.get(8);
        int comps = computersStack.get(2) + computersStack.get(5) + computersStack.get(8);


        System.out.println("------------------finish game----------------");
        System.out.printf("Round |       User       |     Computer    \n" +
                        "------+---------------   +-----------------\n" +
                        "      | Predicted:  %d   | Predicted: %d  \n" +
                        "  -1- | Dice:       %d   | Dice:      %d  \n" +
                        "      | Result:     %d   | Result:    %d  \n" +
                        "------+------------------+----------------\n" +
                        "      | Predicted:  %d   | Predicted: %d  \n" +
                        "  -2- | Dice:       %d   | Dice:      %d  \n" +
                        "      | Result:     %d   | Result:    %d  \n" +
                        "------+------------------+----------------\n" +
                        "------+------------------+----------------\n" +
                        "      | Predicted:  %d   | Predicted: %d  \n" +
                        "  -3- | Dice:       %d   | Dice:      %d  \n" +
                        "      | Result:     %d   | Result:    %d  \n" +

                        "------+------------------+----------------\n" +
                        " Total| Points:     %d   |Points:     %d",
                usersStack.pop(), computersStack.pop(),
                usersStack.pop(), computersStack.pop(),
                usersStack.pop(), computersStack.pop(),
                usersStack.pop(), computersStack.pop(),
                usersStack.pop(), computersStack.pop(),
                usersStack.pop(), computersStack.pop(),
                usersStack.pop(), computersStack.pop(),
                usersStack.pop(), computersStack.pop(),
                usersStack.pop(), computersStack.pop(),
                users, comps
        );


    }
}
