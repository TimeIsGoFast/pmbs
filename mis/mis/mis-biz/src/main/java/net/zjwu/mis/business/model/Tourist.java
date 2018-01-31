package net.zjwu.mis.business.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_t_tourist")
public class Tourist implements Serializable {
    @Id
    private Integer id;

    /**
     * 景点名
     */
    @Column(name = "tourist_name")
    private String touristName;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 热门等级
     */
    private Integer grade;

    /**
     * 地址
     */
    private String adress;

    /**
     * 景点类型
     */
    @Column(name = "tourist_type")
    private Integer touristType;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 临近机场
     */
    private String airport;

    /**
     * 备注
     */
    private String remark;

    private Date create;

    /**
     * 图片路径
     */
    @Column(name = "pic_url")
    private String picUrl;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取景点名
     *
     * @return tourist_name - 景点名
     */
    public String getTouristName() {
        return touristName;
    }

    /**
     * 设置景点名
     *
     * @param touristName 景点名
     */
    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    /**
     * 获取所在城市
     *
     * @return city - 所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在城市
     *
     * @param city 所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取热门等级
     *
     * @return grade - 热门等级
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 设置热门等级
     *
     * @param grade 热门等级
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取地址
     *
     * @return adress - 地址
     */
    public String getAdress() {
        return adress;
    }

    /**
     * 设置地址
     *
     * @param adress 地址
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * 获取景点类型
     *
     * @return tourist_type - 景点类型
     */
    public Integer getTouristType() {
        return touristType;
    }

    /**
     * 设置景点类型
     *
     * @param touristType 景点类型
     */
    public void setTouristType(Integer touristType) {
        this.touristType = touristType;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取临近机场
     *
     * @return airport - 临近机场
     */
    public String getAirport() {
        return airport;
    }

    /**
     * 设置临近机场
     *
     * @param airport 临近机场
     */
    public void setAirport(String airport) {
        this.airport = airport;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return create
     */
    public Date getCreate() {
        return create;
    }

    /**
     * @param create
     */
    public void setCreate(Date create) {
        this.create = create;
    }

    /**
     * 获取图片路径
     *
     * @return pic_url - 图片路径
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置图片路径
     *
     * @param picUrl 图片路径
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}