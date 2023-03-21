package fuel.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RentCompanyTest {

    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    @DisplayName("차량별 주입 연료량 보고서 테스트")
    void generateReport_Test() {
        RentCompany rentCompany = RentCompany.create();
        rentCompany.addCar(new Sonata(150));
        rentCompany.addCar(new K5(260));
        rentCompany.addCar(new Sonata(120));
        rentCompany.addCar(new Avante(300));
        rentCompany.addCar(new K5(390));

        String report = rentCompany.generateReport();
        assertThat(report).isEqualTo(
                "Sonata : 15리터" + NEWLINE +
                        "K5 : 20리터" + NEWLINE +
                        "Sonata : 12리터" + NEWLINE +
                        "Avante : 20리터" + NEWLINE +
                        "K5 : 30리터" + NEWLINE
        );
    }

    @Test
    @DisplayName("회사에 보유한 자동차가 없을 때 예외 반환")
    void carsEmpty_Exception_Test() {
        RentCompany rentCompany = RentCompany.create();

        assertThatThrownBy(rentCompany::generateReport)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보유한 자동차가 없습니다");
    }
}