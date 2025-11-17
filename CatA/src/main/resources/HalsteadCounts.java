package resources;

// Public Resource for Halstead Checks
public class HalsteadCounts {
	
		// I Used AI To Find a Way To Write Numbers Across Checks
		// I Figured the Resource Folder Was a Good Place For It
		private static int operands = 0;
		private static int operators = 0;

	 	private static int uOperands = 0;
	    private static int uOperators = 0;
	    
	    public static final void setOperands(int count) { operands = count; }
	    public static final void setOperators(int count) { operators = count; }

	    public static int getOperands() { return operands; }
	    public static int getOperators() { return operators; }

	    public static final void setUOperands(int count) { uOperands = count; }
	    public static final void setUOperators(int count) { uOperators = count; }
	    
	    public static int getUOperands() { return uOperands; }
	    public static int getUOperators() { return uOperators; }
	    
}
