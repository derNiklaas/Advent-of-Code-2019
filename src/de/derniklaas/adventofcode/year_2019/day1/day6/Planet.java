package de.derniklaas.adventofcode.year_2019.day1.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Planet {

    private Planet from;
    private String name;

    public Planet(String name, Planet from) {
        this.from = from;
        this.name = name;
    }

    public Planet getFrom() {
        return from;
    }

    public void setFrom(Planet from) {
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public int getOrbit() {
        if (from == null) {
            return 0;
        }
        return from.getOrbit() + 1;
    }

    public int getOrbit(String until) {
        if (from == null) {
            return 0;
        }
        if (name.equals(until)) {
            return 0;
        }
        return from.getOrbit(until) + 1;
    }

    public List<Planet> getOrbits() {
        if (from == null) return new ArrayList<>();
        List<Planet> planets = new ArrayList<>();
        planets.add(from);
        planets.addAll(from.getOrbits());
        return planets;
    }

    private List<Planet> getOrbits(List<Planet> list) {
        if (from == null) return new ArrayList<>();
        list.add(from);
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(from, planet.from) &&
                Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, name);
    }
}
