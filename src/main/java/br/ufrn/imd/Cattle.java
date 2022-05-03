package br.ufrn.imd;

import br.ufrn.imd.enuns.*;
import br.ufrn.imd.utils.Utils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Class Cattle.
 *
 * @param <T> Generic type for the implementation of the vaccine.
 * @author Jonas, Neylane e Débora.
 */
@Getter
@Setter
@EqualsAndHashCode
public abstract class Cattle<T> {
    private static AtomicLong ID_GENERATOR = new AtomicLong(0);
    private Long id;

    private String name;

    private LocalDate birthday;
    private Float weigth;

    private Boolean isSick;
    private Boolean horn;

    private Specie specie;
    private Sex sex;
    private Color color;

    private List<String> feeding = new ArrayList<>();
    private Map<LocalDate, Vaccine<T>> doses = new HashMap<>();

    /**
     * Constructor of the class Cattle.
     *
     * @param name     Name of the cattle.
     * @param birthday Birthday of the cattle.
     * @param weigth   Weight of the cattle.
     * @param isSick   Is the cattle sick?
     * @param horn     Does the cattle have horns?
     * @param specie   Specie of the cattle.
     * @param sex      Sex of the cattle.
     * @param color    Color of the cattle.
     * @throws DateTimeException If the birthday is later than today.
     */
    public Cattle(String name, LocalDate birthday, Float weigth, Boolean isSick, Boolean horn, Specie specie,
                  Sex sex, Color color) throws DateTimeException {
        if (birthday.isAfter(LocalDate.now())) {
            final String errorMsg =
                    "Birthday " + Utils.LocalDateToString(birthday) + " must be before or equal to " + Utils.LocalDateToString(LocalDate.now()) + ".";
            throw new DateTimeException(errorMsg);
        }

        this.id = ID_GENERATOR.getAndIncrement();
        this.name = name;
        this.birthday = birthday;
        this.weigth = weigth;
        this.isSick = isSick;
        this.horn = horn;
        this.specie = specie;
        this.sex = sex;
        this.color = color;
    }

    /**
     * Method to set the birthday of Cattle.
     *
     * @param birthday Birthday of Cattle.
     * @throws DateTimeException If the birthday is later than today.
     */
    public void setBirthday(final LocalDate birthday) throws DateTimeException {
        if (birthday.isAfter(LocalDate.now())) {
            final String errorMsg =
                    "Birthday " + Utils.LocalDateToString(birthday) + " must be before or equal to " + Utils.LocalDateToString(LocalDate.now()) + ".";
            throw new DateTimeException(errorMsg);
        }
        this.birthday = birthday;
    }

    /**
     * Method to return the age of Cattle.
     *
     * @return Age.
     */
    public Integer getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    /**
     * Method to add the type of feeding for the cattle.
     *
     * @param feeding feeding type.
     * @throws IllegalArgumentException If some property of this element prevents it from being added to this list.
     */
    public void addFeeding(final String feeding) throws IllegalArgumentException {
        this.feeding.add(feeding);
    }

    /**
     * Method to add a vaccine to the cattle's register.
     *
     * @param date    date of the vaccine.
     * @param vaccine name of the vaccine.
     * @throws IllegalArgumentException If the specified key or value is null and this map does not permit null keys
     *                                  or values.
     * @throws NullPointerException     If some property of the specified key or value prevents it from being stored
     *                                  in this map.
     * @throws DateTimeException        If the date is later than today.
     */
    public void addDose(final LocalDate date, final Vaccine<T> vaccine) throws IllegalArgumentException,
            NullPointerException, DateTimeException {
        if (date.isAfter(LocalDate.now())) {
            final String errorMsg =
                    "Date " + Utils.LocalDateToString(birthday) + " must be before or equal to " + Utils.LocalDateToString(LocalDate.now()) + ".";
            throw new DateTimeException(errorMsg);
        }

        this.doses.put(date, vaccine);
    }

