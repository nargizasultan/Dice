package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        char choice = 0;
//        do {
            Scanner scanner = new Scanner(System.in);
            Stack<Integer> usersStack = new Stack<>();
            Stack<Integer> computersStack = new Stack<>();
            int counter = 0;
            while (counter < 3) {
                System.out.println("-------Start game--------");
                System.out.println();
                System.out.print("Predict amount of points(2..12): ");
                int input = scanner.nextInt();
                System.out.print("Do you want to cheat? (Y/N): ");
                Dice dice1 = new Dice();
                Dice dice2 = new Dice();
//                choice = scanner.next().charAt(0);
//                if (choice == 'Y' || choice == 'y') {
//                    if (counter == 0) {
//                        int a = random.nextInt(2);
//                        if (a == 1) {
//                            dice1.toCheat(input);
//
//                        } else {
//                            dice1.setScore(dice1.getScore() - 10);
//                        }
//                    }
//                    if (counter == 1) {
//                        int a = random.nextInt(4);
//                        if (a == 1) {
//                            dice1.toCheat(input);
//                        } else {
//                            dice1.setScore(dice1.getScore() - 10);
//                        }
//                    }
//                    if (counter == 2) {
//                        int a = random.nextInt(6);
//                        if (a == 1) {
//                            dice1.toCheat(input);
//                        } else {
//                            dice1.setScore(dice1.getScore() - 10);
//                        }
//                    }
//
//                }
                usersStack.push(input);
                System.out.println("User rolls the dices...");

                Dice dice = new Dice();

                dice.throwADice();
                System.out.println();

//                Dice dice1 = new Dice();
                dice1.throwADice();
                int total = dice.getScore() + dice1.getScore();
                usersStack.push(total);
                System.out.printf("On the dice fell %d points.\n", total);
                int x = Math.abs(total - input) * 2;
                usersStack.push(x);
                System.out.printf("Result is %d - abs(%d-%d)*2: %d points\n ", total, total, input, x);

                System.out.println(x > 0 ? "User win!" : "User lose!");
                System.out.println();


                Computer computer = new Computer();
                System.out.printf("Computer predicted %d points \n", computer.getRandomComputerNumber());
                computersStack.push(computer.getRandomComputerNumber());
                System.out.println("Computer rolls the dices...");
//                Dice dice2 = new Dice();
                dice2.throwADice();
                System.out.println();

                Dice dice3 = new Dice();
                dice3.throwADice();
                int total1 = dice2.getScore() + dice3.getScore();
                computersStack.push(total1);
                System.out.printf("On the dice fell %d points\n", total1);
                int x1 = Math.abs(total1 - computer.getRandomComputerNumber()) * 2;
                computersStack.push(x1);
                System.out.printf("Result is %d - abs(%d-%d)*2: %d points\n ", total1, total1, computer.getRandomComputerNumber(), x1);
                System.out.println();

                if (x > x1) {
                    System.out.printf("User win %d points more!", x - x1);

                } else if (x == x1) {
                    System.out.println("Points are equal");
                } else {
                    System.out.printf("User win %d points more!", x1 - x);
                }
                System.out.println("Congratulations");
                System.out.println();
                System.out.println("----------Current score------------");
                System.out.printf("User: %d points\n", x);
                System.out.printf("Computer: %d points\n", x1);
                System.out.printf(x > x1 ? "User is ahead by " + (x - x1) + "points" : "Computer is ahead by " + (x1 - x) + "points");
                System.out.println("------------------------------------");

                counter++;
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

//        } while (choice != 'q' || choice != 'Q');
    }
}
