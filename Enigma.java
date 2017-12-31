import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class Enigma{

	static char[] Plug = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

	//initialize the 8 rotors and the default
	static final char[] DEFAULT = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};	
	static final char[] ROTOR1 = new char[]{'E','K','M','F','L','G','D','Q','V','Z','N','T','O','W','Y','H','X','U','S','P','A','I','B','R','C','J'};
	static final char[] ROTOR2 = new char[]{'A','J','D','K','S','I','R','U','X','B','L','H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E'};
	static final char[] ROTOR3 = new char[]{'B','D','F','H','J','L','C','P','R','T','X','V','Z','N','Y','E','I','W','G','A','K','M','U','S','Q','O'};
	static final char[] ROTOR4 = new char[]{'E','S','O','V','P','Z','J','A','Y','Q','U','I','R','H','X','L','N','F','T','G','K','D','C','M','W','B'};
	static final char[] ROTOR5 = new char[]{'V','Z','B','R','G','I','T','Y','U','P','S','D','N','H','L','X','A','W','M','J','Q','O','F','E','C','K'};
	static final char[] ROTOR6 = new char[]{'J','P','G','V','O','U','M','F','Y','Q','B','E','N','H','Z','R','D','K','A','S','X','L','I','C','T','W'};
	static final char[] ROTOR7 = new char[]{'N','Z','J','H','G','R','C','X','M','Y','S','W','B','O','U','F','A','I','V','L','P','E','K','Q','D','T'};
	static final char[] ROTOR8 = new char[]{'F','K','Q','H','T','L','X','O','C','B','J','S','P','D','Z','R','A','M','E','W','N','I','U','Y','G','V'};
	static final char[] REFLECTORB = new char[]{'Y','R','U','H','Q','S','L','D','P','X','N','G','O','K','M','I','E','B','F','Z','C','W','V','J','A','T'};

	static int[] DefaultInt = new int[26];
	static int[] Rotor1Int = new int[26];
	static int[] Rotor2Int = new int[26];
	static int[] Rotor3Int = new int[26];
	static int[] Rotor4Int = new int[26];
	static int[] Rotor5Int = new int[26];
	static int[] Rotor6Int = new int[26];
	static int[] Rotor7Int = new int[26];
	static int[] Rotor8Int = new int[26];
	static int[] PlugInt = new int[26];
	static int[] ReflectorInt = new int[26];
	
	static int[] Rotor1Turn = new int[]{16,16};
	static int[] Rotor2Turn = new int[]{4,4};
	static int[] Rotor3Turn = new int[]{21,21};
	static int[] Rotor4Turn = new int[]{9,9};
	static int[] Rotor5Turn = new int[]{25,25};
	static int[] Rotor6Turn = new int[]{12,25};
	static int[] Rotor7Turn = new int[]{12,25};
	static int[] Rotor8Turn = new int[]{12,25};
	

/**
 * for this debugger enter the input as follows in console:
 * @param args[0-2] rotor numbers, left to right 
 * args[3-5] ring settings, as characters, left to right
 * args[6-8] grund settings, as characters, left to right
 * args[9] input string
 * example: 1 2 3 A A A A A A wewillsolvethishavehope
 * @throws IOException 
 */
	
public static void main(String[] args) throws IOException{	
	convertArrays();
		
	String input = "L";
	
	String fullinput = "UUEQANNAGUDJWMNFLQLSPYFVDNZTLDSSQPACBZLBJBJTTYIUPPJCYPECZLFIQISKLXK";
	
	onePlugTest();
	
	//generateLists('K','L');
	//splitLists();
	
	//System.out.println(countRelevantPlug("KKLLBBDDXY"));
	//sortKDB();
	//EnglishFilter();
	
	
	//int[] testarray = turnGrund(0,0,0,1,2,3,64);
	//System.out.print(testarray[0] + "" + testarray[1] + "" + testarray[2]);
	
	//FileCompareKB();
	//ArrayCompareKB();
	//HashCompareKB();
	//HashCompareD();
	
	//Runs 1 set of Plugs through a bunch of inputs from a file
	
	//String input2 = "LX";
	//PlugRunner(input2);
	
	
	
	
	//String input3 = "LXK";
	//KDBPlugs(input3);
	//PostKDB(input3);
	//PostKDB2(input3);
	//SinglePlug(input3);
	
	
	
	
	
	
	/*
	 
	//Testing single line of text with any plugs
	//PlugSetup('z','k');
	PlugSetup('d','z');
	//PlugSetup('f','t');
	//PlugSetup('d','r');
	
	int[] haha = {1, 2, 6, charToInt('h'), charToInt('m'), charToInt('b'), 0, 0, 0};
	
	System.out.println(enc(haha,fullinput));
	
	*/
	
	
	
	
	
	
	
	
	
	//Enigma Machine
		
	///*
	

	//*/
	
}

