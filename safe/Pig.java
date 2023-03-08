package com.hello;
import java.util.Random;
import java.util.Scanner;
public class Pig {

    public static void main(String[] args) {
       Random dice = new Random (); //Random for dice
       Random Computer = new Random(); //Random for Computer
       Scanner scanner = new Scanner (System.in); 
        int PlayerScore = 0;
        int ComputerScore = 0;
        System.out.println("Hello! Welcom to the Pig Game!");
        System.out.print("Play again?");
        String answer = scanner.nextLine(); //Nextline for player
        boolean IsContinue = answer.equals("Y");
        String isRollAgain;
        int RollValue; //Ito yung mga na roll
        int sum = 0; //ipaplus yung mga na roll
        boolean isComputerContinue; //Computer will roll again?
        loop:
        while (IsContinue){ 
           System.out.println("---- YOUR TURN ----");
            do {
                RollValue = dice.nextInt(6) + 1; //Dice sides
                System.out.println("The dice rolled " + RollValue);
                if (RollValue == 1){ /* pag nag 1 mawawala score. pag hindi nag 1 dagdag sa sum */
                    sum = 0; //reset
                    break; 
                     }
                sum = sum + RollValue; /* yung sum plus nya yung roll value*/
                if (sum + PlayerScore >= 100){ //pag 100 pataas panalo na
                    System.out.println("You won");
                    System.out.print("Play Again?");
                    answer = scanner.nextLine(); //Pag tapos na tatanungin kanya kung maglalaro pa ulit
                    IsContinue = answer.equals("Y"); //depende sa sagot yung loop
                    PlayerScore = 0; // reset
                    ComputerScore = 0; // reset
                    continue loop;
                }
                System.out.print("Roll again?");
                isRollAgain = scanner.nextLine(); 
            }
            while (isRollAgain.equals("Y"));
            System.out.println("Your total earn "+ sum);
            PlayerScore = PlayerScore + sum;
            sum = 0;
            System.out.println("Computers turn");
        do {
            RollValue = dice.nextInt(6) + 1;
            System.out.println("The dice rolled " + RollValue);
            if (RollValue ==1){
                sum = 0;
                break;
            }
            sum = sum + RollValue;
            if (sum + ComputerScore >= 100){
                System.out.println("Computer Won");
                System.out.print("Play Again?");
                answer = scanner.nextLine();
                IsContinue = answer.equals("Y");
                PlayerScore = 0;
                ComputerScore = 0;
                continue loop;
            }
            isComputerContinue = Computer.nextInt(2) == 0;
        }
        while (isComputerContinue);
        System.out.println("Computer earn " + sum);
        ComputerScore = ComputerScore + sum;
        sum = 0;
        }

    }
}