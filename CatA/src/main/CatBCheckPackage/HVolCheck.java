package CatBCheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;

public class HVolCheck extends AbstractCheck {
	
	private double volume;
		
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
    	volume = getVolume();
    	
    	
    	// Logs the Number of Operators/Operands at the First Line
    	log(aAST.getLineNo(), "hVolumeFinal", volume);
    }
    
    // Method For Calculating Volume
    public static double getVolume() {
    	return (OperandCountCheck.getOperandCount() + OperatorCountCheck.getOperatorCount()) * (Math.log((OperandCountCheck.getUniqueOperandCount() + OperatorCountCheck.getUniqueOperatorCount())) / Math.log(2));
    }
}
