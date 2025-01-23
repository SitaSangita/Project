package in.sita.sangitaTech.util;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public int add(int i, int j) {
		return i+j;
	}
	public int mul(int i, int j) {
		return i*j;
	}
}
