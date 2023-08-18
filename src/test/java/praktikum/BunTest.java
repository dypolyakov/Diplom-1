package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Флюоресцентная булка R2-D3", 988);
    }

    @Test
    public void getName() {
        String expectedName = "Флюоресцентная булка R2-D3";
        String actualName = bun.getName();
        String errorMessage = "Некорректное название булочки";
        Assert.assertEquals(errorMessage, expectedName, actualName);
    }

    @Test
    public void getPrice() {
        float expectedPrice = 988;
        float actualPrice = bun.getPrice();
        String errorMessage = "Некорректная цена булочки";
        Assert.assertEquals(errorMessage, expectedPrice, actualPrice, 0);
    }
}
