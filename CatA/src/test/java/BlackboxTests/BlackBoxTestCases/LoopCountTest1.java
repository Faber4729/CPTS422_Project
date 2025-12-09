package BlackboxTests.BlackBoxTestCases;

public class LoopCountTest1 {
	public void runMile() {
		boolean flag = true;
		int laps = 0;
		do { 
			laps ++;
			if (laps == 4) { flag = false; }
		}
		while(flag == true); // Should return 1
	}
}
