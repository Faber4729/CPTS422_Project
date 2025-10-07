package CatACheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class CommentLineCountCheck extends AbstractCheck{

	private int commentLineCount = 0;
	private int blockCommentStart = 0;
	
	// Allows for Comments in AST
	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}
	
	// I Am Counting Each // and /* */
	@Override
	public int[] getAcceptableTokens() {
		return new int[] {TokenTypes.SINGLE_LINE_COMMENT, 
				TokenTypes.BLOCK_COMMENT_BEGIN, 
				TokenTypes.BLOCK_COMMENT_END
			};
	}
	
	@Override
	public int[] getDefaultTokens() {
		return getAcceptableTokens();
	}
	
	@Override
	public int[] getRequiredTokens() {
		return getAcceptableTokens();
	}
	
	@Override
	public void visitToken(DetailAST aAST) {
		// Increase Count If a Single Line Comment
		if(aAST.getType() == TokenTypes.SINGLE_LINE_COMMENT) {
			commentLineCount++;
		}
		
		// If It's a Block Beginning, Set the Start Variable
		if(aAST.getType() == TokenTypes.BLOCK_COMMENT_BEGIN) {
			blockCommentStart = aAST.getLineNo();
		}
		
		// If it's a Block End, Subtract To Get the Line Count
		if(aAST.getType() == TokenTypes.BLOCK_COMMENT_END) {
			commentLineCount += aAST.getLineNo() - blockCommentStart;
			
			// Add One Line to Account For the End Comment
			commentLineCount++;
		}
		
	}
	
	@Override
    public void beginTree(DetailAST aAST) {
        commentLineCount = 0;
    }

    @Override
    public void finishTree(DetailAST aAST) {
    	// Logs the Number of Comments at the First Line
    	log(aAST.getLineNo(), "commentLineFinal", commentLineCount);
    }
}
