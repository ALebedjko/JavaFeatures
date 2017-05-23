package main.java.org.banjalive.JavaFeatures;

/**
 * Created by a.lebedjko on 2017.02.03..
 */
public class DateConversionResult {
    private String convertedDate;
    private boolean converted;

    public String getConvertedDate() {
        return convertedDate;
    }

    public void setConvertedDate(String convertedDate) {
        this.convertedDate = convertedDate;
    }

    public boolean isConverted() {
        return converted;
    }

    public void setConverted(boolean converted) {
        this.converted = converted;
    }

    public DateConversionResult() {
    }

    public DateConversionResult(String convertedDate, boolean converted) {
        this.convertedDate = convertedDate;
        this.converted = converted;
    }

    @Override
    public String toString() {
        return "DateConversionResult [convertedDate=" + convertedDate + ", converted=" + converted + "]";
    }

}