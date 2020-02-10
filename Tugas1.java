import java.util.Scanner;
public class Tugas1 {
    public static void main(String[] args) {
        String nama;
        int jml;
        int nilai[] = new int[100];
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Nama : ");
        nama = scanInput.nextLine();
        System.out.print("Berapa nilai yang akan diinput? : ");
        jml = scanInput.nextInt();
        for (int i = 1; i <=jml; i++) 
        {
            scanInput.nextLine();
            System.out.print("Nilai ke-" + i + ": ");
            nilai[i] = scanInput.nextInt();
        }
        int max = 0;
        int min = 99999999;
        for (int i = 1; i <=jml; i++) 
        {
            if (min>nilai[i]) 
            {
                min=nilai[i];
            }
             if (max<nilai[i]) 
            {
                max=nilai[i];
            }
        }
        System.out.println("");
        System.out.println("===INI DATA ANDA===");
        System.out.println("Nama : " +nama);
        System.out.println("Nilai Tertinggi : "+ max);
        System.out.println("Nilai Terendah : "+ min);
        int total =0;
        for (int i = 1; i <=jml; i++) 
        {
            total = total + nilai[i];
        }
       // rata = total/jml;
        System.out.println("Rata-rata nilai = " + (total*1.0/jml*1.0));
    }
}