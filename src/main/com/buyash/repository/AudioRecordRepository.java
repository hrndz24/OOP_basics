package com.buyash.repository;

import com.buyash.entity.AudioRecord;
import com.buyash.specification.Specification;

import java.util.Set;

public interface AudioRecordRepository {

    void addAudioRecord(AudioRecord audioRecord);

    void removeAudioRecord(AudioRecord audioRecord);

    Set<AudioRecord> query(Specification specification);

    //todo add update by specification method
}
