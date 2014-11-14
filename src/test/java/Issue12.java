import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;

public class Issue12 {

    @Test
    public void testName() throws Exception {


        // given: an empty list
        List myList = new ArrayList();

        // when: we try to get the first element of the list
        when(myList).get(1);

        // then: we expect an IndexOutOfBoundsException
        Assertions.assertThat(caughtException())
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("Index: 1, Size: 0")
                .hasNoCause();

    }
}