public static void splitLists() throws IOException{
	File readFile = new File("C:\\Users\\Kevin\\workspace\\Enigma\\FortuneK.txt");
	BufferedReader readText = new BufferedReader(new FileReader(readFile));
	
	FileWriter fw1 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList1.txt");
    BufferedWriter outFile = new BufferedWriter(fw1);
    
	FileWriter fw2 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList2.txt");
    BufferedWriter outFile2 = new BufferedWriter(fw2);
    
	FileWriter fw3 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList3.txt");
    BufferedWriter outFile3 = new BufferedWriter(fw3);
    
	FileWriter fw4 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList4.txt");
    BufferedWriter outFile4 = new BufferedWriter(fw4);
    
	FileWriter fw5 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList5.txt");
    BufferedWriter outFile5 = new BufferedWriter(fw5);
    
	FileWriter fw6 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList6.txt");
    BufferedWriter outFile6 = new BufferedWriter(fw6);
    
	FileWriter fw7 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList7.txt");
    BufferedWriter outFile7 = new BufferedWriter(fw7);
    
	FileWriter fw8 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList8.txt");
    BufferedWriter outFile8 = new BufferedWriter(fw8);
    
	FileWriter fw9 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList9.txt");
    BufferedWriter outFile9 = new BufferedWriter(fw9);
    
	FileWriter fw10 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList10.txt");
    BufferedWriter outFile10 = new BufferedWriter(fw10);
    
	FileWriter fw11 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList11.txt");
    BufferedWriter outFile11 = new BufferedWriter(fw11);
    
	FileWriter fw12 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList12.txt");
    BufferedWriter outFile12 = new BufferedWriter(fw12);
    
	FileWriter fw13 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList13.txt");
    BufferedWriter outFile13 = new BufferedWriter(fw13);
    
	FileWriter fw14 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList14.txt");
    BufferedWriter outFile14 = new BufferedWriter(fw14);
	
	FileWriter fw15 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\KList15.txt");
    BufferedWriter outFile15 = new BufferedWriter(fw15);
	
	String currentLine;
	int outputCounter = 0;
	
	while((currentLine = readText.readLine()) != null){
		if(outputCounter < 10000000){
		outFile.write(currentLine);
		outFile.newLine();
		outputCounter++;
		}
		else if(outputCounter < 20000000){
			outFile2.write(currentLine);
			outFile2.newLine();
			outputCounter++;
		}
		else if(outputCounter < 30000000){
			outFile3.write(currentLine);
			outFile3.newLine();
			outputCounter++;
		}
		else if(outputCounter < 40000000){
			outFile4.write(currentLine);
			outFile4.newLine();
			outputCounter++;
		}
		else if(outputCounter < 50000000){
			outFile5.write(currentLine);
			outFile5.newLine();
			outputCounter++;
		}
		else if(outputCounter < 60000000){
			outFile6.write(currentLine);
			outFile6.newLine();
			outputCounter++;
		}
		else if(outputCounter < 70000000){
			outFile7.write(currentLine);
			outFile7.newLine();
			outputCounter++;
		}
		else if(outputCounter < 80000000){
			outFile8.write(currentLine);
			outFile8.newLine();
			outputCounter++;
		}
		else if(outputCounter < 90000000){
			outFile9.write(currentLine);
			outFile9.newLine();
			outputCounter++;
		}
		else if(outputCounter < 100000000){
			outFile10.write(currentLine);
			outFile10.newLine();
			outputCounter++;
		}
		else if(outputCounter < 110000000){
			outFile11.write(currentLine);
			outFile11.newLine();
			outputCounter++;
		}
		else if(outputCounter < 120000000){
			outFile12.write(currentLine);
			outFile12.newLine();
			outputCounter++;
		}
		else if(outputCounter < 130000000){
			outFile13.write(currentLine);
			outFile13.newLine();
			outputCounter++;
		}
		else if(outputCounter < 140000000){
			outFile14.write(currentLine);
			outFile14.newLine();
			outputCounter++;
		}
		else if(outputCounter < 150000000){
			outFile15.write(currentLine);
			outFile15.newLine();
			outputCounter++;
		}
	}
	
	readText.close();
	outFile.close();
	outFile2.close();
	outFile3.close();
	outFile4.close();
	outFile5.close();
	outFile6.close();
	outFile7.close();
	outFile8.close();
	outFile9.close();
	outFile10.close();
	outFile11.close();
	outFile12.close();
	outFile13.close();
	outFile14.close();
	outFile15.close();
	
}



public static void generateLists(char primary, char secondary) throws IOException{
	FileWriter fw1 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\GenerateKList.txt");
    BufferedWriter outFile = new BufferedWriter(fw1);
	
	String input = secondary + "";
    
	int outputcounter = 0;

	//This is the plug partner for k and l. for D,X and B,K , the functionality is the same.
	char kPair;
	char lPair;
	
	for(int p1 = 0; p1 < 26; p1++){
		for(int p2 = 0; p2 < 26; p2++){
			PlugReset();
			//set up k with a plug partner. edit this to d or b depending on which you're running.
			PlugSetup(primary,intToChar(p1));
			kPair = intToChar(p1);
			//make sure k and l dont have the same plug partners. (same for d and b setups. no change)
			if(p2 != p1){
				//only passes if either K is paired to not L and L isn't paired back to K or K is paired to L
				//Ks become D or Bs. Ls become X or Ks.
				if((p1 != charToInt(secondary) && p2 != charToInt(primary)) || p1 == charToInt(secondary) && p2 == charToInt(secondary)){
					//change L to X or K for the other setups. makes sure that you dont repair L if K is plugged to L.
				if(p1 != charToInt(secondary)){
					//plugs a partner for L if it isn't plugged to K.
					PlugSetup(secondary,intToChar(p2));
					lPair = intToChar(p2);
				}
				//you dont replug L since it's alreayd plugged. change to D or B accordingly.
				else{
					lPair = primary;
				}
						
	for(int a = 1; a < 9; a++){
		for(int b = 1; b < 9; b++){
			for(int c = 1; c < 9; c++){
				if(a != b && a != c && b != c){
					//Set up the grund calc. 64 for K / L. 65 for D / X. 66 for B / K. 
					int[] GrundCalc = turnGrund(0,0,0,a,b,c,64);
	for(int x = 0; x < 26; x++){
		for(int y = 0; y < 26; y++){
			for(int z = 0; z < 26; z++){
					int[] settings = {a, b, c, x, y, z, GrundCalc[0], GrundCalc[1], GrundCalc[2]};
					String output = enc(settings, input);			
					
					//change to output equals D or B for the other setups.
					if(output.equals("" + primary)){
						//System.out.println("Output: " + "K" + kPair + "L" + lPair + a + b + c + intToChar(x) + intToChar(y) + intToChar(z));
						//change write K to write D or B
						outFile.write(primary);
						outFile.write(kPair + "");
						//change write L to write X or K
						outFile.write(secondary);
						outFile.write(lPair + "");
						outFile.write(a + "");
						outFile.write(b + "");
						outFile.write(c + "");
						outFile.write(intToChar(x));
						outFile.write(intToChar(y));
						outFile.write(intToChar(z));
						outFile.newLine();
						outputcounter++;
						System.out.println(outputcounter);
					}
					
					
				
			}	
			
		}
	}
					}
				}
			}
		}
			}
	
		}
	
	}
}
	
	System.out.println(outputcounter);
	
	outFile.close();
	fw1.close();
}

