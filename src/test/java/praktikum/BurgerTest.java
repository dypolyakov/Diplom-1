package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    List<Ingredient> ingredients;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.ingredients = ingredients;
        Ingredient ingredient = new Ingredient(
                IngredientType.FILLING,
                "Мясо бессмертных моллюсков Protostomia",
                1337
        );
        burger.addIngredient(ingredient);
        Mockito.verify(ingredients, Mockito.times(1)).add(ingredient);
    }

    @Test
    public void removeIngredient() {
        burger.ingredients = ingredients;
        burger.removeIngredient(Mockito.anyInt());
        Mockito.verify(ingredients, Mockito.times(1)).remove(Mockito.anyInt());
    }
}
