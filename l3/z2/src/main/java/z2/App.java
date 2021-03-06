/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package z2;

import z2.GeneticAlgorithm.Crossover.SinglePointCrossover;
import z2.GeneticAlgorithm.GeneticAlgorithm;
import z2.GeneticAlgorithm.Genotype;
import z2.GeneticAlgorithm.InitialPopulation.GivenPopulation;
import z2.GeneticAlgorithm.InitialPopulation.RandomPopulation;
import z2.GeneticAlgorithm.Mutation.LetterMutation;
import z2.GeneticAlgorithm.Selection.RouletteWheel;

import java.util.List;

public class App {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        inputParser.getInput();
        List<Letter> letters = inputParser.getLetters();
        List<String> startingWords = inputParser.getWords();
        List<String> allWords = inputParser.loadDict();
        int maxTime = inputParser.getMaxTime();

        WordScoreFunction fitnessFunction = new WordScoreFunction(allWords, letters);

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(
                maxTime,
                fitnessFunction,
                //new RandomPopulation(1000, letters, 5),
                new GivenPopulation(startingWords),
                new RouletteWheel(),
                new SinglePointCrossover(),
                new LetterMutation(letters));

        Genotype topIndividual = geneticAlgorithm.evolve();

        topIndividual.setFitness(fitnessFunction.compute(topIndividual.getValue()));
        System.out.println((int)topIndividual.getFitness());
        System.err.println(topIndividual.getValue());

    }
}
