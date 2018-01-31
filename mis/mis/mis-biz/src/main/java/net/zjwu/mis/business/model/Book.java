package net.zjwu.mis.business.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_t_book")
public class Book implements Serializable {
    @Id
    private Integer id;

    /**
     * 书籍名
     */
    @Column(name = "book_name")
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 书籍类型
     */
    @Column(name = "book_type")
    private Integer bookType;

    /**
     * 出版社
     */
    private String publics;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 出版日期
     */
    @Column(name = "public_date")
    private String publicDate;

    /**
     * 热门等级
     */
    private Integer grade;

    /**
     * 备注
     */
    private String remark;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 图片路径
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 简介
     */
    private String descr;

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
     * 获取书籍名
     *
     * @return book_name - 书籍名
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 设置书籍名
     *
     * @param bookName 书籍名
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取书籍类型
     *
     * @return book_type - 书籍类型
     */
    public Integer getBookType() {
        return bookType;
    }

    /**
     * 设置书籍类型
     *
     * @param bookType 书籍类型
     */
    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }



    public String getPublics() {
		return publics;
	}

	public void setPublics(String publics) {
		this.publics = publics;
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
     * 获取出版日期
     *
     * @return public_date - 出版日期
     */
    public String getPublicDate() {
        return publicDate;
    }

    /**
     * 设置出版日期
     *
     * @param publicDate 出版日期
     */
    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
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
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    /**
     * 获取简介
     *
     * @return descr - 简介
     */
    public String getDescr() {
        return descr;
    }

    /**
     * 设置简介
     *
     * @param descr 简介
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }
}