package java.com.buyash.repository;

import java.com.buyash.entity.AudioRecord;
import java.com.buyash.specification.Specification;
import java.util.Set;

public interface AudioRecordRepository {

    void addAudioRecord(AudioRecord audioRecord);

    void removeAudioRecord(AudioRecord audioRecord);

    Set<AudioRecord> query(Specification specification);
}
