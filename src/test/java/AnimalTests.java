import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTests {

    Animal testAnimal = new Animal();

    // проверка: при вводе неверного параметра в getFood() появляется исключение с ожидаемым текстом
    @Test
    public void getFoodUnknownKindThrowsCorrectException() throws Exception {
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        try {
            testAnimal.getFood("Всеядное");
        } catch(Exception e) {
            Assert.assertEquals("Ошибка: сообщение в исключении не соответствует ожидаемому", expected, e.getMessage());
        }
    }

    // проверка: метод getFamily() возвращает ожидаемую строку
    @Test
    public void getFamilyReturnsCorrectString() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals("Ошибка: строка не совпадает с ожидаемой", expected, testAnimal.getFamily());
    }

}