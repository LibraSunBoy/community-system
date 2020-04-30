package cn.com.entity;

import java.io.Serializable;
import java.util.Date;

public class Trash implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 编号
     *
     * @mbggenerated
     */
    private String number;

    /**
     * 垃圾分类Id
     *
     * @mbggenerated
     */
    private Integer trashTypeId;

    /**
     * 容量
     *
     * @mbggenerated
     */
    private String capacity;

    /**
     * 状态0.空1.未满2.已满
     *
     * @mbggenerated
     */
    private Long status;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createDate;

    /**
     * 位置
     *
     * @mbggenerated
     */
    private String location;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Integer createBy;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getTrashTypeId() {
        return trashTypeId;
    }

    public void setTrashTypeId(Integer trashTypeId) {
        this.trashTypeId = trashTypeId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", trashTypeId=").append(trashTypeId);
        sb.append(", capacity=").append(capacity);
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", location=").append(location);
        sb.append(", createBy=").append(createBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}