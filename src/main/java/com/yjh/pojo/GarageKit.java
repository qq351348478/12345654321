package com.yjh.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarageKit {
    private Long id;
    private String gkname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date reserveDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date saleDate;
    private String role;
    private Float price;
    private Integer num;
    private String manufacturer;
    private String scale;
    private String material;
    private String rule;
    private String publish;
    private String profilePhotoPath;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 创建人
     */
    private String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String updateBy;

    public int hashCode(){
        return this.id.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
      /*  1）对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；
　　　　    如果作用于引用类型的变量，则比较的是所指向的对象的地址
　　      2）对于equals方法，注意：equals方法不能作用于基本数据类型的变量
　　　　    如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
　　　　    诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。*/
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        GarageKit other = (GarageKit) obj;
        return other.id.equals(this.id);
    }

}