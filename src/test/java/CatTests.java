import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    Feline feline;

    private Cat testCat;

    @Before
    public void setUp() {
        testCat = new Cat(feline);
    }

    // проверка: метод getFood() вызывает метод eatMeat() класса Feline с аргументом "Хищник"
    @Test
    public void getFoodInvokesFelineEatMeat() throws Exception {
       List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
       Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
       List<String> actualFood = testCat.getFood();
       Assert.assertEquals("Ошибка: неверный тип питания", expectedFood, actualFood);
    }


    // проверка: метод getSound() возвращает ожидаемую строку
    @Test
    public void doesCatMeow() {
        String result = testCat.getSound();
        Assert.assertEquals("Ошибка: кот не хочет мяукать", "Мяу", result);
    }

}
