/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konversi.bilangan;

/**
 *
 * @author sulthonsr
 */
import java.util.Scanner;

public class KonversiBilangan {
    static int rem;
    static int jumlah=0;
    static int i;
    static String urutan = "";
    static String[] bilHexa = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    static int [] bilBin = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    public static void DecimalToBiner(int decimal){
        urutan="";
        for (i = decimal; i > 0; i = i / 2) {
            urutan = Integer.toString(i % 2) + urutan;
        }

    }
    public static void DecimalToOctal(int decimal){
        urutan="";
        for (i = decimal; i > 0; i = i / 8) {
            urutan = Integer.toString(i % 8) + urutan;
        }
    }
    public static void DecimalToHexa(int decimal){
        urutan="";
        for (i = decimal; i > 0; i = i / 16) {
            urutan = bilHexa[i % 16] + urutan;
        }
    }
    public static int BinerToDecimal(int biner){
        while (biner > 0) {
            rem = biner % 2;
            biner = biner / 10;
            jumlah = (int) (jumlah + (rem * Math.pow(2, i)));
            i++;
        }
        return jumlah;
    }
    public static int OctalToDecimal(int Octal){
        while (Octal > 0) {
            rem = Octal % 10;
            Octal=Octal/10;
            jumlah = (int) (jumlah + (rem * Math.pow(8, i)));
            i++;
        }
        return jumlah;
    }
    public static int HexaToDesimal(String Hexadecimal){
        int nilaiDesimal=0;
        for (int i=0; i<Hexadecimal.length(); i++){
            char hexKar = Hexadecimal.charAt(i);
            nilaiDesimal = nilaiDesimal *16 + hexKarKeDesimal(hexKar);
        }
        return nilaiDesimal;
    }
    public static int hexKarKeDesimal(char ch){
        if(ch>='A' && ch <='F'){
            return 10+ch-'A';
        }else{
            return ch-'0';
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("pilih bilangan :");
        System.out.println("1. decimal");
        System.out.println("2. biner");
        System.out.println("3. octal");
        System.out.println("4. hexadecimal");
        int pilih = input.nextInt();
        switch(pilih) {
            case 1:
                System.out.print("masukan bilangan desimal : ");
                int decimal = input.nextInt();
                DecimalToBiner(decimal);
                System.out.println("bilangan biner          = "+urutan);
                DecimalToOctal(decimal);
                System.out.println("bilangan octal          = "+urutan);
                DecimalToHexa(decimal);
                System.out.println("bilangan hexadecimal    = "+urutan);
                break;
            case 2:
                System.out.print("masukan bilangan biner : ");
                int biner = input.nextInt();
                decimal=BinerToDecimal(biner);
                System.out.println("bilangan desimal        = "+decimal);
                DecimalToOctal(decimal);
                System.out.println("bilangan octal          = "+urutan);
                DecimalToHexa(decimal);
                System.out.println("bilangan hexadecimal    = "+urutan);
                break;
            case 3:
                System.out.print("masukan bilangan oktal : ");
                int Octal = input.nextInt();
                decimal = OctalToDecimal(Octal);
                System.out.println("bilangan desimal        = "+decimal);
                DecimalToBiner(decimal);
                System.out.println("bilangan biner          = "+urutan);
                DecimalToHexa(decimal);
                System.out.println("bilangan hexadecimal    = "+urutan);
                break;
            case 4:
                System.out.print("masukan bilangan hexadecimal : ");
                String Hexadecimal = input.next();
                int Hex = HexaToDesimal(Hexadecimal.toUpperCase());
                System.out.println("bilangan desimal        = "+Hex);
                DecimalToBiner(Hex);
                System.out.println("bilangan biner          = "+urutan);
                DecimalToOctal(Hex);
                System.out.println("bilangan oktal          = "+urutan);
                break;
            default:
                break;
        }
    }
}