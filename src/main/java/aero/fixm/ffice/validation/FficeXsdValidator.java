package aero.fixm.ffice.validation;

public class FficeXsdValidator {

    private final FficeUnmarshallerPool pool = new FficeUnmarshallerPool();

    public void validateAndUnmarshal(String xml) throws ValidationException {
        try {
            pool.unmarshalAndValidate(xml);
        } catch (FficeUnmarshallerPool.FficeUnmarshalException e) {
            throw new ValidationException(e.getMessage(), e);
        }
    }

    public static class ValidationException extends Exception {
        public ValidationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
