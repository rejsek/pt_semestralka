import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static String PATH = "inputs/";

    private static String[] warehouses;

    private static String[] customers;

    private static String[] barrows;

    private static int sizeOfArray(Scanner sc, String filename) throws IOException {
        /**
         * Metoda zjisti kolik zaznamu obsahuje nacitany soubor
         *
         * @param sc            instance Scanneru
         * @param filename      nazev souboru
         *
         * @return pocet zaznamu v souboru
         */

        String fullPath = PATH + filename;
        int size = 0;
        String current = "";

        sc = new Scanner(Paths.get(fullPath));

        while(sc.hasNext()) {
            current = sc.nextLine();

            if(!(current.startsWith("❄") && current.endsWith("⛏"))) {
                size += 1;
            }
        }

        sc.close();

        return size;
    }

    private static String[] loadData(Scanner sc, String filename) throws IOException {
        /**
         * Metoda nacte data obsazena v souboru a vrati je jako pole
         *
         * @param sc            instrance Scanneru
         * @param filename      nazev souboru
         *
         * @return pole reprezentujici obsah predaneho souboru
         */

        int size = sizeOfArray(sc, filename);
        int position = 0;
        String[] data = new String[size];
        String current = "";

        String fullPath = PATH + filename;
        sc = new Scanner(Paths.get(fullPath));

        while(sc.hasNext()) {
            current = sc.nextLine();

            if(current.startsWith("❄") && current.endsWith("⛏")) {
                continue;
            } else {
                data[position] = current.trim();
            }

            position += 1;
        }

        return data;
    }

    private static void createBarrow(int count, String[] data) {
        for(int i = 0; i < count; i++) {
            barrows[i] = data[i + 1];
        }
    }

    private static void createCustomer(int count, int index, String[] data) {
        for(int i = 0; i < count; i++) {
            customers[i] = data[index + i];
        }
    }

    private static void createWarehouse(int count, int index, String[] data) {
        for(int i = 0; i < count; i++) {
            warehouses[i] = data[index + i];
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "tutorial.txt";
        Scanner sc = null;

        int currentPosition = 0;
        int count = sizeOfArray(sc, fileName);
        int currentCount = 0;
        int indexInFile = 0;
        int type = 1;

        String[] dataFromFile = loadData(sc, fileName);

        for (int i = 0; i < count; i++) {
            currentCount = Integer.parseInt(dataFromFile[i]);
            currentPosition = currentCount;
            indexInFile = i + 1;

            //TODO - udelat to po jednolivy radce

            while (currentPosition != 0) {
                switch (type) {
                    case 1:
                        warehouses = new String[currentCount];
                        createWarehouse(currentCount, indexInFile, dataFromFile);
                        break;

                    case 2:
                        customers = new String[currentCount];
                        createCustomer(currentCount, indexInFile, dataFromFile);
                        break;
                }

                currentPosition --;
                indexInFile ++;
            }

            type ++;
            indexInFile = 0;
            i += currentCount;
        }

        for(String data : warehouses) {
            System.out.println("Kolecko: " + data);
        }

        for(String data : customers) {
            System.out.println(data);
        }
//
//        for(String data : barrows) {
//            System.out.println(data);
//        }

    }
}