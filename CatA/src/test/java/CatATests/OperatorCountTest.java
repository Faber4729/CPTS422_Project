package java.CatATests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class OperatorCountTest {
	
	@Test
	public void testTreeidk() throws IllegalStateException {
		
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

}
