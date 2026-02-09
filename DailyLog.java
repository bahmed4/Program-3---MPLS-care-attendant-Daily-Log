/*	
    
    Course: COMP 170, Fall 1 2026
    System: Visual Studio Code, Mac OS
    Author: Bilal Ahmed

*/
import java.util.Scanner;

public class DailyLog {
    public static void main(String[] args) throws Exception {

        Scanner scnr = new Scanner(System.in);

        // DECLARATIONS & CONSTANTS (Requirement #1)
        final int NOAH = 11, SILAS = 22, CHRIS = 33, MYA = 44, QUIT = -1;
        
        // Tally Variables (Requirement #3)
        int totalDogs = 0;
        int rCount = 0, gCount = 0, yCount = 0, bCount = 0;
        int rTime = 0, gTime = 0, yTime = 0, bTime = 0;

        // Initialize variables to satisfy compiler safety
        int attendantId = 0, dogId = 0, timeSpent = 0;
        String dogNote = "";

        // WELCOME MESSAGE
        System.out.println("Welcome to the MPLS care attendant daily log program.");
        System.out.println("  ");
        System.out.println("This program will allow you to enter a care attendant id and produce a log for the dogs under the attendant's care.");
        System.out.println("");

        // PRIMING READ - Initial input before the loop
        System.out.println("Enter 11 for Noah Charles");
        System.out.println("Enter 22 for Silas Alexander");
        System.out.println("Enter 33 for Chris Isaac");
        System.out.println("Enter 44 for Mya Lynn");
        System.out.println("To get started, please enter a care attendant's id from the list above");
        System.out.print("Enter ID #: ");
        attendantId = scnr.nextInt();

        // Initial Defensive Validation (Requirement #2)
        while (attendantId != NOAH && attendantId != SILAS && attendantId != CHRIS && 
               attendantId != MYA && attendantId != QUIT) {
            System.out.println("Sorry, Invalid attendant ID #, please enter a valid id.");
            System.out.print("Enter ID #: ");
            attendantId = scnr.nextInt();
        }

        // MAIN LOOP (Controlled by sentinel value, no break statements used)
        while (attendantId != QUIT) {

            // Noah's Logic (Groups: BLUE and RED)
            if (attendantId == NOAH) {
                System.out.println("\nEnter 348 for Badger\nEnter 301 for Hoosier\nEnter 388 for Husker\nEnter 391 for Bucky\nEnter 362 for Nittany\nEnter 311 for Wolvey");
                System.out.print("Noah, enter id # from the dogs above:");
                dogId = scnr.nextInt();
                while (dogId != 348 && dogId != 301 && dogId != 388 && dogId != 391 && dogId != 362 && dogId != 311) {
                    System.out.print("Sorry, Invalid dog ID, Please enter \nan applicable dog id number\nDog id:");
                    dogId = scnr.nextInt();
                }
                if (dogId == 362 || dogId == 311) bCount++; else rCount++;
            } 
            // Silas's Logic (Groups: GREEN and YELLOW)
            else if (attendantId == SILAS) {
                System.out.println("\nEnter 325 for Spartan\nEnter 388 for Hawk\nEnter 333 for Gopher");
                System.out.print("Silas, enter id # from the dogs above:");
                dogId = scnr.nextInt();
                while (dogId != 325 && dogId != 388 && dogId != 333) {
                    System.out.print("Sorry, Invalid dog ID, Please enter \nan applicable dog id number\nDog id:");
                    dogId = scnr.nextInt();
                }
                if (dogId == 325) gCount++; else yCount++;
            }
            // Chris's Logic (Groups: BLUE and YELLOW)
            else if (attendantId == CHRIS) {
                System.out.println("\nEnter 362 for Nittany\nEnter 311 for Wolvey\nEnter 388 for Hawk\nEnter 333 for Gopher");
                System.out.print("Chris, enter id # from the dogs above:");
                dogId = scnr.nextInt();
                while (dogId != 362 && dogId != 311 && dogId != 388 && dogId != 333) {
                    System.out.print("Sorry, Invalid dog ID, Please enter \nan applicable dog id number\nDog id:");
                    dogId = scnr.nextInt();
                }
                if (dogId == 362 || dogId == 311) bCount++; else yCount++;
            }
            // Mya's Logic (Groups: RED and GREEN)
            else if (attendantId == MYA) {
                System.out.println("\nEnter 348 for Badger\nEnter 301 for Hoosier\nEnter 388 for Husker\nEnter 391 for Bucky\nEnter 325 for Spartan");
                System.out.print("Mya, enter id # from the dogs above:");
                dogId = scnr.nextInt();
                while (dogId != 348 && dogId != 301 && dogId != 388 && dogId != 391 && dogId != 325) {
                    System.out.print("Sorry, Invalid dog ID, Please enter \nan applicable dog id number\nDog id:");
                    dogId = scnr.nextInt();
                }
                if (dogId == 325) gCount++; else rCount++;
            }

            // Common Inputs for all attendants
            System.out.print("Enter total number of minutes spent with dog: ");
            timeSpent = scnr.nextInt();
            scnr.nextLine(); // Clear scanner buffer
            System.out.print("Enter note about dog: ");
            dogNote = scnr.nextLine();

            // Tally Time (Requirement #3 - considering 388 edge cases)
            if (attendantId == NOAH || attendantId == MYA) {
                if (dogId == 325) gTime += timeSpent;
                else if (dogId == 362 || dogId == 311) bTime += timeSpent;
                else rTime += timeSpent; // 388 is RED for Noah/Mya
            } else {
                if (dogId == 325) gTime += timeSpent;
                else if (dogId == 362 || dogId == 311) bTime += timeSpent;
                else yTime += timeSpent; // 388 is YELLOW for Silas/Chris
            }

            // INDIVIDUAL SUMMARY BOX
            System.out.println("Dog Information:");
            System.out.println("*********************************");
            System.out.println("Attendant ID #:\t" + attendantId);
            System.out.println("Dog ID #:\t" + dogId);
            System.out.println("Min. w/Dog:\t" + (double)timeSpent);
            System.out.println("Notes:\t" + dogNote);
            System.out.println("*********************************");
            System.out.println("");

            totalDogs++;

            // UPDATE READ - Asking for next input to control loop exit
            System.out.println("Enter 11 for Noah Charles");
            System.out.println("Enter 22 for Silas Alexander");
            System.out.println("Enter 33 for Chris Isaac");
            System.out.println("Enter 44 for Mya Lynn");
            System.out.print("Enter another ID # or enter -1 to exit: ");
            attendantId = scnr.nextInt();

            // Validate next ID before re-entering loop logic
            while (attendantId != NOAH && attendantId != SILAS && attendantId != CHRIS && 
                   attendantId != MYA && attendantId != QUIT) {
                System.out.println("Sorry, Invalid attendant ID #, please enter a valid id.");
                System.out.print("Enter ID #: ");
                attendantId = scnr.nextInt();
            }
        } // End Main Loop

        // FINAL SUMMARY (Requirement #3)
        System.out.println("Thanks for entering your dog logs");
        System.out.println("*************************************");
        System.out.println("Total # of log entries: " + totalDogs);
        System.out.println("\tRed total count: " + rCount + " \tRed total # of min.: " + rTime);
        System.out.println("\tGreen total count: " + gCount + " \tGreen total # of min.: " + gTime);
        System.out.println("\tYellow total count: " + yCount + " \tYellow total # of min.: " + yTime);
        System.out.println("\tBlue total count: " + bCount + " \tBlue total # of min.: " + bTime);
    }
}