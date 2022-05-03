package br.ufrn.imd;

import br.ufrn.imd.enuns.Color;
import br.ufrn.imd.enuns.Sex;
import br.ufrn.imd.enuns.Specie;
import br.ufrn.imd.utils.Utils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Class Cow, which extends from the superclass Cattle.
 *
 * @param <T> Generic type for the implementation of the vaccine.
 * @author Jonas, Neylane e Débora.
 * @see Cattle
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Cow<T> extends Cattle<T> {
    private Float milkProduction;

    private Boolean isMilking;
    private Boolean isPregnant;

    private ArrayList<Cattle<T>> children = new ArrayList<>();

    /**
     * Constructor of the class Cow, which has all the attributes of Cattle and some others specific for Cow.
     *
     * @param name           Name of the cattle.
     * @param birthday       Birthday of the cattle.
     * @param weigth         Weight of the cattle.
     * @param isSick         Is the cattle sick?
     * @param horn           Does the cattle have horns?
     * @param specie         Specie of the cattle.
     * @param color          Color of the cattle.
     * @param milkProduction Milk production of the cow (in number of liters).
     * @param isMilking      Is the cow milking?
     * @param isPregnant     Is the cow pregnant?
     * @throws DateTimeException If the birthday is later than today.
     */
    public Cow(String name, LocalDate birthday, Float weigth, Boolean isSick, Boolean horn, Specie specie,
               Color color, Float milkProduction, Boolean isMilking, Boolean isPregnant) throws DateTimeException {
        super(name, birthday, weigth, isSick, horn, specie, Sex.FEMALE, color);
        this.milkProduction = milkProduction;
        this.isMilking = isMilking;
        this.isPregnant = isPregnant;
    }

    /**
     * Method to add a calf to the cow's register, if it's pregnant.
     *
     * @param child Registers all the information of the child (type Cattle).
     * @throws IllegalArgumentException If some property of this element prevents it from being added to this list.
     */
    public void addChildren(final Cattle<T> child) throws IllegalArgumentException {
        this.children.add(child);
    }

    /**
     * Return amount of children that the cow has.
     *
     * @return Amount of children.
     */
    public Integer amounOfChildren() {
        return children.size();
    }

    /**
     * Search all children by name.
     *
     * @param name Name of child to be searched.
     * @return List of children.
     * @throws NullPointerException   If the name is null.
     * @throws NoSuchElementException If the children are not found in list.
     */
    public List<Cattle<T>> searchAllChildrenByName(final String name) throws NullPointerException,
            NoSuchElementException {
        List<Cattle<T>> list = children.stream()
                .filter(child -> child.getName().contains(name)).toList();

        if (list.isEmpty())
            throw new NoSuchElementException("Children with names contains " + name + " was not found.");
        return list;
    }

    /**
     * Search first child by name.
     *
     * @param name Name of child to be searched.
     * @return Child.
     * @throws NullPointerException   If the name or element selected is null.
     * @throws NoSuchElementException If the child is not found in list.
     */
    public Cattle<T> searchFirstChildByName(final String name) throws NullPointerException, NoSuchElementException {
        Cattle<T> cattle = children.stream()
                .filter(child -> child.getName().contains(name))
                .findFirst()
                .orElse(null);

        if (cattle == null)
            throw new NoSuchElementException("Child with name contains " + name + " were not found in list.");
        return cattle;
    }

    /**
     * Print all children.
     */
    public void printChildrens() {
        Utils.print(Utils.ListToString(children));
    }

    /**
     * Returns a string with representation of my cow.
     *
     * @return Cow representation in string.
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append("\uD83D\uDC04\uD83D\uDC04\uD83D\uDC04\uD83D\uDC04\uD83D\uDC04\uD83D\uDC04\uD83D\uDC04\uD83D")
                .append("\uDC04\uD83D\uDC04\uD83D\uDC04\uD83D\uDC04\uD83D\uDC04\uD83D\uDC04\uD83D\uDC04\uD83D\uDC04")
                .append(super.toString())
                .append(System.getProperty("line.separator"))
                .append("Milk Production: ").append(milkProduction.toString())
                .append(System.getProperty("line.separator"))
                .append("Is Milking: ").append(isMilking.toString())
                .append(System.getProperty("line.separator"))
                .append("Is Pregnant: ").append(isPregnant.toString())
                .append(System.getProperty("line.separator"))
                .append("Children: ").append(Utils.ListToString(children))
                .append(System.getProperty("line.separator"))
                .append("----------------------------------------")
                .append(System.getProperty("line.separator"))
                .toString();
    }
}
