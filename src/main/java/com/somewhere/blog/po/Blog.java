package com.somewhere.blog.po;


import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity()
@Table(name = "t_blog")
public class Blog {
    @Id
    @GeneratedValue
    //上面是自动生成数据库表所必要的


    private Long id;            //ID
    private String title;//标题


    private String content;     //内容
    private String flag;        //类型   (原创 转载 翻译)
    private Integer views;      //浏览次数
    private boolean published = true;  //是否发布
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime;     //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;    //更新时间




    //一个Blog可以有多个Type
    @ManyToOne
    private Type type;

    //Blog和Tag的关系  多对多
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags= new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private  List<Comment> comments = new ArrayList<>();








    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", published=" + published +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

