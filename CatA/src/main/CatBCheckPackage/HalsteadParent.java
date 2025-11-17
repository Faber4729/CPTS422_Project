package CatBCheckPackage;

import com.puppycrawl.tools.checkstyle.api.*;
import CatACheckPackage.*;
import resources.HalsteadCounts;


public class HalsteadParent extends AbstractCheck{

	// I Used AI to Help Me Figure Out the Parent/Child Relationship For the OperandCount/OperatorCount/Halstead Checks
	private int operands = 0;
	private int uOperands = 0;
	
	private String[] uOperandList = new String[0];
	
	private int operators = 0;
	private int uOperators = 0;
	
	// This Has to Be an AbstractCheck, But I Don't Think It Needs a Tree
	@Override
	public int[] getAcceptableTokens() {
		return new int[] {0};
	}
		
		@Override
		public int[] getDefaultTokens() {
			return getAcceptableTokens();
		}
		
		@Override
		public int[] getRequiredTokens() {
			return getAcceptableTokens();
		}
		
		// Add/Revamped Visit Methods
		// I Just Pasted the Previous Visit Token Methods Here
		public void addOperator() {
			
		}
		
		public void addOperand(String text) {
			// Increase OperandCount
			operands++;
			
			// Check if Symbol is Unique
			boolean flag = false;

			// Iterate Through All Operands
			for(String element : uOperandList) {
				if(text.equals(element)) {
					// If the Operand Exists, Set Flag to True
					flag = true;
				}
			}
			
			// If the Symbol Was Not Found, Increase the Unique Count
			if(flag == false) {
				uOperands++;
				
				// Recreate Unique List
				String[] newOperandList = new String[uOperandList.length + 1];
				
				for (int i = 0; i < uOperandList.length; i++) {
					newOperandList[i] = uOperandList[i];
				}
				
				// Add Type to Operand Collection
				newOperandList[newOperandList.length-1] = text;
				
				// Set List to Modified One
				uOperandList = newOperandList;
			}
		}
		
		// Different Get Methods
		public int getOperands() {
			return this.operands;
		}
		
		public int getUOperands() {
			return this.uOperands;
		}
		
		public int getOperators() {
			return this.operators;
		}
		
		public int getUOperators() {
			return this.uOperators;
		}
}
