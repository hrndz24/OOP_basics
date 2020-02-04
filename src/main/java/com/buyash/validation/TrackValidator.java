package java.com.buyash.validation;

public class TrackValidator extends AudioRecordValidator {

    public boolean hasComposer(String composer) {
        return !(composer == null || composer.isEmpty());
    }
}
