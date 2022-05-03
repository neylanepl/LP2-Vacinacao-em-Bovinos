package br.ufrn.imd;

import br.ufrn.imd.enuns.Color;
import br.ufrn.imd.enuns.Sex;
import br.ufrn.imd.enuns.Specie;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Class Ox, which extends from the superclass Cattle.
 *
 * @param <T> Generic type for the implementation of the vaccine.
 * @author Jonas, Neylane e Débora.
 * @see Cattle
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Ox<T> extends Cattle<T> {
    private Boolean isBreeder;
    private Boolean isCastrated;

    /**
     * Constructor of the class Ox, which has all the attributes of Cattle and some others specific for Ox.
     *
     * @param name        Name of the cattle.
     * @param birthday    Birthday of the cattle.
     * @param weigth      Weight of the cattle.
     * @param isSick      Is the cattle sick?
     * @param horn        Does the cattle have horns?
     * @param specie      Specie of the cattle.
     * @param color       Color of the cattle.
     * @param isBreeder   Is the ox a breeder?
     * @param isCastrated Is the ox castrated?
     * @throws DateTimeException If the birthday is later than today.
     */
    public Ox(String name, LocalDate birthday, Float weigth, Boolean isSick, Boolean horn, Specie specie,
              Color color, Boolean isBreeder, Boolean isCastrated) throws DateTimeException {
        super(name, birthday, weigth, isSick, horn, specie, Sex.MALE, color);
        this.isBreeder = isBreeder;
        this.isCastrated = isCastrated;
    }

    /**
     * Returns a string with representation of my ox.
     *
     * @return Ox representation in string.
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append("\uD83D\uDC02\uD83D\uDC02\uD83D\uDC02\uD83D\uDC02\uD83D\uDC02\uD83D\uDC02\uD83D\uDC02\uD83D")
                .append("\uDC02\uD83D\uDC02\uD83D\uDC02\uD83D\uDC02\uD83D\uDC02\uD83D\uDC02\uD83D\uDC02\uD83D\uDC02")
                .append(super.toString())
                .append(System.getProperty("line.separator"))
                .append("Is Breeder: ").append(isBreeder.toString())
                .append(System.getProperty("line.separator"))
                .append("Is Castrated: ").append(isCastrated.toString())
                .append(System.getProperty("line.separator"))
                .append("----------------------------------------")
                .append(System.getProperty("line.separator"))
                .toString();
    }
}
