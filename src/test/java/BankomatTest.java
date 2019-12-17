import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class BankomatTest {
    @Test
    public void payMoneyFirst1() {

        long value = 6;
        List<Integer> nominals = Arrays.asList(2, 3);
        long[] counts = {0, 0};
        LinkedHashSet<String> expected = new LinkedHashSet<String>();
        expected.add("3 3\n");
        expected.add("2 2 2 \n");
        Bankomat c = new Bankomat();
        String result = c.Exchange(nominals, counts, 0, value);
        List<String> res = Arrays.asList(result);
        Assert.assertEquals(expected, res);
    }
}