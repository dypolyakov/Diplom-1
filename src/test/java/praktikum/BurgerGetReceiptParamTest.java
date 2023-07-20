package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParamTest {
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final String expectedReceipt;

    public BurgerGetReceiptParamTest(Bun bun, List<Ingredient> ingredients, String expectedReceipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters
    public static Object[][] getBurger() {
        return new Object[][]{
                // булочка + 2 ингредиента
                {
                        new Bun("Краторная булка N-200i", 1255),
                        new ArrayList<>(List.of(new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90),
                                new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337))),
                        "(==== Краторная булка N-200i ====)\n" +
                                "= sauce Соус Spicy-X =\n" +
                                "= filling Мясо бессмертных моллюсков Protostomia =\n" +
                                "(==== Краторная булка N-200i ====)\n\n" +
                                "Price: 3937,000000\n"
                },
                // булочка без ингредиентов
                {
                        new Bun("Флюоресцентная булка R2-D3", 988),
                        new ArrayList<>(),
                        "(==== Флюоресцентная булка R2-D3 ====)\n" +
                                "(==== Флюоресцентная булка R2-D3 ====)\n\n" +
                                "Price: 1976,000000\n"
                },
                // булочка без названия + ингредиент без названия (цена 0)
                {
                        new Bun("", 0),
                        new ArrayList<>(List.of(new Ingredient(IngredientType.SAUCE, "", 0))),
                        "(====  ====)\n" +
                                "= sauce  =\n" +
                                "(====  ====)\n\n" +
                                "Price: 0,000000\n"
                },
                // булочка c названием null + ингредиент c названием null
                {
                        new Bun(null, 100),
                        new ArrayList<>(List.of(new Ingredient(IngredientType.SAUCE, null, 200))),
                        "(==== null ====)\n" +
                                "= sauce null =\n" +
                                "(==== null ====)\n\n" +
                                "Price: 400,000000\n"
                }
        };
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients = ingredients;
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }

}
