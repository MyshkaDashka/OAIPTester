package by.home.dto;

import java.sql.Date;

/**
 * Created by Darya on 07.05.16.
 */
public class ReportDTO {

    private Integer mark;

    private Integer attemptCount;

    private Date lastAttemptDate;

    private String testTitle;

    public ReportDTO(){}

    public ReportDTO(Integer mark, Integer attemptCount, Date lastAttemptDate, String testTitle){
        this.mark = mark;
        this.attemptCount = attemptCount;
        this.lastAttemptDate=lastAttemptDate;
        this.testTitle=testTitle;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(Integer attemptCount) {
        this.attemptCount = attemptCount;
    }

    public Date getLastAttemptDate() {
        return lastAttemptDate;
    }

    public void setLastAttemptDate(Date lastAttemptDate) {
        this.lastAttemptDate = lastAttemptDate;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }
}
