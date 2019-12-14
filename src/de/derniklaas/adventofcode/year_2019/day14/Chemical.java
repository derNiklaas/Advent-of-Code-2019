package de.derniklaas.adventofcode.year_2019.day14;

import java.util.Objects;

public class Chemical {

    private String name;
    private int amount;

    public Chemical(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chemical chemical = (Chemical) o;
        return Objects.equals(name, chemical.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
