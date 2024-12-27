package com.craftmen.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.craftmen.common.annotation.Excel;
import com.craftmen.common.core.domain.BaseEntity;

/**
 * 客户管理对象 craftmen_customers
 * 
 * @author craftMen
 * @date 2024-12-25
 */
public class CraftmenCustomers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户编号 */
    @Excel(name = "客户编号")
    private Long id;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String name;

    /** 客户全称 */
    @Excel(name = "客户全称")
    private String fullName;

    /** 客户地址 */
    @Excel(name = "客户地址")
    private String address;

    /** 客户邮箱 */
    @Excel(name = "客户邮箱")
    private String email;

    /** 经理姓名 */
    @Excel(name = "经理姓名")
    private String managerName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 客户状态 */
    @Excel(name = "客户状态")
    private String status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setFullName(String fullName) 
    {
        this.fullName = fullName;
    }

    public String getFullName() 
    {
        return fullName;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setManagerName(String managerName) 
    {
        this.managerName = managerName;
    }

    public String getManagerName() 
    {
        return managerName;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("fullName", getFullName())
            .append("address", getAddress())
            .append("email", getEmail())
            .append("managerName", getManagerName())
            .append("phone", getPhone())
            .append("status", getStatus())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .append("remark", getRemark())
            .toString();
    }
}
