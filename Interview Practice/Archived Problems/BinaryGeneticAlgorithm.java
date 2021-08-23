package OldProblems;

import java.util.function.ToDoubleFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BinaryGeneticAlgorithm {
	/***************************************************************
	 * Feel free to change the private methods' signatures (I did) *
	 * Only the "run" functions are tested                         *
	 ***************************************************************/
	private static String generate(int length) {
		int max = (int) Math.pow(2, length)-1;
		int min = (int) Math.pow(2,  length-1)+1;
		Random rand = new Random();
		Integer n = rand.nextInt(max-min) + min;
		System.out.println(n);
		return Integer.toBinaryString(n);

	}

	private static String[] select(List<String> population, List<Double> fitnesses) {
		Double weightedSum = (double) 0;
		for (Double d : fitnesses) {
			weightedSum += d;
		}
		Random rand = new Random();
		Double percent = rand.nextDouble();
		Double secondPercent = rand.nextDouble();
		
		Double dart = percent*weightedSum;
		Double secondDart = secondPercent*weightedSum;
		
		int index = -1;
		int secondIndex = -1;
		for (int i = 0; i < fitnesses.size(); i++) {
			dart -= fitnesses.get(i);
			if (dart < 0) {
				index = i;
				break;
			}
		}
		for (int i = 0; i < fitnesses.size(); i++) {
			secondDart -= fitnesses.get(i);
			if (secondDart < 0) {
				secondIndex = i;
				break;
			}
		}
		
		return new String[] {population.get(index), population.get(secondIndex)};
	}
	
	public static String mutate(String chromosome, double p) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder(chromosome);
		for (int i = 0; i < chromosome.length(); i++) {
			int prob = rand.nextInt(1000);
			if (prob <= p * 1000) {
				if (chromosome.charAt(i) == '1') {
					sb.setCharAt(i, '0');
				} else {
					sb.setCharAt(i,  '1');
				}
			}
		}
		
		return sb.toString();
		
	}

	public static String crossover(String chromosome1, String chromosome2) {
		Random rand = new Random();
		int slice = rand.nextInt(chromosome1.length()-1);
		String newChrom = chromosome1.substring(0, slice) + chromosome2.substring(slice, chromosome2.length());
		
		return newChrom;
		
	}

	public static void main(String[] args) {

		System.out.println(generate(8));
		
		ArrayList<String> population = new ArrayList<String>();
		population.add("10101010");
		population.add("10100000");
		population.add("11011100");
		population.add("10010000");
		population.add("11111100");
		population.add("10000100");
		population.add("11111110");
		
		ArrayList<Double> fitnesses = new ArrayList<Double>();
		fitnesses.add(new Double(1));
		fitnesses.add(new Double(2));
		fitnesses.add(new Double(3));
		fitnesses.add(new Double(4));
		fitnesses.add(new Double(5));
		fitnesses.add(new Double(6));
		fitnesses.add(new Double(7));
		
		System.out.println(Arrays.deepToString(select(population, fitnesses)));
		
		System.out.println(mutate(population.get(0), .002));
		
		System.out.println(crossover("11111111", "00000000"));


	}


}