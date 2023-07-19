package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void getName() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        String expectedResult = "Флюоресцентная булка R2-D3";
        String actualResult = bun.getName();
        String message = "Некорректное название булочки";
        Assert.assertEquals(message, expectedResult, actualResult);
    }
}
