package in.sita.sangitaTech.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import in.sita.sangitaTech.util.Calculator;

@SpringBootTest
public class CalculateTest {
	@Test
	public void addTest() {
		Calculator c=new Calculator();
		int expResult = c.add(10, 20);
		int actResult=30;
		assertEquals(actResult, expResult);
	}
	@Test
	public void mulTest() {
		Calculator c=new Calculator();
		int expResult = c.mul(10, 20);
		int actResult=200;
		assertEquals(actResult, expResult);

	}

}
