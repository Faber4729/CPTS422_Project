package CatBTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;
import CatBCheckPackage.*;

import static org.mockito.Mockito.*;

public class HDifficultyTest {
	
	/*
	 * Same issue as with category A
	 * Mockito was unable to mock the Checkstyle/Abstract classes, so I was unable to call 
	 * verify([spyClass).log(parameters) for the finishTree methods, when actually running the tests
	 */
	
	
	// Check getAcceptableTokens
	@Test
	public void testGetAcceptableTokens(){
		
		// Create new HDiff
		HDifficultyCheck HD = (new HDifficultyCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Run getAcceptableTokens
		HD.getAcceptableTokens();
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HD.getAcceptableTokens());	
	}
	
	// Check getDefaultTokens
	@Test
	public void testGetDefaultTokens(){
		
		// Create new HDiff
		HDifficultyCheck HD = (new HDifficultyCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HD.getDefaultTokens());	
	}
	
	// Check getRequiredTokens
	@Test
	public void testGetRequiredTokens(){
		
		// Create new HDiff
		HDifficultyCheck HD = (new HDifficultyCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HD.getRequiredTokens());	
	}
		
	// Test FinishTree
	@Test
	public void testFinishTree() {
		
		// Create new HDiff
		HDifficultyCheck HD = (new HDifficultyCheck());
		
		// Create a Mock AST
		DetailAST mockAST = mock(DetailAST.class); 
		
		// Run beginTree
		HD.beginTree(mockAST);
		
		// Set Variables for Operator Counts
		OperandCountCheck.setOperandCount(0);
		OperatorCountCheck.setUniqueOperatorCount(0);
		OperandCountCheck.setUniqueOperandCount(1);
		
        // Assert that the Line Number is Still 0 and Difficulty is 0
 		assertEquals(0, mockAST.getLineNo());
 		assertEquals(0, HD.getDiff());
	}
	
	// Test Get Difficulty Method
	@Test
	public void testGetDiff() {
		// Create new HDiff
		HDifficultyCheck HD = (new HDifficultyCheck());
			
		// Create New Double and Compare
		double diff = 3;
		
		// Set Variables for Operator Counts
		OperandCountCheck.setOperandCount(3);
		OperatorCountCheck.setUniqueOperatorCount(2);
		OperandCountCheck.setUniqueOperandCount(1);

		// Check that Value Calculated Properly		
		assertEquals(diff, HD.getDiff());
	}
	
	// Test Get Difficulty with 0
	@Test
	public void testGetDiff0(){
		// Create new HDiff
		HDifficultyCheck HD = (new HDifficultyCheck());
			
		// Create New Double and Compare
		double diff = 0;
		
		// Set Variables for Operator Counts
		OperandCountCheck.setOperandCount(0);
		OperatorCountCheck.setUniqueOperatorCount(0);
		OperandCountCheck.setUniqueOperandCount(0);

		// Check that Value Calculated Properly		
		assertEquals(diff, HD.getDiff());
	}
}
