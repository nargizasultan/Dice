package com.company;

import java.util.Random;
import java.util.Scanner;
import static com.company.Dice.*;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.println("-------Start game--------");
            System.out.printf(i == 0 ? "        Round 1          \n" : "        Round 2           \n");

            System.out.print("Predict amount of points(2..12): ");
            int input = scanner.nextInt();
            exception(input);
            System.out.println("Do u want to cheat? Y/N");
            String choice = scanner1.nextLine();
            Dice dice1 = new Dice();
            Dice dice2 = new Dice();

            if (choice.equals("y") || choice.equals("Y")) {
                if (i == 0) {
                    int random1 = random.nextInt(2);
                    System.out.println("User rolls the dices...");
                    if (random1 == 0) {
                        getRandomForCheating(dice1, dice2, input);
                    } else {
                        getRandom(dice1, dice2);
                        dice1.setScore(dice1.getScore() - 10);
                    }
                } else if (i == 1) {
                    int random1 = random.nextInt(4);
                    System.out.println("User rolls the dices...");
                    if (random1 == 0) {
                        getRandomForCheating(dice1, dice2, input);
                    } else {
                        getRandom(dice1, dice2);
                        dice1.setScore(dice1.getScore() - 10);
                    }

                }
            } else {
                getRandom(dice1, dice2);

            }
            usersStack.push(input);
            System.out.println();
            int total = dice1.getScore() + dice2.getScore();

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
            getRandom(dice2, dice3);
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
            exception(input);
            System.out.println("Do u want to cheat? Y/N");
            String choice = scanner1.nextLine();

            Dice dice3 = new Dice();
            Dice dice4 = new Dice();
            if (choice.equals("y") || choice.equals("Y")) {

                int random1 = random.nextInt(6);
                System.out.println("User rolls the dices...");
                if (random1 == 0) {
                    getRandomForCheating(dice3, dice4, input);

                } else {

                    getRandom(dice3, dice4);
                    dice3.setScore(dice4.getScore() - 10);
                }
            } else if (i == 1) {
                int random1 = random.nextInt(4);
                System.out.println("User rolls the dices...");
                if (random1 == 0) {
                    getRandomForCheating(dice3, dice4, input);
                } else {
                    getRandom(dice3, dice4);
                    dice3.setScore(dice4.getScore() - 10);
                }


            } else {
                getRandom(dice3, dice4);

            }

            thirdStageUsers.push(input);


            System.out.println();


            int total = dice3.getScore() + dice4.getScore();

            thirdStageUsers.push(total);
            System.out.printf("On the dice fell %d points.\n", total);


            int x = total - Math.abs(total - input) * 2;

            thirdStageUsers.push(x);

            System.out.println();
            Dice dice5 = new Dice();
            Dice dice6 = new Dice();

            Computer computer = new Computer();
            System.out.printf("Computer predicted %d points \n", computer.getRandomComputerNumber());
            thirdStageComp.push(computer.getRandomComputerNumber());
            System.out.println("Computer rolls the dices...");
            dice5.throwADice();
            System.out.println();
            dice6.throwADice();
            int total1 = dice5.getScore() + dice6.getScore();
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
                usersStack.get(0), computersStack.get(0),
                usersStack.get(1), computersStack.get(1),
                usersStack.get(2), computersStack.get(2),
                usersStack.get(3), computersStack.get(3),
                usersStack.get(4), computersStack.get(4),
                usersStack.get(5), computersStack.get(5),

                sumOfPredicts, sumOfPredictsComp,
                sumOfDice, sumOfDiceComp,
                sumOfResult, sumOfResultComp,
                users, comps
        );


    }

    public static void getRandom(Dice dice1, Dice dice2) {
        Random random = new Random();
        int random3 = random.nextInt(1, 7);
        dice1.setNumber(random3);
        dice1.throwADice();
        System.out.println();
        int random4 = random.nextInt(1, 7);
        dice2.setNumber(random4);
        dice2.throwADice();
    }

    public static void getRandomForCheating(Dice dice1, Dice dice2, int input) {

        if (input % 2 == 0) {
            dice1.setNumber(input / 2);
            dice1.throwADice();
            System.out.println();
            dice2.setNumber(input / 2);
            dice2.throwADice();
        } else {
            dice1.setNumber(input / 2 + 1);
            dice1.throwADice();
            System.out.println();
            dice2.setNumber(input / 2);
            dice2.throwADice();
        }
    }
    public static void exception(int input){
        try {
            if (input < 2 || input > 12) {
                throw new InvalidNumberException();
            }
        }catch (InvalidNumberException e){
            System.err.printf("Number %d if not valid\n", input);
        }
    }


}
