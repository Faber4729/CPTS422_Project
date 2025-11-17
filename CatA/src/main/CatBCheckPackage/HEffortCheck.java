package CatBCheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.OperandCountCheck;
import CatACheckPackage.OperatorCountCheck;

public class HEffortCheck extends AbstractCheck {
	
	private double volume;
	private double diff;
	private double effort;
		
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
    	
    	volume = HVolCheck.getVolume();
    	
    	diff = HDifficultyCheck.getDiff();
    	
    	effort = diff * volume;
    	
    	// Logs the Number of Operators/Operands at the First Line
    	log(aAST.getLineNo(), "hEffortFinal", effort);
    }
}
