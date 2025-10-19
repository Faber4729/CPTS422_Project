package java.CatATests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.*;

import CatACheckPackage.CommentCountCheck;

import static org.mockito.Mockito.*;

public class CommentCountTest {
	
	// Test for if isCommentNodesRequired
	@Test
	public void testCommentNodesRequired{
		
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = spy(new CommentCountCheck());

		// Assert that Comment Nodes are Required
		assertEquals(true, spyCommentCountCheck.isCommentNodesRequired());	
	}
	
	// Check getAcceptableTokens
	@Test
	public void testGetDefaultTokens{
		
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = spy(new CommentCountCheck());

		// Create Array For Return Values
		int[] tokenArray = new int [] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
		
		spyCommentCountCheck.getRequiredTokens();
		
		// Assert the Returned Values Are the Same as Expected
		assertEquals(tokenArray, spyCommentCountCheck.getAcceptableTokens());	
	}
	
	// getDefaultTokens Test
	@Test
	public void testGetDefaultTokens{
		
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = spy(new CommentCountCheck());

		// Create Array For Return Values
		int[] tokenArray = new int [] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
			
		// Do Returns {TokenTypes}
		doReturn(tokenArray).when(spyCommentCountCheck).getAcceptableTokens();
		
		spyCommentCountCheck.getDefaultTokens();
		
		// Verify getDefaultTokens calls getAcceptableTokens
		verify(spyCommentCountCheck).getAcceptableTokens();
		
		// Assert the Returned Values Are the Same as Expected
		assertEquals(tokenArray, spyCommentCountCheck.getAcceptableTokens());	
	}
	
	// getRequiredTokens Test
	@Test
	public void testGetRequiredTokens{
		
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = spy(new CommentCountCheck());

		// Create Array For Return Values
		int[] tokenArray = new int [] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
			
		// Do Returns {TokenTypes}
		doReturn(tokenArray).when(spyCommentCountCheck).getAcceptableTokens();
		
		spyCommentCountCheck.getRequiredTokens();
		
		// Verify getRequiredTokens calls getAcceptableTokens
		verify(spyCommentCountCheck).getAcceptableTokens();
		
		// Assert the Returned Values Are the Same as Expected
		assertEquals(tokenArray, spyCommentCountCheck.getAcceptableTokens());	
	}
	
	// Check Visit Token
	@Test
	public void testVisitToken{
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = spy(new CommentCountCheck());
		
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
	public void testBeginTree{
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = spy(new CommentCountCheck());
		
		// Create a Mock AST For Tree
		DetailAST mockAST = mock(DetailAST.class); 
		
		// Confirm Comment Count is Initially 0
		assertEquals(0, spyCommentCountCheck.getCommentCount());	
				
		// Run Begin Tree
		spyCommentCountCheck.beginTree(mockAST);
		
		// Assert that CommentCount is Still 0
		assertEquals(0, spyCommentCountCheck.getCommentCount());
		
		// Verify That Visit Token Was Never Called
		verify(spyCommentCountCheck, never()).visitToken(mockAST);
		
	}
	
	
	// Check Finish Tree
	@Test
	public void testFinishTree{
		// Create spyCommentCountCheck
		CommentCountCheck spyCommentCountCheck = spy(new CommentCountCheck());
		
		// Create a Mock AST For Beginning Tree
		DetailAST mockAST = mock(DetailAST.class); 
		
		// Set Return for Tree Line Number to be 0
		doReturn(0).when(mockAST.getLineNo());
		
		// Run Visit Token 3 Times to Increase Comment Count
		spyCommentCountCheck.visitToken(mockAST);
		spyCommentCountCheck.visitToken(mockAST);
		spyCommentCountCheck.visitToken(mockAST);
				
		// Run Finish Tree
		spyCommentCountCheck.finishTree(mockAST);
		
		// Verify That log Was Called With All Arguments
		verify(spyCommentCountCheck.log(0, "commentFinal", 3));
		
		// Assert that the Line Number is Still 0 and CommentCount is 3
		assertEquals(0, mockAST.getLineNo());
		assertEquals(3, spyCommentCountCheck.getCommentCount());
	}
}