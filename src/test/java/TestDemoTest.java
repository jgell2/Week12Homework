import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;


class TestDemoTest {
	private TestDemo testDemo;
	

	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		// Given: two integers
		
		
		// When: both are positive
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		
		// Then: integers are added together
	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		//@formatter:off
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(3, 5, 8, false),
				arguments(0, 5, 0, true),
				arguments(-1, 0, -1, true)
				);
		
	}
	
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		// Given: a random integer
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		// When: random integer is 5
		int fiveSquared = mockDemo.randomNumberSquared();
		
		// Then: number squared is 25
		assertThat(fiveSquared).isEqualTo(25);
	}
	

}
