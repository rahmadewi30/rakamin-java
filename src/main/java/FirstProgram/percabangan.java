package FirstProgram;
import java.util.Scanner;

public class percabangan {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String password = prompt("Enter password: ");
        String validPassword = "password";

        //jika benar maka selamat datang bos
        //jika salah (Else) maka error message
        if (password.equals(validPassword)){
            System.out.println("Selamat datang bos!");
        } else {
            System.out.println("Password salah, coba lagi");
        }
        System.out.println("Terima kasih sudah menggunakan aplikasi kami");
    }

    public static String prompt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }
}
