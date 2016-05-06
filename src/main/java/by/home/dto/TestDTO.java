package by.home.dto;

import java.sql.Date;

/**
 * Created by Darya on 06.05.16.
 */
public class TestDTO {
    private String title;
    private Date createDate;

    public TestDTO() {
    }

    public TestDTO(String title, Date createDate) {
        this.title = title;
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
