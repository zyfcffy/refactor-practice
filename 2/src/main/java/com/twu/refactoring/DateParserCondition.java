package com.twu.refactoring;

public class DateParserCondition {
    Integer start;

    Integer end;

    String stringIndexOutOfBoundsException;

    String numberFormatException;

    Integer max;

    Integer min;

    String illegalArgumentException;

    public DateParserCondition(Integer start, Integer end, String stringIndexOutOfBoundsException, String numberFormatException, Integer max, Integer min, String illegalArgumentException) {
        this.start = start;
        this.end = end;
        this.stringIndexOutOfBoundsException = stringIndexOutOfBoundsException;
        this.numberFormatException = numberFormatException;
        this.max = max;
        this.min = min;
        this.illegalArgumentException = illegalArgumentException;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public String getStringIndexOutOfBoundsException() {
        return stringIndexOutOfBoundsException;
    }

    public void setStringIndexOutOfBoundsException(String stringIndexOutOfBoundsException) {
        this.stringIndexOutOfBoundsException = stringIndexOutOfBoundsException;
    }

    public String getNumberFormatException() {
        return numberFormatException;
    }

    public void setNumberFormatException(String numberFormatException) {
        this.numberFormatException = numberFormatException;
    }

    public String getIllegalArgumentException() {
        return illegalArgumentException;
    }

    public void setIllegalArgumentException(String illegalArgumentException) {
        this.illegalArgumentException = illegalArgumentException;
    }
}
