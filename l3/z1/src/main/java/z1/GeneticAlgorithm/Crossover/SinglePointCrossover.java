package z1.GeneticAlgorithm.Crossover;

import z1.GeneticAlgorithm.Genotype;

import java.util.ArrayList;
import java.util.List;

public class SinglePointCrossover implements CrossoverAlgorithm{
    /**
     * Funkcja wykonuje single-point crossover an podanych wektorach
     * @param parents lista osobnikow
     * @return dzieci osobnikow
     */
    @Override
    public List<Genotype> crossover(List<Genotype> parents) {
        List<Genotype> crossover = new ArrayList<>();

        for (int i = 0; i < parents.size(); i++) {
            for (Genotype parent : parents) {
                //liczymy losowy punkt przeciecia wykluczajac brzegowe przypadki
                int crossoverPoint = (int) (Math.random() * (parents.get(i).getValue().size()-2))+1;

                //tworzymy nowy wektor
                List<Double> newVector = new ArrayList<>();
                newVector.addAll(parents.get(i).getValue().subList(0, crossoverPoint));
                newVector.addAll(parent.getValue().subList(crossoverPoint, parents.get(0).getValue().size()));

                if (newVector.size() != parents.get(0).getValue().size()) throw new IllegalStateException();
                crossover.add(new Genotype(newVector));
            }
        }
        return crossover;
    }
}
