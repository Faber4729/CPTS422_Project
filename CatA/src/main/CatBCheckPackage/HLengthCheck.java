package CatBCheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;
import resources.HalsteadCounts;

public class HLengthCheck extends AbstractCheck {
	
	private int length;
		
	// I Think This Has to Be an AbstractCheck, But I Don't Think It Needs a Tree
	@Override
	public int[] getAcceptableTokens() {
		return new int[] {0};
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
    public void finishTree(DetailAST aAST) {
    	length = (HalsteadCounts.getOperands() + HalsteadCounts.getOperators());
    	
    	// Logs the Number of Operators/Operands at the First Line
    	log(aAST.getLineNo(), "hLengthFinal", length);
    }
}
