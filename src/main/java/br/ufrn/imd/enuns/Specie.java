package br.ufrn.imd.enuns;

/**
 * Bovine species.
 */
public enum Specie {
    /**
     * Angus specie.
     */
    ANGUS("Angus"),
    /**
     * Ayrshire specie.
     */
    AYRSHIRE("Ayrshire"),
    /**
     * Brahman specie.
     */
    BRAHMAN("Brahman"),
    /**
     * Brown Swiss specie.
     */
    BROWN_SWISS("Brown Swiss"),
    /**
     * Charolais specie.
     */
    CHAROLAIS("Charolais"),
    /**
     * Guernsey specie.
     */
    GUERNSEY("Guernsey"),
    /**
     * Hereford specie.
     */
    HEREFORD("Hereford"),
    /**
     * Holstein Friesian specie.
     */
    HOLSTEIN_FRIESIAN("Holstein Friesian"),
    /**
     * Jersey specie.
     */
    JERSEY("Jersey"),
    /**
     * Murray Grey specie.
     */
    MURRAY_GREY("Murray Grey"),
    /**
     * Santa Gertrudis specie.
     */
    SANTA_GERTRUDIS("Santa Gertrudis"),
    /**
     * Shorthorn specie.
     */
    SHORTHORN("Shorthorn"),
    /**
     * Banteng specie.
     */
    BANTENG("Banteng"),
    /**
     * Bison specie.
     */
    BISON("Bison"),
    /**
     * Gayal specie.
     */
    GAYAL("Gayal"),
    /**
     * Yak specie.
     */
    YAK("Yak"),
    /**
     * Aurochs specie.
     */
    AUROCHS("Aurochs"),
    /**
     * Gaur specie.
     */
    GAUR("Gaur"),
    /**
     * Kouprey specie.
     */
    KOUPREY("Kouprey"),
    /**
     * Others species.
     */
    OTHERS("Others");

    private String name;

    /**
     * Constructor to Specie.
     *
     * @param name
     */
    Specie(String name) {
        this.name = name;
    }

    /**
     * Returns name.
     *
     * @return name.
     */
    @Override
    public String toString() {
        return name;
    }
}
