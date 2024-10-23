import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestCatParameterized {

    @Spy
    Feline feline;

    @Before
    public void SetUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameter
    public int initNum;

    @Parameterized.Parameter(1)
    public String stringInsert;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {0, "Травоядное"},
                {1, "Хищник"},
                {0, "test"}
        };
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(initNum)).getFood(stringInsert);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

}
