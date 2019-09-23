package pl.sii.ums.services.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("MonthUtil Test of static methods")
public class MonthUtilTest {
	
	private MonthUtil monthUtil = new MonthUtil();
	
	@Test
	@DisplayName("MonthUtil Test - compare classes")
	public void getMonthUtil() {
		assertEquals(MonthUtil.class,monthUtil.getClass());
	}
	
	@Test
	@DisplayName("MonthUtil Test - get month number by name")
	public void getMonthNumber() {
		assertEquals(1, MonthUtil.getMonthNumberFromName("Styczeń"));
		assertEquals(2, MonthUtil.getMonthNumberFromName("Luty"));
		assertEquals(3, MonthUtil.getMonthNumberFromName("Marzec"));
		assertEquals(4, MonthUtil.getMonthNumberFromName("Kwiecień"));
		assertEquals(5, MonthUtil.getMonthNumberFromName("Maj"));
		assertEquals(6, MonthUtil.getMonthNumberFromName("Czerwiec"));
		assertEquals(7, MonthUtil.getMonthNumberFromName("Lipiec"));
		assertEquals(8, MonthUtil.getMonthNumberFromName("Sierpień"));
		assertEquals(9, MonthUtil.getMonthNumberFromName("Wrzesień"));
		assertEquals(10, MonthUtil.getMonthNumberFromName("Pazdziernik"));
		assertEquals(11, MonthUtil.getMonthNumberFromName("Listopad"));
		assertEquals(12, MonthUtil.getMonthNumberFromName("Grudzień"));
		assertEquals(0, MonthUtil.getMonthNumberFromName(""));
		assertEquals(0, MonthUtil.getMonthNumberFromName(null));
	}
	
	@Test
	@DisplayName("MonthUtil Test - get month name by number")
	public void getMonthName() {
		assertEquals("Styczeń", MonthUtil.getMonthNameFromNumber(1));
		assertEquals("Luty", MonthUtil.getMonthNameFromNumber(2));
		assertEquals("Marzec", MonthUtil.getMonthNameFromNumber(3));
		assertEquals("Kwiecień", MonthUtil.getMonthNameFromNumber(4));
		assertEquals("Maj", MonthUtil.getMonthNameFromNumber(5));
		assertEquals("Czerwiec", MonthUtil.getMonthNameFromNumber(6));
		assertEquals("Lipiec", MonthUtil.getMonthNameFromNumber(7));
		assertEquals("Sierpień", MonthUtil.getMonthNameFromNumber(8));
		assertEquals("Wrzesień", MonthUtil.getMonthNameFromNumber(9));
		assertEquals("Pazdziernik", MonthUtil.getMonthNameFromNumber(10));
		assertEquals("Listopad", MonthUtil.getMonthNameFromNumber(11));
		assertEquals("Grudzień", MonthUtil.getMonthNameFromNumber(12));
		assertEquals("", MonthUtil.getMonthNameFromNumber(0));
	}
}
