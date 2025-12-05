package CatBTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;
import CatBCheckPackage.*;

import static org.mockito.Mockito.*;

public class HLengthTest {

	// Check getAcceptableTokens
	@Test
	public void testGetAcceptableTokens(){
		
		// Create new HLength
		HLengthCheck HL = (new HLengthCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Run getAcceptableTokens
		HL.getAcceptableTokens();
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HL.getAcceptableTokens());	
	}
	
	// Check getDefaultTokens
	@Test
	public void testGetDefaultTokens(){
		
		// Create new HLength
		HLengthCheck HL = (new HLengthCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HL.getDefaultTokens());	
	}
	
	// Check getRequiredTokens
	@Test
	public void testGetRequiredTokens(){
		
		// Create new HLength
		HLengthCheck HL = (new HLengthCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HL.getRequiredTokens());	
	}
		
	// Test FinishTree
	@Test
	public void testFinishTree() {
		
		// Create new HLength
		HLengthCheck HL = (new HLengthCheck());
		
		// Create a Mock AST
		DetailAST mockAST = mock(DetailAST.class); 
		
		// Run beginTree
		HL.beginTree(mockAST);
		
		// Set Variables for Counts
		OperandCountCheck.setOperandCount(0);
		OperatorCountCheck.setOperatorCount(0);
		
        // Assert that the Line Number is Still 0 and Length is 0
 		assertEquals(0, mockAST.getLineNo());
 		assertEquals(0, HL.getLength());
	}
	
	// Test Get Length Method
	@Test
	public void testGetEffort() {
		
		// Create new HLength
		HLengthCheck HL = (new HLengthCheck());
			
		// Create New Double and Compare
		double length = 2;
		
		// Set Variables for Counts
		OperandCountCheck.setOperandCount(4);
		OperatorCountCheck.setOperatorCount(-2);

		// Check that Value Calculated Properly		
		assertEquals(length, HL.getLength());
	}
}