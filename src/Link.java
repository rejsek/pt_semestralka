/**
 * Prvek spojoveho seznamu pro ulozeni sousedu vrcholu grafu
 */
class Link {
    /**
     * Soused
    */
    IGraph neighbour;

    /**
     * Ohodnoceni hrany
     */
    double edgeWeight;

    /**
     * Odkaz na dalsiho souseda
    */
    Link next;

    /**
     * Vytvori novy prvek seznamu pro ulozeni souseda vrcholu grafu
     * @param n cislo souseda
     * @param next odkaz na dalsiho souseda
     */
    public Link(IGraph n, Link next, double edgeWeight) {
        this.neighbour = n;
        this.next = next;
        this.edgeWeight = edgeWeight;
    }
}