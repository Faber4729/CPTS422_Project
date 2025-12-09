package CatATests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;

import static org.mockito.Mockito.*;

public class ExpressionCountTest {
	
	/*
	 * Mockito was unable to mock the Checkstyle/Abstract classes, so I was unable to call 
	 * verify([spyClass).log(parameters) for the finishTree methods, when actually running the tests
	 */
	
	// Check getAcceptableTokens
		@Test
		public void testGetAcceptableTokens(){
			
			// Create ExpressionCountCheck
			ExpressionCountCheck ECC = (new ExpressionCountCheck());

			// Create Array For Return Values
			int[] tokenArray = new int [] {TokenTypes.DIV, 
					TokenTypes.PLUS, 
					TokenTypes.MINUS, 
					TokenTypes.STAR, 
					TokenTypes.MOD,
					TokenTypes.ASSIGN
				};
			
			// Assert the Returned Values Are the Same as Expected
			assertArrayEquals(tokenArray, ECC.getAcceptableTokens());	
		}
		
		// getDefaultTokens Test
		@Test
		public void testGetDefaultTokens(){
			
			// Create ExpressionCountCheck
			ExpressionCountCheck ECC = (new ExpressionCountCheck());

			// Create Array For Return Values
			int[] tokenArray = new int [] {TokenTypes.DIV, 
					TokenTypes.PLUS, 
					TokenTypes.MINUS, 
					TokenTypes.STAR, 
					TokenTypes.MOD,
					TokenTypes.ASSIGN
				}; 
						
			// Assert the Returned Values Are the Same as Expected
			assertArrayEquals(tokenArray, ECC.getDefaultTokens());		
		}
		
		// getRequiredTokens Test
		@Test
		public void testGetRequiredTokens(){
			
			// Create ExpressionCountCheck
			ExpressionCountCheck ECC = (new ExpressionCountCheck());
			
			// Create Array For Return Values
			int[] tokenArray = new int [] {TokenTypes.DIV, 
					TokenTypes.PLUS, 
					TokenTypes.MINUS, 
					TokenTypes.STAR, 
					TokenTypes.MOD,
					TokenTypes.ASSIGN
				};
						
			// Assert the Returned Values Are the Same as Expected
			assertArrayEquals(tokenArray, ECC.getRequiredTokens());			
		}
	    
		// Check Visit Token
		@Test
		public void testVisitToken(){
			// Create ExpressionCountCheck
			ExpressionCountCheck ECC = (new ExpressionCountCheck());
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = mock(DetailAST.class); 
			
			// Run Begin Tree
			ECC.beginTree(mockAST);
			
			// Set AST To Have It's Next Sibling as NOT null
			when(mockAST.getNextSibling()).thenReturn(mockAST);
			
			// Run Visit Token 3 Times
			ECC.visitToken(mockAST);
			ECC.visitToken(mockAST);
			ECC.visitToken(mockAST);
			
			// Check that Count Did Not Update
			assertEquals(0, ECC.getExpressionCount());
			
			// Set Sibling to Null
			when(mockAST.getNextSibling()).thenReturn(null);
			
			// Run Visit Token 3 Times
			ECC.visitToken(mockAST);
			ECC.visitToken(mockAST);
			ECC.visitToken(mockAST);
			
			// Assert that ExpressionCount is 3
			assertEquals(3, ECC.getExpressionCount());
		}
		
		// Check Begin Tree
		@Test
		public void testBeginTree(){
			// Create ExpressionCountCheck
			ExpressionCountCheck ECC = (new ExpressionCountCheck());
			
			// Create a Mock AST For Tree
			DetailAST mockAST = mock(DetailAST.class); 
			
			// Run Begin Tree
			ECC.beginTree(mockAST);
			
			// Confirm Expression Count is Initially 0
			assertEquals(0, ECC.getExpressionCount());
		}
		
		
		// Check Finish Tree
		@Test
		public void testFinishTree(){
			// Create ExpressionCountCheck
			ExpressionCountCheck ECC = (new ExpressionCountCheck());
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = mock(DetailAST.class); 
			
			// Run Begin Tree
			ECC.beginTree(mockAST);
			
			// Set Sibling to Null
			when(mockAST.getNextSibling()).thenReturn(null);
			
			// Run Visit Token 
			ECC.visitToken(mockAST);
			
			// Assert that the Line Number is Still 0 and ExpressionCount is 1
			assertEquals(0, mockAST.getLineNo());
			assertEquals(1, ECC.getExpressionCount());
		}
		
		// Finish Tree With No Input
		@Test
		public void testFinishTreeNull(){
			// Create Check
			ExpressionCountCheck ECC = (new ExpressionCountCheck());
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = null; 

			// Set Return for Tree Line Number to be 0
			//when(mockAST.getLineNo()).thenReturn(0);
			
			// No Return is Possible on Null AST

			// Assert that Count is 0
			assertEquals(0, ECC.getExpressionCount());
		}
		
		// Check Get Method
		@Test
		public void testGet() {
			// Create ExpressionCountCheck
			ExpressionCountCheck ECC = new ExpressionCountCheck();
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = mock(DetailAST.class); 
					
			// Run Begin Tree
			ECC.beginTree(mockAST);	

			// Confirm Count is Set Correctly
			assertEquals(0, ECC.getExpressionCount());
			
			// Run Visit Token A Few Times
			when(mockAST.getNextSibling()).thenReturn(null);
			
			ECC.visitToken(mockAST);
			ECC.visitToken(mockAST);
			ECC.visitToken(mockAST);
			ECC.visitToken(mockAST);
			ECC.visitToken(mockAST);
			
			// Confirm Count Updated Correctly
			assertEquals(5, ECC.getExpressionCount());
		}
}
