package java.com.buyash.entity;

import java.com.buyash.entity.AudioRecord;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Disk<T extends AudioRecord> implements Serializable {

    // it is generified because some of the tasks
    // cannot be performed on all entities
    private List<T> records;
    private BigDecimal capacity;
    private String name;
    private BigDecimal availableSpace;

    public Disk() {
    }

    public Disk(BigDecimal capacity, String name) {
        this.records = new ArrayList<>();
        this.capacity = capacity.setScale(2, RoundingMode.HALF_UP);
        this.name = name;
        this.availableSpace = this.capacity;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity.setScale(2, RoundingMode.HALF_UP);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(BigDecimal availableSpace) {
        this.availableSpace = availableSpace;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (capacity != null ? capacity.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Disk other = (Disk) obj;

        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else {
            if (!this.name.equals(other.name)) {
                return false;
            }
        }

        if (this.capacity == null) {
            if (other.capacity != null) {
                return false;
            }
        } else {
            if (!this.capacity.equals(other.capacity)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "name: " + name + "|capacity:" + capacity;
    }
}
