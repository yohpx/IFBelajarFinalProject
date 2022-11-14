import java.util.Scanner;

public class Program {
    public Program() {
        Scanner in = new Scanner(System.in);
        int jmlInput, pilMenu;
        double tempDouble;

        //System.out.println("Silakan masukan data sebelum memulai program.");
        //System.out.print("Masukkan jumlah karyawan yang akan didata: "); jmlInput = Integer.parseInt(in.nextLine());
        //System.out.println("Menyiapkan data...");
        //String[][] dataID = new String[jmlInput][2]; //array String (Nama lengkap dan golongan)
        //double[][] dataGaji = new double[jmlInput][2]; //array double (Gaji pokok dan lembur)
//
        //// INPUT DATA
        //for (int i = 0; i < dataID.length; i++) {
        //    System.out.println("Input Data karyawan ke-" + (i+1) + ": ");
        //    //Input data identitas dan golongan
        //    System.out.print("/ Nama Lengkap\t: "); dataID[i][0] = in.nextLine();
        //   // System.out.print("/ Golongan\t\t: "); dataID[i][1] = in.nextLine();
        //    //Input data gaji
        //    System.out.print("$ Gaji pokok\t: "); dataGaji[i][0] = Integer.parseInt(in.nextLine());
        //    System.out.print("$ Gaji Lembur\t: "); dataGaji[i][1] = Integer.parseInt(in.nextLine());
        //    System.out.println();
        //}
        System.out.println("Inisialisasi data berhasil!");
        String[][] dataID = { { "01", "Ghazali Ahlam Jazali", "5" }, { "02", "Heksaloga", "6" }, { "03", "Yohanes Maria", "10" } };
        double[][] dataGaji = { { 10000000.0, 150000.0 }, { 150000000.0, 250000.0 }, { 35000000.0, 245000.0 } };
        // walau ini double, kita akan menggunakan primitive int untuk output

        while (true) {
            System.out.println("\n<PILIHAN MENU>");
            System.out.println("(1) Daftar karyawan");
            System.out.println("(2) Modifikasi data karyawan");
            System.out.println("(3) Gaji karyawan");
            System.out.println("(4) Keluar");

            do {
                System.out.print("Masukkan pilihan: ");
                pilMenu = Integer.parseInt(in.nextLine());
                if (!(pilMenu >= 1 && pilMenu <= 4)) System.out.print("Masukkan pilihan yang benar! ");
            } while (!(pilMenu >= 1 && pilMenu <= 4));

            switch (pilMenu) {
                case 1 -> {
                    System.out.println("DAFTAR KARYAWAN");
                    // COUNTING REQUIRED -
                    int[] columnLength = {0, 0, 0, 0, 0};
                    int tableLength;
                    String tableSeparator = "";

                    // COLUMN LENGTH DATA DIRI
                    for (int i = 0; i < dataID.length; i++) {
                        //TABLE VALUES
                        if (dataID[i][0].length() > columnLength[0]) { //UUID
                            columnLength[0] = dataID[i][0].length();
                        }
                        if (dataID[i][1].length() > columnLength[1]) { //NAME
                            columnLength[1] = dataID[i][1].length();
                        }
                        if (dataID[i][2].length() > columnLength[2]) { //GOLO
                            columnLength[2] = dataID[i][2].length();
                        }
                    }
                    // COLUMN LENGTH GAJI
                    for (int i = 0; i < dataID.length; i++) {
                        if (String.valueOf((int) dataGaji[i][0]).length() > columnLength[3]) {
                            columnLength[3] = String.valueOf((int) dataGaji[i][0]).length();
                        }
                        if (String.valueOf((int) dataGaji[i][1]).length() > columnLength[4]) {
                            columnLength[4] = String.valueOf((int) dataGaji[i][1]).length();
                        }
                    }

                    //COMPARING TO TABLE HEADER
                    String[] TABLE_HEADER = {"ID", "NAMA LENGKAP", "GOLONGAN", "GAJI POKOK", "GAJI LEMBUR"};
                    for (int i = 0; i < TABLE_HEADER.length; i++) {
                        if (TABLE_HEADER[i].length() > columnLength[i]) {
                            columnLength[i] = TABLE_HEADER[i].length();
                        }
                    }

                    tableLength = (columnLength.length + 1) + (columnLength[0] + 2) + (columnLength[1] + 2) + (columnLength[2] + 2) + (columnLength[3] + 2) + (columnLength[4] + 2);
                    // MEMBUAT SEPARATOR ANTAR DATA KARYAWAN
                    for (int i = 0; i < tableLength; i++) {
                        if (i == 0 || i == tableLength - 1
                                || i == 3 + columnLength[0]
                                || i == 3 + columnLength[0] + 3 + columnLength[1]
                                || i == 3 + columnLength[0] + 3 + columnLength[1] + 3 + columnLength[2]
                                || i == 3 + columnLength[0] + 3 + columnLength[1] + 3 + columnLength[2] + 3 + columnLength[3]
                        ) tableSeparator += "+";
                        else tableSeparator += "-";
                    }

                    System.out.println(tableSeparator);
                    for (int i = -1; i < dataID.length; i++) {
                        if (i >= 0) { //table value builder
                            System.out.print("| ");
                            int c = 0;
                            for (int k = 0; k < dataID.length; k++) { //columnLength[0 to 2]: ID, NAMA LENGKAP, GOLONGAN
                                System.out.print(dataID[i][c]);
                                for (int j = 0; j < (columnLength[c] - dataID[i][c].length()); j++) {
                                    System.out.print(" ");
                                }
                                System.out.print(" | ");
                                c++;
                            }

                            //GAJP COLUMN
                            System.out.print((int) dataGaji[i][0]);
                            for (int j = 0; j < (columnLength[3] - String.valueOf((int) dataGaji[i][0]).length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");
//
                            //GAJL COLUMN
                            System.out.print((int) dataGaji[i][1]);
                            for (int j = 0; j < (columnLength[4] - String.valueOf((int) dataGaji[i][1]).length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");
                        }
                        else { //table header builder
                            for (int b = 0; b < TABLE_HEADER.length; b++) {
                                if (!(b == 0)) System.out.print(TABLE_HEADER[b]);
                                else System.out.print("| " + TABLE_HEADER[b]);
                                for (int j = 0; j < (columnLength[b] - TABLE_HEADER[b].length()); j++) {
                                    System.out.print(" ");
                                }
                                System.out.print(" | ");
                            }
                        }
                        System.out.println("\n" + tableSeparator); //newline
                    }
                }
                case 2 -> System.out.println("Case 2");
                case 3 -> System.out.println("Case 3");
                case 4 -> {
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    System.exit(0);}
            }
        }
    }
    public static void main(String[] args) {
        new Program();
    }
}
