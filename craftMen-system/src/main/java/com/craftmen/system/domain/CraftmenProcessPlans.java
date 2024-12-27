package com.craftmen.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.craftmen.common.annotation.Excel;
import com.craftmen.common.core.domain.BaseEntity;

/**
 * 工艺计划对象 craftmen_process_plans
 * 
 * @author craftMen
 * @date 2024-12-26
 */
public class CraftmenProcessPlans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工艺计划编号 */
    @Excel(name = "工艺计划编号")
    private Long id;

    /** 工艺编号 */
    @Excel(name = "工艺编号")
    private Long processId;

    /** 批次数量 */
    @Excel(name = "批次数量")
    private Long batchQuantity;

    /** 计划开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planStart;

    /** 计划结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planEnd;

    /** 计划提交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submittedAt;

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
    public void setBatchQuantity(Long batchQuantity) 
    {
        this.batchQuantity = batchQuantity;
    }

    public Long getBatchQuantity() 
    {
        return batchQuantity;
    }
    public void setPlanStart(Date planStart) 
    {
        this.planStart = planStart;
    }

    public Date getPlanStart() 
    {
        return planStart;
    }
    public void setPlanEnd(Date planEnd) 
    {
        this.planEnd = planEnd;
    }

    public Date getPlanEnd() 
    {
        return planEnd;
    }
    public void setSubmittedAt(Date submittedAt) 
    {
        this.submittedAt = submittedAt;
    }

    public Date getSubmittedAt() 
    {
        return submittedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("processId", getProcessId())
            .append("batchQuantity", getBatchQuantity())
            .append("planStart", getPlanStart())
            .append("planEnd", getPlanEnd())
            .append("submittedAt", getSubmittedAt())
            .toString();
    }
}
