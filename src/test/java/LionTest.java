import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Spy
    Feline feline;

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void doesHaveManeSamecReturnsTrue() throws Exception {
        Lion lion = new Lion("Самец", null);
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeSamecReturnFalse() throws Exception {
        Lion lion = new Lion("Самка", null);
        Assert.assertFalse(lion.doesHaveMane());
    }



    @Test
    public void lionThrowsExceptionWhenParamIsIncorrect() {
        try {
            Lion lion = new Lion("Test", null);
            lion.doesHaveMane();
            fail("expected exception was not occured");
        } catch(Exception e) {
            System.out.println("exception is here");
        }
    }
}
