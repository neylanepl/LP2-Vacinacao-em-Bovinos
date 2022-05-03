package br.ufrn.imd;

import com.google.common.primitives.UnsignedInteger;
import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Class Vaccine.
 *
 * @param <T> Generic type for the extra information of the vaccine.
 * @author Jonas, Neylane e Débora.
 */
@Data
public class Vaccine<T> {
    private static AtomicLong ID_GENERATOR = new AtomicLong(0);
    private Long id;

    private String name;
    private String manufacturer;

    private UnsignedInteger periodicInDays;
    private Float amountOfmls;

    private T extraInformations;

    /**
     * Constructor of the Vaccine.
     *
     * @param name              Name of the vaccine.
     * @param manufacturer      Company which manufactores the vaccine.
     * @param periodicInDays    Number of days to get another shot of the vaccine.
     * @param amountOfmls       Amount of milliliters of the vaccine.
     * @param extraInformations Extra information about the vaccine.
     * @throws IllegalArgumentException If period is negative or >= 2^32.
     */
    public Vaccine(String name, String manufacturer, UnsignedInteger periodicInDays, Float amountOfmls,
                   T extraInformations) throws IllegalArgumentException {
        this.id = ID_GENERATOR.getAndIncrement();
        this.name = name;
        this.manufacturer = manufacturer;
        this.periodicInDays = periodicInDays;
        this.amountOfmls = amountOfmls;
        this.extraInformations = extraInformations;
    }

    /**
     * Returns a string with representation of my vaccine.
     *
     * @return Vaccine representation in string.
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append("\uD83D\uDC89\uD83D\uDC89\uD83D\uDC89\uD83D\uDC89\uD83D\uDC89\uD83D\uDC89\uD83D\uDC89\uD83D")
                .append("\uDC89\uD83D\uDC89\uD83D\uDC89\uD83D\uDC89\uD83D\uDC89\uD83D\uDC89\uD83D\uDC89\uD83D\uDC89")
                .append(System.getProperty("line.separator"))
                .append("Id: ").append(id)
                .append(System.getProperty("line.separator"))
                .append("Name: ").append(name)
                .append(System.getProperty("line.separator"))
                .append("Manufacturer: ").append(manufacturer)
                .append(System.getProperty("line.separator"))
                .append("Periodic Between Doses (Days): ").append(periodicInDays)
                .append(System.getProperty("line.separator"))
                .append("Amount (mls): ").append(amountOfmls)
                .append(System.getProperty("line.separator"))
                .append("Extra Information: ").append(extraInformations.toString())
                .append(System.getProperty("line.separator"))
                .append("----------------------------------------")
                .toString();
    }
}
