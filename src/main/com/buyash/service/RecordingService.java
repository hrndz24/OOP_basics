package com.buyash.service;


import com.buyash.entity.Track;
import com.buyash.exception.ServiceException;
import com.buyash.validation.TrackValidator;

public class RecordingService {

    private TrackValidator trackValidator = new TrackValidator();
    public Track recordTrack(Track track) {
        //todo validate track
        // then add to repository
        return null;
    }

    //todo maybe it's not needed here
    private void checkTrack(Track track) throws ServiceException {
        if (track == null) {
            throw new ServiceException("Null track");
        }

        if (!trackValidator.isPositiveLength(track.getLengthInMilliseconds())) {
            throw new ServiceException("Negative track name");
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
}
