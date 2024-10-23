import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FelineTest {
    private Feline feline = new Feline();

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
}





