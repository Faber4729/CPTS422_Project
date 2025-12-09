package CatATests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;

import static org.mockito.Mockito.*;

public class LoopCountTest {
	
	/*
	 * Mockito was unable to mock the Checkstyle/Abstract classes, so I was unable to call 
	 * verify([spyClass).log(parameters) for the finishTree methods, when actually running the tests
	 */
	
	// Check getAcceptableTokens
		@Test
		public void testGetAcceptableTokens(){
			
			// Create LoopCountCheck
			LoopCountCheck LCC = (new LoopCountCheck());

			// Create Array For Return Values
			int[] tokenArray = new int [] {
					TokenTypes.LITERAL_FOR,
					TokenTypes.FOR_EACH_CLAUSE,
					TokenTypes.LITERAL_WHILE,
					TokenTypes.DO_WHILE};
			
			// Assert the Returned Values Are the Same as Expected
			assertArrayEquals(tokenArray, LCC.getAcceptableTokens());	
		}
		
		// getDefaultTokens Test
		@Test
		public void testGetDefaultTokens(){
			
			// Create LoopCountCheck
			LoopCountCheck LCC = (new LoopCountCheck());

			// Create Array For Return Values
			int[] tokenArray = new int [] {
					TokenTypes.LITERAL_FOR,
					TokenTypes.FOR_EACH_CLAUSE,
					TokenTypes.LITERAL_WHILE,
					TokenTypes.DO_WHILE};
			
			// Assert the Returned Values Are the Same as Expected
			assertArrayEquals(tokenArray, LCC.getDefaultTokens());		
		}
		
		// getRequiredTokens Test
		@Test
		public void testGetRequiredTokens(){
			
			// Create LoopCountCheck
			LoopCountCheck CLCC = (new LoopCountCheck());
			
			// Create Array For Return Values
			int[] tokenArray = new int [] {
					TokenTypes.LITERAL_FOR,
					TokenTypes.FOR_EACH_CLAUSE,
					TokenTypes.LITERAL_WHILE,
					TokenTypes.DO_WHILE};
			
			// Assert the Returned Values Are the Same as Expected
			assertArrayEquals(tokenArray, CLCC.getRequiredTokens());			
		}
	    
		// Check Visit Token
		@Test
		public void testVisitToken(){
			// Create LoopCountCheck
			LoopCountCheck LCC = (new LoopCountCheck());
			
			// Create a Mock AST For Visiting Token
			DetailAST mockAST = mock(DetailAST.class); 
			
			// Confirm Loop Count is Initially 0
			assertEquals(0, LCC.getLoopCount());
			
			// Run Visit Token
			LCC.visitToken(mockAST);
			
			// Assert the Returned Values Are the Same as Expected
			assertEquals(1, LCC.getLoopCount());
		}
		
		// Check Begin Tree
		@Test
		public void testBeginTree(){
			// Create LoopCountCheck
			LoopCountCheck LCC = (new LoopCountCheck());
			
			// Create a Mock AST For Tree
			DetailAST mockAST = mock(DetailAST.class); 
			
			// Confirm Loop Count is Initially 0
			assertEquals(0, LCC.getLoopCount());	
					
			// Run Begin Tree
			LCC.beginTree(mockAST);
			
			// Assert that Loop Count is Still 0
			assertEquals(0, LCC.getLoopCount());
		}
		
		
		// Check Finish Tree
		@Test
		public void testFinishTree(){
			// Create LoopCountCheck
			LoopCountCheck LCC = (new LoopCountCheck());
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = mock(DetailAST.class); 
			
			// Run Begin Tree
			LCC.beginTree(mockAST);
			
			// Run Visit Token 3 Times to Increase Loop Count
			LCC.visitToken(mockAST);
			LCC.visitToken(mockAST);
			LCC.visitToken(mockAST);
			
			// Assert that the Line Number is Still 0 and LoopCount is 3
			assertEquals(0, mockAST.getLineNo());
			assertEquals(3, LCC.getLoopCount());
		}
		
		// Finish Tree With No Input
		@Test
		public void testFinishTreeNull(){
			// Create Check
			LoopCountCheck LCC = (new LoopCountCheck());
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = null; 

			// Set Return for Tree Line Number to be 0
			//when(mockAST.getLineNo()).thenReturn(0);
			
			// No Return is Possible on Null AST

			// Assert that Count is 0
			assertEquals(0, LCC.getLoopCount());
		}
		
		// Check Get Method
		@Test
		public void testLoopCountGet() {
			// Create LoopCountCheck
			LoopCountCheck LCC = new LoopCountCheck();
			
			// Create a Mock AST For Beginning Tree
			DetailAST mockAST = mock(DetailAST.class); 
					
			// Run Begin Tree
			LCC.beginTree(mockAST);	
			
			// Create New Int and Compare
			int LC = 0;
			
			// Confirm Initial Value is 0
			assertEquals(LC, LCC.getLoopCount());
			
			// Run Visit Token A Few Times
			LCC.visitToken(mockAST);
			LCC.visitToken(mockAST);
			LCC.visitToken(mockAST);
			LCC.visitToken(mockAST);
			LCC.visitToken(mockAST);
			
			LC = 5;
			
			assertEquals(LC, LCC.getLoopCount());
		}
}