    /**
     * Search vaccine by date.
     *
     * @param date Date of vaccine application.
     * @return Entry with date and vaccine searched.
     * @throws NullPointerException   If the element selected is null.
     * @throws NoSuchElementException Vaccine was not found in map.
     * @throws IllegalStateException  Implementations may, but are not required to, throw this exception if the entry
     *                                has been removed from the backing map.
     */
    public Map.Entry<LocalDate, Vaccine<T>> searchVaccineByDate(final LocalDate date) throws NullPointerException,
            NoSuchElementException, IllegalStateException {
        Map.Entry<LocalDate, Vaccine<T>> mapEntry = doses.entrySet().stream()
                .filter(entry -> entry.getKey().isEqual(date))
                .findFirst().orElse(null);

        if (mapEntry == null)
            throw new NoSuchElementException("Vaccine with date " + Utils.LocalDateToString(date) + " was not " +
                    "found in map.");
        return mapEntry;
    }

    /**
     * Search first vaccine by name.
     *
     * @param name Name of vaccine to be searched.
     * @return Entry with date and vaccine searched.
     * @throws NullPointerException   If the name or element selected is null.
     * @throws NoSuchElementException If the vaccine is not found in list.
     * @throws IllegalStateException  Implementations may, but are not required to, throw this exception if the entry
     *                                has been removed from the backing map.
     */
    public Map.Entry<LocalDate, Vaccine<T>> searchFirstVaccineByName(final String name) throws NullPointerException,
            NoSuchElementException, IllegalStateException {
        Map.Entry<LocalDate, Vaccine<T>> mapEntry = doses.entrySet().stream()
                .filter(entry -> entry.getValue().getName().contains(name))
                .findFirst().orElse(null);

        if (mapEntry == null)
            throw new NoSuchElementException("Vaccine with name contains " + name + " was not found in map.");
        return mapEntry;
    }

    /**
     * Search all vaccines by name.
     *
     * @param name Name of vaccine to be searched.
     * @return Map with all dates and vaccines searched.
     * @throws NullPointerException   If the name or element selected is null.
     * @throws NoSuchElementException If the vaccine is not found in list.
     * @throws IllegalStateException  Implementations may, but are not required to, throw this exception if the entry
     *                                has been removed from the backing map.
     */
    public Map<LocalDate, Vaccine<T>> searchAllVaccinesByName(final String name) throws NullPointerException,
            NoSuchElementException, IllegalStateException {
        Map<LocalDate, Vaccine<T>> map = doses.entrySet().stream()
                .filter(entry -> entry.getValue().getName().contains(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if (map.isEmpty())
            throw new NoSuchElementException("Vaccines with names contains " + name + " were not found in map.");
        return map;
    }

    /**
     * Print all foods.
     */
    public void printFeeding() {
        Utils.print(Utils.ListToString(feeding));
    }

    /**
     * Print all doses taken.
     *
     * @throws DateTimeException If an error occurs during printing.
     */
    public void printDoses() throws DateTimeException {
        Utils.print(Utils.MapToString(doses, t -> Utils.LocalDateToString(t)));
    }

    /**
     * Returns a string with representation of my cattle.
     *
     * @return Cattle representation in string.
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append(System.getProperty("line.separator"))
                .append("Id: ").append(id)
                .append(System.getProperty("line.separator"))
                .append("Name: ").append(name)
                .append(System.getProperty("line.separator"))
                .append("Birthday: ").append(Utils.LocalDateToString(birthday))
                .append(System.getProperty("line.separator"))
                .append("Weigth: ").append(weigth.toString())
                .append(System.getProperty("line.separator"))
                .append("Is Sick: ").append(isSick.toString())
                .append(System.getProperty("line.separator"))
                .append("Has Horn: ").append(horn)
                .append(System.getProperty("line.separator"))
                .append("Specie: ").append(specie.toString())
                .append(System.getProperty("line.separator"))
                .append("Sex: ").append(sex.toString())
                .append(System.getProperty("line.separator"))
                .append("Color: ").append(color.toString())
                .append(System.getProperty("line.separator"))
                .append("Feeding: ").append(Utils.ListToString(feeding))
                .append(System.getProperty("line.separator"))
                .append("Doses: ").append(Utils.MapToString(doses, t -> Utils.LocalDateToString(t)))
                .toString();
    }
}
