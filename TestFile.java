import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;


public class TestFile {

	public static void main(String[] args){
		
		
		Hashtable<String, ArrayList<String>> arrayhash2 = new Hashtable<String, ArrayList<String>>();
		
		ArrayList<String> testingarray = new ArrayList<String>();
		
		testingarray.add("Hi");
		testingarray.add("This");
		testingarray.add("Is");
		
		arrayhash2.put("This Is", testingarray);
		
				
		ArrayList<String> retrieve = arrayhash2.get("This Is");
		
		
		for(int a = 0; a < retrieve.size(); a++){
			System.out.println(retrieve.get(a));			
		}

		retrieve = new ArrayList<String>();
				
		for(int a = 0; a < retrieve.size(); a++){
			System.out.println(retrieve.get(a));			
		}
		
		Hashtable<String, String> arrayhash = new Hashtable<String, String>();
		arrayhash.put("Happy", "Sad");
		arrayhash.put("Happy","Angry");
		
		System.out.println(arrayhash.get("Happy"));
		
		System.out.println("------------");
		
		String[] testarray = new String[5];
		System.out.println(testarray[0]);
		
		BigDecimal a = BigDecimal.valueOf(0.99);
		System.out.println(a);
		System.out.println(a.pow(15));
		
		BigDecimal b = BigDecimal.valueOf(0.99);
		BigDecimal c = BigDecimal.valueOf(0.01);
		
		BigDecimal f = c.multiply(b.pow(14)).multiply(BigDecimal.valueOf(15));
		System.out.println(f);
		
		System.out.println(a.pow(15).add(f));
				
		System.out.println("-------------");
		
		BigDecimal numcounter = BigDecimal.ZERO;
		
		for(int choosenum = 0; choosenum < 69; choosenum++){

			BigDecimal TopFact = new BigDecimal("2480035542436830599600990418569171581047399201355367672371710738018221445712183296000000000000000");
			BigDecimal BotFact1 = BigDecimal.valueOf(1);
			BigDecimal BotFact2 = BigDecimal.valueOf(1);
			
			for(int temp = choosenum; temp > 0; temp--){
				BotFact1 = BotFact1.multiply(BigDecimal.valueOf(temp));
			}
			
			for(int temp = (68 - choosenum); temp > 0; temp--){
				BotFact2 = BotFact2.multiply(BigDecimal.valueOf(temp));
			}
			
			BigDecimal x = TopFact.divide((BotFact1.multiply(BotFact2)));
			
			double chance = 0.381;
			double oneminus = 1 - chance;
			
			BigDecimal y = BigDecimal.valueOf(chance);
			BigDecimal z = BigDecimal.valueOf(oneminus);
			
			BigDecimal finalresult = x.multiply(y.pow(choosenum).multiply(z.pow(68 - choosenum)));
			System.out.println(choosenum + " - " + finalresult);
			
			if(choosenum > 15 && choosenum < 37){
				numcounter = numcounter.add(finalresult);
			}
		}

		System.out.println(numcounter);


		
	}
	
	public static String[] caughtSkipping(String [] line, String skipper, String skipped){

	boolean skipperPresent = false;
	boolean skippedPresent = false;
	int skipperIndex = 0;
	int skippedIndex = 0; 

	for(int a = 0; a < line.length ; a++){
		if (line[a].equals(skipper)){
		skipperPresent = true;
		skipperIndex = a;
		}
		if (line[a].equals(skipped)){
		skippedPresent = true;
		skippedIndex = a;
		}
	}

	if(skipperPresent && skippedPresent){

		if(skipperIndex < skippedIndex){
		int lastIndexLength = (line[line.length - 1]).length();
		
		line[line.length - 1] = line[line.length - 1] + line[skipperIndex];

		for(int a = skipperIndex ; a < (line.length - 1) ; a++){
			line[a] = line[a + 1];
		}	


		line[line.length - 2] = line[line.length - 2].substring(0,lastIndexLength);
		line[line.length - 1] = line[line.length - 1].substring(lastIndexLength);

		}
	}


	return line;

	}
	
}
