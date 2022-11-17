import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int jmlInput, pilMenu;
        double potongan = 0, totalGaji;

        System.out.println("Silakan masukan data sebelum memulai program.");
        System.out.print("Masukkan jumlah karyawan yang akan didata: ");
        jmlInput = Integer.parseInt(in.nextLine());
        System.out.println("Menyiapkan data...");
        String[] dataID = new String[jmlInput];
        String[] dataNama = new String[jmlInput];
        int[] dataGolongan = new int[jmlInput];
        double[] dataGajiPokok = new double[jmlInput];
        double[] dataGajiLembur = new double[jmlInput];
        double[] dataGajiBersih = new double[jmlInput];

        //String[] dataID = {"1", "2"};
        //String[] dataNama = {"Nara Narwandaru", "Obama Bin Laden"};
        //int[] dataGolongan = {3, 2};
        //double[] dataGajiPokok = {30000000.0, 15000000.0};
        //double[] dataGajiLembur = {3500000.0, 154000.0};
        //double[] dataGajiBersih = new double[2];
        //

        for (int i = 0; i < dataID.length; i++) {
            System.out.println("Input Data karyawan ke-" + (i+1) + ": ");
            //Input data identitas dan golongan
            System.out.print("/ Generated ID\t: " + (i+1)); dataID[i] = String.valueOf(i+1);
            System.out.println();
            System.out.print("/ Nama Lengkap\t: "); dataNama[i] = in.nextLine();
            do {
                System.out.print("/ Golongan\t\t: ");
                dataGolongan[i] = in.nextInt();
            } while (!(dataGolongan[i] >= 1 && dataGolongan[i] <= 3));
            //Input data gaji
            System.out.print("$ Gaji pokok\t: "); dataGajiPokok[i] = in.nextInt();
            System.out.print("$ Gaji Lembur\t: "); dataGajiLembur[i] = in.nextInt();
            switch (dataGolongan[i]) {
                case 1 -> {potongan = 0.05;}
                case 2 -> {potongan = 0.1;}
                case 3 -> {potongan = 0.15;}
            }
            totalGaji = dataGajiPokok[i] + dataGajiLembur[i];
            dataGajiBersih[i] = totalGaji - (potongan * totalGaji);
            System.out.println(dataGajiBersih[i]);
            in.nextLine();
        }

        while (true) {
            System.out.println("\n<PILIHAN MENU>");
            System.out.println("(1) Daftar karyawan dan Gaji");
            System.out.println("(2) Modifikasi data karyawan");
            System.out.println("(3) Keluar");

            do {
                System.out.print("Masukkan pilihan: "); pilMenu = in.nextInt();
                if (!(pilMenu >= 1 && pilMenu <= 4)) System.out.print("Masukkan pilihan yang benar! ");
            } while (!(pilMenu >= 1 && pilMenu <= 4));

            switch (pilMenu) {
                case 1 -> { // DAFTAR KARYAWAN DAN GAJI
                    System.out.println("\n<DAFTAR KARYAWAN DAN GAJI>");
                    // COUNTING REQUIRED
                    int[] dataColSize = {0, 0, 0, 0, 0, 0};
                    String tableSeparator = "";

                    // MENGHITUNG JUMLAH KARAKTER MAKSIMAL
                    for (int i = 0; i < dataID.length; i++) { //ID
                        if (dataID[i].length() > dataColSize[0]) {
                            dataColSize[0] = dataID[i].length();
                        }
                    }
                    for (int i = 0; i < dataNama.length; i++) { //NAMA LENGKAP
                        if (dataID[i].length() > dataColSize[1]) {
                            dataColSize[1] = dataNama[i].length();
                        }
                    }
                    for (int i = 0; i < dataGolongan.length; i++) { //GOLONGAN
                        if (dataID[i].length() > dataColSize[2]) {
                            dataColSize[2] = String.valueOf(dataGolongan[i]).length();
                        }
                    }
                    for (int i = 0; i < dataGajiPokok.length; i++) { //GAJI POKOK
                        if (dataID[i].length() > dataColSize[3]) {
                            dataColSize[3] = String.valueOf(dataGajiPokok[i]).length();
                        }
                    }
                    for (int i = 0; i < dataGajiLembur.length; i++) { //GAJI LEMBUR
                        if (dataID[i].length() > dataColSize[4]) {
                            dataColSize[4] = String.valueOf(dataGajiLembur[i]).length();
                        }
                    }
                    for (int i = 0; i < dataGajiBersih.length; i++) { //GAJI BERSIH
                        if (dataID[i].length() > dataColSize[5]) {
                            dataColSize[5] = String.valueOf(dataGajiBersih[i]).length();
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
                            //OUTPUT GAJI
                            System.out.print(dataID[i]);
                            for (int j = 0; j < (dataColSize[0] - String.valueOf(dataID[i]).length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");

                            //OUTPUT NAMA LENGKAP
                            System.out.print(dataNama[i]);
                            for (int j = 0; j < (dataColSize[1] - dataNama[i].length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");

                            //OUTPUT GOLONGAN
                            System.out.print((int) dataGolongan[i]);
                            for (int j = 0; j < (dataColSize[2] - String.valueOf((int) dataGolongan[i]).length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");

                            //OUTPUT GAJI POKOK
                            System.out.print((int) dataGajiPokok[i]);
                            for (int j = 0; j < (dataColSize[3] - String.valueOf((int) dataGajiPokok[i]).length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");

                            //OUTPUT GAJI LEMBUR
                            System.out.print((int) dataGajiLembur[i]);
                            for (int j = 0; j < (dataColSize[4] - String.valueOf((int) dataGajiLembur[i]).length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");

                            //OUTPUT GAJI BERSIH
                            System.out.print((int) dataGajiBersih[i]);
                            for (int j = 0; j < (dataColSize[5] - String.valueOf((int) dataGajiBersih[i]).length()); j++) {
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
            }
        }
    }
}
