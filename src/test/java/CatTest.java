import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }
}
