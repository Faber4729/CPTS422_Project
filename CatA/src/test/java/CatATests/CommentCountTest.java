package CatATests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.*;
import CatBCheckPackage.HDifficultyCheck;

import static org.mockito.Mockito.*;

public class CommentCountTest {
	
	/*
	 * Mockito was unable to mock the Checkstyle/Abstract classes, so I was unable to call 
	 * verify([spyClass).log(parameters) for the finishTree methods, when actually running the tests
	 */
	
	// Test for if isCommentNodesRequired
	@Test
	public void testCommentNodesRequired(){
		
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = (new CommentCountCheck());

		// Run isCommentNodesRequired
		spyCommentCountCheck.isCommentNodesRequired();
		
		// Assert that Comment Nodes are Required
		assertEquals(true, spyCommentCountCheck.isCommentNodesRequired());
	}
	
	// Check getAcceptableTokens
	@Test
	public void testGetAcceptableTokens(){
		
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = (new CommentCountCheck());

		// Create Array For Return Values
		int[] tokenArray = new int [] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, spyCommentCountCheck.getAcceptableTokens());	
	}
	
	// getDefaultTokens Test
	@Test
	public void testGetDefaultTokens(){
		
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = (new CommentCountCheck());

		// Create Array For Return Values
		int[] tokenArray = new int [] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, spyCommentCountCheck.getDefaultTokens());		
	}
	
	// getRequiredTokens Test
	@Test
	public void testGetRequiredTokens(){
		
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = (new CommentCountCheck());
		
		// Create Array For Return Values
		int[] tokenArray = new int [] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
		
		// Assert the Returned Values Are the Same as Expected
		assertArrayEquals(tokenArray, spyCommentCountCheck.getRequiredTokens());			
	}
    
	// Check Visit Token
	@Test
	public void testVisitToken(){
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = (new CommentCountCheck());
		
		// Create a Mock AST For Visiting Token
		DetailAST mockAST = mock(DetailAST.class); 
		
		// Confirm Comment Count is Initially 0
		assertEquals(0, spyCommentCountCheck.getCommentCount());
				
		// Run Visit Token
		spyCommentCountCheck.visitToken(mockAST);
		
		// Assert the Returned Values Are the Same as Expected
		assertEquals(1, spyCommentCountCheck.getCommentCount());
		
		// Run Visit Token Multiple Times
		spyCommentCountCheck.visitToken(mockAST);
		spyCommentCountCheck.visitToken(mockAST);
		spyCommentCountCheck.visitToken(mockAST);
		spyCommentCountCheck.visitToken(mockAST);
		
		// Assert the Final Value is As Expected
		assertEquals(5, spyCommentCountCheck.getCommentCount());
	}
	
	// Check Begin Tree
	@Test
	public void testBeginTree(){
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = (new CommentCountCheck());
		
		// Create a Mock AST For Tree
		DetailAST mockAST = mock(DetailAST.class); 
		
		// Confirm Comment Count is Initially 0
		assertEquals(0, spyCommentCountCheck.getCommentCount());	
				
		// Run Begin Tree
		spyCommentCountCheck.beginTree(mockAST);
		
		// Assert that CommentCount is Still 0
		assertEquals(0, spyCommentCountCheck.getCommentCount());
	}
	
	
	// Check Finish Tree
	@Test
	public void testFinishTree(){
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = (new CommentCountCheck());
		
		// Create a Mock AST For Beginning Tree
		DetailAST mockAST = mock(DetailAST.class); 
		
		// Run Begin Tree
		spyCommentCountCheck.beginTree(mockAST);
		
		// Set Return for Tree Line Number to be 0
		when(mockAST.getLineNo()).thenReturn(0);
		
		// Run Visit Token 3 Times to Increase Comment Count
		spyCommentCountCheck.visitToken(mockAST);
		spyCommentCountCheck.visitToken(mockAST);
		spyCommentCountCheck.visitToken(mockAST);
		
		// Assert that the Line Number is Still 0 and CommentCount is 3
		assertEquals(0, mockAST.getLineNo());
		assertEquals(3, spyCommentCountCheck.getCommentCount());
	}
	
	// Check Get Method
	@Test
	public void testGet() {
		// Create CommentCountCheck
		CommentCountCheck CCC = new CommentCountCheck();
		
		// Create New Int and Compare
		int CC = 0;
		
		assertEquals(CC, CCC.getCommentCount());
	}
}