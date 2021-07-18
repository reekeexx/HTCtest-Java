package com.example.htctest.model;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Passport {

    @NotNull(message = "Серия не может быть пустым")
    private Integer seriesPassport;

    @NotNull(message = "Номер не может быть пустым")
    private Integer numberPassport;

    private String datePassport;

    public Integer getSeriesPassport() {
        return seriesPassport;
    }

    public void setSeriesPassport(Integer seriesPassport) {
        this.seriesPassport = seriesPassport;
    }

    public Integer getNumberPassport() {
        return numberPassport;
    }

    public void setNumberPassport(Integer numberPassport) {
        this.numberPassport = numberPassport;
    }

    public String getDatePassport() {
        return datePassport;
    }

    public void setDatePassport(String datePassport) {
        this.datePassport = datePassport;
    }
}
