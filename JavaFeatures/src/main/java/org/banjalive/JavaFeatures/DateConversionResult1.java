package main.java.org.banjalive.JavaFeatures;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by a.lebedjko on 2017.02.03..
 */
public class DateConversionResult1 {
    private List<String> convertedDates;
    private boolean converted;

    public DateConversionResult1(boolean converted, List<String> convertedDates) {
        this.converted = converted;
        this.convertedDates = convertedDates;
    }

    public List<String> getConvertedDates() {
        return convertedDates;
    }

    public void setConvertedDates(List<String> convertedDates) {
        this.convertedDates = convertedDates;
    }

    public boolean isConverted() {
        return converted;
    }

    public void setConverted(boolean converted) {
        this.converted = converted;
    }

    @Override
    public String toString() {
        return "DateConversionResult [convertedDates=" + convertedDates + ", converted=" + converted + "]";
    }

    public void addConversionResultToList(String convertedDate) {
        if (!StringUtils.isEmpty(convertedDate)) convertedDates.add("convertedDate");
    }
}