public static void onePlugTest() throws IOException{
	
	FileWriter fw1 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\TDecrypt.txt");
    BufferedWriter outFile = new BufferedWriter(fw1);
	
	
	String input = "TOINCREASETHESECURITYOFENIGMATHEGERMANGOVERNMENTMANDATEDSEVERAL";
	
	char p1;
	String output;
	String output2;
	
	int[] settings = {8, 5, 7, charToInt('H'), charToInt('T'), charToInt('F'), 0, 0, 0};
	for(int b = 0; b < 26; b++){
		p1 = intToChar(b);
	for(int a = 0; a < 26; a++){
		if(charToInt(p1) != a){
			PlugReset();
			PlugSetup(p1,intToChar(a));
			output = enc(settings, input);
			PlugReset();
			output2 = enc(settings, output);
			
			outFile.write(output2 + " " + p1 + intToChar(a));
			outFile.newLine();
			
		}
		
	}
}
	
	outFile.close();
}


public static int[] turnGrund(int grund1, int grund2, int grund3, int lR, int mR, int rR, int count){
	
	int g1 = grund1;
	int g2 = grund2;
	int g3 = grund3;
	
	
	int[] mRT;
	int[] rRT;
	
	
	if(mR==1) mRT = Rotor1Turn; 
	else if(mR==2) mRT = Rotor2Turn;
	else if(mR==3) mRT = Rotor3Turn;
	else if(mR==4) mRT = Rotor4Turn;
	else if(mR==5) mRT = Rotor5Turn;
	else if(mR==6) mRT = Rotor6Turn;
	else if(mR==7) mRT = Rotor7Turn;
	else mRT = Rotor8Turn;
	
	if(rR==1) rRT = Rotor1Turn; 
	else if(rR==2) rRT = Rotor2Turn;
	else if(rR==3) rRT = Rotor3Turn;
	else if(rR==4) rRT = Rotor4Turn;
	else if(rR==5) rRT = Rotor5Turn;
	else if(rR==6) rRT = Rotor6Turn;
	else if(rR==7) rRT = Rotor7Turn;
	else rRT = Rotor8Turn;
	
	for(int i = 0; i < count; i++){

	    if(g3 == rRT[0] || g3 == rRT[1]){
	        if(g2 == mRT[0] || g2 == mRT[1])
	            g1 = (g1 + 1) % 26;
	        g2 = (g2 + 1) % 26;

	    }
	    else{
	        if(g2 == mRT[0] || g2 == mRT[1]){
	            g1 = (g1 + 1) % 26;
	            g2 = (g2 + 1) % 26;
	        }
	    }
	    g3 = (g3 + 1) % 26;
	    
	}
    
    int[] grunds = new int[]{g1, g2, g3};
    return grunds;
}

public static int[] turnGrundOnce(int grund1, int grund2, int grund3, int[] mRT, int[] rRT){
	
	int g1 = grund1;
	int g2 = grund2;
	int g3 = grund3;
	
	    if(g3 == rRT[0] || g3 == rRT[1]){
	        if(g2 == mRT[0] || g2 == mRT[1])
	            g1 = (g1 + 1) % 26;
	        g2 = (g2 + 1) % 26;

	    }
	    else{
	        if(g2 == mRT[0] || g2 == mRT[1]){
	            g1 = (g1 + 1) % 26;
	            g2 = (g2 + 1) % 26;
	        }
	    }
	    g3 = (g3 + 1) % 26;
	    
	   
    int[] grunds = new int[]{g1, g2, g3};
    return grunds;
}

public static void HashCompareKBF() throws IOException{
	
	String[] karray = new String[26000000];//200000000
	Hashtable<String, String> btable = new Hashtable<String, String>();
	
	String kline;
	String bline;
	int kcounter = 0;
	int outputcounter = 0;
	
	FileWriter fw1 = new FileWriter(
"C:\\Users\\fortu\\Documents\\Eclipse\\eclipse\\Projects\\CS352_Enigma_Group\\HashCompare\\HashCompare_KB1.txt");
    BufferedWriter outFile = new BufferedWriter(fw1);
	
	File readFile = new File(
"C:\\Users\\fortu\\Documents\\Eclipse\\eclipse\\Projects\\CS352_Enigma_Group\\HashCompare\\Klist_Split\\Klist1.txt");
	BufferedReader readText = new BufferedReader(new FileReader(readFile));	
	
	while((kline = readText.readLine()) != null){
		karray[kcounter] = kline;
		kcounter++;
	}
	
    File readFile2 = new File(
"C:\\Users\\fortu\\Documents\\Eclipse\\eclipse\\Projects\\CS352_Enigma_Group\\HashCompare\\Blist_HashedArrayList.txt");
    BufferedReader readText2 = new BufferedReader(new FileReader(readFile2)); 
    
	while((bline = readText2.readLine()) != null){
		
		String bsettings = bline.substring(4,10);        
	    
		if(btable.containsKey(bsettings)){
	        String bcombine = btable.get(bsettings) + bline;
	        btable.put(bsettings, bcombine);
	    }
	    else {
	    	btable.put(bsettings, bline);        
	    }
	}
	
	for(int kloop = 0 ; karray[kloop] != null ; kloop++){	
		
    	char kpair = karray[kloop].charAt(1);
    	char lpair = karray[kloop].charAt(3);    
    	
    	String ksettings = karray[kloop].substring(4,10);
    	
		if(btable.containsKey(ksettings)){
			
			String breturn = btable.get(ksettings);   
			
            for(int a = 0; a < breturn.length(); a = a + 10){
            	
	        	char bpair = breturn.charAt(1+a);
	        	char kpair2 = breturn.charAt(3+a);      
	        	
	        	if(kpair == kpair2 && pairCompare('L',lpair,'B',bpair)){
	        		outFile.write("K" + kpair + "L" + lpair + "B" + bpair + ksettings);
	        		outFile.newLine();
	        		outputcounter++;
	        		System.out.println(outputcounter);
	        	}
	        	
            }
		}
	}
	outFile.flush();	
	readText.close();
	readText2.close();
	outFile.close();
	fw1.close();   
}

