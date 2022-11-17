import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int jmlInput, pilMenu;

        //System.out.println("Silakan masukan data sebelum memulai program.");
        //System.out.print("Masukkan jumlah karyawan yang akan didata: "); jmlInput = Integer.parseInt(in.nextLine());
        //System.out.println("Menyiapkan data...");
        //String[][] dataID = new String[jmlInput][3]; //array String (Nama lengkap dan golongan)
        //double[][] dataGaji = new double[jmlInput][2]; //array double (Gaji pokok dan lembur)
//
        //// INPUT DATA
        //for (int i = 0; i < dataID.length; i++) {
        //    System.out.println("Input Data karyawan ke-" + (i+1) + ": ");
        //    //Input data identitas dan golongan
        //    System.out.print("/ Generated ID\t: " + (i+1)); dataID[i][0] = String.valueOf(i+1);
        //    System.out.println();
        //    System.out.print("/ Nama Lengkap\t: "); dataID[i][1] = in.nextLine();
        //    System.out.print("/ Golongan\t\t: "); dataID[i][2] = in.nextLine();
        //    //Input data gaji
        //    System.out.print("$ Gaji pokok\t: "); dataGaji[i][0] = Integer.parseInt(in.nextLine());
        //    System.out.print("$ Gaji Lembur\t: "); dataGaji[i][1] = Integer.parseInt(in.nextLine());
        //    System.out.println();
        //}

        String[][] dataID = { { "01", "Ghazali Ahlam Jazali", "5" }, { "02", "Heksaloga", "6" }, { "03", "Nicolaus Bayu", "10" }, { "04", "Eren Yeager", "7" }, { "05", "Gimana Coba", "2" }};
        double[][] dataGaji = {{ 10000000.0, 150000.0 }, { 150000000.0, 250000.0 }, { 35000000.0, 245000.0 }, { 45000000.0, 300000.0 }, { 17000000.0, 270000.0 }};
        // walau ini double, kita akan menggunakan primitive int untuk output

        while (true) {
            System.out.println("\n<PILIHAN MENU>");
            System.out.println("(1) Daftar karyawan");
            System.out.println("(2) Modifikasi data karyawan");
            System.out.println("(3) Hitung Gaji karyawan");
            System.out.println("(4) Keluar");

            do {
                System.out.print("Masukkan pilihan: ");
                //pilMenu = Integer.parseInt(in.nextLine());
                pilMenu = in.nextInt();
                if (!(pilMenu >= 1 && pilMenu <= 4)) System.out.print("Masukkan pilihan yang benar! ");
            } while (!(pilMenu >= 1 && pilMenu <= 4));

            switch (pilMenu) {
                case 1 -> {
                    System.out.println("DAFTAR KARYAWAN");
                    // COUNTING REQUIRED -
                    int[] dataColSize = {0, 0, 0, 0, 0};
                    String tableSeparator = "";

                    // COLUMN LENGTH DATA DIRI
                    for (int i = 0; i < dataID.length; i++) {
                        //TABLE VALUES
                        if (dataID[i][0].length() > dataColSize[0]) { //UUID
                            dataColSize[0] = dataID[i][0].length();
                        }
                        if (dataID[i][1].length() > dataColSize[1]) { //NAME
                            dataColSize[1] = dataID[i][1].length();
                        }
                        if (dataID[i][2].length() > dataColSize[2]) { //GOLO
                            dataColSize[2] = dataID[i][2].length();
                        }
                    }
                    // COLUMN LENGTH GAJI
                    for (int i = 0; i < dataID.length; i++) {
                        if (String.valueOf((int) dataGaji[i][0]).length() > dataColSize[3]) {
                            dataColSize[3] = String.valueOf((int) dataGaji[i][0]).length();
                        }
                        if (String.valueOf((int) dataGaji[i][1]).length() > dataColSize[4]) {
                            dataColSize[4] = String.valueOf((int) dataGaji[i][1]).length();
                        }
                    }

                    //COMPARING TO TABLE HEADER
                    String[] TABLE_HEADER = {"ID", "NAMA LENGKAP", "GOLONGAN", "GAJI POKOK", "GAJI LEMBUR", "GAJI BERSIH"};
                    for (int i = 0; i < TABLE_HEADER.length; i++) {
                        if (TABLE_HEADER[i].length() > dataColSize[i]) {
                            dataColSize[i] = TABLE_HEADER[i].length();
                        }
                    }

                    // MEMBUAT SEPARATOR ANTAR DATA KARYAWAN
                    for (int i = 0; i < dataColSize.length; i++) {
                        tableSeparator += "+--";
                        for (int k = 0; k < dataColSize[i]; k++) {
                            tableSeparator += "-";
                        }
                        if (i == dataColSize.length - 1) tableSeparator += "+";
                    }

                    System.out.println(tableSeparator);
                    for (int i = -1; i < dataID.length; i++) {
                        if (i >= 0) { //table value builder
                            System.out.print("| ");
                            int c = 0;
                            for (int k = 0; k < dataID[i].length; k++) { //dataColSize[0 to 2]: ID, NAMA LENGKAP, GOLONGAN
                                System.out.print(dataID[i][c]);
                                for (int j = 0; j < (dataColSize[c] - dataID[i][c].length()); j++) {
                                    System.out.print(" ");
                                }
                                System.out.print(" | ");
                                c++;
                            }

                            //GAJP COLUMN
                            System.out.print((int) dataGaji[i][0]);
                            for (int j = 0; j < (dataColSize[3] - String.valueOf((int) dataGaji[i][0]).length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");

                            //GAJL COLUMN
                            System.out.print((int) dataGaji[i][1]);
                            for (int j = 0; j < (dataColSize[4] - String.valueOf((int) dataGaji[i][1]).length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");
                        }
                        else { //table header builder
                            for (int b = 0; b < TABLE_HEADER.length; b++) {
                                if (!(b == 0)) System.out.print(TABLE_HEADER[b]);
                                else System.out.print("| " + TABLE_HEADER[b]);
                                for (int j = 0; j < (dataColSize[b] - TABLE_HEADER[b].length()); j++) {
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
}
