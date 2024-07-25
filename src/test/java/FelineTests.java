import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {

    @Spy
    private Feline testFeline;

    // проверка: метод eatMeat() вызывает метод getFood() с аргументом "Хищник"
    @Test
    public void eatMeatSendsCarnivoreString() throws Exception {
        testFeline.eatMeat();
        Mockito.verify(testFeline).getFood("Хищник");
    }

    // проверка: метод getFamily() возвращает ожидаемую строку
    @Test
    public void getFamilyReturnsFeline() {
        String expected = "Кошачьи";
        Assert.assertEquals("Ошибка: метод не возвращает ожидаемое значение", expected, testFeline.getFamily());
    }

    // проверка: метод getKittens() без аргументов вызывает метод getKittens(int) с аргументом 1
    @Test
    public void getKittensReturnsOneKitten() {
        testFeline.getKittens();
        Mockito.verify(testFeline).getKittens(1);
    }

    // проверка: метод getKittens(int) возвращает число, соответствующее переданному аргументу
    @Test
    public void getKittensReturnsEnteredAmount() {
        int number = 7;
        int result = testFeline.getKittens(number);
        Assert.assertEquals("Ошибка: должно вернуться количество котят: " + number, number, result);
    }

}
