/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package z2;

import z2.GeneticAlgorithm.Crossover.SinglePointCrossover;
import z2.GeneticAlgorithm.GeneticAlgorithm;
import z2.GeneticAlgorithm.Genotype;
import z2.GeneticAlgorithm.InitialPopulation.RandomPopulation;
import z2.GeneticAlgorithm.Mutation.LetterMutation;
import z2.GeneticAlgorithm.Selection.RouletteWheel;
import z2.GeneticAlgorithm.Selection.TournamentSelection;

import java.util.List;

public class App {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        inputParser.getInput();
        List<Letter> letters = inputParser.getLetters();
        List<String> words = inputParser.getWords();
        int maxTime = inputParser.getMaxTime();

        WordScoreFunction fitnessFunction = new WordScoreFunction(words, letters);

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(
                maxTime,
                fitnessFunction,
                new RandomPopulation(10000, letters, 5),
                new RouletteWheel(),
                new SinglePointCrossover(),
                new LetterMutation(letters));

        Genotype topIndividual = geneticAlgorithm.evolve();

        topIndividual.setFitness(fitnessFunction.compute(topIndividual.getValue()));
        System.out.println((int)topIndividual.getFitness());
        System.err.println(topIndividual.getValue());

    }
}
