package tests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("### beforeAll\n");
    }

    int result;
    @BeforeEach
    void countForTest(){
        System.out.println("### countForTest");
        result = getResult();
    }

    @AfterAll
    static void afterAll(){
        System.out.println("### afterAll");
    }

    @AfterEach
    void zeroForTest(){
        System.out.println("### zeroForTest\n");
        result = 0;
    }
    @Test
    void firstTest(){
        int result = getResult();
        System.out.println("### firstTest");
        Assertions.assertTrue(result > 2);
    }


    @Test
    void secondTest(){
        System.out.println("### secondTest");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest(){
        System.out.println("### thirdTest");
        Assertions.assertTrue(result > 2);
    }


    private int getResult() {
        return 3;
    }


}
