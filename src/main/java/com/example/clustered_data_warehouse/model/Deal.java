package com.example.clustered_data_warehouse.model;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "deals")
public class Deal {
    @Id
    private String id;
    @NotNull(message = "id  shouldn't be empty")
    private String dealUniqueId;
    @NotNull
    @Pattern(regexp = "^[A-Z]{3}$",message = "invalid from currency entered ")
    private String fromCurrencyIsoCode;
    @NotNull
    @Pattern(regexp = "^[A-Z]{3}$",message = "invalid to currency entered ")
    private String toCurrencyIsoCode;
    @NotNull
    private String dealTimestamp;
    @NotNull
    @DecimalMin(value = "0.0", message = "Deal amount cannot be negative")
    @Digits(integer = 10, fraction = 2, message = "Deal amount must be a number with up to 10 integer digits and 2 fraction digits")
    private double dealAmount;

    public Deal(String dealUniqueId, String fromCurrencyIsoCode, String toCurrencyIsoCode, String dealTimestamp, double dealAmount) {
        this.dealUniqueId = dealUniqueId;
        this.fromCurrencyIsoCode = fromCurrencyIsoCode;
        this.toCurrencyIsoCode = toCurrencyIsoCode;
        this.dealTimestamp = dealTimestamp;
        this.dealAmount = dealAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDealUniqueId() {
        return dealUniqueId;
    }

    public void setDealUniqueId(String dealUniqueId) {
        this.dealUniqueId = dealUniqueId;
    }

    public String getFromCurrencyIsoCode() {
        return fromCurrencyIsoCode;
    }

    public void setFromCurrencyIsoCode(String fromCurrencyIsoCode) {
        this.fromCurrencyIsoCode = fromCurrencyIsoCode;
    }

    public String getToCurrencyIsoCode() {
        return toCurrencyIsoCode;
    }

    public void setToCurrencyIsoCode(String toCurrencyIsoCode) {
        this.toCurrencyIsoCode = toCurrencyIsoCode;
    }

    public String getDealTimestamp() {
        return dealTimestamp;
    }

    public void setDealTimestamp(String dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }

    public double getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(double dealAmount) {
        this.dealAmount = dealAmount;
    }
}
