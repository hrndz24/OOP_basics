package com.buyash.factory;

import com.buyash.repository.AudioRecordRepository;
import com.buyash.repository.implementation.AudioRecordRepositoryImplementation;

public class RepositoryFactory {

    private AudioRecordRepository audioRecordRepository = AudioRecordRepositoryImplementation.getInstance();

    private static class SingletonHolder {
        private static final RepositoryFactory INSTANCE = new RepositoryFactory();
    }

    private RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public AudioRecordRepository getAudioRecordRepository() {
        return audioRecordRepository;
    }

}
