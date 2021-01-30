import static org.junit.jupiter.api.Assertions.*;

class RecursiveMultiplyTest {

    @org.junit.jupiter.api.Test
    void multiplyTwoIntegers() {
        RecursiveMultiply a = new RecursiveMultiply();
        long outputNumber = a.multiplyTwoIntegers(20000000, 20000000);
        assertEquals(40000000, outputNumber);
    }
}