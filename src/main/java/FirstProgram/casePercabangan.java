package FirstProgram;

import java.util.Scanner;

public class casePercabangan {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan nilai: ");
        int nilai = scanner.nextInt();
        String grade;

        if (nilai > 89) {
            grade = "A";
        } else if (nilai > 79) {
            grade = "B+";
        } else if (nilai > 69) {
            grade = "B";
        } else {
            grade = "F";
        }
        System.out.println("Grade adalah = " + grade);
    }
}
