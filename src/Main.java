import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int row, col;
        Scanner scan = new Scanner(System.in);

        System.out.println("Mayın tarlası oyununa hoşgeldiniz");
        System.out.println("Mayın tarlasının olmasını istediğiniz boyutlarını giriniz");
        System.out.print("Mayın tarlası kaç satır olsun: ");
        row = scan.nextInt();
        System.out.print("Mayın tarlası kaç sütün olsun: ");
        col = scan.nextInt();

        if(row==1 || col==1){
            System.out.print("OTOMATİK OLARAK OYUN 3'E 3 OLUŞTURULMUŞTUR !!");
            row=3;
            col=3;
        }


        MayinTarlasi oyun = new MayinTarlasi(row,col);

    oyun.run();

    }
}
