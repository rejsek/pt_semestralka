import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static String PATH = "inputs/";

    private static Warehouse[] warehouses;

    private static Customer[] customers;

    private static String[] ways;

    private static Barrow[] barrows;

    private static String[] requests;

    private static int indexInFile = 0;
    private static int index = 0;

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

    private static int[] getIntData(String[] dataFromFile) {
        String data = dataFromFile[index];
        String[] splitData = data.split("\\s+");
        int[] convertedData = new int[splitData.length];

        for(int j = 0; j < convertedData.length; j ++) {
            convertedData[j] = Integer.parseInt(splitData[j]);
        }

        return  convertedData;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "tutorial.txt";
        Scanner sc = null;

        int currentPosition, currentCount;
        int count = sizeOfArray(sc, fileName);
        int type = index = 1;
        int array_index = 0;
        boolean firstIteration = true;

        String[] dataFromFile = loadData(sc, fileName);

        for (int i = 0; i < count; i++) {
            currentCount = Integer.parseInt(dataFromFile[i]);
            currentPosition = currentCount;

            while(currentPosition != 0) {
                switch (type) {
                    case 1:
                        if (firstIteration) {
                            warehouses = new Warehouse[currentCount];
                        }

                        int[] warehouseData = getIntData(dataFromFile);

                        warehouses[array_index] = new Warehouse(warehouseData[0], warehouseData[1], warehouseData[2], warehouseData[3], warehouseData[4]);
                        break;

                    case 2:
                        if (firstIteration) {
                            customers = new Customer[currentCount];
                        }

                        int[] customerData = getIntData(dataFromFile);

                        customers[array_index] = new Customer(0, customerData[0], customerData[1]);
                        break;

                    case 3:
                        if (firstIteration) {
                            ways = new String[currentCount];
                        }

                        ways[array_index] = dataFromFile[index];
                        break;

                    case 4:
                        if (firstIteration) {
                            barrows = new Barrow[currentCount];
                        }

                        int[] barrowData = getIntData(dataFromFile);

                        //TODO - upravit vytvoreni objektu, jako prvni argument se dava String
                        //barrows[array_index] = new Barrow(barrowData[0], barrowData[1], barrowData[2], barrowData[3], barrowData[4], barrowData[5], barrowData[6], barrowData[7]);
                        break;

                    case 5:
                        if (firstIteration) {
                            requests = new String[currentCount];
                        }

                        requests[array_index] = dataFromFile[index];
                        break;
                }

                array_index ++;
                index ++;
                currentPosition --;
                firstIteration = false;
            }

            type ++;
            i += currentCount;
            index ++;
            array_index = 0;
            firstIteration = true;
        }

        System.out.println("Sklady: ");
        for(Warehouse data : warehouses) {
            System.out.println(data.toString());
        }
//
//        System.out.println("Cesty: ");
//        for(String data : ways) {
//            System.out.println(data);
//        }
//
//        System.out.println("Zakaznici: ");
//        for(String data : customers) {
//            System.out.println(data);
//        }
//
//        System.out.println("Kolecka: ");
//        for(String data : barrows) {
//            System.out.println(data);
//        }
//
//        System.out.println("Pozadavky: ");
//        for(String data : requests) {
//            System.out.println(data);
//        }
    }
}
