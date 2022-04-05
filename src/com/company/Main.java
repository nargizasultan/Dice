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

        for (int i = 0; i < 2; i++) {

            if (i == 0) {
                System.out.println("-------Start game--------");
                System.out.println("        Round 1          ");
            } else if (i == 1) {
                System.out.println("-------Start game--------");
                System.out.println("        Round 2          ");
            }

            System.out.print("Predict amount of points(2..12): ");
            int input = scanner.nextInt();

            Dice dice1 = new Dice();
            Dice dice2 = new Dice();

            usersStack.push(input);
            System.out.println("User rolls the dices...");


            System.out.println();


            Dice dice = new Dice();

            dice.throwADice();
            System.out.println();
            dice1.throwADice();

            int total = dice.getScore() + dice1.getScore();

            usersStack.push(total);
            System.out.printf("On the dice fell %d points.\n", total);


            int x = total - Math.abs(total - input) * 2;

            usersStack.push(x);
            System.out.printf("Result is %d - abs(%d-%d)*2: %d points\n ", total, total, input, x);

            System.out.println(x > 0 ? "User win!" : "User lose!");
            System.out.println();


            Computer computer = new Computer();
            System.out.printf("Computer predicted %d points \n", computer.getRandomComputerNumber());
            computersStack.push(computer.getRandomComputerNumber());
            System.out.println("Computer rolls the dices...");

            dice2.throwADice();
            System.out.println();

            Dice dice3 = new Dice();
            dice3.throwADice();
            int total1 = dice2.getScore() + dice3.getScore();
            computersStack.push(total1);
            System.out.printf("On the dice fell %d points\n", total1);
            int x1 = total1 - Math.abs(total1 - computer.getRandomComputerNumber()) * 2;
            computersStack.push(x1);
            System.out.printf("Result is %d - abs(%d-%d)*2: %d points\n ", total1, total1, computer.getRandomComputerNumber(), x1);
            System.out.println();

            if (x > x1) {
                System.out.printf("User win %d points more!\n", x - x1);

            } else if (x == x1) {
                System.out.println("Points are equal\n");
            } else {
                System.out.printf("User win %d points more!\n", x1 - x);
            }
            System.out.println();


        }
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.println("-------Start game--------");
                System.out.println("         Round 3 (1)         ");
            }
            if (i == 1) {
                System.out.println("-------Start game--------");
                System.out.println("         Round 3 (2)         ");
            }
            if (i == 2) {
                System.out.println("-------Start game--------");
                System.out.println("         Round 3 (3)         ");
            }


            System.out.print("Predict amount of points(2..12): ");
            int input = scanner.nextInt();

            Dice dice1 = new Dice();
            Dice dice2 = new Dice();

            thirdStageUsers.push(input);
            System.out.println("User rolls the dices...");


            System.out.println();


            Dice dice = new Dice();
            dice.throwADice();
            System.out.println();

            dice1.throwADice();
            int total = dice.getScore() + dice1.getScore();

            thirdStageUsers.push(total);
            System.out.printf("On the dice fell %d points.\n", total);


            int x = total - Math.abs(total - input) * 2;

            thirdStageUsers.push(x);

            System.out.println();


            Computer computer = new Computer();
            System.out.printf("Computer predicted %d points \n", computer.getRandomComputerNumber());
            thirdStageComp.push(computer.getRandomComputerNumber());
            System.out.println("Computer rolls the dices...");
            dice2.throwADice();
            System.out.println();

            Dice dice3 = new Dice();
            dice3.throwADice();
            int total1 = dice2.getScore() + dice3.getScore();
            thirdStageComp.push(total1);
            System.out.printf("On the dice fell %d points\n", total1);
            int x1 = total1 - Math.abs(total1 - computer.getRandomComputerNumber()) * 2;
            thirdStageComp.push(x1);
            //System.out.printf("Result is %d - abs(%d-%d)*2: %d points\n ", total1, total1, computer.getRandomComputerNumber(), x1);
            System.out.println();


            System.out.println();
            System.out.println("----------Current score------------");
            System.out.printf("User: %d points\n", x);
            System.out.printf("Computer: %d points\n", x1);
            System.out.printf(x > x1 ? "User is ahead by " + (x - x1) + " points\n" : "Computer is ahead by " + (x1 - x) + " points\n");
            System.out.println("------------------------------------");
            System.out.println();

        }


        int sumOfPredicts = thirdStageUsers.get(0) + thirdStageUsers.get(3) + thirdStageUsers.get(6);
        int sumOfDice = thirdStageUsers.get(1) + thirdStageUsers.get(4) + thirdStageUsers.get(7);
        int sumOfResult = thirdStageUsers.get(2) + thirdStageUsers.get(5) + thirdStageUsers.get(8);

        int sumOfPredictsComp = thirdStageComp.get(0) + thirdStageComp.get(3) + thirdStageComp.get(6);
        int sumOfDiceComp = thirdStageComp.get(1) + thirdStageComp.get(4) + thirdStageComp.get(7);
        int sumOfResultComp = thirdStageComp.get(2) + thirdStageComp.get(5) + thirdStageComp.get(8);
        int users = usersStack.get(2) + usersStack.get(5) + sumOfResult;
        int comps = computersStack.get(2) + computersStack.get(5) + sumOfResultComp;


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
                sumOfPredicts, sumOfPredictsComp,
                sumOfDice, sumOfDiceComp,
                sumOfResult, sumOfResultComp,
                users, comps
        );


    }
}
