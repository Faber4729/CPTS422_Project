package CatACheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

import CatBCheckPackage.HalsteadParent;
import resources.HalsteadCounts;

public class OperandCountCheck extends AbstractCheck{
	
	// Parent Halstead Class For Metrics
	private HalsteadParent parent;

	// Overall Operand Count
	private int operandCount = 0;
	
	// Unique Operand Count
	private int uOperandCount = 0;
	
	// These Are All Strings, Variables, True/False, and Numbers
	// This Also Includes Package Names, Method Names, and main/args in main(string[] args)
	@Override
	public int[] getAcceptableTokens() {
		return new int[] {TokenTypes.IDENT, // Variable
			TokenTypes.NUM_DOUBLE,
			TokenTypes.NUM_FLOAT,
			TokenTypes.NUM_LONG,
			TokenTypes.NUM_INT,
			TokenTypes.STRING_LITERAL,
			TokenTypes.LITERAL_TRUE,
			TokenTypes.LITERAL_FALSE,
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
		// Add Operand Through Parent
		parent.addOperand(aAST.getText());
	}
	
	@Override
    public void beginTree(DetailAST aAST) {
		if (getParent() instanceof HalsteadParent) {
	        parent = (HalsteadParent) getParent();
	    } else {
	        throw new IllegalStateException(
	            "HalsteadOperandCheck must be inside HalsteadParent in checkstyle.xml"
	        );
	    }
    }

    @Override
    public void finishTree(DetailAST aAST) {
    	// Get Parent/Count Values
    	parent = (HalsteadParent) aAST.getParent();
    	operandCount = parent.getOperands();
    	uOperandCount = parent.getUOperands();
    			
    	// Logs the Number of Operands at the First Line
    	log(aAST.getLineNo(), "operandFinal", operandCount, uOperandCount);
    }
    
    // For Testing Purposes, Get Counts
    public int getOperandCount() {
    	return this.operandCount;
    }
    
    // And Get Unique Count
    public int getUniqueOperandCount() {
    	return this.uOperandCount;
    }
}
