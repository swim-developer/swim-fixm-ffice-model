package aero.fixm.ffice.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FficeUnmarshallerPoolTest {

    private FficeUnmarshallerPool pool;

    @BeforeEach
    void setUp() {
        pool = new FficeUnmarshallerPool();
    }

    @Test
    void nullXmlThrowsUnmarshalException() {
        assertThatThrownBy(() -> pool.unmarshalAndValidate(null))
                .isInstanceOf(FficeUnmarshallerPool.FficeUnmarshalException.class)
                .hasMessageContaining("null or empty");
    }

    @Test
    void emptyXmlThrowsUnmarshalException() {
        assertThatThrownBy(() -> pool.unmarshalAndValidate("   "))
                .isInstanceOf(FficeUnmarshallerPool.FficeUnmarshalException.class)
                .hasMessageContaining("null or empty");
    }

    @Test
    void invalidXmlThrowsUnmarshalException() {
        assertThatThrownBy(() -> pool.unmarshalAndValidate("<not-valid/>"))
                .isInstanceOf(FficeUnmarshallerPool.FficeUnmarshalException.class);
    }

    // TODO: add parameterized tests for valid and invalid XML samples
    // Place valid XML files in src/test/resources/ffice-valid/
    // Place invalid XML files in src/test/resources/ffice-invalid/
}
