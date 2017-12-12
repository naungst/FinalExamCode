package pkgEmpty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import pkgCore.Retirement;

public class TestRetirement {
	@Test
	public void TEST1() {
		Retirement DAWKINS = new Retirement(40, .07, 20, .02, 10000, 2642);
		assertTrue(554.13 == DAWKINS.AmountToSave());
		assertTrue(1454485.55 == DAWKINS.TotalAmountSaved());
		assertEquals(554.13, DAWKINS.AmountToSave(), .001);
		assertEquals(1454485.55, DAWKINS.TotalAmountSaved(), .001);
	}
}
