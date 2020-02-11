package com.buyash.service;

import com.buyash.entity.AudioRecord;
import com.buyash.entity.Song;
import com.buyash.entity.SpeechRecord;
import com.buyash.entity.Track;
import com.buyash.exception.ServiceException;
import com.buyash.factory.RepositoryFactory;
import com.buyash.repository.AudioRecordRepository;
import com.buyash.specification.implementation.AudioRecordSpecificationByLengthRange;
import com.buyash.specification.implementation.TrackSpecificationByComposer;
import com.buyash.validation.SongValidator;
import com.buyash.validation.SpeechRecordValidator;
import com.buyash.validation.TrackValidator;

import java.util.Set;

public class RecordsService {

    private AudioRecordRepository audioRecordRepository = RepositoryFactory.getInstance().getAudioRecordRepository();

    private SpeechRecordValidator speechValidator = new SpeechRecordValidator();
    private TrackValidator trackValidator = new TrackValidator();
    private SongValidator songValidator = new SongValidator();

    private static class SingletonHolder {
        private static final RecordsService INSTANCE = new RecordsService();
    }

    private RecordsService() {
    }

    public static RecordsService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Set<AudioRecord> findRecordsByLengthRange(int minLength, int maxLength) throws ServiceException {

        if (maxLength < minLength) {
            throw new ServiceException("Negative length range");
        }

        if (minLength <= 0) {
            throw new ServiceException("Negative minimum length");
        }

        return audioRecordRepository.query(new AudioRecordSpecificationByLengthRange(minLength, maxLength));
    }

    public Set<AudioRecord> findTracksByComposer(String composer) throws ServiceException {
        if (composer == null || composer.isEmpty()) {
            throw new ServiceException("Null composer");
        }

        return audioRecordRepository.query(new TrackSpecificationByComposer(composer));
    }

    public void recordTrack(Track track) throws ServiceException {
        verifyEveryTrackField(track);
        audioRecordRepository.addAudioRecord(track);
    }

    public void deleteTrack(Track track) throws ServiceException {
        verifyEveryTrackField(track);
        audioRecordRepository.removeAudioRecord(track);
    }

    public void recordSong(Song song) throws ServiceException {
        verifyEverySongField(song);
        audioRecordRepository.addAudioRecord(song);
    }

    public void deleteSong(Song song) throws ServiceException {
        verifyEverySongField(song);
        audioRecordRepository.removeAudioRecord(song);
    }

    public void recordSpeech(SpeechRecord speech) throws ServiceException {
        verifyEverySpeechRecordField(speech);
        audioRecordRepository.addAudioRecord(speech);
    }

    public void deleteSpeech(SpeechRecord speech) throws ServiceException {
        verifyEverySpeechRecordField(speech);
        audioRecordRepository.removeAudioRecord(speech);
    }

    private void verifyEverySpeechRecordField(SpeechRecord speech) throws ServiceException {
        if (speech == null) {
            throw new ServiceException("Null speech record");
        }

        if (!speechValidator.isPositiveLength(speech.getLengthInMilliseconds())) {
            throw new ServiceException("Negative speech record length");
        }

        if (!speechValidator.hasTitle(speech.getTitle())) {
            throw new ServiceException("Speech record does not have a title");
        }

        if (speech.getSizeInMegabytes() == null) {
            throw new ServiceException("Null speech record size");
        }

        if (!speechValidator.isPositiveSize(speech.getSizeInMegabytes())) {
            throw new ServiceException("Negative speech record size");
        }

        if (!speechValidator.hasNarrator(speech.getNarrator())) {
            throw new ServiceException("Speech record does not have a narrator");
        }
    }

    private void verifyEveryTrackField(Track track) throws ServiceException {
        if (track == null) {
            throw new ServiceException("Null track");
        }

        if (!trackValidator.isPositiveLength(track.getLengthInMilliseconds())) {
            throw new ServiceException("Negative track length");
        }

        if (!trackValidator.hasTitle(track.getTitle())) {
            throw new ServiceException("Track does not have a title");
        }

        if (track.getSizeInMegabytes() == null) {
            throw new ServiceException("Null track size");
        }

        if (!trackValidator.isPositiveSize(track.getSizeInMegabytes())) {
            throw new ServiceException("Negative track size");
        }

        if (!trackValidator.hasComposer(track.getComposer())) {
            throw new ServiceException("Track does not have a composer");
        }

        if (track.getInstrument() == null) {
            throw new ServiceException("Null track instrument");
        }

        if (track.getStyle() == null) {
            throw new ServiceException("Null track style");
        }
    }

    private void verifyEverySongField(Song song) throws ServiceException {
        if (song == null) {
            throw new ServiceException("Null song");
        }

        if (!songValidator.isPositiveLength(song.getLengthInMilliseconds())) {
            throw new ServiceException("Negative song length");
        }

        if (!songValidator.hasTitle(song.getTitle())) {
            throw new ServiceException("Song does not have a title");
        }

        if (song.getSizeInMegabytes() == null) {
            throw new ServiceException("Null song size");
        }

        if (!songValidator.isPositiveSize(song.getSizeInMegabytes())) {
            throw new ServiceException("Negative song size");
        }

        if (!songValidator.hasComposer(song.getComposer())) {
            throw new ServiceException("Song does not have a composer");
        }

        if (song.getInstrument() == null) {
            throw new ServiceException("Null song instrument");
        }

        if (song.getStyle() == null) {
            throw new ServiceException("Null song style");
        }

        if (!songValidator.hasSinger(song.getSinger())) {
            throw new ServiceException("Song does not have a singer");
        }
    }
}
