import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

// проверка: переменная hasMane принимает нужное значение в зависимости от аргумента, переданного в конструктор
@RunWith(Parameterized.class)
public class LionDoesHaveManeTest {

    private final String sex;
    private final boolean hasMane;

    public LionDoesHaveManeTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManePositiveCases() throws Exception {
        Lion testLion = new Lion(sex, feline);
        Assert.assertEquals("Ошибка: пол льва не совпадает с введённым", hasMane, testLion.doesHaveMane());
    }

}
