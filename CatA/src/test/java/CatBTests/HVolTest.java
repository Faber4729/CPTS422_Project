package CatBTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;
import CatBCheckPackage.*;

import static org.mockito.Mockito.*;

public class HVolTest {

	
	// Check getAcceptableTokens
	@Test
	public void testGetAcceptableTokens(){
		
		// Create new HVol
		HVolCheck HV = (new HVolCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Run getAcceptableTokens
		HV.getAcceptableTokens();
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HV.getAcceptableTokens());	
	}
	
	// Check getDefaultTokens
	@Test
	public void testGetDefaultTokens(){
		
		// Create new HVol
		HVolCheck HV = (new HVolCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HV.getDefaultTokens());	
	}
	
	// Check getRequiredTokens
	@Test
	public void testGetRequiredTokens(){
		
		// Create new HVol
		HVolCheck HV = (new HVolCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HV.getRequiredTokens());	
	}
		
	// Test FinishTree
	@Test
	public void testFinishTree() {
		
		// Create new HVol
		HVolCheck HV = (new HVolCheck());
		
		// Create a Mock AST
		DetailAST mockAST = mock(DetailAST.class); 
		
		// Run beginTree
		HV.beginTree(mockAST);
		
		// Set Variables for Counts
		OperandCountCheck.setOperandCount(0);
		OperatorCountCheck.setOperatorCount(0);
		OperatorCountCheck.setUniqueOperatorCount(1);
		OperandCountCheck.setUniqueOperandCount(1);
		
        // Assert that the Line Number is Still 0 and Volume is 0
 		assertEquals(0, mockAST.getLineNo());
 		assertEquals(0, HV.getVolume());
	}
	
	// Test Get Volume Method
	@Test
	public void testGetVol() {
		
		// Create new HVol
		HVolCheck HV = (new HVolCheck());
			
		// Create New Double and Compare
		double vol = 8;
		
		// Set Variables for Counts
		OperandCountCheck.setOperandCount(3);
		OperatorCountCheck.setOperatorCount(5);
		OperatorCountCheck.setUniqueOperatorCount(1);
		OperandCountCheck.setUniqueOperandCount(1);

		// Check that Value Calculated Properly		
		assertEquals(vol, HV.getVolume());
	}
}