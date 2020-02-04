package com.buyash.service;

import com.buyash.comparator.ComparatorByStyle;
import com.buyash.entity.AudioRecord;
import com.buyash.entity.Disk;
import com.buyash.entity.Track;
import com.buyash.exception.ServiceException;
import com.buyash.repository.AudioRecordRepository;
import com.buyash.specification.implementation.AudioRecordSpecificationByLengthRange;
import com.buyash.validation.DiskValidator;
import com.buyash.factory.RepositoryFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class ProcessingRecordsService {

    //todo make it singleton
    private AudioRecordRepository audioRecordRepository = RepositoryFactory.getInstance().getAudioRecordRepository();
    private DiskValidator diskValidator = new DiskValidator();


    public <T extends AudioRecord> Disk<T> writeToDisk(Disk<T> disk, List<T> records) throws ServiceException {
        verifyEveryDiskField(disk);
        if (records == null) {
            throw new ServiceException("Null records");
        }

        BigDecimal totalRecordsSize = new BigDecimal(0);
        for (T record : records) {
            if (record == null) {
                throw new ServiceException("Null record");
            } else {
                totalRecordsSize = totalRecordsSize.add(record.getSizeInMegabytes());
            }
        }

        if (totalRecordsSize.doubleValue() > disk.getAvailableSpace().doubleValue()) {
            throw new ServiceException("Not enough space on disk to write records");
        }

        records.addAll(disk.getRecords());
        disk.setRecords(records);
        return disk;
    }

    public <T extends AudioRecord> Disk<T> removeFromDisk(Disk<T> disk, List<T> records) throws ServiceException {
        verifyEveryDiskField(disk);
        if (records == null) {
            throw new ServiceException("Null records");
        }

        for (T record : records) {
            if (record == null) {
                throw new ServiceException("Null record");
            }
        }

        List<T> diskRecords = disk.getRecords();
        diskRecords.removeAll(records);
        disk.setRecords(diskRecords);
        return disk;
    }

    public <T extends AudioRecord> int calculateTotalRecordsLength(Disk<T> disk) throws ServiceException {

        verifyEveryDiskField(disk);

        int totalLength = 0;
        for (T record : disk.getRecords()) {
            totalLength += record.getLengthInMilliseconds();
        }
        return totalLength;
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

    public Disk<? extends Track> sortTracksByStyle(Disk<? extends Track> disk) throws ServiceException {

        verifyEveryDiskField(disk);

        disk.getRecords().sort(new ComparatorByStyle());
        return disk;
    }

    private <T extends AudioRecord> void verifyEveryDiskField(Disk<T> disk) throws ServiceException {

        if (disk == null) {
            throw new ServiceException("Null disk");
        }

        List<T> records = disk.getRecords();
        if (records == null) {
            throw new ServiceException("Null disk records");
        }

        if (disk.getCapacity() == null) {
            throw new ServiceException("Null disk capacity");
        }

        if (disk.getAvailableSpace() == null) {
            throw new ServiceException("Null disk available space");
        }

        if (disk.getName() == null) {
            throw new ServiceException("Null disk name");
        }

        if (!diskValidator.isPositiveCapacity(disk.getCapacity())) {
            throw new ServiceException("Negative disk capacity");
        }

        if (!diskValidator.isPositiveAvailableSpace(disk.getAvailableSpace())) {
            throw new ServiceException("Negative disk available space");
        }
    }

}
