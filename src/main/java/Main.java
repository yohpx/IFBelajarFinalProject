/* PROGRAM PENGGAJIAN KARYAWAN PERUSAHAAN
 * Proyek ini dibuat untuk pengajuan lomba antar kelas workshop IF Belajar 2022 USD.
 * 
 * Kontributor: Nara, Bayu, Stepanus
 * Pembimbing: Heksa, Ghazali, Pieter
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) { // INISIASI METODE UTAMA
        Scanner in = new Scanner(System.in);
        int jmlInput, pilMenuUtama, pilModifData;
        double potongan = 0, totalGaji;

        System.out.println("PROGRAM PENGGAJIAN KARYAWAN\n");

        System.out.println("Silakan masukan data sebelum memulai program.");
        System.out.print("Masukkan jumlah karyawan yang akan didata: ");
        jmlInput = Integer.parseInt(in.nextLine());
        
        System.out.println("Menyiapkan data...");
        // INISIASI VARIABEL ARRAY PENYIMPAN DATA KARYAWAN
        String[] dataID = new String[jmlInput];
        String[] dataNama = new String[jmlInput];
        int[] dataGolongan = new int[jmlInput];
        double[] dataGajiPokok = new double[jmlInput];
        double[] dataUangLembur = new double[jmlInput];
        double[] dataGajiBersih = new double[jmlInput];

        
        // INPUT UNTUK SETIAP KARYAWAN PERUSAHAAN
        for (int i = 0; i < dataID.length; i++) {
            System.out.println("Input Data karyawan ke-" + (i+1) + ": ");
            //Input data identitas dan golongan
            System.out.print("/ Generated ID\t: " + (i+1)); dataID[i] = String.valueOf(i+1);
            System.out.println();
            System.out.print("? Nama Lengkap\t: "); dataNama[i] = in.nextLine();
            do {
                System.out.print("? Golongan\t\t: ");
                dataGolongan[i] = Integer.parseInt(in.nextLine());
                if (!(dataGolongan[i] >= 1 && dataGolongan[i] <= 3)) System.out.println("Harap masukan golongan 1 sampai 3.");
            } while (!(dataGolongan[i] >= 1 && dataGolongan[i] <= 3));
            
            //Input data gaji
            System.out.print("$ Gaji pokok\t: "); dataGajiPokok[i] = Integer.parseInt(in.nextLine());
            System.out.print("$ Uang lembur\t: "); dataUangLembur[i] = Integer.parseInt(in.nextLine());
            switch (dataGolongan[i]) {
                case 1 -> {potongan = 0.05;}
                case 2 -> {potongan = 0.1;}
                case 3 -> {potongan = 0.15;}
            }
            totalGaji = dataGajiPokok[i] + dataUangLembur[i];
            dataGajiBersih[i] = totalGaji - (potongan * totalGaji);
            System.out.println();
        }

        while (true) { // LOOP MENU UTAMA
            System.out.println("<MENU UTAMA>");
            System.out.println("[1] Daftar karyawan dan Gaji");
            System.out.println("[2] Modifikasi data karyawan");
            System.out.println("[3] Keluar");

            do {
                System.out.print("Masukkan pilihan: "); pilMenuUtama = Integer.parseInt(in.nextLine());
                if (!(pilMenuUtama >= 1 && pilMenuUtama <= 3)) System.out.print("Masukkan pilihan yang benar! ");
            } while (!(pilMenuUtama >= 1 && pilMenuUtama <= 3));

            switch (pilMenuUtama) {
                case 1 -> { // DAFTAR KARYAWAN DAN GAJI
                    System.out.println("\n<DAFTAR KARYAWAN DAN GAJI>");
                    // COUNTING REQUIRED
                    int[] dataColSize = {0, 0, 0, 0, 0, 0};
                    String tableSeparator = "";

                    // MENGHITUNG JUMLAH KARAKTER MAKSIMAL SETIAP ARRAY
                    for (int i = 0; i < dataID.length; i++) {
                        if (dataID[i].length() > dataColSize[0]) { //ID
                            dataColSize[0] = dataID[i].length();
                        }
                        if (dataNama[i].length() > dataColSize[1]) { //NAMA LENGKAP
                            dataColSize[1] = dataNama[i].length();
                        }
                        if (dataID[i].length() > dataColSize[2]) {
                            dataColSize[2] = String.valueOf(dataGolongan[i]).length(); //GOLONGAN
                        }
                        if (dataID[i].length() > dataColSize[3]) {
                            dataColSize[3] = String.valueOf(dataGajiPokok[i]).length(); //GAJI POKOK
                        }
                        if (dataID[i].length() > dataColSize[4]) { //GAJI LEMBUR
                            dataColSize[4] = String.valueOf(dataUangLembur[i]).length();
                        }
                        if (dataID[i].length() > dataColSize[5]) { //GAJI BERSIH
                            dataColSize[5] = String.valueOf(dataGajiBersih[i]).length();
                        }
                    }
                    //COMPARING TO TABLE HEADER
                    String[] TABLE_HEADER = {"ID", "NAMA LENGKAP", "GOLONGAN", "GAJI POKOK (Rp)", "GAJI LEMBUR (Rp)", "GAJI BERSIH (Rp)"};
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

                    // TABLE BUILDER
                    for (int i = -1; i < dataID.length; i++) {
                        if (i >= 0) { //table value builder
                            System.out.print("| ");
                            //OUTPUT table ID
                            System.out.print(dataID[i]);
                            for (int j = 0; j < (dataColSize[0] - dataID[i].length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");

                            //OUTPUT table NAMA LENGKAP
                            System.out.print(dataNama[i]);
                            for (int j = 0; j < (dataColSize[1] - dataNama[i].length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");

                            //OUTPUT table GOLONGAN
                            System.out.print((int) dataGolongan[i]);
                            for (int j = 0; j < (dataColSize[2] - String.valueOf((int) dataGolongan[i]).length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");

                            //OUTPUT table GAJI POKOK
                            System.out.print((int) dataGajiPokok[i]);
                            for (int j = 0; j < (dataColSize[3] - String.valueOf((int) dataGajiPokok[i]).length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");

                            //OUTPUT table GAJI LEMBUR
                            System.out.print((int) dataUangLembur[i]);
                            for (int j = 0; j < (dataColSize[4] - String.valueOf((int) dataUangLembur[i]).length()); j++) {
                                System.out.print(" ");
                            }
                            System.out.print(" | ");

                            //OUTPUT table GAJI BERSIH
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
                    System.out.println();
                }
                case 2 -> {
                    boolean runMenuModif = true;
                    while (runMenuModif) { // LOOP MENU MODIFIKASI DATA
                        System.out.println();
                        System.out.println("<MENU MODIFIKASI DATA> ");
                        System.out.println("[1] Mengubah gaji karyawan");
                        System.out.println("[2] Menambah uang lembur");
                        System.out.println("[3] Kembali ke menu utama");
                        do {
                            System.out.print("Masukkan pilihan: ");
                            pilModifData = Integer.parseInt(in.nextLine());// loop menu modifikasi data
                            if (!(pilModifData >= 1 && pilModifData <= 3)) System.out.print("Masukkan pilihan yang benar! ");
                        } while (!(pilModifData >= 1 && pilModifData <= 3));

                        int indeks = 0;
                        double ubahGaji, uangLembur;
                        if (pilModifData == 1 || pilModifData == 2) {
                            System.out.println("\n<MEMODIFIKASI DATA>");
                            System.out.print("ID yang ingin dimodifikasi: ");
                            indeks = Integer.parseInt(in.nextLine()) - 1;
                            if (!(indeks >= 0 && indeks < dataID.length)) { // validasi indeks yang dimasukan
                                System.out.println("ID tidak valid! ID dapat dilihat dari menu utama.");
                                continue;
                            }
                        }

                        switch (pilModifData) {
                            case 1 -> { // EDIT JUMLAH GAJI POKOK
                                System.out.printf("Gaji ID %s (%s) sebelumnya adalah Rp.%,.2f\n", dataID[indeks], dataNama[indeks], dataGajiPokok[indeks]);
                                System.out.print("Jumlah gaji pokok baru: Rp. ");
                                ubahGaji = in.nextDouble();
                                in.nextLine();
                                dataGajiPokok[indeks] = ubahGaji;
                                System.out.printf("Gaji pokok berhasil diperbarui menjadi Rp.%,.2f \n", dataGajiPokok[indeks]);
                                continue;
                            }
                            case 2 -> { // TAMBAH UANG LEMBUR
                                System.out.printf("Uang lembur ID %s (%s) sebelumnya adalah Rp.%,.2f\n", dataID[indeks], dataNama[indeks], dataUangLembur[indeks]);
                                System.out.print("Jumlah tambahan uang lembur: Rp. ");
                                uangLembur = in.nextDouble();
                                in.nextLine();
                                dataUangLembur[indeks] += uangLembur;
                                System.out.printf("Uang lembur berhasil diperbarui menjadi Rp.%,.2f \n", dataUangLembur[indeks]);
                                continue;
                            }
                            case 3 -> { // KEMBALI KE MENU UTAMA
                                runMenuModif = false;
                            }
                            default -> { // ERROR HANDLER
                                System.out.println("Data tidak valid.");
                                continue;
                            }
                        }
                        System.out.println();
                    }
                }
                case 3 -> {
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    System.exit(0);
                }
            }
        }
    }
}
