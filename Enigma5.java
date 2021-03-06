import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Enigma5 {
static final int[][] ROTORS = new int[][]{{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25},
										{4,10,12,5,11,6,3,16,21,25,13,19,14,22,24,7,23,20,18,15,0,8,1,17,2,9},
										{0,9,3,10,18,8,17,20,23,1,11,7,22,19,12,2,16,6,25,13,15,24,5,21,14,4},
										{1,3,5,7,9,11,2,15,17,19,23,21,25,13,24,4,8,22,6,0,10,12,20,18,16,14},
										{4,18,14,21,15,25,9,0,24,16,20,8,17,7,23,11,13,5,19,6,10,3,2,12,22,1},
										{21,25,1,17,6,8,19,24,20,15,18,3,13,7,11,23,0,22,12,9,16,14,5,4,2,10},
										{9,15,6,21,14,20,12,5,24,16,1,4,13,7,25,17,3,10,0,18,23,11,8,2,19,22},
										{13,25,9,7,6,17,2,23,12,24,18,22,1,14,20,5,0,8,21,11,15,4,10,16,3,19},
										{5,10,16,7,19,11,23,14,2,1,9,18,15,3,25,17,0,12,4,22,13,8,20,24,6,21}};
static final int[] REFLECTORB = new int[]{24,17,20,7,16,18,11,3,15,23,13,6,14,10,12,8,4,1,5,25,2,22,21,9,0,19};
static int[] Plug = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
static int[][] RotorTurn = new int[][]{{},{16,16},{4,4},{21,21},{9,9},{25,25},{12,25},{12,25},{12,25}};

public static void main(String[] args){
	//all rotors, rings, no plugs: 5905536	5.7028114056, 5.1893937121 minutes
	final long startTime = System.currentTimeMillis();
	int outputcounter = 0;
	String alphabet = "abcdefghijklmnopqrstuvwxyz ";
	File big = new File ("C:\\Users\\fortu\\Documents\\Eclipse\\eclipse\\Projects\\CS352_DetectEnglish\\big.txt");
	File good = new File ("C:\\Users\\fortu\\Documents\\Eclipse\\eclipse\\Projects\\CS352_DetectEnglish\\good.txt");
	File bad = new File ("C:\\Users\\fortu\\Documents\\Eclipse\\eclipse\\Projects\\CS352_DetectEnglish\\bad.txt");
	List<String> bigList = DetectEnglish.getLines(big);
	List<String> goodList = DetectEnglish.getLines(good);
	List<String> badList = DetectEnglish.getLines(bad);		
	DetectEnglish.setDetector (bigList, goodList, badList, alphabet);
	try {
		//C:\Users\fortu\Documents\Eclipse\eclipse\Projects\CS352_Enigma_Group
		FileWriter fw1 = new FileWriter(
"C:\\Users\\fortu\\Documents\\Eclipse\\eclipse\\Projects\\CS352_Enigma_Group\\Enigma5_Output.txt");
	    BufferedWriter outFile = new BufferedWriter(fw1); 
	    String input = "UUEQANNAGUDJWMNFLQLSPYFVDNZTLDSSQPACBZLBJBJTTYIUPPJCYPECZLFIQISKLXK";
	    //String input5 = "UUEQA";
	    //String input6 = "UUEQAN";
	    //String input8 = "UUEQANNA";		
	    for(int a = 1; a < 9; a++){
    	for(int b = 1; b < 9; b++){
		for(int c = 1; c < 9; c++){
			if(a != b && a != c && b != c){
	    for(int x = 0; x < 26; x++){
    	for(int y = 0; y < 26; y++){
		for(int z = 0; z < 26; z++){
    		int[] settings = {a, b, c, x, y, z, 0, 0, 0};
    		String output = enc(settings, input);
    		if (DetectEnglish.isEnglish(output)){
    			outFile.write(a+""+b+""+c+""+(char)(x+65)+(char)(y+65)+(char)(z+65)+"000 "+output);
    			outFile.newLine();
    			System.out.println(a+""+b+""+c+""+(char)(x+65)+(char)(y+65)+(char)(z+65)+"000 "+output);
    			outputcounter++;
    		}
	    }}}}}}}
	    
	    outFile.write("total "+outputcounter);
		outFile.flush();
		outFile.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	final long endTime = System.currentTimeMillis();
	System.out.println("Enigma5 "+outputcounter+" "+(endTime-startTime)*0.0000166667+" minutes");
}

public static int rotor(int inputChar, int[] inputRotor, int GrundSetting, int RingSetting){
	int AdjustedValue = ((inputChar + GrundSetting) - RingSetting + 26) % 26;	
	return (inputRotor[AdjustedValue] - GrundSetting + RingSetting + 26) % 26;	
}
public static int rotorInverse(int inputChar, int[] inputRotor, int grundSetting, int RingSetting){
	int AdjustedValue = ((inputChar + grundSetting - RingSetting) + 26) % 26;			
	int index = 0;
	while(inputRotor[index] != AdjustedValue){
		index++;
	}	
	index = (index - grundSetting + RingSetting + 26) % 26;
	return ROTORS[0][index];
}
public static void PlugSetup(int InputA, int InputB){
		Plug[InputA] = InputB;
		Plug[InputB] = InputA;
}
public static int PlugSwap(int Input){
	return Plug[Input];
}
public static String enc(int[] settings, String inputString){	
	int[] leftRotorArray = ROTORS[settings[0]];
	int[] middleRotorArray = ROTORS[settings[1]];
	int[] rightRotorArray = ROTORS[settings[2]];

	int[] middleRotorTurn = RotorTurn[settings[1]];
	int[] rightRotorTurn  = RotorTurn[settings[2]];
		
	char[] input = inputString.toCharArray();
	int[] inputInt = new int [inputString.length()];
	for (int i = 0; i < input.length; i++)
		inputInt[i] = (char)(input[i]-65);
	char[] output = new char[inputString.length()];
	
	for(int i=0; i<inputString.length(); i++){
		if(settings[8] == rightRotorTurn[0] || settings[8] == rightRotorTurn[1]){
			if(settings[7] == middleRotorTurn[0] || settings[7] == middleRotorTurn[1])
				settings[6] = (settings[6] + 1) % 26;
			settings[7] = (settings[7] + 1) % 26;		
		}
		else{
			if(settings[7] == middleRotorTurn[0] || settings[7] == middleRotorTurn[1]){
				settings[6] = (settings[6] + 1) % 26;
				settings[7] = (settings[7] + 1) % 26;
			}
		}
		settings[8] = (settings[8] + 1) % 26;				
		int c = inputInt[i];
		c = PlugSwap(c);
		c = rotor(c, rightRotorArray, settings[8], settings[5]);
		c = rotor(c, middleRotorArray, settings[7], settings[4]);
		c = rotor(c, leftRotorArray, settings[6], settings[3]);
		c = REFLECTORB[c];
		c = rotorInverse(c, leftRotorArray, settings[6], settings[3]);
		c = rotorInverse(c, middleRotorArray, settings[7], settings[4]);
		c = rotorInverse(c, rightRotorArray, settings[8], settings[5]);
		c = PlugSwap(c);		
		output[i] = (char)(c+65);	
	}
	String outputString = new String(output);
	return outputString;
}
public static boolean filter (String line){
	int vowel=0, consonant=0;
	for (int i = 0; i < line.length(); i++){
		if (line.charAt(i)=='A'||line.charAt(i)=='E'||line.charAt(i)=='I'||line.charAt(i)=='O'||line.charAt(i)=='U')
			vowel++;
		else	consonant++;
		if (vowel==5)	return false;
		if (consonant==5)	return false;
	}
	return true;	
}
}
