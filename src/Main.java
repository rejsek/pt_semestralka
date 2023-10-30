import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

/**
 * Hlavni trida, slouzi pro spusteni programu
 */
public class Main {
    /**
     * Konstanta pro adresar
     */
    private static String PATH = "inputs/";

    /**
     * Pole pro reprezentaci objektu skladu
     */
    private static Warehouse[] warehouses;

    /**
     * Pole pro reprezentaci objektu zakazniku
     */
    private static Customer[] customers;

    /**
     * Pole pro reprezentaci cest
     */
    private static Way[] ways;

    /**
     * Pole pro reprezentaci kolecek
     */
    private static Barrow[] barrowsTypes;

    /**
     * Realna vyuzitelna kolecka
     */
    private static Barrow[] barrows;

    /**
     * Pole pro reprezentaci pozadavku
     */
    private static Request[] requests;

    /**
     * Pocita id
     */
    private static int z = 1;

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

        while (sc.hasNext()) {
            current = sc.next();

            if (current.equals("❄")) {
                while (!current.equals("⛏")) {
                    current = sc.next();

                    if(current.equals("⛏⛏")) {
                        break;
                    }
                }
            } else {
                if(current.endsWith("⛏") || current.endsWith("❄")) {
                    continue;
                } else {
                    size ++;
                }
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
        int comment = 0;    //citac, zda jsem v komentari
        String[] data = new String[size];
        String current = "";

        String fullPath = PATH + filename;
        sc = new Scanner(Paths.get(fullPath));

        while(sc.hasNext()) {
            current = sc.next();

            if(current.equals("❄") || current.equals("⛏")) {
                switch (current) {
                    case "⛏":
                        while(!current.equals("❄")) {
                            current = sc.next();
                        }

                        break;

                    case "❄":
                        while(!current.equals("⛏")) {
                            current = sc.next();

                            if(current.equals("⛏⛏")) {
                                break;
                            }
                        }

                        break;
                }

            } else {
                if(current.endsWith("⛏") || current.endsWith("❄")) {
                    continue;
                } else {
                    if(current.contains("⛏") || current.contains("❄")) {
                        String numbersOnly = current.replaceAll("[^\\d]", "");
                        data[position] = numbersOnly.trim();
                        position ++;

                    } else {
                        data[position] = current.trim();
                        position ++;
                    }
                }
            }
        }

        return data;
    }

    private static void setArrays(String[] dataFromFile, int count) {
        /**
         * Metoda z prichozich dat ze soboru nastavi pole objekty
         *
         * @param dataFromFile      obsah souboru
         * @param count             pocet zaznamu v souboru
         */

        int currentCount;
        int indexInFile = 0;
        int type = 1;
        boolean firstIteration = true;
        boolean arraySetup = true;
        int iterations;
        int arraySize;
        int index = 0;
        double[] data;
        String[] barrowData;

        while(indexInFile != count) {
            currentCount = Integer.parseInt(dataFromFile[indexInFile]);
            arraySize = currentCount;

            while(currentCount != 0) {
                if (firstIteration) {
                    indexInFile ++;
                    firstIteration = false;
                }

                switch (type) {
                    case 1:
                        if(arraySetup) {
                            warehouses = new Warehouse[currentCount];
                            arraySetup = false;
                        }

                        iterations = 0;

                        data = new double[5];

                        while(iterations != 5) {
                            data[iterations] = Double.parseDouble(dataFromFile[indexInFile]);

                            indexInFile ++;
                            iterations ++;
                        }

                        warehouses[index] = new Warehouse(z, data[0], data[1], data[2], data[3], data[4]);
                        z ++;

                        break;

                    case 2:
                        if(arraySetup) {
                            customers = new Customer[currentCount];
                            arraySetup = false;
                        }

                        iterations = 0;

                        data = new double[2];

                        while(iterations != 2) {
                            data[iterations] = Double.parseDouble(dataFromFile[indexInFile]);

                            indexInFile ++;
                            iterations ++;
                        }

                        customers[index] = new Customer(z, data[0], data[1]);
                        z ++;

                        break;

                    case 3:
                        if(arraySetup) {
                            ways = new Way[currentCount];
                            arraySetup = false;
                        }

                        iterations = 0;

                        data = new double[2];

                        while(iterations != 2) {
                            data[iterations] = Double.parseDouble(dataFromFile[indexInFile]);

                            indexInFile ++;
                            iterations ++;
                        }

                        ways[index] = new Way(data[0], data[1]);

                        break;

                    case 4:
                        if(arraySetup) {
                            barrowsTypes = new Barrow[currentCount];
                            arraySetup = false;
                        }

                        iterations = 0;

                        String barrowName = "";
                        data = new double[7];

                        while(iterations != 8) {
                            if(iterations == 0) {
                                barrowName = dataFromFile[indexInFile];
                            } else {
                                data[iterations - 1] = Double.parseDouble(dataFromFile[indexInFile]);
                            }

                            indexInFile ++;
                            iterations ++;
                        }

                        barrowsTypes[index] = new Barrow(barrowName, data[0], data[1], data[2], data[3], data[4], data[5], data[6]);

                        break;

                    case 5:
                        if(arraySetup) {
                            requests = new Request[currentCount];
                            arraySetup = false;
                        }

                        iterations = 0;

                        data = new double[4];

                        while(iterations != 4) {
                            try {
                                data[iterations] = Double.parseDouble(dataFromFile[indexInFile]);

                                indexInFile++;
                                iterations++;
                            } catch (Exception ex) {
                                indexInFile++;
                            }
                        }

                        requests[index] = new Request(data[0], data[1], data[2], data[3]);

                        break;
                }

                index ++;
                currentCount --;
            }

            firstIteration = true;
            arraySetup = true;
            type ++;
            index = 0;
        }
    }

    private static void printArrays() {
        /**
         * Metoda pro vypis obsahu vsech poli obsazenych ve tride
         */

        System.out.println("Sklady: ");
        for(Warehouse data : warehouses) {
            System.out.println(data.toString());
        }

        System.out.println("Zakaznici: ");
        for(Customer data : customers) {
            System.out.println(data.toString());
        }

        System.out.println("Cesty: ");
        for(Way data : ways) {
            System.out.println(data.toString());
        }

        System.out.println("Kolecka: ");
        for(Barrow data : barrowsTypes) {
            System.out.println(data.toString());
        }

        System.out.println("Pozadavky: ");
        for(Request data : requests) {
            System.out.println(data.toString());
        }
    }

    public static boolean crossedDeadline(double current_time, int deadline){
        if(current_time>deadline){
            //sout kolečko nestihlo splnit požadavek
            //asi parametrem předat celé kolečko
            //System.out.println("DEADLINE CROSSED");
            return true;
        }
        return false;
    }

    private static void realizeRequests(Graph g) throws InterruptedException {
//        for(String request : requests) {
//            String[] splitRequest = request.split("\\s+");
//            int deadline = Integer.parseInt(splitRequest[3]);
//
//            System.out.printf("Cas: %s, Zakaznik: %s, Pocet pytlu: %s, Deadline: \n", splitRequest[0], splitRequest[1], splitRequest[2], splitRequest[3]);
//        }

        Request splitRequest = requests[0];

        System.out.printf("Cas: %s, Zakaznik: %s, Pocet pytlu: %s, Deadline: %s\n", splitRequest.getArrivedTime(), splitRequest.getIdCustomer(), splitRequest.getBagCount(), splitRequest.getRequestTime());

        int time = (int) splitRequest.getArrivedTime();
        int bagCount =  (int)splitRequest.getBagCount();
        int deadline = (int)splitRequest.getRequestTime();
        int customerID = (int)splitRequest.getIdCustomer(); //+ warehouses.length;
        //double distance = g.getEdges()[(customerID)].edgeWeight;  //??????

        //jedeme vždy z prvního skladu
        double distance = g.shortestPathLengthE(warehouses[0], customers[customerID]);
        Barrow barrow = new Barrow(barrowsTypes[0]);



        //potrebuju zjistit z jakyho skladu ma kolecko vyjet a jaky kolecko ma vyjet

        System.out.printf("Cas: %d, Kolecko: 1, Sklad: %d, Nalozeno pytlu: %d, Odjezd v: %d\n", time, warehouses[0].getId(), bagCount, (int) (time + warehouses[0].getLoadTime()*bagCount));
        time += warehouses[0].getLoadTime()*bagCount; //naložení
        warehouses[0].setBagCount(warehouses[0].getBagCount()-bagCount); //chce to dodelat kontroly: jestli je ve skladu dostatek, a jestli to kolecko uveze
        if(crossedDeadline(time, deadline)){
            System.out.printf("Cas: %d, Zakaznik %d umrzl zimou, protoze jezdit s koleckem je hloupost, konec",time,customerID);
            return;
        }
        barrow.damage(distance);
        time += distance/barrow.getSpeed();
        if(crossedDeadline(time, deadline)){
            System.out.printf("Cas: %d, Zakaznik %d umrzl zimou, protoze jezdit s koleckem je hloupost, konec",time,customerID);
            return;
        }
        System.out.printf("Cas: %d, Kolecko: 1, Zakaznik: %d, Vylozeno pytlu: %d, Vylozeno v: %d, Casova rezerva: %d\n", time, customerID, bagCount, (int) (time + warehouses[0].getLoadTime()*bagCount), (int) (deadline - (time + warehouses[0].getLoadTime()*bagCount)));
        time += warehouses[0].getLoadTime()*bagCount; //vyložení
        if(crossedDeadline(time, deadline)){
            System.out.printf("Cas: %d, Zakaznik %d umrzl zimou, protoze jezdit s koleckem je hloupost, konec",time,customerID);
            return;
        }
        barrow.damage(distance);
        time += distance/barrow.getSpeed();
        if(crossedDeadline(time, deadline)){
            System.out.printf("Cas: %d, Zakaznik %d umrzl zimou, protoze jezdit s koleckem je hloupost, konec",time,customerID);
            return;
        }
        System.out.printf("Cas: %d, Kolecko: 1, Navrat do skladu: %d\n", time, warehouses[0].getId());

        System.out.printf("Počet pytlů: %d, počet požadavků splněno: %d", bagCount, 1);

        //jak určit jestli kolečko potřebuje opravit?
        //System.out.println(); zpráva o tom že potřebuje opravit
        /*if(barrow.getDurability()<???){
            time += barrow.getRepair_time();
            barrow.setDurability(barrow.getMax_distance());
        }*/

        /*
         *  TODO
         *  tohle je potřeba předělat na smyčku
         *   chybí:
         *       odečíst bags ze skladu (udelany bez kontroly)
         *       * kontrola deadline  //funkční (???) ale dodělat tu officialni zpravu
         *       Zpravu pokud by byla potrebova oprava
         *
         *       konstruktor pro použitelné kola + jejich pole //funkční ale nedodělaný - nevime jak velky ma bejt pole
         *       náhodná generace kol podle daného ratio       //funkční
         *       upravit přidávání hrany grafu + ?Dijkstra Algorithm?
         *       pravdepodobne pridavame ty VAHY HRAN spatne (delali jsme to podle tutorial.txt)
         *
         *      * prohledání do šířky/hloubky (???), zjistíme kudy má projít
         *      * kontrola kudy má jít
         *
         *       kontrola jestli je na skladě tolik pytlů kolik potřebujeme
         *       zařídit aby se ve skladech restockovaly bags po restockTime
         *       - zeptat se Dana jestli mluvil s tema co to odevzdali, jak udelat s casem
         *
         *
         *
         *
         *
         *
         *       jestli se do kolečka vejde tolik pytlů kolik potřebujeme
         *
         *       kolečka aby měla ID (asi fuknční)
         *      * kolečka/druhy koleček //funkční
         *
         *
         *       možná potřebuje každé kolečko svůj vlastní čas? protože budou jezdit nezávisle na sobě a tudíž nemůžeme mít 1 čas pro všechny
         *
         * */





       /* int kvota = bagCount / barrow.getMax_capacity();
        if(((double)bagCount / (double) barrow.getMax_capacity() ) - kvota > 0 ) kvota++;
        // distance * 2 * kvota = celkova dalka kterou kolecko ujede pro dokonceni pozadavku*/

        //ted nasimulovat tu cestu toho kolečka. Je potřeba to simulovat doslova? jakože přímo čekat (třeba přes príkaz sleep()) přesně ten čas, jak dlouho trvá kolečku tam dojet?
        //co je rychlost kolečka? jestli to je jakou vzdálenost ujede za 1 sekundu, tak je to hodne pomaly ale nevim co jinyho by to bylo

        //







    }

    private static void createBarrows(int index){
        double total_ratio=0;
        for(int i = 0; i < barrowsTypes.length;i++){
            total_ratio+=barrowsTypes[i].getRatio(); // ratio z pole TYPU kolecek musi dat dohromady 1.0 (100%)
        }

        if(total_ratio != 1.0){
            System.out.println("Celkové ratio nedává 100%");
        }
        else{
            Random random = new Random();
            double rand = random.nextDouble(); // vygeneruje se hodnota mezi 0.0 - 1.0
            double current_ratio= 0;
            for(int i = 0; i < barrowsTypes.length;i++){
                current_ratio+=barrowsTypes[i].getRatio();
                if(rand < current_ratio){
                    barrows[index] =  new Barrow(barrowsTypes[i]);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        /**
         * Vstupni bod programu
         *
         * @param args      parametry prikazove radky
         */

        String fileName = "tutorial.txt";
        Scanner sc = null;
        Graph g = new Graph();

        String[] dataFromFile = loadData(sc, fileName);

        int count = sizeOfArray(sc, fileName);

        setArrays(dataFromFile, count);
        printArrays();

        g.initialize(z);

        barrows = new Barrow[10];
        for(int i = 0; i < barrows.length; i ++) {
            createBarrows(i);
        }

        int warehousesLength = warehouses.length;
        IGraph[] edge = new IGraph[2]; //ulozi pro pridani do grafu

        for(int i = 0; i < ways.length; i ++) {
            double start = ways[i].getIdStart();
            double end = ways[i].getIdEnd();

            int index1;
            int index2;

            if (start > warehousesLength) {
                index1 = (int) start - warehousesLength - 1;
                edge[0] = customers[index1];
            } else {
                index1 = (int) start - 1;
                edge[0] = warehouses[index1];
            }

            if (end > warehousesLength) {
                index2 = (int) end - warehousesLength - 1;
                edge[1] = customers[index2];
            } else {
                index2 = (int) end - 1;
                edge[1] = warehouses[index2];
            }

            System.out.print(edge[0].getId() + " -> " + edge[1].getId() + "\n");
            double edgeWeight = Math.sqrt(Math.pow(edge[0].getX() - edge[1].getX(), 2) + Math.pow(edge[0].getY() - edge[1].getY(), 2)); //spocte ohodnoceni hrany pomoci vzorce pro vypocet delky vektoru
            g.addEdge(edge[0], edge[1], edgeWeight);
        }

        // System.out.println(g.shortestPathLength(warehouses[0], customers[3]));

        realizeRequests(g);
    }
}