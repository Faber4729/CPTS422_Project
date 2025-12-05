package CatBTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;
import CatBCheckPackage.*;

import static org.mockito.Mockito.*;

public class HEffortTest {

	// Check getAcceptableTokens
	@Test
	public void testGetAcceptableTokens(){
		
		// Create new HEffort
		HEffortCheck HE = (new HEffortCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Run getAcceptableTokens
		HE.getAcceptableTokens();
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HE.getAcceptableTokens());	
	}
	
	// Check getDefaultTokens
	@Test
	public void testGetDefaultTokens(){
		
		// Create new HEffort
		HEffortCheck HE = (new HEffortCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HE.getDefaultTokens());	
	}
	
	// Check getRequiredTokens
	@Test
	public void testGetRequiredTokens(){
		
		// Create new HEffort
		HEffortCheck HE = (new HEffortCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HE.getRequiredTokens());	
	}
		
	// Test FinishTree
	@Test
	public void testFinishTree() {
		
		// Create new HEffort
		HEffortCheck HE = (new HEffortCheck());
		
		// Create a Mock AST
		DetailAST mockAST = mock(DetailAST.class); 
		
		// Run beginTree
		HE.beginTree(mockAST);
		
		// Set Variables for Counts
		OperandCountCheck.setOperandCount(0);
		OperatorCountCheck.setOperatorCount(0);
		OperatorCountCheck.setUniqueOperatorCount(1);
		OperandCountCheck.setUniqueOperandCount(1);
		
        // Assert that the Line Number is Still 0 and Effort is 0
 		assertEquals(0, mockAST.getLineNo());
 		assertEquals(0, HE.getEffort());
	}
	
	// Test Get Effort Method
	@Test
	public void testGetEffort() {
		
		// Create new HEffort
		HEffortCheck HE = (new HEffortCheck());
			
		// Create New Double and Compare
		double effort = 16;
		
		// Set Variables for Counts
		OperandCountCheck.setOperandCount(4);
		OperatorCountCheck.setOperatorCount(4);
		OperatorCountCheck.setUniqueOperatorCount(1);
		OperandCountCheck.setUniqueOperandCount(1);

		// Check that Value Calculated Properly		
		assertEquals(effort, HE.getEffort());
	}
}