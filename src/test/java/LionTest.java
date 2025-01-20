import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.zip.CheckedOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Test
    public void doesHaveManeSamecReturnsTrue() throws Exception {
        Lion lion = new Lion("Самец");
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeSamecReturnFalse() throws Exception {
        Lion lion = new Lion("Самка");
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testFooThrowsIndexOutOfBoundsException() {
        try {
            Lion lion = new Lion("Test");
            lion.doesHaveMane();
            fail("expected exception was not occured.");
        } catch(Exception e) {
            System.out.println("exception is here");
        }
    }

    @Test
    public void testGetKittens() throws Exception {

        Feline feline = Mockito.spy(new Feline());
        Lion lion = new Lion("Самец");
        lion.feline = feline;
        int actual = lion.getKittens();
        assertEquals(1, actual);
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = Mockito.spy(new Feline());
        Lion lion = new Lion("Самец");
        lion.feline = feline;
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