public static void HashCompareKB() throws IOException{
	
	//change these to size 200k for the real inputs due to their size. adjust memory in run config accordingly.
	String[] karray = new String[10000001];
	Hashtable<String, String> btable = new Hashtable<String, String>();
	
	
	String kline;
	String bline;
	int kcounter = 0;
	int outputcounter = 0;
	
	int blinecount = 0;

	FileWriter fw1 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\K1B10.txt");
    BufferedWriter outFile = new BufferedWriter(fw1);
	
	File readFile = new File("C:\\Users\\Kevin\\workspace\\Enigma\\KList1.txt");
	BufferedReader readText = new BufferedReader(new FileReader(readFile));
	
	while((kline = readText.readLine()) != null){
		karray[kcounter] = kline;
		kcounter++;
	}
		
    File readFile2 = new File("C:\\Users\\Kevin\\workspace\\Enigma\\BList10.txt");
    BufferedReader readText2 = new BufferedReader(new FileReader(readFile2));
    
    
	while((bline = readText2.readLine()) != null){
		
		blinecount++;
		//System.out.println(blinecount);
		
		String bsettings = bline.substring(4,10);
		
	if(btable.containsKey(bsettings)){
		String bcombine = btable.get(bsettings) + bline;
		btable.put(bsettings, bcombine);
	}
	else{
		btable.put(bsettings, bline);		
	}
		

	}
	

	//-------------------------
	
	
	for(int kloop = 0 ; karray[kloop] != null ; kloop++){
					
    	char kpair = karray[kloop].charAt(1);
    	char lpair = karray[kloop].charAt(3);
    	
    	String ksettings = karray[kloop].substring(4,10);
    	
		if(btable.containsKey(ksettings)){
			
			String breturn = btable.get(ksettings);
        	
			for(int a = 0; a < breturn.length(); a = a + 10){
				
	        	char bpair = breturn.charAt(1 + a);
	        	char kpair2 = breturn.charAt(3 + a);

	      		
	        	if(kpair == kpair2 && pairCompare('L',lpair,'B',bpair)){
	        		outFile.write("K" + kpair + "L" + lpair + "B" + bpair + ksettings);
	        		outFile.newLine();
	        	outputcounter++;
	        	System.out.println(outputcounter);
	        	}
	        	
			}
					
		}

	}
	
	System.out.println("Done");
	
    	readText.close();
    	readText2.close();
    	outFile.close();
    	fw1.close();
   
}

public static void sortKDB() throws IOException{
	File readFile = new File("C:\\Users\\Kevin\\workspace\\Enigma\\kdbcompared.txt");
	BufferedReader readText = new BufferedReader(new FileReader(readFile));
	
	FileWriter fw4 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\FourPlug.txt");
    BufferedWriter outFile4 = new BufferedWriter(fw4);
    
	FileWriter fw3 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\ThreePlug.txt");
    BufferedWriter outFile3 = new BufferedWriter(fw3);
	
	FileWriter fw2 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\TwoPlug.txt");
    BufferedWriter outFile2 = new BufferedWriter(fw2);
	
	FileWriter fw1 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\OnePlug.txt");
    BufferedWriter outFile1 = new BufferedWriter(fw1);
	
	FileWriter fw0 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\ZeroPlug.txt");
    BufferedWriter outFile0 = new BufferedWriter(fw0);
    
	String readLine;
	
	int count4 = 0;
	int count3 = 0;
	int count2 = 0;
	int count1 = 0;
	int count0 = 0;
	
	while((readLine = readText.readLine()) != null){
		
		String plugSection = readLine.substring(0, 10);
		
		int relevantPlugCount = countRelevantPlug(plugSection);
		
		if(relevantPlugCount == 4){
			outFile4.write(readLine);
			outFile4.newLine();
			count4++;
		}
		else if(relevantPlugCount == 3){
			outFile3.write(readLine);
			outFile3.newLine();
			count3++;
		}
		else if(relevantPlugCount == 2){
			outFile2.write(readLine);
			outFile2.newLine();
			count2++;
		}
		else if(relevantPlugCount == 1){
			outFile1.write(readLine);
			outFile1.newLine();
			count1++;
		}
		else if(relevantPlugCount == 0){
			outFile0.write(readLine);
			outFile0.newLine();
			count0++;
		}
	}
	
	System.out.println("4: " + count4);
	System.out.println("3: " + count3);
	System.out.println("2: " + count2);
	System.out.println("1: " + count1);
	System.out.println("0: " + count0);
	
	readText.close();
	outFile4.close();
	outFile3.close();
	outFile2.close();
	outFile1.close();
	outFile0.close();
}

