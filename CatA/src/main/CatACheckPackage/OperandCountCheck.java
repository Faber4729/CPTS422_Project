package CatACheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class OperandCountCheck extends AbstractCheck{

	// These are Static So the Halstead Checks Can Reference Them
	// Overall Operand Count
	public static int operandCount = 0;
	
	// Unique Operand Count
	public static int uOperandCount = 0;
	private String[] uOperandList = new String[0];
	
	// These Are All Strings, Variables, True/False, and Numbers
	// This Also Includes Package Names, Method Names, and main/args in main(string[] args)
	@Override
	public int[] getAcceptableTokens() {
		return new int[] {TokenTypes.IDENT, // Variable
			TokenTypes.NUM_DOUBLE,
			TokenTypes.NUM_FLOAT,
			TokenTypes.NUM_LONG,
			TokenTypes.NUM_INT,
			TokenTypes.STRING_LITERAL,
			TokenTypes.LITERAL_TRUE,
			TokenTypes.LITERAL_FALSE,
		};

	}
	
	@Override
	public int[] getDefaultTokens() {
		return getAcceptableTokens();
	}
	
	@Override
	public int[] getRequiredTokens() {
		return getAcceptableTokens();
	}
	
	@Override
	public void beginTree(DetailAST aAST) {
		// Set OperandCounts to 1 For Initial Root
		operandCount = 1;
		uOperandCount = 1;
	}
	
	@Override
    public void visitToken(DetailAST aAST) {
		// Increase OperandCount
		operandCount++;
		
		// Check if Symbol is Unique
		boolean flag = false;

		// Iterate Through All Operands
		for(String element : uOperandList) {
			if(aAST.getText().equals(element)) {
				// If the Operand Exists, Set Flag to True
				flag = true;
			}
		}
		
		// If the Symbol Was Not Found, Increase the Unique Count
		if(flag == false) {
			uOperandCount++;
			
			// Recreate Unique List
			String[] newOperandList = new String[uOperandList.length + 1];
			
			for (int i = 0; i < uOperandList.length; i++) {
				newOperandList[i] = uOperandList[i];
			}
			
			// Add Type to Operand Collection
			newOperandList[newOperandList.length-1] = aAST.getText();
			
			// Set List to Modified One
			uOperandList = newOperandList;
		}
    }

    @Override
    public void finishTree(DetailAST aAST) {	
    	// Logs the Number of Operands at the First Line
    	log(aAST.getLineNo(), "operandFinal", operandCount, uOperandCount);
    }
    
    // For Halstead Purposes, Get Counts
    public static int getOperandCount() {
    	return operandCount;
    }
    
    // And Get Unique Count
    public static int getUniqueOperandCount() {
    	return uOperandCount;
    }
}
