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
        String answer;

        System.out.println("Hello! Welcome to the Pig Game!");

        do {
            System.out.print("Do you want to start a new game? (Y/N):");
            answer = scanner.nextLine(); //Nextline for player
        } while(
            !(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N"))
            );
        System.out.println();

        boolean IsContinue = answer.equalsIgnoreCase("Y");
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
                    System.out.println("\nYou won with ["+(sum + PlayerScore)+"] points\n");
                    
                    do {
                        System.out.print("Do you want to start a new game? (Y/N):");
                        answer = scanner.nextLine(); //Pag tapos na tatanungin kanya kung maglalaro pa ulit
                    } while(
                        !(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N"))
                        );

                    IsContinue = answer.equalsIgnoreCase("Y"); //depende sa sagot yung loop

                    PlayerScore = 0; // reset
                    ComputerScore = 0; // reset
                    continue loop;
                }

                do {
                System.out.print("Keep Going? (Y/N):"); //
                isRollAgain = scanner.nextLine();
                }while(
                    !(isRollAgain.equalsIgnoreCase("Y") || isRollAgain.equalsIgnoreCase("N"))
                    ); //mag loloop kapag nag enter ng Y/N

            }
            while (isRollAgain.equalsIgnoreCase("Y"));
            System.out.println("Turn ended. You earned "+ sum + " points"); 
            PlayerScore = PlayerScore + sum;
            System.out.println();
            
            sum = 0;
            System.out.println("--- COMPUTER TURN ----");
        do {
            RollValue = dice.nextInt(6) + 1;
            System.out.println("The dice rolled " + RollValue);
            if (RollValue ==1){
                sum = 0;
                break;
            }

            sum = sum + RollValue; //yung sum plus nya yung roll value

            if (sum + ComputerScore >= 100){
                System.out.println("\nComputer won with ["+(sum+ComputerScore)+"]\n");
                do {
                    System.out.print("Do you want to start a new game? (Y/N):");
                    answer = scanner.nextLine();
                } while(
                    !(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N"))
                    );
                
                IsContinue = answer.equalsIgnoreCase("Y");
                PlayerScore = 0;
                ComputerScore = 0;
                continue loop;
            }
            System.out.print("Keep Going? (Y/N):");
            isComputerContinue = Computer.nextInt(2) == 0; // 0 yes, 1 no
            System.out.println(isComputerContinue?"Y":"N");
        }
        while (isComputerContinue);
        System.out.println("Turn ended. Computer earned " + sum + " points");
        ComputerScore = ComputerScore + sum;
        System.out.println();
        sum = 0;
        }

    }
}