public static int countRelevantPlug(String inputString){
	
	boolean[] switchArray = new boolean[]{true,true,true,true,true};
	
	int distinct = 0;
	
	char[] inputArray = new char[10];
	
	for(int i = 0; i < 10; i++){
		inputArray[i] = inputString.charAt(i);
	}

	if(inputArray[0] == inputArray[1] && inputArray[2] == inputArray[3] && inputArray[4] == inputArray[5] && inputArray[6] == inputArray[7] && inputArray[8] == inputArray[9]){
		return 0;
	}
	
	//if APair is B, C, D or E (2, 4, 6, 8), don't check if switch for A is turned to false
	for(int checkA = 0; checkA < 10 && switchArray[0] == true ; checkA = checkA + 2){
		if(checkA != 0){
			if(inputArray[1] == inputArray[checkA]){
				switchArray[(checkA / 2)] = false;
				distinct++;
				switchArray[0] = false;
			}
		}
	}
	
	//check that A is paired to itself. dont count if it is
	if(inputArray[0] != inputArray[1] && switchArray[0] != false){
		distinct++;
	}

	
	
	//if BPair is A, C, D or E (0, 4, 6, 8), don't check if switch for B is turned to false
	for(int checkB = 0; checkB < 10 && switchArray[1] == true ; checkB = checkB + 2){
		if(checkB != 2){
			if(inputArray[3] == inputArray[checkB]){
				switchArray[(checkB / 2)] = false;
				distinct++;
				switchArray[1] = false;
			}
		}
	}
	
	//check that B is paired to itself. dont count if it is
	if(inputArray[2] != inputArray[3] && switchArray[1] != false){
	distinct++;
	switchArray[1] = false;
	}
	
	//if CPair is A, B, D or E (0, 2, 6, 8), don't check if switch for C is turned to false
	for(int checkC = 0; checkC < 10 && switchArray[2] == true ; checkC = checkC + 2){
		if(checkC != 4){
			if(inputArray[5] == inputArray[checkC]){
				switchArray[(checkC / 2)] = false;
				distinct++;
				switchArray[2] = false;
			}
		}
	}
	
	//check that C is paired to itself. dont count if it is
	if(inputArray[4] != inputArray[5] && switchArray[2] != false){
	distinct++;
	switchArray[2] = false;
	}
	
	//if DPair is A, B, C or E (0, 2, 4, 8), don't check if switch for D is turned to false
	for(int checkD = 0; checkD < 10 && switchArray[3] == true ; checkD = checkD + 2){
		if(checkD != 6){
			if(inputArray[7] == inputArray[checkD]){
				switchArray[(checkD / 2)] = false;
				distinct++;
				switchArray[3] = false;
			}
		}
	}
	
	//check that D is paired to itself. dont count if it is
	if(inputArray[6] != inputArray[7] && switchArray[3] != false){
	distinct++;
	switchArray[3] = false;
	}

	//if EPair is A, B, C or D (0, 2, 4, 6), don't check if switch for E is turned to false
	for(int checkE = 0; checkE < 10 && switchArray[4] == true ; checkE = checkE + 2){
		if(checkE != 8){
			if(inputArray[9] == inputArray[checkE]){
				switchArray[(checkE / 2)] = false;
				distinct++;
				switchArray[4] = false;
			}
		}
	}	
	
	//check that E is paired to itself. dont count if it is
	if(inputArray[8] != inputArray[9] && switchArray[4] != false){
	distinct++;
	switchArray[4] = false;
	}
	
	return distinct;
}

public static void HashCompareD() throws IOException{
	
	//change these to size 200k for the real inputs due to their size. adjust memory in run config accordingly.
	String[] oarray = new String[6000000];
	Hashtable<String, String> dtable = new Hashtable<String, String>();
	
	
	String oline;
	String dline;
	int ocounter = 0;
	int outputcounter = 0;

	FileWriter fw1 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\odoutput.txt");
    BufferedWriter outFile = new BufferedWriter(fw1);
	
    //combined k and b list
	File readFile = new File("C:\\Users\\Kevin\\workspace\\Enigma\\ooutput1m.txt");
	BufferedReader readText = new BufferedReader(new FileReader(readFile));
	
	while((oline = readText.readLine()) != null){
		oarray[ocounter] = oline;
		ocounter++;
	}
	
	//dlist
    File readFile2 = new File("C:\\Users\\Kevin\\workspace\\Enigma\\doutput1m.txt");
    BufferedReader readText2 = new BufferedReader(new FileReader(readFile2));
    
	while((dline = readText2.readLine()) != null){
				
		String dsettings = dline.substring(4,10);
		
		
	if(dtable.containsKey(dsettings)){
		String dcombine = dtable.get(dsettings) + dline;
		dtable.put(dsettings, dcombine);
	}
	else{
		dtable.put(dsettings, dline);		
	}
		
		
	}
	
	
	
	
	//-------------------------
	
	
	for(int oloop = 0 ; oarray[oloop] != null ; oloop++){
					
    	char kpair = oarray[oloop].charAt(1);
    	char lpair = oarray[oloop].charAt(3);
    	char bpair = oarray[oloop].charAt(5);
    	
    	String osettings = oarray[oloop].substring(6,12);
    	
		if(dtable.containsKey(osettings)){
			
			String dreturn = dtable.get(osettings);
        	
			for(int a = 0; a < dreturn.length(); a = a + 10){
			
        	char dpair = dreturn.charAt(1 + a);
        	char xpair = dreturn.charAt(3 + a);
      		
        	if(bigPlugCompare('K',kpair,'L',lpair,'B',bpair,'D',dpair,'X',xpair)){
        		outFile.write("K" + kpair + "L" + lpair + "B" + bpair + "D" + dpair + "X" + xpair + osettings);
        		outFile.newLine();
        	outputcounter++;
        	System.out.println(outputcounter);
        	}
			
			}
					
		}

	}

	
	System.out.println("Done");
	
    	readText.close();
    	readText2.close();
    	outFile.close();
    	fw1.close();
   
}

public static boolean bigPlugCompare(char a, char apair, char b, char bpair, char c, char cpair, char d, char dpair, char e, char epair){
	//by default a b and c are already fine in relation to each other. only have to check theirs with d and e.
	//same for d and e together since they came from the same list.
	if(apair == dpair || apair == epair || bpair == dpair || bpair == epair || cpair == dpair || cpair == epair){
		return false;
	}
	if((apair == d && dpair != a) || (apair == e &&  epair != a) || (bpair == d && dpair != b) || (bpair == e &&  epair != b) || (cpair == d && dpair != c) || (cpair == e &&  epair != c)){
		return false;
	}
	if((dpair == a && apair != d) || (epair == a && apair != e) || (dpair == b && bpair != d) || (epair == b && bpair != e) || (dpair == c && cpair != d) || (epair == c && cpair != e)){
		return false;
	}
	
	//since there's 5 pairs, there's a chance of distinct pairs which is not possible since we only have 4 pairs.
	//thus, since there's 5, there has to be at least one that's self-paired. even if you did A - D and D - A,
	//those come in pairs of plugs so at best you'd have 4 of the letters doing that and 1 left.
	if(!(a == apair || b == bpair || c == cpair || d == dpair || e == epair)){
		return false;
	}
	
	
	return true;
	
	
	
}



