package org.example.model;
import java.time.LocalDate;

public class Lease {
    Long leaseNo;
    LocalDate startDate;
    LocalDate endDate;
    Double monthlyRentalRate;
    String tenant;

    public Lease(Long leaseNo, LocalDate startDate, LocalDate endDate, Double monthlyRentalRate, String tenant) {
        this.leaseNo = leaseNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyRentalRate = monthlyRentalRate;
        this.tenant = tenant;
    }

    public Long getLeaseNo() {
        return leaseNo;
    }

    public void setLeaseNo(Long leaseNo) {
        this.leaseNo = leaseNo;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getMonthlyRentalRate() {
        return monthlyRentalRate;
    }

    public void setMonthlyRentalRate(Double monthlyRentalRate) {
        this.monthlyRentalRate = monthlyRentalRate;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }
}
