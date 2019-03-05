import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class assignment1 {

	
	public static void main(String[] args) throws FileNotFoundException {
		int[] errors = new int[6];
		String[] errorNames = {"ill-formed operand", 
		                        "invalid opcode",
		                        "too many operand",
		                        "too few operand",
		                        "ill-informed identifier",
		                        "ill-informed literal"};		
		ArrayList<String> result = new ArrayList<String>();
		
		try {
			Scanner input = new Scanner(new File("MAL.txt"));
			PrintWriter output = new PrintWriter(new File("MALoutput.txt"));
			while(input.hasNext()) {
				
				output.println(input.nextLine());
	
			}
			input.close();
			output.close();
			input=null;
			output=null;
			
			input= new Scanner(new File("MAL.txt"));
			output= new PrintWriter(new File("MALoutput.txt"));
			
			while(input.hasNext()) {
			String line = input.nextLine();
	
	        line = line.split("\\;", 2) [0]
	        		   .replaceAll("\\s+", " ");

	        if(line.trim().isEmpty()) {
	        	 continue;
	         }
	        String[] splitLine = line.split(" ");
	        
	        String[] regLine = new String[] {""};
	        
	        String opcode = splitLine[0];
	        
	        for(int i = 1; i < splitLine.length; i++) {
	        	if(splitLine[i].indexOf(",") != splitLine[i].lastIndexOf(",")) {
	        		regLine = splitLine[i].split(",");
	        	}
	        }
	 
	        System.out.print(opcode + " ");
	        
	        if(!regLine[0].equals("")) {
	        	for(String s : regLine) 
	        		System.out.print(s + ", ");
	        } else {
	        	for(int i = 1; i < splitLine.length; i++)
	        		System.out.print(splitLine[i] + " ");
	        }
	        
	        System.out.println(" ");
	        
	        
	        String[] arguments = null;
	        
	        switch (opcode) {
		        case "ADD": 
		        	arguments = new String[] {"register", "label", "label"};
		        	
	        		break; 		
		        case "LOAD": 
		        	arguments = new String[] {"register", "label"};
		        	
		        	break;
		        case "SUB":
		        	arguments = new String[] {"register", "label", "label"};
		        	
		        	break;
		        case "STORE": 
		        	arguments = new String[] {"register", "register"};
		        	
		        	break;
		        case "LOADI":
		        	arguments = new String[] {"register", "label"};
		        	
		        	break;
		        case "INC":
		        	arguments = new String[] {"register"};
		        	
		        	break;
		        case "DEC":
		        	arguments = new String[] {"register"};
		        	
		        	break;
		        case "BEQ":
		        	arguments = new String[] {"register", "register", "label"};
		        	
		        	break;
		        case "BLT":
		        	arguments = new String[] {"register", "register", "label"};
		        	
		        	break;
		        case "BGT":
		        	arguments = new String[] {"register", "register", "label"};
		        	
		        	break;
		        case "BR":
		        	arguments = new String[] {"label"};
		        	break;
		        case "NOOP":
		        	arguments = new String[] {""};
		        	break;
		        case "END":
		        	arguments = new String[] {};
		        	break;
		        default: 
		        	arguments = new String[] {" "};
		        	System.out.println("** error: invalid opcode " + opcode);
		        	errors[1]++;
		        	// TODO: end this iteration, throw away the rest of the line
		        	
		        	break;

	        }
	     /*  String [] errors = null;
	       for(int i = 0; i < errors.length; i++) {
	    	   errors[0] = opcodeError;
	       }
	     */  
	        	if(!regLine[0].equals("")) { // regLine is used
	        		if(regLine.length != arguments.length) {
		        		if(regLine.length < arguments.length) {
		        	
		        		} else {
		       
		        		}
	        		}
	        	} else { // splitLine is used
	        		if(splitLine.length-1 != arguments.length) {
	        			if(splitLine.length-1 < arguments.length) {
	        				System.out.println("** error: too few operand");
	        				errors[3]++;
	        			} else {
	        				System.out.println("** error: too many operand");
	        				errors[4]++;
	        			}
	        		}
	        	}
	        

	        output.println(line);
	       // result.add(line);
	        
	        try {
		        //loop
		        for(int i = 0; i < arguments.length; i++) {
			        if(arguments[i].equals("register")) {
			        	//is splitLine[i+1] / regLine[i] a register
			        	if(!regLine[0].equals("")) {
			        		// use regline
				        	if (!(regLine[i].toLowerCase().charAt(0) ==114)) {
					        	// error
					        	System.out.println("** error: ill-formed operand, expected register");
					        	errors[0]++;
				        	}
			        	} else {
			        		// use splitline
				        	if (!(splitLine[i+1].toLowerCase().charAt(0) ==114)) {
					        	// error
					        	System.out.println("** error: ill-formed operand, expected register");
					        	errors[0]++;	
					        }
			        	}
			        
			        }else if(arguments[i].equals("label")) {
			        	if(!regLine[0].equals("")) {
			        		if(regLine[i].toLowerCase().charAt(0) >= 97 && regLine[i].toLowerCase().charAt(0) <= 122) {
			        			// starts with a letter
			        		} else {
			        			System.out.println("** error: this is not a label");
			        		}
			        		
			        	} else {
			        		if(splitLine[i].toLowerCase().charAt(0) >= 97 && splitLine[i].toLowerCase().charAt(0) <= 122) {
			        			
			        		}
			        		else {
			        			System.out.println("** error: this is not a label");
			        			//error
			        		}
			        		
			        	} 
			        	
			        }
			        
			        
		        }
	        	
	        	
		        for(int i = 0; i+1 < splitLine.length && i < regLine.length; i++) {
					if(splitLine[i+1].toLowerCase().charAt(0) >= 97 && splitLine[i+1].toLowerCase().charAt(0) <= 112) {
		        		//Check if this character is between A-Z or a-z.
		        	}
					//if(splitLine[i+1])
		        }
	        
	        }
	        catch(ArrayIndexOutOfBoundsException ex) {
	        }
	        
	    }
			
		input.close();
	    output.close();    
		}catch (FileNotFoundException e){
			System.out.print("File Not Found");
		}
		     
	      // Check for errors
	      for(int i = 0; i < errors.length; i++) {
	    	  if(errors[i] != 0) {
	    		  System.out.format("%d %s\n", errors[i], errorNames[i]);
	    	  }
	      }
	}
	


}

