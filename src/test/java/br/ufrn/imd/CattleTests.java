package br.ufrn.imd;

import br.ufrn.imd.enuns.Color;
import br.ufrn.imd.enuns.Specie;
import br.ufrn.imd.utils.Utils;
import com.google.common.primitives.UnsignedInteger;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static br.ufrn.imd.utils.Utils.BRAZILIAN_DATE_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CattleTests {

    private Cow<String> cow;
    private Ox<String> ox;

    private List<Cattle<String>> bezerro_list;
    private List<Vaccine<String>> vaccine_list;

    @BeforeAll
    final public void prepareData() {
        this.initializeCow();
        this.initializeOx();
        this.initializeBezerros();
        this.initializeVaccineList();
        this.applyVaccinesInCow();
        this.initializeFood();
    }

    private void initializeCow() {
        cow = new Cow<String>("(vaca) - Grace", LocalDate.parse("29/02/2019", BRAZILIAN_DATE_FORMAT), 400f, false,
                false,
                Specie.JERSEY, Color.WHITE_OR_CREAM, 1.5f, true, false);
    }

    private void initializeOx() {
        ox = new Ox<String>("(boi) - Jeremias", LocalDate.parse("10/05/2015", BRAZILIAN_DATE_FORMAT), 600f, false, true,
                Specie.AUROCHS, Color.RED, true, false);
    }

    private void initializeBezerros() {
        Ox<String> bezerro_mimoso = new Ox<String>("(bezerro) - Mimoso", LocalDate.parse("07/03/2001",
                BRAZILIAN_DATE_FORMAT), 90f,
                false, false, Specie.ANGUS, Color.RED_AND_BLACK, true, false);
        Ox<String> bezerro_canaro = new Ox<String>("(bezerro) - Canaro", LocalDate.parse("01/04/2002",
                BRAZILIAN_DATE_FORMAT), 120f,
                false, false, Specie.BISON, Color.BLACK, true, false);
        Cow<String> bezerra_estrelinha = new Cow<String>("(bezerra) - Estrelinha", LocalDate.parse("05/02/1999",
                BRAZILIAN_DATE_FORMAT), 100f,
                false, false, Specie.CHAROLAIS, Color.ORANGE, 0f, false, false);

        bezerro_list = Arrays.asList(bezerro_mimoso, bezerro_canaro, bezerra_estrelinha);

        for (Cattle<String> bezerro : bezerro_list)
            cow.addChildren(bezerro);
    }

    private void initializeVaccineList() {
        Vaccine<String> vaccine_febre_aftosa = new Vaccine<String>("Febre Raiva", "ourofino sa",
                UnsignedInteger.valueOf(180), 30f,
                "Não indicado para menores de 6 meses.");
        Vaccine<String> vaccine_brucelose = new Vaccine<String>("Brucelose", "ourofino sa", null, 30f,
                "Dose única em femeas 3-8 meses.");
        Vaccine<String> vaccine_clostridioses = new Vaccine<String>("Clostridioses", "ourofino sa",
                UnsignedInteger.valueOf(30), 30f,
                "Todos os animais devem tomar, iniciando aos dois meses + 1 dose de reforço.");
        Vaccine<String> vaccine_botulismo = new Vaccine<String>("Botulismo", "ourofino sa",
                UnsignedInteger.valueOf(42), 30f,
                "Duas doses e mais uma dose anual em todo rebanho.");
        Vaccine<String> vaccine_raiva = new Vaccine<String>("Raiva Bovina", "ourofino sa",
                UnsignedInteger.valueOf(30), 30f,
                "Aplicação de dose anual em todos os animais.");

        vaccine_list = Arrays.asList(vaccine_febre_aftosa, vaccine_brucelose, vaccine_clostridioses,
                vaccine_botulismo, vaccine_raiva);
    }

    private void applyVaccinesInCow() {
        LocalDate localDate = LocalDate.now();

        for (Vaccine<String> vaccine : vaccine_list) {
            localDate = localDate.minusDays(1);
            cow.addDose(localDate, vaccine);
        }
    }

    public void initializeFood() {
        cow.addFeeding("pao");
        cow.addFeeding("trigo");
        cow.addFeeding("palha de milho");
        cow.addFeeding("soja");
        cow.addFeeding("capim");
        cow.addFeeding("ração");
    }

    @Test
    public void testNameCow() {
        Utils.printEmptyLine();
        Utils.printBlue("COW TEST - cow.getName()");
        assertEquals("(vaca) - Grace", cow.getName());
    }

    @Test
    public void testNameOx() {
        Utils.printEmptyLine();
        Utils.printPurple("OX TEST - ox.getAge()");
        assertEquals(6, ox.getAge());
    }

    @Test
    public void testAddChildrenCow() {
        Utils.printEmptyLine();
        Utils.printBlue("COW TEST - cow.addChildren()");

        List<Cattle<String>> actualList = cow.getChildren();

        List<Integer> range = IntStream.rangeClosed(0, bezerro_list.size() - 1).boxed().toList();
        for (Integer index : range)
            assertEquals(bezerro_list.get(index), actualList.get(index));
    }

    @Test
    public void testAmountOfChildrenCow() {
        Utils.printEmptyLine();
        Utils.printBlue("COW TEST - cow.amountOfChildren()");
        assertEquals(bezerro_list.size(), cow.amounOfChildren());
    }

    @Test
    public void testSearchFirstChildByNameCow() {
        Utils.printEmptyLine();
        Utils.printBlue("COW TEST - cow.searchFirstChildByName()");
        assertEquals("(bezerro) - Mimoso", cow.searchFirstChildByName("Mimoso").getName());
    }

    @Test
    public void testSearchAllChildrenByNameCow() {
        Utils.printEmptyLine();
        Utils.printBlue("COW TEST - cow.searchAllChildrenByName()");

        List<Cattle<String>> expectedList =
                bezerro_list.stream().filter(child -> child.getName().contains("bezerro")).toList();
        List<Cattle<String>> actualList = cow.searchAllChildrenByName("bezerro");

        int expectedAssert = expectedList.size();
        int actualAssert = actualList.size();

        List<Integer> range = IntStream.rangeClosed(0, expectedAssert - 1).boxed().toList();
        for (Integer index : range)
            assertEquals(expectedList.get(index), actualList.get(index));

        assertEquals(expectedAssert, actualAssert);
    }

    @Test
    public void testIdCattle() {
        Utils.printEmptyLine();
        Utils.printYellow("CATTLE TEST - cattle.getId()");

        assertEquals(0, cow.getId());
        assertEquals(1, ox.getId());
    }

    @Test
    public void testVaccines() {
        Utils.printEmptyLine();
        Utils.printCyan("VACCINE TEST - cow.getVaccine()");

        Map<LocalDate, Vaccine<String>> actualMap = cow.getDoses();

        for (LocalDate date : actualMap.keySet()) {
            Vaccine<String> actualVaccine = actualMap.get(date);
            Vaccine<String> expectedVaccine = vaccine_list.stream()
                    .filter(vaccine -> vaccine.equals(actualVaccine))
                    .findFirst()
                    .orElse(null);

            assertTrue(vaccine_list.contains(actualVaccine));
            assertEquals(expectedVaccine, actualVaccine);
            assertEquals(expectedVaccine == null ? "" : expectedVaccine.getName(), actualVaccine.getName());
            assertEquals(expectedVaccine == null ? "" : expectedVaccine.getExtraInformations(),
                    actualVaccine.getExtraInformations());
        }

        assertEquals(vaccine_list.size(), actualMap.size());
    }
}
