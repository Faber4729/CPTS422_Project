package CatACheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class CommentCountCheck extends AbstractCheck{
	
	private int commentCount = 0;
	
	// Allows for Comments in AST
	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}
	
	// I Am Only Checking for // and /*, Assuming all Comments Started are Finished
	@Override
	public int[] getAcceptableTokens() {
		return new int[] {TokenTypes.SINGLE_LINE_COMMENT,
				TokenTypes.BLOCK_COMMENT_BEGIN
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
		// Increase Count (If No Other Comments are On the Same Line)
		if(aAST.getNextSibling() == null) {
			commentCount++;
		}
	}
	
	@Override
    public void beginTree(DetailAST aAST) {
		commentCount = 0;
    }

    @Override
    public void finishTree(DetailAST aAST) {
    	// Logs the Number of Comments at the First Line
    	log(aAST.getLineNo(), "commentFinal", commentCount);
    }
    
    // Get Comment Count for Testing Purposes
    public int getCommentCount() {
    	return commentCount;
    }
}