//UseHashCompareKB instead. It's faster.
public static void ArrayCompareKB() throws IOException{
	
	//change these to size 200k for the real inputs due to their size. adjust memory in run config accordingly.
	String[] karray = new String[200000];
	String[] barray = new String[200000];
	
	String kline;
	String bline;
	int kcounter = 0;
	int bcounter = 0;
	int outputcounter = 0;

	FileWriter fw1 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\kboutput.txt");
    BufferedWriter outFile = new BufferedWriter(fw1);
	
	File readFile = new File("C:\\Users\\Kevin\\workspace\\Enigma\\koutput.txt");
	BufferedReader readText = new BufferedReader(new FileReader(readFile));
	
	while((kline = readText.readLine()) != null){
		karray[kcounter] = kline;
		kcounter++;
	}
		
    File readFile2 = new File("C:\\Users\\Kevin\\workspace\\Enigma\\boutput.txt");
    BufferedReader readText2 = new BufferedReader(new FileReader(readFile2));
    
	while((bline = readText2.readLine()) != null){
		barray[bcounter] = bline;
		bcounter++;
	}
	
	
	
	for(int kloop = 0 ; karray[kloop] != null ; kloop++){
		
    	boolean blinecheck = true;
		
    	char kpair = karray[kloop].charAt(1);
    	char lpair = karray[kloop].charAt(3);
    	
    	String ksettings = karray[kloop].substring(4,10);
    	int ksettingnum = Integer.parseInt(karray[kloop].substring(4,7));
    	int kring1 = charToInt(karray[kloop].charAt(7));
    	int kring2 = charToInt(karray[kloop].charAt(8));
    	int kring3 = charToInt(karray[kloop].charAt(9));
		
		for(int bloop = 0 ; barray[bloop] != null && blinecheck == true; bloop++){
			
			
        	String bsettings = barray[bloop].substring(4,10);
        	int bsettingnum = Integer.parseInt(barray[bloop].substring(4,7));
        	int bring1 = charToInt(barray[bloop].charAt(7));
        	int bring2 = charToInt(barray[bloop].charAt(8));
        	int bring3 = charToInt(barray[bloop].charAt(9));
        	//System.out.println(bsettings);
        	
        	if(ksettings.equals(bsettings)){
      		
        	char bpair = barray[bloop].charAt(1);
        	char kpair2 = barray[bloop].charAt(3);
        	//System.out.println(bpair);
        	//System.out.println(kpair2);
      		
        	if(kpair == kpair2 && pairCompare('L',lpair,'B',bpair)){
        	//System.out.println("K" + kpair + "L" + lpair + "B" + bpair + ksettings);
        		outFile.write("K" + kpair + "L" + lpair + "B" + bpair + ksettings);
        		outFile.newLine();
        	outputcounter++;
        	System.out.println(outputcounter);
        	}
        	
      	}
      		
        	if(bsettingnum > ksettingnum || (bsettingnum == ksettingnum && compareRing(kring1, kring2, kring3, bring1, bring2, bring3) == false)){
        		blinecheck = false;
        	}
					
		}

	}
	
    	readText.close();
    	readText2.close();
    	outFile.close();
    	fw1.close();
   
}

public static void EnglishFilter() throws IOException{
	File readFile = new File("C:\\Users\\Kevin\\workspace\\Enigma\\ThreePlug_Decrypts.txt");
	BufferedReader readText = new BufferedReader(new FileReader(readFile));
		
	FileWriter fw1 = new FileWriter("C:\\Users\\Kevin\\workspace\\Enigma\\EnglishFilter3.txt");
    BufferedWriter outFile = new BufferedWriter(fw1);
    
    String inputLine;
    String subLine;
    int outputcounter = 0;
    while((inputLine = readText.readLine()) != null){
    	subLine = inputLine.substring(19,86);
		if(isEnglish(subLine)){
			outFile.write(inputLine + "");
			outFile.newLine();
			System.out.println(subLine);
			outputcounter++;
			System.out.println(outputcounter);
		}
	}
    
    readText.close();
    outFile.close();
}



public static boolean pairCompare(char a, char apair, char b, char bpair){
	if(apair == bpair){
		return false;
	}
	if(apair == b && bpair != a){
		return false;
	}
	if(bpair == a && apair != b){
		return false;
	}
	return true;
}


