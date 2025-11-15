package CatACheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class OperandCountCheck extends AbstractCheck{

	// Overall Operand Count
	private int operandCount = 0;
	
	// Unique Operand Count
	private int uOperandCount = 0;
	private int[] operandCollection = {1, 1, 1, 1, 1}; // The Length of All Possible Tokens
	private int spot = 0;
	
	// I Am Only Checking for /, +, -, *, %
	// Assuming that Expressions Are Only Basic Algebraic Expressions
	// This Counts Things Like: string = "a" + "b" and i++	
	
	@Override
	public int[] getAcceptableTokens() {
		return new int[] {TokenTypes.DIV, 
				TokenTypes.PLUS, 
				TokenTypes.MINUS, 
				TokenTypes.STAR, 
				TokenTypes.MOD
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
	public void visitToken(DetailAST aAST) {
		// Increase Count 
		operandCount++;
		
//		// Check if Symbol is Unique
		boolean flag = false;
		
		for(int element : operandCollection) {
			if(element != 1) {
				if(aAST.getType() == element) {
					flag = true;
				}
			}
		}
		
		// If the Symbol Was Not Found, Increase the Unique Count
		if(flag == false) {
			uOperandCount++;
			
			// And Add Type to Collection
			operandCollection[spot] = aAST.getType();
			spot++;
		}
		
	}
	
	@Override
    public void beginTree(DetailAST aAST) {
		operandCount = 0;
    }

    @Override
    public void finishTree(DetailAST aAST) {
    	// Logs the Number of Operands at the First Line
    	log(aAST.getLineNo(), "operandFinal", operandCount, uOperandCount);
    }
    
    // For Halstead Purposes, Get Count
    public int getOperandCount() {
    	return this.operandCount;
    }
    
    // And Get Unique Count
    public int getUniqueOperandCount() {
    	return this.uOperandCount;
    }
}
