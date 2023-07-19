package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void getName() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        String expectedName = "Флюоресцентная булка R2-D3";
        String actualName = bun.getName();
        String errorMessage = "Некорректное название булочки";
        Assert.assertEquals(errorMessage, expectedName, actualName);
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        float expectedPrice = 988;
        float actualPrice = bun.getPrice();
        String errorMessage = "Некорректная цена булочки";
        Assert.assertEquals(errorMessage, expectedPrice, actualPrice, 0.01);
    }
}
