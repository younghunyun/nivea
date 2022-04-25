package kr.bespinlab.nivea;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class NiveaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void assertionTutorial() {
		boolean source = true;
		boolean target = true;
		Assertions.assertThat(source).isEqualTo(target);
	}

}
