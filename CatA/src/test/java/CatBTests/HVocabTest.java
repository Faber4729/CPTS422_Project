package CatBTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;
import CatBCheckPackage.*;

import static org.mockito.Mockito.*;

public class HVocabTest {
	// Check getAcceptableTokens
	@Test
	public void testGetAcceptableTokens(){
		
		// Create new HVocab
		HVocabCheck HV = (new HVocabCheck());

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
		
		// Create new HVocab
		HVocabCheck HV = (new HVocabCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HV.getDefaultTokens());	
	}
	
	// Check getRequiredTokens
	@Test
	public void testGetRequiredTokens(){
		
		// Create new HVocab
		HVocabCheck HV = (new HVocabCheck());

		// Create Array For Return Value
		int[] tokenArray = new int [] {0};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, HV.getRequiredTokens());	
	}
		
	// Test FinishTree
	@Test
	public void testFinishTree() {
		
		// Create new HVocab
		HVocabCheck HV = (new HVocabCheck());
		
		// Create a Mock AST
		DetailAST mockAST = mock(DetailAST.class); 
		
		// Run beginTree
		HV.beginTree(mockAST);
		
		// Set Variables for Counts
		OperandCountCheck.setUniqueOperandCount(0);
		OperatorCountCheck.setUniqueOperatorCount(0);
		
        // Assert that the Line Number is Still 0 and Vocab is 0
 		assertEquals(0, mockAST.getLineNo());
 		assertEquals(0, HV.getVocab());
	}
	
	// Test Get Vocab Method
	@Test
	public void testGetEffort() {
		
		// Create new HVocab
		HVocabCheck HV = (new HVocabCheck());
			
		// Create New Double and Compare
		double vocab = 3;
		
		// Set Variables for Counts
		OperandCountCheck.setUniqueOperandCount(-3);
		OperatorCountCheck.setUniqueOperatorCount(6);

		// Check that Value Calculated Properly		
		assertEquals(vocab, HV.getVocab());
	}
}