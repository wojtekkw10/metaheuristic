package z1.GeneticAlgorithm;

import java.util.List;

public class Genotype {
    private final List<Double> vector;
    private double fitness;

    public Genotype(List<Double> vector) {
        this.vector = vector;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public List<Double> getValue() {
        return vector;
    }

    @Override
    public String toString() {
        return "Genotype{" +
                vector +
                ", fitness=" + fitness +
                '}';
    }
}
