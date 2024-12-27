package com.craftmen.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.craftmen.common.annotation.Excel;
import com.craftmen.common.core.domain.BaseEntity;

/**
 * 工艺要求对象 craftmen_process_requirements
 * 
 * @author craftMen
 * @date 2024-12-26
 */
public class CraftmenProcessRequirements extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工艺要求编号 */
    @Excel(name = "工艺要求编号")
    private Long id;

    /** 工艺编号 */
    @Excel(name = "工艺编号")
    private Long processId;

    /** 工艺名称 */
    @Excel(name = "工艺名称")
    private String name;

    /** 工艺要求 */
    @Excel(name = "工艺要求")
    private String requirement;

    /** 工艺要求添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "工艺要求添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 工艺要求修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "工艺要求修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProcessId(Long processId) 
    {
        this.processId = processId;
    }

    public Long getProcessId() 
    {
        return processId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setRequirement(String requirement) 
    {
        this.requirement = requirement;
    }

    public String getRequirement() 
    {
        return requirement;
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
            .append("processId", getProcessId())
            .append("name", getName())
            .append("requirement", getRequirement())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
