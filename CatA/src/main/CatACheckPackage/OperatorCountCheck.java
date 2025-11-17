package CatACheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class OperatorCountCheck extends AbstractCheck{

	public static int operatorCount = 0;
	
	// Unique Operand Count
	public static int uOperatorCount = 0;
	private int[] operatorCollection = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // The Length of All Possible Tokens
	private int spot = 1;
	
	// I Got These Tokens From https://checkstyle.sourceforge.io/checks/whitespace/operatorwrap.html#OperatorWrap
	// They're: +, -, *, /, %, ++, --, ==, !=, >>>, <<<, >, <, >=, <=, ^, |, ||, &&, ^=, +=, -=, /=, *=, %=, >>>=, |=, ||=
	@Override
	public int[] getAcceptableTokens() {
		return new int[] {TokenTypes.DIV, 
				TokenTypes.PLUS, 
				TokenTypes.MINUS, 
				TokenTypes.STAR, 
				TokenTypes.MOD, 
				TokenTypes.EQUAL, 
				TokenTypes.NOT_EQUAL,
				TokenTypes.INC,
				TokenTypes.DEC, 
				TokenTypes.SR, 
				TokenTypes.BSR, 
				TokenTypes.GE, 
				TokenTypes.GT, 
				TokenTypes.SL, 
				TokenTypes.LE,
				TokenTypes.LT, 
				TokenTypes.BXOR, 
				TokenTypes.BOR, 
				TokenTypes.LOR, 
				TokenTypes.BAND, 
				TokenTypes.LAND,
				TokenTypes.PLUS_ASSIGN, 
				TokenTypes.DIV_ASSIGN, 
				TokenTypes.MINUS_ASSIGN, 
				TokenTypes.STAR_ASSIGN, 
				TokenTypes.MOD_ASSIGN, 
				TokenTypes.SR_ASSIGN, 
				TokenTypes.BOR_ASSIGN, 
				TokenTypes.BSR_ASSIGN,
				TokenTypes.BXOR_ASSIGN, 
				TokenTypes.BAND_ASSIGN
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
		operatorCount++;
		
		// Check if Symbol is Unique
		boolean flag = false;
		
		for(int element : operatorCollection) {
			if(element != 1) {
				if(aAST.getType() == element) {
					flag = true;
				}
			}
		}
		
		// If the Symbol Was Not Found, Increase the Unique Count
		if(flag == false) {
			uOperatorCount++;
			
			// And Add Type to Collection
			operatorCollection[spot] = aAST.getType();
			spot++;
		}
				
	}
	
	@Override
    public void beginTree(DetailAST aAST) {
		// Since An Operator is Found, Increase Count at Start of Tree
        operatorCount = 1;
        uOperatorCount = 1;
    }

    @Override
    public void finishTree(DetailAST aAST) {	
    	// Logs the Number of Operators/Unique Operators at the First Line
    	log(aAST.getLineNo(), "operatorFinal", operatorCount, uOperatorCount);
    }
    

    // For Halstead Purposes, Get Counts
    public static int getOperatorCount() {
    	return operatorCount;
    }
    
    // And Get Unique Count
    public static int getUniqueOperatorCount() {
    	return uOperatorCount;
    }
	
}