public static boolean compareRing(int kring1, int kring2, int kring3, int bring1, int bring2, int bring3){
	if(bring1 > kring1){
		return false;
	}
	if(bring1 == kring1 && bring2 > kring2){
		return false;
	}
	if(bring1 == kring1 && bring2 == kring2 && bring3 > kring3){
		return false;
	}
	return true;
}

	
public static String enc(int[] settings, String inputString)
{
	int leftRotor = settings[0];
	int middleRotor = settings[1];
	int rightRotor = settings[2];
	int leftRing = settings[3];
	int middleRing = settings[4];
	int rightRing = settings[5];
	int leftGround = settings[6];
	int middleGround = settings[7];
	int rightGround = settings[8];

	int[] rightRotorArray;
	int[] middleRotorArray;
	int[] leftRotorArray;
	
	if(rightRotor==1) rightRotorArray = Rotor1Int; 
	else if(rightRotor==2) rightRotorArray = Rotor2Int;
	else if(rightRotor==3) rightRotorArray = Rotor3Int;
	else if(rightRotor==4) rightRotorArray = Rotor4Int;
	else if(rightRotor==5) rightRotorArray = Rotor5Int;
	else if(rightRotor==6) rightRotorArray = Rotor6Int;
	else if(rightRotor==7) rightRotorArray = Rotor7Int;
	else rightRotorArray = Rotor8Int;
	
	if(middleRotor==1) middleRotorArray = Rotor1Int; 
	else if(middleRotor==2) middleRotorArray = Rotor2Int;
	else if(middleRotor==3) middleRotorArray = Rotor3Int;
	else if(middleRotor==4) middleRotorArray = Rotor4Int;
	else if(middleRotor==5) middleRotorArray = Rotor5Int;
	else if(middleRotor==6) middleRotorArray = Rotor6Int;
	else if(middleRotor==7) middleRotorArray = Rotor7Int;
	else middleRotorArray = Rotor8Int;
	
	if(leftRotor==1) leftRotorArray = Rotor1Int; 
	else if(leftRotor==2) leftRotorArray = Rotor2Int;
	else if(leftRotor==3) leftRotorArray = Rotor3Int;
	else if(leftRotor==4) leftRotorArray = Rotor4Int;
	else if(leftRotor==5) leftRotorArray = Rotor5Int;
	else if(leftRotor==6) leftRotorArray = Rotor6Int;
	else if(leftRotor==7) leftRotorArray = Rotor7Int;
	else leftRotorArray = Rotor8Int;
	
	//determines the spots where the rotors will the turn the next one
	int middleRotorTurn[];
	int rightRotorTurn[];
	
	if(middleRotor==1) middleRotorTurn = Rotor1Turn; 
	else if(middleRotor==2) middleRotorTurn = Rotor2Turn;
	else if(middleRotor==3) middleRotorTurn = Rotor3Turn;
	else if(middleRotor==4) middleRotorTurn = Rotor4Turn;
	else if(middleRotor==5) middleRotorTurn = Rotor5Turn;
	else if(middleRotor==6) middleRotorTurn = Rotor6Turn;
	else if(middleRotor==7) middleRotorTurn = Rotor7Turn;
	else middleRotorTurn = Rotor8Turn;
	
	if(rightRotor==1) rightRotorTurn = Rotor1Turn; 
	else if(rightRotor==2) rightRotorTurn = Rotor2Turn;
	else if(rightRotor==3) rightRotorTurn = Rotor3Turn;
	else if(rightRotor==4) rightRotorTurn = Rotor4Turn;
	else if(rightRotor==5) rightRotorTurn = Rotor5Turn;
	else if(rightRotor==6) rightRotorTurn = Rotor6Turn;
	else if(rightRotor==7) rightRotorTurn = Rotor7Turn;
	else rightRotorTurn = Rotor8Turn;
		
	char[] input = inputString.toCharArray();
	char[] output = new char[inputString.length()];
	
			for(int i=0; i<inputString.length(); i++)
			{	
				//regular turning spots	
				if(rightGround == rightRotorTurn[0] || rightGround == rightRotorTurn[1]){
					if(middleGround == middleRotorTurn[0] || middleGround == middleRotorTurn[1]){
						leftGround = (leftGround + 1) % 26;
						}
				middleGround = (middleGround + 1) % 26;
				
				}
				else{
					//double step
					if(middleGround == middleRotorTurn[0] || middleGround == middleRotorTurn[1]){
						leftGround = (leftGround + 1) % 26;
						middleGround = (middleGround + 1) % 26;
						}
				}
				
				//turn for right rotor each run
				rightGround = (rightGround + 1) % 26;
				
		int c = charToInt(input[i]);
		c = PlugSwap(c);
		c = rotor(c, rightRotorArray, rightGround, rightRing);
		c = rotor(c, middleRotorArray, middleGround, middleRing);
		c = rotor(c, leftRotorArray, leftGround, leftRing);
		c = ReflectorB(c);
		c = rotorInverse(c, leftRotorArray, leftGround, leftRing);
		c = rotorInverse(c, middleRotorArray, middleGround, middleRing);
		c = rotorInverse(c, rightRotorArray, rightGround, rightRing);
		c = PlugSwap(c);
		
		output[i] = intToChar(c);
	
	}
	String outputString = new String(output);
	return outputString;
}

public static boolean KDBTest(){
	return false;
}

public static boolean isEnglish(String inputString){


	double vowelcount = 0;
	int outliercount = 0;
	
	char Current = '?';
	char Before = '?';
	char BeforeBefore = '?';
	char BeforeBeforeBefore = '?';
	
	int[] letterCount = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int[] upperBound = new int[]{13,5,6,8,17,6,5,10,11,2,3,8,6,11,12,5,2,10,11,13,6,4,6,2,5,2};
	int[] lowerBound = new int[]{0,-1,-1,-1,2,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1};
	
	int lastLetter = inputString.length() - 1;
	
	/*
	int kdbCounter = 0;
	
	if(inputString.charAt(lastLetter - 2) == 'K'){
		kdbCounter++;
	}
	if(inputString.charAt(lastLetter - 1) == 'D'){
		kdbCounter++;
	}
	if(inputString.charAt(lastLetter) == 'B'){
		kdbCounter++;
	}
	
	if(kdbCounter < 2){
		return false;
	}
	*/
	
	if(inputString.charAt(lastLetter - 2) != 'K' && inputString.charAt(lastLetter - 1) != 'D' && inputString.charAt(lastLetter) != 'B'){
		return false;
	}
	
	
	for(int a = 0; a < inputString.length(); a++){
		
		BeforeBeforeBefore = BeforeBefore;
		BeforeBefore = Before;
		Before = Current;
		Current = inputString.charAt(a);	
		
		//LetterCounter
		letterCount[(charToInt(Current))]++;
		
		//Three in a row
	//	if((BeforeBefore == Before) && (BeforeBefore == Current)){
	//	return false;
	//	}
		
	//	//Consecutive doubles
	//	if((BeforeBeforeBefore == BeforeBefore) && (Before == Current)){
	//		return false;
	//	}
						
		//VowelCounter
		if(inputString.charAt(a) == 'A' || inputString.charAt(a) == 'E' || inputString.charAt(a) == 'I' || inputString.charAt(a) == 'O' || inputString.charAt(a) == 'U'){
			vowelcount++;
		}
	}
	
	//for(int a = 0; a < 26; a++){
	//	System.out.println(letterCount[a]);
	//}
	
	
	//ZCheck
	//if(letterCount[25] > 2){
	//	//System.out.println("Z:" + letterCount[25]);
	//	return false;
	//}
	
	//XCheck
	//if(letterCount[23] > 2){
	//	System.out.println("X:" + letterCount[23]);
	//	return false;
	//}

	//QCheck
	//if(letterCount[16] > 2){
	//	System.out.println("Q:" + letterCount[16]);
	//	return false;
	//}

	//VowelCheck
	if((vowelcount) > 37 || (vowelcount) < 16){
	return false;
	}
	
	
	//OutlierCounter
	for(int a = 0 ; a < 26 ; a++){
		if(letterCount[a] <= lowerBound[a] || letterCount[a] >= upperBound[a]){
			outliercount++;
		}
	}
		
	if(outliercount > 1){
		//System.out.println(outliercount);
		return false;
	}
		
	//if(letterCount[4] < 4 || letterCount[4] > 16){
	//	return false;
	//}
	
	
	return true;
}



