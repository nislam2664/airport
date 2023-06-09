package com.laba.solvd.database.domain;

import java.time.LocalDate;
import java.util.Objects;

public class License {
    private Integer id;
    private int certificationNo;
    private LocalDate issued;
    private LocalDate expired;

    public License() {

    }

    public License(Integer id, int certificationNo, LocalDate issued, LocalDate expired) {
        this.id = id;
        this.certificationNo = certificationNo;
        this.issued = issued;
        this.expired = expired;
    }

    public Integer getId() {
        return id;
    }

    public int getCertificationNo() {
        return certificationNo;
    }

    public LocalDate getIssued() {
        return issued;
    }

    public LocalDate getExpired() {
        return expired;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCertificationNo(int certificationNo) {
        this.certificationNo = certificationNo;
    }

    public void setIssued(LocalDate issued) {
        this.issued = issued;
    }

    public void setExpired(LocalDate expired) {
        this.expired = expired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        License license = (License) o;
        return Objects.equals(id, license.id) && Objects.equals(certificationNo, license.certificationNo) && Objects.equals(issued, license.issued) && Objects.equals(expired, license.expired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, certificationNo, issued, expired);
    }

    @Override
    public String toString() {
        return "License{" +
                "id=" + id +
                ", certificationNo=" + certificationNo +
                ", issued=" + issued +
                ", expired=" + expired +
                '}';
    }
}
