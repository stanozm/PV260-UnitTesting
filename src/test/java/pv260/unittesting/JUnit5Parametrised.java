package pv260.unittesting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JUnit5Parametrised {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testMulutiplyByTwo(int number) {
        assertThat(Calculator.multiplyByTwo(number)).isEqualTo(number*2);
    }


    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 2, 7",
            "0, 2, 2"
    })
    void testAdditionWithMultipleInputParameters(int a, int b, int expectedResult) {
        assertThat(Calculator.add(a,b)).isEqualTo(expectedResult);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv")
    void testAdditionWithCSVFile(int a, int b, int expectedResult) {
        assertThat(Calculator.add(a,b)).isEqualTo(expectedResult);
    }










    private static class Calculator {
        public static int multiplyByTwo(int number){
            return number*2;
        }

        public static int add(int a, int b) {
            return a+b;
        }
    }

}