public static int rotor(int inputChar, int[] inputRotor, int GrundSetting, int RingSetting){
	//takes value and adds the grund shift value.
	int AdjustedValue = ((inputChar + GrundSetting) - RingSetting + 26) % 26;
	//takes output from array and subtracts grund shift value.
	
	int ReturnValue = (inputRotor[AdjustedValue] - GrundSetting + RingSetting + 26) % 26;
	
	return ReturnValue;
}
	
public static int rotorInverse(int inputChar, int[] inputRotor, int grundSetting, int RingSetting){
	char[] Default = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	int[] DefaultInt = new int[26];
	for(int a = 0; a < 26 ; a++){
		DefaultInt[a] = charToInt(Default[a]);
	}
		
	//takes value and subtracts the grund shift value.
	int AdjustedValue = ((inputChar + grundSetting - RingSetting) + 26) % 26;
			
	int index = 0;
	while(inputRotor[index] != AdjustedValue){
		index++;
	}
	
	index = (index - grundSetting + RingSetting + 26) % 26;
	
	//takes output from array and subtracts grund shift value.
	return DefaultInt[index];
}
	
public static int ReflectorB(int inputChar){	
	return ReflectorInt[inputChar];
}
	
public static int charToInt(char z)
{
	char x = Character.toUpperCase(z);
	if(x=='A')return 0;
	if(x=='B')return 1;
	if(x=='C')return 2;
	if(x=='D')return 3;
	if(x=='E')return 4;
	if(x=='F')return 5;
	if(x=='G')return 6;
	if(x=='H')return 7;
	if(x=='I')return 8;
	if(x=='J')return 9;
	if(x=='K')return 10;
	if(x=='L')return 11;
	if(x=='M')return 12;
	if(x=='N')return 13;
	if(x=='O')return 14;
	if(x=='P')return 15;
	if(x=='Q')return 16;
	if(x=='R')return 17;
	if(x=='S')return 18;
	if(x=='T')return 19;
	if(x=='U')return 20;
	if(x=='V')return 21;
	if(x=='W')return 22;
	if(x=='X')return 23;
	if(x=='Y')return 24;
	else return 25;
}
	
public static char intToChar(int x) 
{
		x = x % 26;
		if(x==0)return 'A';
		if(x==1)return 'B';
		if(x==2)return 'C';
		if(x==3)return 'D';
		if(x==4)return 'E';
		if(x==5)return 'F';
		if(x==6)return 'G';
		if(x==7)return 'H';
		if(x==8)return 'I';
		if(x==9)return 'J';
		if(x==10)return 'K';
		if(x==11)return 'L';
		if(x==12)return 'M';
		if(x==13)return 'N';
		if(x==14)return 'O';
		if(x==15)return 'P';
		if(x==16)return 'Q';
		if(x==17)return 'R';
		if(x==18)return 'S';
		if(x==19)return 'T';
		if(x==20)return 'U';
		if(x==21)return 'V';
		if(x==22)return 'W';
		if(x==23)return 'X';
		if(x==24)return 'Y';
		else return 'Z';
}
	
public static boolean checkInput(char Input){
	boolean Check = false;
	for(int a = 0; a < 26 && Check == false ; a++){
		if(Input == DEFAULT[a]){
				Check = true;
			}
	}
	return Check;
}
	
	//Converts input into the plug swapped value.
	public static int PlugSwap(int Input){
		return charToInt(Plug[Input]);
	}
	
	//Takes two inputs and swaps them. Edits the array. (A would be 0 so if you swap A to Z, it would set Plug[0] to Z and Plug[25] to A)
	//By default they are in normal order. (A -> Z)
	public static void PlugSetup(char InputA, char InputB){
		char Input1 = Character.toUpperCase(InputA);
		char Input2 = Character.toUpperCase(InputB);;
		if(checkInput(Input1) && checkInput(Input2)){
			int InputOne = charToInt(Input1);
			int InputTwo = charToInt(Input2);
			Plug[InputOne] = Input2;
			Plug[InputTwo] = Input1;
		}
		else{
			System.out.println("Not Valid Input for PlugSwag");
		}
		
	}
	
	public static void PlugReset(){
		Plug = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	}
	
	/**
	 * I think we need to remove this part and update the original arrays instead to int... more efficient- Stan
	 */
	private static void convertArrays()
	{
		//convert them into int arrays for easier usage
		for(int a = 0; a < 26 ; a++){
			DefaultInt[a] = charToInt(DEFAULT[a]);
			Rotor1Int[a] = charToInt(ROTOR1[a]);
			Rotor2Int[a] = charToInt(ROTOR2[a]);
			Rotor3Int[a] = charToInt(ROTOR3[a]);
			Rotor4Int[a] = charToInt(ROTOR4[a]);
			Rotor5Int[a] = charToInt(ROTOR5[a]);
			Rotor6Int[a] = charToInt(ROTOR6[a]);
			Rotor7Int[a] = charToInt(ROTOR7[a]);
			Rotor8Int[a] = charToInt(ROTOR8[a]);
			ReflectorInt[a] = charToInt(REFLECTORB[a]);
		}
		PlugInt = DefaultInt.clone();
	}
}