package BlackboxTests.BlackBoxTestCases;

public class CommentLineCountTest2 {
	public int multiply(int a, int b) {
		// Still adding a lot of comments // in // one // line
		return a * b;
		/*
		 * and also adding
		 *
		 /* more of these
		 *
		 * in one comment - Should return 8
		 */ 
	}
}
