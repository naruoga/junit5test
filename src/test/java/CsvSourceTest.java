import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("CSVから読み込むテスト")
class CsvSourceTest {

    @DisplayName("CSVファイルからファイルを読み込む")
    @ParameterizedTest(name = " {index} -> {0} + {1} is {2}?")
    @CsvFileSource(resources = "/test.csv", numLinesToSkip = 1)
    void readCsv(int arg1, int arg2, int expected) {
        assertEquals(expected, arg1 + arg2);
    }

    @DisplayName("CSVファイルからファイルを読み込むが、型が合わない")
    @ParameterizedTest(name = " {index} -> {0} + {1} is {2}?")
    @CsvFileSource(resources = "/test.csv")
    void readCsvButFail(int arg1, int arg2, int expected) {
        assertEquals(expected, arg1 + arg2);
    }

    @DisplayName("文字列を読み込む")
    @ParameterizedTest(name = "文字列を読み込む {index}: {0} -> {1}")
    @CsvFileSource(resources = "/countries.csv", numLinesToSkip = 1)
    void readTextCsv(String japanese, String english) {
        assertEquals(jpToEn(japanese), english);
    }

    String jpToEn(String japanese) {
        switch (japanese) {
            case "日本": return "Japan";
            case "米国": return "United States of America";
            default: throw new RuntimeException(japanese + "の英語はわかりません。");
        }
    }

    @DisplayName("表示名のテスト")
    @Test
    void displayName() {
        assertTrue(true);
    }

}
