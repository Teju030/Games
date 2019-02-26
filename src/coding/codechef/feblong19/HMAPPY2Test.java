package coding.codechef.feblong19;

import coding.codechef.feblong19.Solver;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HMAPPY2Test {

    private final Random random  =  new Random();
    @Test
    public void test()
    {
        assertEquals("Lose",new Solver().solve(100, 23, 11, 11));
    }

}