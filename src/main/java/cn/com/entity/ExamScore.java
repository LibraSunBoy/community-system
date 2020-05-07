package cn.com.entity;

import java.io.Serializable;
import java.util.Date;

public class ExamScore implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Integer memberId;

    /**
     * 昵称
     *
     * @mbggenerated
     */
    private String nickName;

    /**
     * 成绩
     *
     * @mbggenerated
     */
    private Integer score;

    /**
     * 测试id
     *
     * @mbggenerated
     */
    private Integer examId;

    /**
     * 测试标题
     *
     * @mbggenerated
     */
    private String title;

    /**
     * 添加时间
     *
     * @mbggenerated
     */
    private Date createDate;

    /**
     * 题目-答案
     *
     * @mbggenerated
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", nickName=").append(nickName);
        sb.append(", score=").append(score);
        sb.append(", examId=").append(examId);
        sb.append(", title=").append(title);
        sb.append(", createDate=").append(createDate);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}