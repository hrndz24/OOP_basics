package java.com.buyash.validation;

public class SongValidator extends TrackValidator {

    public boolean hasSinger(String singer){
        return !(singer == null || singer.isEmpty());
    }
}
