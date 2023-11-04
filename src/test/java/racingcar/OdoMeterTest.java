package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class OdoMeterTest extends NsTest {
    @Test
    void 이동거리를_문자열로_변환() {
        OdoMeter odoMeter = new OdoMeter();

        final int DISTANCE = 5;
        odoMeter.add(DISTANCE);
        assertThat(odoMeter.get()).isEqualTo(DISTANCE);
        assertThat(odoMeter.toString()).isEqualTo("-----");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
