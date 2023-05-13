//@author Shreyan Wankavala
//112634232

import java.util.Scanner;

public class LunchLineSimulator {

    private static StudentLine realityA = new StudentLine();
    private static StudentLine realityB = new StudentLine();


    public static void main(String[]args){

        Scanner scan = new Scanner(System.in);

        System.out.println("\n\nWelcome to the game CERTIFIED LUNCH LINE!. It is your time to shine! \nThese middle school kids are your puppets, and you are God. \nYou will start from reality A.\n");

        String command = "test";
        String reality = "A";

        while(!command.equals("Q")){

            System.out.print("\nMenu:\n" +
                    "     A) Add a student to the line at the end\n" +
                    "     C) Have a new student cut a friend\n" +
                    "     T) Have two students trade places\n" +
                    "     B) Have the bully remove a student\n" +
                    "     U) Update a student's money amount\n" +
                    "     S) Serve a student\n" +
                    "     P) Print the current reality's lunch line\n" +
                    "     O) Switch to the other reality\n" +
                    "     E) Check if the realities are equal\n" +
                    "     D) Duplicate this reality into the other reality\n" +
                    "     Q) Quit middle school and move on to real life.");

            System.out.print("\n\nPlease select an option: "); command = scan.nextLine();

            command = command.toUpperCase();

            if(command.equals("A")) {
                if (reality.equals("A")) {
                    try {
                        System.out.print("Please enter student name: ");
                        String name = scan.nextLine();

                        System.out.print("Please enter money amount: ");
                        double money = Double.parseDouble(scan.nextLine());

                        Student newStudent = new Student(name, money);

                        realityA.addStudent(realityA.numStudents(), newStudent);
                        if (money == 0.0) {
                            System.out.println("\nThe student has no money for lunch! He/She will have to leave the line.\n");
                            realityA.removeStudent(realityA.numStudents()-1);
                        }else if(money < 0){
                            System.out.println("\nThe student cannot be in debt! He/She will have to leave the line.\n");
                            realityA.removeStudent(realityA.numStudents()-1);
                        }else{
                            System.out.print("\n" + name + " has been added to the line in Position " + realityA.numStudents() + ". " + name + " has " + "$" + money + ".\n");
                        }
                    } catch (DeanException full) {
                        System.out.println("\nA student attempted to join a full lunch line. The Dean, Mr.Mean, has sent them to detention. He/She will not be added to the line.\n");
                    }
                }
                if (reality.equals("B")) {
                    try {
                        System.out.print("Please enter student name: ");
                        String name = scan.nextLine();

                        System.out.print("Please enter money amount: ");
                        double money = Double.parseDouble(scan.nextLine());
                        Student newStudent = new Student(name, money);

                        realityB.addStudent(realityB.numStudents(), newStudent);
                        if (money == 0.0) {
                            System.out.println("\nThe student has no money for lunch! He/She will have to leave the line.\n");
                            realityB.removeStudent(realityB.numStudents()-1);
                        }else if(money < 0){
                            System.out.println("\nThe student cannot be in debt! He/She will have to leave the line.\n");
                            realityB.removeStudent(realityB.numStudents()-1);
                        }else{
                            System.out.print("\n" + name + " has been added to the line in Position " + realityB.numStudents() + ". " + name + " has " + "$" + money + ".\n");
                        }                    } catch (DeanException full) {
                        System.out.println("\nA student attempted to join a full lunch line. The Dean, Mr.Mean, has sent them to detention. He/She will not be added to the line.\n");
                    }
                }
            }
            else if(command.equals("C")){
                if(reality.equals("A")) {
                    if(realityA.numStudents() != 20) {
                        System.out.print("Please enter student name: ");
                        String name = scan.nextLine();

                        System.out.print("Please enter money amount: ");
                        double money = Double.parseDouble(scan.nextLine());
                        Student newStudent = new Student(name, money);
                        if(money == 0){
                            System.out.println("\nThe student has no money for lunch! He/She will have to leave the line.\n");
                            continue;
                        }else if(money < 0){
                            System.out.println("\nThe student cannot be in debt! He/She will have to leave the line.\n");
                            continue;
                        }

                        System.out.print("Enter the student's index: ");
                        int index = Integer.parseInt(scan.nextLine());
                        if(index > realityA.numStudents()-1){
                            System.out.println("\nThere are no students at this index! Try again.\n");
                            continue;
                        }

                        realityA.cutFriend(index, newStudent);
                    }else{
                        System.out.print("Please enter student name: ");
                        String name = scan.nextLine();

                        System.out.print("Please enter money amount: ");
                        double money = Double.parseDouble(scan.nextLine());
                        Student newStudent = new Student(name, money);
                        if(money == 0){
                            System.out.println("\nThe student has no money for lunch! He/She will have to leave the line.\n");
                            continue;
                        }else if(money < 0){
                            System.out.println("\nThe student cannot be in debt! He/She will have to leave the line.\n");
                            continue;
                        }

                        System.out.print("Enter the student's index: ");
                        int index = Integer.parseInt(scan.nextLine());
                        if(index > realityA.numStudents()-1){
                            System.out.println("\nThere are no students at this index! Try again.\n");
                            continue;
                        }

                        if(index == realityA.numStudents()-1){
                            realityA.removeStudent(realityA.numStudents()-1);
                            realityA.addStudentFull(realityA.numStudents(), newStudent);
                        }else{
                            realityA.removeStudent(realityA.numStudents() - 1);
                            System.out.println("\nA student was pushed off of the lunch line! The Dean, Mr.Mean, has sent them to detention.\n");
                            realityA.cutFriend(index, newStudent);
                        }
                    }
                }
                if(reality.equals("B")) {
                    if(realityB.numStudents() != 20) {
                        System.out.print("Please enter student name: ");
                        String name = scan.nextLine();

                        System.out.print("Please enter money amount: ");
                        double money = Double.parseDouble(scan.nextLine());
                        Student newStudent = new Student(name, money);
                        if(money == 0){
                            System.out.println("\nThe student has no money for lunch! He/She will have to leave the line.\n");
                            continue;
                        }else if(money < 0){
                            System.out.println("\nThe student cannot be in debt! He/She will have to leave the line.\n");
                            continue;
                        }
                        System.out.print("Enter the student's index: ");
                        int index = Integer.parseInt(scan.nextLine());
                        if(index > realityB.numStudents()-1){
                            System.out.println("\nThere are no students at this index! Try again.\n");
                            continue;
                        }

                        realityB.cutFriend(index, newStudent);
                    }else{
                        System.out.print("Please enter student name: ");
                        String name = scan.nextLine();

                        System.out.print("Please enter money amount: ");
                        double money = Double.parseDouble(scan.nextLine());
                        Student newStudent = new Student(name, money);
                        if(money == 0){
                            System.out.println("\nThe student has no money for lunch! He/She will have to leave the line.\n");
                            continue;
                        }else if(money < 0){
                            System.out.println("\nThe student cannot be in debt! He/She will have to leave the line.\n");
                            continue;
                        }

                        System.out.print("Enter the student's index: ");
                        int index = Integer.parseInt(scan.nextLine());
                        if(index > realityB.numStudents()-1){
                            System.out.println("\nThere are no students at this index! Try again.\n");
                            continue;
                        }

                        if(index == realityB.numStudents()-1){
                            realityB.removeStudent(realityB.numStudents()-1);
                            realityB.addStudentFull(realityB.numStudents(), newStudent);
                        }else{
                            realityB.removeStudent(realityB.numStudents() - 1);
                            System.out.println("\nA student was pushed off of the lunch line! The Dean, Mr.Mean, has sent them to detention.\n");
                            realityB.cutFriend(index, newStudent);
                        }
                    }
                }
            }
            else if(command.equals("T")){
                if(reality.equals("A")) {
                    System.out.print("Enter student1 index: ");
                    int index1 = Integer.parseInt(scan.nextLine());
                    System.out.print("Enter student2 index: ");
                    int index2 = Integer.parseInt(scan.nextLine());

                    if(index1 > realityA.numStudents() - 1 && index2 > realityA.numStudents()-1){
                        System.out.println("\nThere are no students at either index! Try Again.\n");
                    }else if(index1 > realityA.numStudents()-1){
                        System.out.println("\nThere are no students at the first index! Try Again.\n");
                    }else if(index2 > realityA.numStudents()-1){
                        System.out.println("\nThere are no students at the second index! Try Again.\n");
                    }else {
                        realityA.swapStudents(index1, index2);
                        System.out.println("\nThe students have swapped places!\n");
                    }
                }
                if(reality.equals("B")) {
                    System.out.print("Enter student1 index: ");
                    int index1 = Integer.parseInt(scan.nextLine());
                    System.out.print("Enter student2 index: ");
                    int index2 = Integer.parseInt(scan.nextLine());

                    if(index1 > realityB.numStudents() - 1 && index2 > realityB.numStudents()-1){
                        System.out.println("\nThere are no students at either index! Try Again.\n");
                    }else if(index1 > realityB.numStudents()-1){
                        System.out.println("\nThere are no students at the first index! Try Again.\n");
                    }else if(index2 > realityB.numStudents()-1){
                        System.out.println("\nThere are no students at the second index! Try Again.\n");
                    }else {
                        realityB.swapStudents(index1, index2);
                        System.out.println("\nThe students have swapped places!\n");
                    }                }
            }
            else if(command.equals("B")){
                if(reality.equals("A")) {
                    System.out.print("Enter the index of the student to bully: ");
                    int index = Integer.parseInt(scan.nextLine());

                    if(index >= realityA.numStudents()){
                        System.out.println("\nThere is no student at this index! Try Again.\n");
                    }else {
                        System.out.println("\n" + realityA.getStudent(index).getName() + " has been bullied and is now crying in the bathroom!\n");
                        realityA.removeStudent(index);
                    }
                }
                if(reality.equals("B")) {
                    System.out.print("Enter the index of the student to bully: ");
                    int index = Integer.parseInt(scan.nextLine());

                    if(index >= realityB.numStudents()){
                        System.out.println("\nThere is no student at this index! Try Again.\n");
                    }else {
                        System.out.println("\n" + realityB.getStudent(index).getName() + " has been bullied and is now crying in the bathroom!\n");
                        realityB.removeStudent(index);
                    }
                }
            }
            else if(command.equals("U")){
                if(reality.equals("A")) {
                    System.out.print("Please enter student index: ");
                    int index = Integer.parseInt(scan.nextLine());

                    if(index >= realityA.numStudents()){
                        System.out.println("\nThere is no student at this index! Try Again.\n");
                    }else {
                        System.out.print("Please enter new money amount: ");
                        double money = Double.parseDouble(scan.nextLine());

                        realityA.getStudent(index).setMoney(money);
                        if (money == 0.0) {
                            System.out.println("\nThe student has no money for lunch! He/She will have to leave the line.\n");
                            realityA.removeStudent(index);
                        }else if(money < 0){
                            System.out.println("\nThe student cannot be in debt! He/She will have to leave the line.\n");
                            realityA.removeStudent(index);
                        }else{
                            System.out.println("\n" + realityA.getStudent(index).getName() + " now has $" + realityA.getStudent(index).getMoney() + "!\n");
                        }
                    }
                }
                if(reality.equals("B")) {
                    System.out.print("Please enter student index: ");
                    int index = Integer.parseInt(scan.nextLine());

                    if(index >= realityB.numStudents()){
                        System.out.println("\nThere is no student at this index! Try Again.\n");
                    }else {
                        System.out.print("Please enter new money amount: ");
                        double money = Double.parseDouble(scan.nextLine());

                        realityB.getStudent(index).setMoney(money);
                        if (money == 0.0) {
                            System.out.println("\nThe student has no money for lunch! He/She will have to leave the line.\n");
                            realityB.removeStudent(index);
                        }else if(money < 0){
                            System.out.println("\nThe student cannot be in debt! He/She will have to leave the line.\n");
                            realityB.removeStudent(index);
                        }else{
                            System.out.println("\n" + realityB.getStudent(index).getName() + " now has $" + realityB.getStudent(index).getMoney() + "!\n");
                        }
                    }
                }
            }
            else if(command.equals("S")){
                if(reality.equals("A")) {
                    if(realityA.numStudents() == 0){
                        System.out.println("\nThe line is empty! Add a new student to the line.\n");
                    }else{
                        System.out.print("\n" + realityA.getStudent(0).getName() + " has been served food!\n");
                        realityA.removeStudent(0);
                    }
                }
                if(reality.equals("B")) {
                    if(realityB.numStudents() == 0){
                        System.out.println("\nThe line is empty! Add a new student to the line.\n");
                    }else{
                        System.out.print("\n" + realityB.getStudent(0).getName() + " has been served food!\n");
                        realityB.removeStudent(0);
                    }
                }
            }
            else if(command.equals("P")){
                if(reality.equals("A")) {
                    System.out.println("\nLunch Line in Reality A: ");

                    System.out.println(realityA.toString());
                }
                if(reality.equals("B")) {
                    System.out.println("\nLunch Line in Reality B: ");

                    System.out.println(realityB.toString());
                }

            }
            else if(command.equals("O")){
                System.out.println("\nSwitching to the other reality...\n");
                if(reality.equals("A")){
                    reality = "B";
                }else if(reality.equals("B")){
                    reality = "A";
                }

            }
            else if(command.equals("E")){
                if(realityA.equals(realityB)){
                    System.out.println("\nThe two realities are equal!\n");
                }else{
                    System.out.println("\nThe two realities are not equal!\n");
                }
            }
            else if(command.equals("D")){
                System.out.println("\nThe reality has been cloned!\n");
                if(reality.equals("A")) {
                    realityB = realityA.clone();
                }else if(reality.equals("B")) {
                    realityA = realityB.clone();
                }
            }
            else if(command.equals("Q")){
                break;
            }
            else{
                System.out.println("\nYou have not entered a valid command. Try again! Type Q if you want to quit.");
            }



        }


        System.out.println("\n\nYou have chosen to leave middle school and quit your position as God. Thanks for playing!");


    }
}



