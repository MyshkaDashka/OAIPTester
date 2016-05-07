package by.home.dto;

import java.sql.Date;

/**
 * Created by Darya on 06.05.16.
 */
public class TestDTO {
    private String title;
    private Date createDate;
    private Date updateDate;

    public TestDTO() {
    }

    public TestDTO(String title, Date createDate, Date updateDate) {
        this.title = title;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
