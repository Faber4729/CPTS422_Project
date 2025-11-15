package CatACheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class OperandCountCheck extends AbstractCheck{

	// Overall Operand Count
	private int expressionCount = 0;
	
	// Unique Operand Count
	private int uExpressionCount = 0;
	private int[] expressionCollection = {1, 1, 1, 1, 1}; // The Length of All Possible Tokens
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
		expressionCount++;
		
//		// Check if Symbol is Unique
//		boolean flag = false;
//		
//		for(int element : expressionCollection) {
//			if(element != 1) {
//				if(aAST.getType() == element) {
//					flag = true;
//				}
//			}
//		}
//		
//		// If the Symbol Was Not Found, Increase the Unique Count
//		if(flag == false) {
//			uExpressionCount++;
//			
//			// And Add Type to Collection
//			expressionCollection[spot] = aAST.getType();
//			spot++;
//		}
//		
//		// Check For If Another Token is In the Same Line
//		DetailAST nextaAST = aAST.getNextSibling();
//		
//		if(nextaAST != null) {
//			// Remove a Count to Balance the Value
//			// Only the Last Expression Symbol Should Count
//			expressionCount--;
//		}
	}
	
	@Override
    public void beginTree(DetailAST aAST) {
        expressionCount = 0;
    }

    @Override
    public void finishTree(DetailAST aAST) {
    	// Logs the Number of Operands at the First Line
    	log(aAST.getLineNo(), "expressionFinal", expressionCount, " And unique: ", uExpressionCount);
    }
    
    // For Halstead Purposes, Get Count
    public int getOperandCount() {
    	return this.expressionCount;
    }
    
    // And Get Unique Count
    public int getUniqueOperandCount() {
    	return this.uExpressionCount;
    }
}
