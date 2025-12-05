package ExtraCreditChecks;

import com.puppycrawl.tools.checkstyle.api.*;

public class CastCount extends AbstractCheck {

	// Tracker Variable
	private int castCount = 0;
	
	@Override
	public int[] getAcceptableTokens() {
	// Gets All ( and )
	return new int[] {TokenTypes.LPAREN,
			TokenTypes.RPAREN,
			TokenTypes.LITERAL_CHAR,
			TokenTypes.LITERAL_INT,
			TokenTypes.LITERAL_CHAR,
			TokenTypes.LITERAL_CHAR,
			TokenTypes.LITERAL_CHAR,
			TokenTypes.LITERAL_CHAR,
			TokenTypes.LITERAL_CHAR,
			TokenTypes.LITERAL_CHAR,
			TokenTypes.LITERAL_CHAR,
			TokenTypes.LITERAL_CHAR,
			TokenTypes.LITERAL_CHAR,
			TokenTypes.LITERAL_CHAR,// Actually maybe do a notation detector like hungarian check and see if parent is left parentheses?
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
		// Check if Left Parenthesis and If So, Check if Next Part of Tree is Null
		// If Not, Check if Following is Right Parentheses
		
	}	
	
	@Override
    public void beginTree(DetailAST aAST) {
		castCount = 0;
    }

    @Override
    public void finishTree(DetailAST aAST) {
    	// Logs the Number of Casts at the First Line
    	log(aAST.getLineNo(), "castFinal", castCount);
    }

	
}
