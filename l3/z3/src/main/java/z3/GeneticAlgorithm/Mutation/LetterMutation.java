package z3.GeneticAlgorithm.Mutation;

import z3.GeneticAlgorithm.Genotype;
import z3.Letter;

import java.util.ArrayList;
import java.util.List;

public class LetterMutation implements MutationAlgorithm{
    private final List<Letter> letters;

    public LetterMutation(List<Letter> letters) {
        this.letters = letters;
    }

    /**
     * Funkcja bierze liste osobnikow i losowo mutuje ich wektory z podanym prawdopodobienstwem
     * @param individuals osobniki do mutowania
     * @param mutationProbability niezalezne prawdopobienstwo mutacji wspolrzednej wektora
     * @return lista osobnikow
     */
    @Override
    public List<Genotype> mutate(List<Genotype> individuals, double mutationProbability) {
        List<Genotype> mutatedIndividuals = new ArrayList<>();

        for (Genotype individual : individuals) {
            if (Math.random() < mutationProbability) {
                if (Math.random() > 0.333){
                    if(Math.random() > 0.5){
                        //Podmianka litery
                        String word = individual.getValue();
                        int randPos = (int)(Math.random()*word.length());
                        word = word.substring(0, randPos) + getRandomLetter() + word.substring(randPos+1);
                        mutatedIndividuals.add(new Genotype(word));
                    }
                    else{
                        //Dodanie litery
                        String word = individual.getValue();
                        int randPos = (int)(Math.random()*word.length());
                        word = word.substring(0, randPos) + getRandomLetter() + word.substring(randPos);
                        mutatedIndividuals.add(new Genotype(word));
                    }
                }
                else{
                    String word = individual.getValue();
                    int randPos = (int)(Math.random()*(word.length()-2))+1;
                    word = word.substring(0, randPos-1) + word.substring(randPos);
                    mutatedIndividuals.add(new Genotype(word));
                }
            } else {
                mutatedIndividuals.add(individual);
            }
        }
        return mutatedIndividuals;
    }

    private String getRandomLetter(){
        int pos = (int)(Math.random()*letters.size());
        return letters.get(pos).getLetter();
    }
}
