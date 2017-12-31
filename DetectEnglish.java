import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DetectEnglish{
		  final static Map<Character, Integer> alphabetMap = new HashMap<Character, Integer>();
		  static final int MIN = 10;

		  static String alphabet;
		  static double[][] Probability = null;
		  static double threshold = 0d;
		
		public static void setDetector(List<String> bigLines, List<String> goodLines, List<String> badLines, String alph) {
			alphabet = alph;
			build(bigLines, goodLines, badLines);		
		}
				
		public static void build(List<String> bigLines, List<String> goodLines, List<String> badLines) {
			initAlphabetMap();
			
			int[][] alphabetMatrix = getAlphabetMatrix(bigLines);
			Probability = getProbability(alphabetMatrix);
				
			List<Double> goodP = getAvgP(goodLines, Probability);
			List<Double> badP = getAvgP(badLines, Probability);
			
			double min = Collections.min(goodP);
			double max = Collections.max(badP);
					
			if (min <= max)	throw new AssertionError("no threshold");
			threshold = (min + max) / 2;
		}
			
		public static void initAlphabetMap() {
			char[] chars = alphabet.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				alphabetMap.put(chars[i], i);
			}
		}
		
		public static String refine(String line) {
			StringBuilder lineN = new StringBuilder();
			for (char c: line.toLowerCase().toCharArray()) {
				lineN.append(alphabet.contains(Character.toString(c)) ? c : "");
			}
			return lineN.toString();
		}
		
		public static List<String> getNGram(int n, String line) {
			String newLine = refine(line);
			List<String> nGram = new ArrayList<String>();
			for (int i = 0; i < newLine.length() - n + 1; i++) {
				nGram.add(newLine.substring(i, i + n));			
			}
			return nGram;
		}
		
		public static int[][] getAlphabetMatrix(List<String> bigLines) {
			int[][] alphabetMatrix = createArray(alphabet.length());		
			for (String line : bigLines) {
				List<String> nGram = getNGram(2, line);
				for (String nG : nGram) {
					alphabetMatrix[alphabetMap.get(nG.charAt(0))][alphabetMap.get(nG.charAt(1))]++;				
				}	
			}
			return alphabetMatrix;
		}
		
		public static double[][] getProbability(int[][] alphabetMatrix) {
			int len = alphabet.length();
			double[][] Probability = new double[len][len];
			for (int i = 0; i < alphabetMatrix.length; i++) {
				double sum = getSum(alphabetMatrix[i]); 
				for (int j = 0; j < alphabetMatrix[i].length; j++) {				
					Probability[i][j] = Math.log(alphabetMatrix[i][j]/sum);
				}
			}
			return Probability;
		}
		
		public static List<Double> getAvgP(List<String> lines, double[][] Probability) {	
			List<Double> AvgP = new ArrayList<Double>();		
			for (String line : lines) {		
				AvgP.add(getAvgP(line, Probability));
			}
			return AvgP;
		}
	
		public static double getAvgP(String line, double[][] Probability) {
			double prob = 0d;
			int count = 0;
			List<String> nGram = getNGram(2, line);
			for (String touple : nGram) {
				prob += Probability[alphabetMap.get(touple.charAt(0))][alphabetMap.get(touple.charAt(1))];
				count++;
			}
			return Math.exp(prob / Math.max(count, 1));
		}
			
		public static int[][] createArray(int length){
			int[][] alphabetMatrix = new int[length][length];
		    for (int i = 0; i < alphabetMatrix.length; i++){
		        Arrays.fill(alphabetMatrix[i], MIN);
		    }
		    return alphabetMatrix;
		}
		
		public static double getSum(int[] array) {
			double sum = 0; 
			for (int i = 0; i < array.length; i++) {
				sum += array[i];
			}
			return sum; 
		}
		
		// true if the sentence is English, false otherwise.
		public static boolean isEnglish(String line) {
			return (getAvgP(line, Probability) > threshold);
		}
	
	public static void main(String[] args) throws IOException{
		
		File readFile = new File("C:\\Users\\Kevin\\workspace\\Enigma\\TDecrypt.txt");
		BufferedReader readText = new BufferedReader(new FileReader(readFile));
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz ";
		String[] goodEx = {"LETSWRITCABUZCHOFCIPMERTEXTSSOTHATWGCAZTESTIOWECAZFILTEREZDLISH", "ZNTUWRITNABUECROXKIPHNRTNXTXROTHATWNCRNTNSTIYWNCAEYILTNRNQGLISH"};
		String[] badEx = {"UUEQANNAGUDJWMNFLQLSPYFVDNZTLDSSQPACBZLBJBJTTYIUPPJCYPECZLFIQISKLXK", "eplantsdwihtmontainzntowyhxuorsesspaibrcj", "qmdupoebcvuutkljsupwre"};
	
		File big = new File ("C:\\Users\\Kevin\\workspace\\Enigma\\big.txt");
		File good = new File ("C:\\Users\\Kevin\\workspace\\Enigma\\good.txt");
		File bad = new File ("C:\\Users\\Kevin\\workspace\\Enigma\\bad.txt");
		List<String> bigList = getLines(big);
		List<String> goodList = getLines(good);
		List<String> badList = getLines(bad);		
		setDetector (bigList, goodList, badList, alphabet);		
	//	for (String line : goodEx) {
	//		System.out.println(line+" -"+isEnglish(line));
	//	}
	//	for (String line : badEx) {
	//		System.out.println(line+" -"+isEnglish(line));
	//	}
		//System.out.println("hellohelloorangehelloorangeorange"
		//		+" -"+isEnglish("hellohelloorangehelloorangeorange"));
		
		String readLine;
		int wrongcounter = 0;
		int ecounter = 0;
		int tcounter = 0;
		int acounter = 0;
		int icounter = 0;
		int ocounter = 0;
		
		while((readLine = readText.readLine()) != null){
			
			int length = 63;
			
			String sub = readLine.substring(0, length);
			
			if(isEnglish(sub)){
			//	System.out.println("True" + " " + readLine.substring(length + 1));
			}
			else{
				//System.out.println("False" + " " + readLine.substring(length + 1));
				wrongcounter++;
				if(readLine.charAt(length + 1) == 'E'){
					ecounter++;
				}
				if(readLine.charAt(length + 1) == 'T'){
					tcounter++;
				}
				if(readLine.charAt(length + 1) == 'A'){
					acounter++;
				}
				if(readLine.charAt(length + 1) == 'I'){
					icounter++;
				}
				if(readLine.charAt(length + 1) == 'O'){
					ocounter++;
				}
				
			}
			
		}
		
		System.out.println("E: " + ecounter);
		System.out.println("T: " + tcounter);
		System.out.println("A: " + acounter);
		System.out.println("I: " + icounter);
		System.out.println("O: " + ocounter);
		System.out.println(wrongcounter);
		
	}
	
	static List<String> getLines(File file) {
		List<String> lines = new ArrayList<String>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line.trim());
			}
		}
		catch (Exception e) {
			System.out.println("wrong file: " + file.getAbsolutePath());
		}
		return lines;
	}
}

