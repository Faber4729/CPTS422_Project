package CatBCheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;

public class HDifficultyCheck extends AbstractCheck {
		
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
    	// Logs the Number of Operators/Operands at the First Line
    	log(aAST.getLineNo(), "hDifficultyFinal", getDiff());
    }
    
    public static double getDiff() {
    	return (OperandCountCheck.getOperandCount() * (0.5 * OperatorCountCheck.getUniqueOperatorCount())) / OperandCountCheck.getUniqueOperandCount();
    }
}
