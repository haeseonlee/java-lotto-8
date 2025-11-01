package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("당첨 번호 내에 보너스 번호와 같은 숫자가 존재하면 예외가 발생한다.")
    @Test
    void 당첨_번호와_보너스번호_겹치면_예외_발생() {

        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 ~ 45 이내의 범위를 넘어가면 예외가 발생한다.")
    @Test
    void 보너스_번호_정해진_범위_초과시_예외_발생() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 70))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 발행한 로또 번호가 몇 개 일치하는지 반환한다.")
    @Test
    void 당첨번호와_로또번호_일치하는_번호있으면_개수_반환() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        assertThat(winningLotto.countMatchingNumbers(lotto)).isEqualTo(3);
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되는지 여부를 반환한다.")
    @Test
    void 보너스번호_로또번호_포함여부_반환() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 9, 10));

        assertThat(winningLotto.isBonusMatch(lotto)).isEqualTo(true);
    }
}
