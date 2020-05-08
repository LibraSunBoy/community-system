package cn.com.entity;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    private String account;

    /**
     * 登录密码
     *
     * @mbggenerated
     */
    private String password;

    /**
     * 昵称
     *
     * @mbggenerated
     */
    private String nickName;

    /**
     * 性别0.保密1.男2.女
     *
     * @mbggenerated
     */
    private Integer gender;

    /**
     * 邮箱
     *
     * @mbggenerated
     */
    private String email;

    /**
     * 手机号
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * 类别
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * 省
     *
     * @mbggenerated
     */
    private String province;

    /**
     * 市
     *
     * @mbggenerated
     */
    private String city;

    /**
     * 区
     *
     * @mbggenerated
     */
    private String area;

    /**
     * 街道
     *
     * @mbggenerated
     */
    private String street;

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
     * 单元id
     *
     * @mbggenerated
     */
    private Integer unitId;

    /**
     * 单元
     *
     * @mbggenerated
     */
    private String unit;

    /**
     * 楼层
     *
     * @mbggenerated
     */
    private Integer floor;

    /**
     * 房间
     *
     * @mbggenerated
     */
    private Integer room;

    /**
     * 积分
     *
     * @mbggenerated
     */
    private Long integral;

    /**
     * 注册时间
     *
     * @mbggenerated
     */
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", nickName=").append(nickName);
        sb.append(", gender=").append(gender);
        sb.append(", email=").append(email);
        sb.append(", mobile=").append(mobile);
        sb.append(", type=").append(type);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", area=").append(area);
        sb.append(", street=").append(street);
        sb.append(", communityId=").append(communityId);
        sb.append(", community=").append(community);
        sb.append(", unitId=").append(unitId);
        sb.append(", unit=").append(unit);
        sb.append(", floor=").append(floor);
        sb.append(", room=").append(room);
        sb.append(", integral=").append(integral);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
