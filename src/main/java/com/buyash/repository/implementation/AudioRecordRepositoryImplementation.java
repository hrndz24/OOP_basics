package com.buyash.repository.implementation;

import com.buyash.entity.AudioRecord;
import com.buyash.repository.AudioRecordRepository;
import com.buyash.specification.Specification;

import java.util.HashSet;
import java.util.Set;

public class AudioRecordRepositoryImplementation implements AudioRecordRepository {

    private Set<AudioRecord> records = new HashSet<>();

    private static class SingletonHolder {
        private static final AudioRecordRepositoryImplementation INSTANCE = new AudioRecordRepositoryImplementation();
    }

    private AudioRecordRepositoryImplementation() {
    }

    public static AudioRecordRepositoryImplementation getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void addAudioRecord(AudioRecord audioRecord) {
        records.add(audioRecord);
    }

    @Override
    public void removeAudioRecord(AudioRecord audioRecord) {
        records.remove(audioRecord);
    }

    @Override
    public Set<AudioRecord> query(Specification specification) {
        Set<AudioRecord> requestedRecords = new HashSet<>();
        for (AudioRecord record : records) {
            if (specification.specified(record)) {
                requestedRecords.add(record);
            }
        }
        return requestedRecords;
    }
}
