package me.geemu.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "test_user_info")
public class TestUserInfo {
    /**
     * 普通会员id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 昵称 唯一
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否删除 0未删除 1删除
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取普通会员id
     *
     * @return id - 普通会员id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置普通会员id
     *
     * @param id 普通会员id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取昵称 唯一
     *
     * @return nick_name - 昵称 唯一
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称 唯一
     *
     * @param nickName 昵称 唯一
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号
     *
     * @return phone_number - 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号
     *
     * @param phoneNumber 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取是否删除 0未删除 1删除
     *
     * @return is_delete - 是否删除 0未删除 1删除
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除 0未删除 1删除
     *
     * @param isDelete 是否删除 0未删除 1删除
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}