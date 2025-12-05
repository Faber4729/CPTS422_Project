package CatACheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class ExpressionCountCheck extends AbstractCheck {

		private int expressionCount = 0;
		
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
			
			// Check For If Another Token is In the Same Line
			DetailAST nextaAST = aAST.getNextSibling();
			
			if(nextaAST != null) {
				// Remove a Count to Balance the Value
				// Only the Last Expression Symbol Should Count
				expressionCount--;
			}
		}
		
		@Override
	    public void beginTree(DetailAST aAST) {
	        expressionCount = 0;
	    }

	    @Override
	    public void finishTree(DetailAST aAST) {
	    	// Logs the Number of Expressions at First Line
	    	log(aAST.getLineNo(), "expressionFinal", expressionCount);
	    }
	    
	    // Get Method for Testing
	    public int getExpressionCount() {
	    	return expressionCount;
	    }
		
	}
