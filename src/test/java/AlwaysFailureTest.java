import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlwaysFailureTest {

    @Disabled
    @Test
    void 常に失敗するテスト() {
        assertEquals(1 * 1, 2);
    }
}
