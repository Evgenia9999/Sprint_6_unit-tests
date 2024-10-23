import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

public class FelineTest {

    @Mock
    private Feline feline;

    @Before
    public void initFeline() {feline = new Feline();}

    @Test
    public void eatMeatTest() throws Exception {
        List<String> eat = feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, eat);
    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTestWithNoParam() {
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensTestWithParam() {
        int param = 3;
        int expectedKittens = feline.getKittens(param);
        Assert.assertEquals(param, expectedKittens);
    }
}





