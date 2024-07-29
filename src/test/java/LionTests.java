import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    Feline feline;

    private Lion maleLion;

    @Before
    public void setUp() throws Exception {
        maleLion = new Lion("Самец", feline);
    }

    // проверка: при вводе неверного параметра sex в конструкторе появляется исключение с ожидаемым текстом
    @Test
    public void doesHaveManeThrowsExpectedException() {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Лев", feline);
        });
        String expected = "Используйте допустимые значения пола животного - самей или самка";
        String actual = exception.getMessage();
        Assert.assertEquals("Ошибка: сообщение в исключении не соответствует ожидаемому", expected, actual);
    }

    // проверка: метод getKittens() вызывает такой же метод класса Feline
    @Test
    public void getKittensInvokesFelineGetKittens() throws Exception {
        maleLion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    // проверка: метод getFood() вызывает такой же метод класса Feline с аргументом "Хищник"
    @Test
    public void getFoodSendsExpectedArgument() throws Exception {
        maleLion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

}
