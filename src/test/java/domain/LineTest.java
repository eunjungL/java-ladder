package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.TestBooleanGenerator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("현재 위치에서 다리를 놓을 수 있는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"true,true,false", "false,true,true"}, delimiter = ',')
    void checkIsPossibleAddBridgeTest(boolean actual, boolean isConnectable, boolean expected) {
        Line line = new Line(5);
        line.getPoints().add(actual);

        assertThat(line.decideConnectable(1, isConnectable)).isEqualTo(expected);
    }

    @DisplayName("사다리 라인 생성")
    @Test
    void makeLineTest() {
        TestBooleanGenerator testDirectionGenerator = new TestBooleanGenerator(Boolean.TRUE);
        Line line = new Line(4);

        assertThat(line.makeLine(testDirectionGenerator)).isEqualTo(List.of(true, false, true));
    }
}