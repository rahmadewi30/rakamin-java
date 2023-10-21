package FirstProgram;

public class fungsi {
    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        int z = 10;

        NamaKu.Indah("Budi");
        NamaKu.Indah("Suep");
        NamaKu.Indah("Kocak");

        tambah(x,y);
        tambah(x,z);
        tambah(y,z);

    }

    public static int tambah(int a, int b){
        int hasilTambah = a+b;
        System.out.println("Hasil tambah: " + a + " dan " + b + " adalah " + hasilTambah);
        return hasilTambah;

    }
}
