package CatACheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class LoopCountCheck extends AbstractCheck {

	// Tracker Variable
	private int loopCount = 0;
	
	@Override
	public int[] getAcceptableTokens() {
	// Gets All for, foreach, and while Tokens
	return new int[] {TokenTypes.FOR_CONDITION,
			TokenTypes.FOR_EACH_CLAUSE,
			TokenTypes.LITERAL_WHILE};
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
		// Increase Counter
		loopCount++;
	}	
	
	@Override
    public void beginTree(DetailAST aAST) {
        loopCount = 0;
    }

    @Override
    public void finishTree(DetailAST aAST) {
    	// Logs the Number of Loops at the First Line
    	log(aAST.getLineNo(), "loopFinal", loopCount);
    }

    // Get Loop Count for Testing Purposes
    public int getLoopCount() {
    	return this.loopCount;
    }
	
}
