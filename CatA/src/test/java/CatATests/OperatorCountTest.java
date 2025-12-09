package CatATests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;

import static org.mockito.Mockito.*;

public class OperatorCountTest {
	
	/*
	 * Mockito was unable to mock the Checkstyle/Abstract classes, so I was unable to call 
	 * verify([spyClass).log(parameters) for the finishTree methods, when actually running the tests
	 */
	
	// Check getAcceptableTokens
		@Test
		public void testGetAcceptableTokens(){
			
			// Create OperatorCountCheck
			OperatorCountCheck OCC = (new OperatorCountCheck());

			// Create Array For Return Values
			int[] tokenArray = new int [] {TokenTypes.ASSIGN,
					TokenTypes.DIV, 
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
			
			// Assert the Returned Values Are the Same as Expected
			assertArrayEquals(tokenArray, OCC.getAcceptableTokens());	
		}
		
		// getDefaultTokens Test
		@Test
		public void testGetDefaultTokens(){
			
			// Create OperatorCountCheck
			OperatorCountCheck OCC = (new OperatorCountCheck());

			// Create Array For Return Values
			int[] tokenArray = new int [] {TokenTypes.ASSIGN,
					TokenTypes.DIV, 
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
						
			// Assert the Returned Values Are the Same as Expected
			assertArrayEquals(tokenArray, OCC.getDefaultTokens());		
		}
		
		// getRequiredTokens Test
		@Test
		public void testGetRequiredTokens(){
			
			// Create OperatorCountCheck
			OperatorCountCheck OCC = (new OperatorCountCheck());
			
			// Create Array For Return Values
			int[] tokenArray = new int [] {TokenTypes.ASSIGN,
					TokenTypes.DIV, 
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
						
			// Assert the Returned Values Are the Same as Expected
			assertArrayEquals(tokenArray, OCC.getRequiredTokens());			
		}
	    
		// Check Visit Token
		@Test
		public void testVisitToken(){
			// Create OperatorCountCheck
			OperatorCountCheck OCC = (new OperatorCountCheck());
			
			// Create a Mock AST For Visiting Token
			DetailAST mockAST = mock(DetailAST.class); 
			
			// Confirm Counts are Initially 0
			OCC.beginTree(mockAST);
			
			assertEquals(0, OCC.getOperatorCount());	
			assertEquals(0, OCC.getUniqueOperatorCount());
			
			// Set AST to Return ==
			when(mockAST.getType()).thenReturn(TokenTypes.EQUAL);
					
			// Run Visit Token
			OCC.visitToken(mockAST);
			OCC.visitToken(mockAST);
			OCC.visitToken(mockAST);
			
			// Assert the Returned Values Are as Expected
			assertEquals(3, OCC.getOperatorCount());	
			assertEquals(1, OCC.getUniqueOperatorCount());
			
			// Set AST to Be /
			when(mockAST.getType()).thenReturn(TokenTypes.DIV);
			
			// Run Visit Token Four Times
			OCC.visitToken(mockAST);
			OCC.visitToken(mockAST);
			OCC.visitToken(mockAST);
			OCC.visitToken(mockAST);
			
			// Assert the Returned Values Are the Same as Expected
			assertEquals(7, OCC.getOperatorCount());	
			assertEquals(2, OCC.getUniqueOperatorCount());
		}
		
		// Check Begin Tree
		@Test
		public void testBeginTree(){
			// Create OperatorCountCheck
			OperatorCountCheck OCC = (new OperatorCountCheck());
			
			// Create a Mock AST For Tree
			DetailAST mockAST = mock(DetailAST.class);
			
			// Set AST to Be /
			when(mockAST.getType()).thenReturn(TokenTypes.DIV);
			
			// Run Begin Tree
			OCC.beginTree(mockAST);
			
			// Confirm Operator Counts are Initially 0
			assertEquals(0, OCC.getOperatorCount());	
			assertEquals(0, OCC.getUniqueOperatorCount());
					
			// Run Visit Token
			OCC.visitToken(mockAST);
			
			// Assert that Counts are Now 1
			assertEquals(1, OCC.getOperatorCount());	
			assertEquals(1, OCC.getUniqueOperatorCount());
		}
		
		
		// Check Finish Tree
		@Test
		public void testFinishTree(){
			// Create OperatorCountCheck
			OperatorCountCheck OCC = (new OperatorCountCheck());
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = mock(DetailAST.class); 
			
			// Run Begin Tree
			OCC.beginTree(mockAST);
			
			// Set AST To Be + So It Isn't Unique
			when(mockAST.getType()).thenReturn(TokenTypes.PLUS);
			
			// Run Visit Token 2 Times to Increase Count
			OCC.visitToken(mockAST);
			OCC.visitToken(mockAST);
			
			// Assert that the Line Number is Still 0, OperatorCount is 2, and UniqueOperatorCount is 1
			assertEquals(0, mockAST.getLineNo());
			assertEquals(2, OCC.getOperatorCount());
			assertEquals(1, OCC.getUniqueOperatorCount());
		}
		
		// Finish Tree With No Input
		@Test
		public void testFinishTreeNull(){
			// Create Check
			OperatorCountCheck OCC = (new OperatorCountCheck());
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = null; 
			
			// Run BeginTree to Reset Values
			OCC.beginTree(mockAST);

			// Set Return for Tree Line Number to be 0
			//when(mockAST.getLineNo()).thenReturn(0);
			
			// No Return is Possible on Null AST

			// Assert that Counts are both 0
			assertEquals(0, OCC.getOperatorCount());
			assertEquals(0, OCC.getUniqueOperatorCount());
		}
		
		// Check Get/Set Methods
		@Test
		public void testCountSetGet() {
			// Create OperatorCountCheck
			OperatorCountCheck OCC = new OperatorCountCheck();
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = mock(DetailAST.class); 
					
			// Run Begin Tree
			OCC.beginTree(mockAST);	
			
			// Run Set Methods
			OCC.setOperatorCount(0);
			OCC.setUniqueOperatorCount(100000000);
			
			// Confirm Counts are Set Correctly
			assertEquals(0, OCC.getOperatorCount());
			assertEquals(100000000, OCC.getUniqueOperatorCount());
			
			// Repeat
			OCC.setOperatorCount(16);
			OCC.setUniqueOperatorCount(-2);
			
			assertEquals(16, OCC.getOperatorCount());
			assertEquals(-2, OCC.getUniqueOperatorCount());
		}
}