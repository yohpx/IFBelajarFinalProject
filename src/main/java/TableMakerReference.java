public class TableMakerReference {
  public static void main(String[] args) {

    String[][] dataID = { { "Ghazali Ahlam Jazali", "5" }, { "Heksaloga", "6" }, { "Yohanes Maria Vianney Nara Narwandaru", "10" } };
    String[][] dataGaji = { { "100000", "50000" }, { "1000000", "500000" }, { "8012312323123", "48239842384" } };

    int columnLength1 = 0;
    int columnLength2 = 0;
    int columnLength3 = 0;
    int columnLength4 = 0;
    int tableLength;

    for (int i = 0; i < dataID.length; i++) {
      if (dataID[i][0].length() > columnLength1)
        columnLength1 = dataID[i][0].length();
    }

    for (int i = 0; i < dataID.length; i++) {
      if (dataID[i][1].length() > columnLength2)
        columnLength2 = dataID[i][1].length();
    }

    for (int i = 0; i < dataGaji.length; i++) {
      if (dataGaji[i][0].length() > columnLength3)
        columnLength3 = dataGaji[i][0].length();
    }

    for (int i = 0; i < dataGaji.length; i++) {
      if (dataGaji[i][1].length() > columnLength4)
        columnLength4 = dataGaji[i][1].length();
    }

    tableLength = 12 + columnLength1 + columnLength2 + columnLength3 + columnLength4;

    String verticalBorder = "";

    for (int i = 0; i < tableLength; i++) {
      if (i == columnLength1 + 2
          || i == columnLength1 + columnLength2 + 5
          || i == columnLength1 + columnLength2 + columnLength3 + 8
          || i == tableLength - 1)
        verticalBorder += "+";
      else
        verticalBorder += "-";
    }

    System.out.println(verticalBorder);

    for (int i = 0; i < dataID.length; i++) {
      System.out.print(" " + dataID[i][0]);

      for (int j = 0; j < (columnLength1 - dataID[i][0].length()); j++)
        System.out.print(" ");

      System.out.print(" | ");

      System.out.print(dataID[i][1]);

      for (int j = 0; j < (columnLength2 - dataID[i][1].length()); j++)
        System.out.print(" ");

      System.out.print(" | ");

      System.out.print(dataGaji[i][0]);

      for (int j = 0; j < (columnLength3 - dataGaji[i][0].length()); j++)
        System.out.print(" ");

      System.out.print(" | ");

      System.out.print(dataGaji[i][1]);

      for (int j = 0; j < (columnLength4 - dataGaji[i][1].length()); j++)
        System.out.print(" ");

      System.out.println(" |");

      System.out.println(verticalBorder);
    }
  }
}
