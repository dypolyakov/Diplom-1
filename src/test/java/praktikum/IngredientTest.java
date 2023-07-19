package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        float expectedPrice = 90;
        float actualPrice = ingredient.getPrice();
        String errorMessage = "Некорректная цена соуса";
        Assert.assertEquals(errorMessage, expectedPrice, actualPrice, 0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        String expectedName = "Соус Spicy-X";
        String actualName = ingredient.getName();
        String errorMessage = "Некорректное название соуса";
        Assert.assertEquals(errorMessage, expectedName, actualName);
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        IngredientType expectedType = IngredientType.SAUCE;
        IngredientType actualType = ingredient.getType();
        String errorMessage = "Некорректный тип соуса";
        Assert.assertEquals(errorMessage, expectedType, actualType);
    }
}
