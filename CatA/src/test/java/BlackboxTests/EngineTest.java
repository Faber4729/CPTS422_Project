package BlackboxTests;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import org.junit.jupiter.api.Test;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.DefaultContext;
import com.puppycrawl.tools.checkstyle.JavaParser;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.FileContents;
import com.puppycrawl.tools.checkstyle.api.FileText;

import CatACheckPackage.*;
import CatBCheckPackage.*;

class EngineTest {
	@Test
	void test() throws IOException, CheckstyleException {
		
		String filePath = ("src/test/java/BlackboxTests/BlackBoxTestCases/");
		File caseFolder = new File(filePath);
		
		// Loop Through Each File in Folder
		for(File currFile : caseFolder.listFiles()){
		
		// Build File
		File file = new File(filePath + currFile.getName());
		FileText ft = new FileText(file,"UTF-8");
		FileContents fc = new FileContents(ft);
		
		// Fill AST with FileContents
		DetailAST root = JavaParser.parse(fc);
				
		// Find Check Name
		String checkName = currFile.getName().split("Test")[0];
		
		// Check if it's a Comment Check, and Redo root if So
		if(checkName.contains("Comment")) {
			root = JavaParser.parseFile(file, JavaParser.Options.WITH_COMMENTS);
		}
		
		// Initialize/Configure all Checks
		
		// Create all Checks
		CommentCountCheck comment = new CommentCountCheck();
		CommentLineCountCheck commentLine = new CommentLineCountCheck();
		ExpressionCountCheck expression = new ExpressionCountCheck();
		LoopCountCheck loop = new LoopCountCheck();
		OperandCountCheck operand = new OperandCountCheck();
		OperatorCountCheck operator = new OperatorCountCheck();
		
		HDifficultyCheck HDiff = new HDifficultyCheck();
		HVocabCheck HVocab = new HVocabCheck();
		HLengthCheck HLength = new HLengthCheck();
		HEffortCheck HEffort = new HEffortCheck();
		HVolCheck HVol = new HVolCheck();
		
		AbstractCheck[] checks = { 
				comment, commentLine, expression, loop, operand, operator,
				HDiff, HVocab, HLength, HEffort, HVol,
		};
		
		// Configure All Checks
		for (AbstractCheck currCheck : checks) {
			currCheck.configure(new DefaultConfiguration("Local"));
			currCheck.contextualize(new DefaultContext());
		}
		
		// Immediately Check if Halstead, then Run Each Halstead Metric, if So
		if (checkName.equals("HalsteadMetrics")) {
			
			// Run Operand/Operator Checks
			operand.beginTree(root);
			helper(operand, root);
			operand.finishTree(root);
			
			operator.beginTree(root);
			helper(operator, root);
			operator.finishTree(root);
			
			// Run finishTree Methods
			HDiff.finishTree(root);
			HVocab.finishTree(root);
			HLength.finishTree(root);
			HEffort.finishTree(root);
			HVol.finishTree(root);
			
				
			// Verify/Print Results
			if(currFile.getName().split("Test")[1].equals("Test1")){
				assertEquals(1, HDiff.getDiff());
				System.out.println(currFile.getName() + " Done!");
			}
			else{
				//assertTrue(results.get("loopingStatements") == 3);
				System.out.println(currFile.getName() + " Done!");
				
				
			}
		}
				
		else {
			
			if(checkName.equals("OperatorCount")) {
				
				// Run beginTree
				operator.beginTree(root);
				
				helper(operator, root);
				
				// Finish Tree
				operator.finishTree(root);
				
				// Verify/Print Results
				if(currFile.getName().split("Test")[1].equals("Test1")) {
					assertTrue(operator.getOperatorCount() == 1);
					assertTrue(operator.getUniqueOperatorCount() == 1);
					System.out.println(currFile.getName() + " Done!");
				}
				if(currFile.getName().split("Test")[1].equals("Test2")) {
					assertTrue(operator.getOperatorCount() == 10);
					assertTrue(operator.getUniqueOperatorCount() == 6);
					System.out.println(currFile.getName() + " Done!");
				}
				else {
					assertTrue(operator.getOperatorCount() == 2);
					assertTrue(operator.getUniqueOperatorCount() == 2);
					System.out.println(currFile.getName() + " Done!");
				}
			}
			
			else if(checkName.equals("OperandCount")) {
				// Run beginTree
				operand.beginTree(root);
				
				helper(operand, root);
				
				// Finish Tree
				operand.finishTree(root);
				
				// Verify/Print Results
				if(currFile.getName().split("Test")[1].equals("Test1")) {
					assertTrue(operand.getOperandCount() == 0);
					assertTrue(operand.getUniqueOperandCount() == 0);
					System.out.println(currFile.getName() + " Done!");
				}
				else {
					assertTrue(operand.getOperandCount() == 4);
					assertTrue(operand.getUniqueOperandCount() == 2);
					System.out.println(currFile.getName() + " Done!");
				}
			}
			
			else if(checkName.equals("LoopCount")) {
				
				// Run beginTree
				loop.beginTree(root);
				
				helper(loop, root);
				
				// Finish Tree
				loop.finishTree(root);
				
				// Verify/Print Results
				assertTrue(loop.getLoopCount() == 1);
				System.out.println(currFile.getName() + " Done!");;
			}
			
			else if(checkName.equals("ExpressionCount")) {
				
				// Run beginTree
				expression.beginTree(root);
				
				helper(expression, root);
				
				// Finish Tree
				expression.finishTree(root);
				
				// Verify/Print Results
				if(currFile.getName().split("Test")[1].equals("Test1")) {
					assertTrue(expression.getExpressionCount() == 1);
					System.out.println(currFile.getName() + " Done!");
				}
				else {
					assertTrue(expression.getExpressionCount() == 8);
					System.out.println(currFile.getName() + " Done!");
				}
			}
			
			else if(checkName.equals("CommentLineCount")) {
				
				// Run beginTree
				commentLine.beginTree(root);
				
				helper(commentLine, root);
				
				// Finish Tree
				commentLine.finishTree(root);
				
				// Verify/Print Results
				if(currFile.getName().split("Test")[1].equals("Test1")) {
					assertTrue(commentLine.getCommentLineCount() == 1);
					System.out.println(currFile.getName() + " Done!");
				}
				else {		
					assertTrue(commentLine.getCommentLineCount() == 8);
					System.out.println(currFile.getName() + " Done!");
				}			
			}
			
			// All That's Left is CommentCount
			else {
				// Run beginTree
				comment.beginTree(root);
				
				helper(comment, root);
				
				// Finish Tree
				comment.finishTree(root);
				
				// Verify/Print Results
				assertTrue(comment.getCommentCount() == 1);
				System.out.println(currFile.getName() + " Done!");
			}			
			}
		}
		
	}
	
	public void helper(AbstractCheck b, DetailAST a) {
		while(a != null) {
			for (int type : b.getAcceptableTokens()) {
				if(type == a.getType()){
					b.visitToken(a);
					break;
				}
			}
			
			helper(b,a.getFirstChild());
			a = a.getNextSibling();
		}
	}
}

