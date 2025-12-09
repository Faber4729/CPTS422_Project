package CatATests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;

import static org.mockito.Mockito.*;

public class OperandCountTest {
	
	/*
	 * Mockito was unable to mock the Checkstyle/Abstract classes, so I was unable to call 
	 * verify([spyClass).log(parameters) for the finishTree methods, when actually running the tests
	 */
	
	// Check getAcceptableTokens
		@Test
		public void testGetAcceptableTokens(){
			
			// Create OperandCountCheck
			OperandCountCheck OCC = (new OperandCountCheck());

			// Create Array For Return Values
			int[] tokenArray = new int [] {
					TokenTypes.EXPR, 
					TokenTypes.NUM_DOUBLE,
					TokenTypes.NUM_FLOAT,
					TokenTypes.NUM_LONG,
					TokenTypes.NUM_INT,
					TokenTypes.STRING_LITERAL,
					TokenTypes.LITERAL_TRUE,
					TokenTypes.LITERAL_FALSE};
			
			// Assert the Returned Values Are the Same as Expected
			assertArrayEquals(tokenArray, OCC.getAcceptableTokens());	
		}
		
		// getDefaultTokens Test
		@Test
		public void testGetDefaultTokens(){
			
			// Create OperandCountCheck
			OperandCountCheck OCC = (new OperandCountCheck());

			// Create Array For Return Values
			int[] tokenArray = new int [] {
					TokenTypes.EXPR, 
					TokenTypes.NUM_DOUBLE,
					TokenTypes.NUM_FLOAT,
					TokenTypes.NUM_LONG,
					TokenTypes.NUM_INT,
					TokenTypes.STRING_LITERAL,
					TokenTypes.LITERAL_TRUE,
					TokenTypes.LITERAL_FALSE};
						
			// Assert the Returned Values Are the Same as Expected
			assertArrayEquals(tokenArray, OCC.getDefaultTokens());		
		}
		
		// getRequiredTokens Test
		@Test
		public void testGetRequiredTokens(){
			
			// Create OperandCountCheck
			OperandCountCheck OCC = (new OperandCountCheck());
			
			// Create Array For Return Values
			int[] tokenArray = new int [] {
					TokenTypes.EXPR, 
					TokenTypes.NUM_DOUBLE,
					TokenTypes.NUM_FLOAT,
					TokenTypes.NUM_LONG,
					TokenTypes.NUM_INT,
					TokenTypes.STRING_LITERAL,
					TokenTypes.LITERAL_TRUE,
					TokenTypes.LITERAL_FALSE};
						
			// Assert the Returned Values Are the Same as Expected
			assertArrayEquals(tokenArray, OCC.getRequiredTokens());			
		}
	    
		// Check Visit Token
		@Test
		public void testVisitToken(){
			// Create OperandCountCheck
			OperandCountCheck OCC = (new OperandCountCheck());
			
			// Create a Mock AST For Visiting Token
			DetailAST mockAST = mock(DetailAST.class); 
			
			// Confirm Counts are Initially 0
			OCC.beginTree(mockAST);
			
			assertEquals(0, OCC.getOperandCount());	
			assertEquals(0, OCC.getUniqueOperandCount());
			
			// Set AST to Return Literal True
			when(mockAST.getType()).thenReturn(TokenTypes.LITERAL_TRUE);
			
			// Also, Set Up Array to Go Through
			when(mockAST.getText()).thenReturn("LITERAL_TRUE");
					
			// Run Visit Token
			OCC.visitToken(mockAST);
			OCC.visitToken(mockAST);
			
			// Assert the Returned Values Are as Expected
			assertEquals(2, OCC.getOperandCount());	
			assertEquals(1, OCC.getUniqueOperandCount());
			
			// Set AST to Be False
			when(mockAST.getType()).thenReturn(TokenTypes.LITERAL_FALSE);
			when(mockAST.getText()).thenReturn("LITERAL_FALSE");
			
			// Run Visit Token Three Times
			OCC.visitToken(mockAST);
			OCC.visitToken(mockAST);
			OCC.visitToken(mockAST);
			
			// Assert the Returned Values Are the Same as Expected
			assertEquals(5, OCC.getOperandCount());	
			assertEquals(2, OCC.getUniqueOperandCount());
		}
		
		// Check Begin Tree
		@Test
		public void testBeginTree(){
			// Create OperandCountCheck
			OperandCountCheck OCC = (new OperandCountCheck());
			
			// Create a Mock AST For Tree
			DetailAST mockAST = mock(DetailAST.class); 
			
			// Set AST To Be Literal True
			when(mockAST.getType()).thenReturn(TokenTypes.LITERAL_TRUE);
			when(mockAST.getText()).thenReturn("LITERAL_TRUE");
			
			// Run Begin Tree
			OCC.beginTree(mockAST);
			
			// Confirm Operand Counts are Initially 0
			assertEquals(0, OCC.getOperandCount());	
			assertEquals(0, OCC.getUniqueOperandCount());
					
			// Run Visit Token
			OCC.visitToken(mockAST);
			
			// Assert that Counts are Now 1
			assertEquals(1, OCC.getOperandCount());	
			assertEquals(1, OCC.getUniqueOperandCount());
		}
		
		
		// Check Finish Tree
		@Test
		public void testFinishTree(){
			// Create OperandCountCheck
			OperandCountCheck OCC = (new OperandCountCheck());
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = mock(DetailAST.class); 
			
			// Run Begin Tree
			OCC.beginTree(mockAST);
			
			// Set AST To Be Literal True So It Isn't Unique
			when(mockAST.getType()).thenReturn(TokenTypes.LITERAL_TRUE);
			when(mockAST.getText()).thenReturn("LITERAL_TRUE");
			
			// Run Visit Token 3 Times to Increase Count
			OCC.visitToken(mockAST);
			OCC.visitToken(mockAST);
			OCC.visitToken(mockAST);
			
			// Assert that the Line Number is Still 0, OperandCount is 3, and UniqueOperandCount is 1
			assertEquals(0, mockAST.getLineNo());
			assertEquals(3, OCC.getOperandCount());
			assertEquals(1, OCC.getUniqueOperandCount());
		}
		
		// Finish Tree With No Input
		@Test
		public void testFinishTreeNull(){
			// Create Check
			OperandCountCheck OCC = (new OperandCountCheck());
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = null; 
			
			// Run BeginTree to Reset Values
			OCC.beginTree(mockAST);

			// Set Return for Tree Line Number to be 0
			//when(mockAST.getLineNo()).thenReturn(0);
			
			// No Return is Possible on Null AST

			// Assert that Counts are both 0
			assertEquals(0, OCC.getOperandCount());
			assertEquals(0, OCC.getUniqueOperandCount());
		}
		
		// Check Get/Set Methods
		@Test
		public void testCountSetGet() {
			// Create OperandCountCheck
			OperandCountCheck OCC = new OperandCountCheck();
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = mock(DetailAST.class); 
					
			// Run Begin Tree
			OCC.beginTree(mockAST);	
			
			// Run Set Methods
			OCC.setOperandCount(0);
			OCC.setUniqueOperandCount(100000000);
			
			// Confirm Counts are Set Correctly
			assertEquals(0, OCC.getOperandCount());
			assertEquals(100000000, OCC.getUniqueOperandCount());
			
			// Repeat
			OCC.setOperandCount(16);
			OCC.setUniqueOperandCount(-2);
			
			assertEquals(16, OCC.getOperandCount());
			assertEquals(-2, OCC.getUniqueOperandCount());
		}
}