package com.buyash.service;

import com.buyash.comparator.ComparatorByStyle;
import com.buyash.entity.AudioRecord;
import com.buyash.entity.Disk;
import com.buyash.entity.Track;
import com.buyash.exception.ServiceException;
import com.buyash.factory.RepositoryFactory;
import com.buyash.repository.AudioRecordRepository;
import com.buyash.validation.DiskValidator;

import java.math.BigDecimal;
import java.util.List;

public class DiskService {

    private AudioRecordRepository audioRecordRepository = RepositoryFactory.getInstance().getAudioRecordRepository();
    private DiskValidator diskValidator = new DiskValidator();

    private static class SingletonHolder {
        private static final DiskService INSTANCE = new DiskService();
    }

    private DiskService() {
    }

    public static DiskService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public <T extends AudioRecord> Disk<T> writeToDisk(Disk<T> disk, List<T> records) throws ServiceException {
        verifyEveryDiskField(disk);
        if (records == null) {
            throw new ServiceException("Null records");
        }

        BigDecimal totalRecordsSize = calculateRecordsSize(records);
        if (totalRecordsSize.doubleValue() > disk.getAvailableSpace().doubleValue()) {
            throw new ServiceException("Not enough space on disk to write records");
        }

        records.addAll(disk.getRecords());
        disk.setRecords(records);
        disk.setAvailableSpace(disk.getAvailableSpace().subtract(totalRecordsSize));
        return disk;
    }

    public <T extends AudioRecord> Disk<T> removeFromDisk(Disk<T> disk, List<T> records) throws ServiceException {
        verifyEveryDiskField(disk);
        if (records == null) {
            throw new ServiceException("Null records");
        }

        BigDecimal totalRecordsSize = calculateRecordsSize(records);

        List<T> diskRecords = disk.getRecords();
        diskRecords.removeAll(records);
        disk.setRecords(diskRecords);

        disk.setAvailableSpace(disk.getAvailableSpace().add(totalRecordsSize));
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

    public Disk<? extends Track> sortTracksByStyle(Disk<? extends Track> disk) throws ServiceException {

        verifyEveryDiskField(disk);

        disk.getRecords().sort(new ComparatorByStyle());
        return disk;
    }

    private <T extends AudioRecord> BigDecimal calculateRecordsSize(List<T> records) throws ServiceException {
        BigDecimal totalRecordsSize = new BigDecimal(0);
        for (T record : records) {
            if (record == null) {
                throw new ServiceException("Null record");
            } else {
                totalRecordsSize = totalRecordsSize.add(record.getSizeInMegabytes());
            }
        }
        return totalRecordsSize;
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
