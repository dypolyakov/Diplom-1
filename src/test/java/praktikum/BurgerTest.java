package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientSauce;
    @Mock
    Ingredient ingredientFilling;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        bun = new Bun("Краторная булка N-200i", 1255);
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        // добавление начинки в бургер
        burger.addIngredient(ingredientFilling);

        // проверка что в бургере только один ингредиент
        Assert.assertEquals(1, burger.ingredients.size());
        // проверка что в бургере добавленная начинка
        Assert.assertEquals(ingredientFilling, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredient() {
        // добавляю 2 ингредиента в бургер
        burger.ingredients.add(ingredientSauce);
        burger.ingredients.add(ingredientFilling);

        // убираю первый ингредиент (соус)
        burger.removeIngredient(0);

        // проверка что в бургере остался только 1 ингредиент
        Assert.assertEquals(1, burger.ingredients.size());
        // проверка что в бургере осталась начинка
        Assert.assertTrue(burger.ingredients.contains(ingredientFilling));
        // проверка что в бургере не осталось соуса
        Assert.assertFalse(burger.ingredients.contains(ingredientSauce));
    }

    @Test
    public void moveIngredient() {
        // добавляю 2 ингредиента в бургер
        burger.ingredients.add(ingredientFilling);
        burger.ingredients.add(ingredientSauce);

        // перемещаю второй ингредиент на первое место
        burger.moveIngredient(1, 0);

        // провека что второй ингредиент переместился на первое место
        Assert.assertEquals(ingredientSauce, burger.ingredients.get(0));
        // проверка что первый ингредиент переместился на второе место
        Assert.assertEquals(ingredientFilling, burger.ingredients.get(1));
    }

    @Test
    public void getPrice() {
        // цены на булочки, соус и начинку
        float bunPrice = 988f;
        float saucePrice = 90f;
        float fillingPrice = 1337f;

        // расчет ожидаемой цены
        float expectedPrice = bunPrice * 2 + saucePrice + fillingPrice;

        // моки для цен булочки, соуса и начинки
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(saucePrice);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(fillingPrice);

        // создание бургена
        burger.bun = bun;
        burger.ingredients.add(ingredientSauce);
        burger.ingredients.add(ingredientFilling);

        // фактическая цена
        float actualPrice = burger.getPrice();

        // проверка что ожидаемая и фактическая цены совпали
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceipt() {
        bun = new Bun("Краторная булка N-200i", 1255);
        ingredientSauce = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90f);
        ingredientFilling = new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000f);

        burger.bun = bun;
        burger.ingredients.add(ingredientSauce);
        burger.ingredients.add(ingredientFilling);

        String expectedReceipt = "(==== Краторная булка N-200i ====)\n" +
                "= sauce Соус Spicy-X =\n" +
                "= filling Говяжий метеорит (отбивная) =\n" +
                "(==== Краторная булка N-200i ====)\n\n" +
                "Price: 5600,000000\n";

        String actualReceipt = burger.getReceipt();

        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}
