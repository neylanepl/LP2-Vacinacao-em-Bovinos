package br.ufrn.imd.enuns;

/**
 * Bovine sexes.
 */
public enum Sex {
    /**
     * Felame.
     */
    FEMALE("Female"),
    /**
     * Male.
     */
    MALE("Male");

    private String name;

    /**
     * Constructor to Sex.
     *
     * @param name
     */
    Sex(String name) {
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
