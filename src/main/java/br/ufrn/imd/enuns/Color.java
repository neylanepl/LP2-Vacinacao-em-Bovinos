package br.ufrn.imd.enuns;

/**
 * Bovine pigmentations.
 */
public enum Color {
    /**
     * Red color.
     */
    RED("Red"),
    /**
     * Orange color.
     */
    ORANGE("Orange"),
    /**
     * Black color.
     */
    BLACK("Black"),
    /**
     * Red and Black color.
     */
    RED_AND_BLACK("Red and Black"),
    /**
     * White or Cream color.
     */
    WHITE_OR_CREAM("White or Cream"),
    /**
     * Others colors.
     */
    OTHERS("Others");

    private String name;

    /**
     * Constructor to Color.
     *
     * @param name Name of colors.
     */
    Color(String name) {
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
