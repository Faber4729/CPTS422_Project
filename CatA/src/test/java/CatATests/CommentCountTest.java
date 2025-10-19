package java.CatATests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import CatACheckPackage.CommentCountCheck;

import static org.mockito.Mockito.*;

public class CommentCountTest {
	
	// Confirm isCommentNodesRequired
	
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
		
	}
	
	// Check Begin Tree
	@Test
	public void testBeginTree{
		
	}
	
	
	// Check Finish Tree
	@Test
	public void testFinishTree{
		String spyLine;
		
		
	}
	
	@Test
	public void testValidCombination() throws IllegalDateException {

		assertFalse(Date.isLeap(2012));
		assertFalse(Date.validCombination(29, 2, 2012));
		
		//How to mock a static function: 
		try (MockedStatic<Date> mockDate = mockStatic(Date.class, CALLS_REAL_METHODS))
		{
			mockDate.when(() -> Date.isLeap(2012)).thenReturn(true);

			//assertTrue(Date.isLeap(2012));
			assertTrue(Date.validCombination(29, 2, 2012));
			
			mockDate.when(() -> Date.isLeap(2017)).thenReturn(false);
			assertFalse(Date.isLeap(2017));		
			assertFalse(Date.validCombination(29, 2, 2017));
			assertTrue(Date.validCombination(31, 1, 2017));
			assertFalse(Date.validCombination(31, 6, 2017));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	
//
//	public class CommentCountCheck extends AbstractCheck{
//		
//		private int commentCount = 0;
//		
//		// Allows for Comments in AST
//		@Override
//		public boolean isCommentNodesRequired() {
//			return true;
//		}
//		
//		// I Am Only Checking for // and /*, Assuming all Comments Started are Finished
//		@Override
//		public int[] getAcceptableTokens() {
//			return new int[] {TokenTypes.SINGLE_LINE_COMMENT,
//					TokenTypes.BLOCK_COMMENT_BEGIN
//				};
//		}
//		
//		@Override
//		public int[] getDefaultTokens() {
//			return getAcceptableTokens();
//		}
//		
//		@Override
//		public int[] getRequiredTokens() {
//			return getAcceptableTokens();
//		}
//		
//		@Override
//		public void visitToken(DetailAST aAST) {
//			// Increase Count 
//			commentCount++;
//		}
//		
//		@Override
//	    public void beginTree(DetailAST aAST) {
//			commentCount = 0;
//	    }
//
//	    @Override
//	    public void finishTree(DetailAST aAST) {
//	    	// Logs the Number of Comments at the First Line
//	    	log(aAST.getLineNo(), "commentFinal", commentCount);
//	    }
//
//	}

}
