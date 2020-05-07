package cn.com.entity;

import java.io.Serializable;
import java.util.Date;

public class Unit implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 小区id
     *
     * @mbggenerated
     */
    private Integer communityId;

    /**
     * 小区
     *
     * @mbggenerated
     */
    private String community;

    /**
     * 几单元
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 多少层
     *
     * @mbggenerated
     */
    private Integer floor;

    /**
     * 添加时间
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

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", communityId=").append(communityId);
        sb.append(", community=").append(community);
        sb.append(", name=").append(name);
        sb.append(", floor=").append(floor);
        sb.append(", createDate=").append(createDate);
        sb.append(", location=").append(location);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}