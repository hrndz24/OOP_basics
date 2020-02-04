package java.com.buyash.factory;

import java.com.buyash.repository.AudioRecordRepository;
import java.com.buyash.repository.implementation.AudioRecordRepositoryImplementation;

public class RepositoryFactory {

    private AudioRecordRepository audioRecordRepository = new AudioRecordRepositoryImplementation();

    private static class SingletonHolder {
        private static final RepositoryFactory INSTANCE = new RepositoryFactory();
    }

    private RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public AudioRecordRepository getAudioRecordRepository(){
        return audioRecordRepository;
    }

}
