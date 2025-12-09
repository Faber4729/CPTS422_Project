package CatATests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;
import CatBCheckPackage.HDifficultyCheck;

import static org.mockito.Mockito.*;

public class CommentLineCountTest {
	
	/*
	 * Mockito was unable to mock the Checkstyle/Abstract classes, so I was unable to call 
	 * verify([spyClass).log(parameters) for the finishTree methods, when actually running the tests
	 */
	
	// Test for if isCommentNodesRequired
	@Test
	public void testCommentNodesRequired(){
		
		// Create CommentLineCountCheck
		CommentLineCountCheck CLCC = (new CommentLineCountCheck());

		// Run isCommentNodesRequired
		CLCC.isCommentNodesRequired();
		
		// Assert that Comment Nodes are Required
		assertEquals(true, CLCC.isCommentNodesRequired());
	}
	
	// Check getAcceptableTokens
	@Test
	public void testGetAcceptableTokens(){
		
		// Create CommentLineCountCheck
		CommentLineCountCheck CLCC = (new CommentLineCountCheck());

		// Create Array For Return Values
		int[] tokenArray = new int [] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN, TokenTypes.BLOCK_COMMENT_END};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, CLCC.getAcceptableTokens());	
	}
	
	// getDefaultTokens Test
	@Test
	public void testGetDefaultTokens(){
		
		// Create CommentLineCountCheck
		CommentLineCountCheck CLCC = (new CommentLineCountCheck());

		// Create Array For Return Values
		int[] tokenArray = new int [] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN, TokenTypes.BLOCK_COMMENT_END};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, CLCC.getDefaultTokens());		
	}
	
	// getRequiredTokens Test
	@Test
	public void testGetRequiredTokens(){
		
		// Create CommentLineCountCheck
		CommentLineCountCheck CLCC = (new CommentLineCountCheck());
		
		// Create Array For Return Values
		int[] tokenArray = new int [] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN, TokenTypes.BLOCK_COMMENT_END};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, CLCC.getRequiredTokens());			
	}
    
	// Check Visit Token
	@Test
	public void testVisitToken(){
		// Create CommentLineCountCheck
		CommentLineCountCheck CLCC = (new CommentLineCountCheck());
		
		// Create a Mock AST For Visiting Token
		DetailAST mockAST = mock(DetailAST.class); 
		
		// Confirm Comment Count is Initially 0
		assertEquals(0, CLCC.getCommentLineCount());
		
		// Set AST to Return Single Line
		when(mockAST.getType()).thenReturn(TokenTypes.SINGLE_LINE_COMMENT);
				
		// Run Visit Token
		CLCC.visitToken(mockAST);
		
		// Assert the Returned Values Are the Same as Expected
		assertEquals(1, CLCC.getCommentLineCount());
		
		// Set AST to Be Start
		when(mockAST.getType()).thenReturn(TokenTypes.BLOCK_COMMENT_BEGIN);
		when(mockAST.getLineNo()).thenReturn(2);
		
		// Run Visit Token
		CLCC.visitToken(mockAST);
		
		// Set AST to Be End
		when(mockAST.getType()).thenReturn(TokenTypes.BLOCK_COMMENT_END);
		when(mockAST.getLineNo()).thenReturn(10);
		
		// Run Visit Token
		CLCC.visitToken(mockAST);
				
		// Assert the Final Value is As Expected
		assertEquals(11, CLCC.getCommentLineCount());
	}
	
	// Check Begin Tree
	@Test
	public void testBeginTree(){
		// Create CommentLineCountCheck
		CommentLineCountCheck CLCC = (new CommentLineCountCheck());
		
		// Create a Mock AST For Tree
		DetailAST mockAST = null; 
		
		// Confirm Comment Count is Initially 0
		assertEquals(0, CLCC.getCommentLineCount());	
				
		// Run Begin Tree
		CLCC.beginTree(mockAST);
		
		// Assert that CommentLineCount is Still 0
		assertEquals(0, CLCC.getCommentLineCount());
	}
	
	
	// Check Finish Tree
	@Test
	public void testFinishTree(){
		// Create CommentLineCountCheck
		CommentLineCountCheck CLCC = (new CommentLineCountCheck());
		
		// Create a Mock AST For Beginning Tree
		DetailAST mockAST = mock(DetailAST.class); 
		
		// Run Begin Tree
		CLCC.beginTree(mockAST);
		
		// Set AST To Be Single Line Comment
		when(mockAST.getType()).thenReturn(TokenTypes.SINGLE_LINE_COMMENT);
		
		// Run Visit Token 3 Times to Increase Comment Line Count
		CLCC.visitToken(mockAST);
		CLCC.visitToken(mockAST);
		CLCC.visitToken(mockAST);
		
		// Assert that the Line Number is Still 0 and CommentLineCount is 3
		assertEquals(0, mockAST.getLineNo());
		assertEquals(3, CLCC.getCommentLineCount());
	}
	
	// Finish Tree With No Input
	@Test
	public void testFinishTreeNull(){
		// Create Check
		CommentLineCountCheck CLCC = (new CommentLineCountCheck());
		
		// Create a Mock AST For Beginning Tree
		DetailAST mockAST = null; 

		// Set Return for Tree Line Number to be 0
		//when(mockAST.getLineNo()).thenReturn(0);
		
		// No Return is Possible on Null AST

		// Assert that Line Count is 0
		assertEquals(0, CLCC.getCommentLineCount());
	}
	
	// Check Get Methods
	@Test
	public void testOverallGet() {
		// Create CommentLineCountCheck
		CommentLineCountCheck CLCC = new CommentLineCountCheck();
		
		// Create a Mock AST For Beginning Tree
		DetailAST mockAST = mock(DetailAST.class); 
				
		// Run Begin Tree
		CLCC.beginTree(mockAST);	
		
		// Set AST To Be Single Line Comment
		when(mockAST.getType()).thenReturn(TokenTypes.SINGLE_LINE_COMMENT);
		
		// Run Visit Token Once to Increase Comment Line Count
		CLCC.visitToken(mockAST);
				
		// Create New Int and Compare
		int CLC = 1;
		
		assertEquals(CLC, CLCC.getCommentLineCount());
	}
	
	@Test
	public void testBlockCommentGet() {
		// Create CommentLineCountCheck
		CommentLineCountCheck CLCC = new CommentLineCountCheck();
		
		// Create a Mock AST For Beginning Tree
		DetailAST mockAST = mock(DetailAST.class); 
				
		// Run Begin Tree
		CLCC.beginTree(mockAST);	
		
		// Set AST to Be Start
		when(mockAST.getType()).thenReturn(TokenTypes.BLOCK_COMMENT_BEGIN);
		when(mockAST.getLineNo()).thenReturn(2);
		
		// Run Visit Token Once to Set Get
		CLCC.visitToken(mockAST);
				
		// Create New Int and Compare
		int CLC = 2;
		
		assertEquals(CLC, CLCC.getBlockStart());
	}
}