package CatACheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class OperatorCountCheck extends AbstractCheck{

	private int operatorCount = 0;
	
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
	// TODO Auto-generated method stub
	return getAcceptableTokens();
	}
	
	
	@Override
	public void visitToken(DetailAST aAST) {
		// Increase Count
		operatorCount++;
	}
	
	@Override
    public void beginTree(DetailAST rootAST) {
        operatorCount = 0;
    }

    @Override
    public void finishTree(DetailAST rootAST) {
    	// Logs the Number of Operators at the Final Operator's Line
    	log(rootAST.getLineNo(), "operatorFinal", operatorCount);
    }
	
}
