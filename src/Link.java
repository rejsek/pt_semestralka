/**
 * Prvek spojoveho seznamu pro ulozeni sousedu vrcholu grafu
 */
class Link {
    /** Cislo souseda */
    int neighbour;
    /** Odkaz na dalsiho souseda */
    Link next;

    /**
     * Vytvori novy prvek seznamu pro ulozeni souseda vrcholu grafu
     * @param n cislo souseda
     * @param next odkaz na dalsiho souseda
     */
    public Link(int n, Link next) {
        neighbour = n;
        this.next = next;
    }
}