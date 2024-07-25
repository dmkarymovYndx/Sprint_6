import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

// проверка: метод getFood возвращает нужный список в зависимости от введённого типа животного
@RunWith(Parameterized.class)
public class AnimalGetFoodTest {

    private final String animalKind;
    private final List<String> food;

    public AnimalGetFoodTest(String animalKind, List<String> food) {
        this.animalKind = animalKind;
        this.food = food;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFoodPositiveCases() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals("Ошибка: еда не соответствует введённому типу животного", food, animal.getFood(animalKind));
    }

}
