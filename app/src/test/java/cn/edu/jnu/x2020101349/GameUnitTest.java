package cn.edu.jnu.x2020101349;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GameUnitTest {
    Game game;
    @Before
    public void setUp(){
        game=new Game();
    }
    @Test
    public void testAll20() // 10次都是2分
    {
        rollSame(1,20);
        assertEquals(10,game.score());
    }
    private void rollSame(int pins, int n) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }


}