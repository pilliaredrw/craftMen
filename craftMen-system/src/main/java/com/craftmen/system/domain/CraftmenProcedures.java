package com.craftmen.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.craftmen.common.annotation.Excel;
import com.craftmen.common.core.domain.BaseEntity;

/**
 * 工序管理对象 craftmen_procedures
 * 
 * @author craftMen
 * @date 2024-12-26
 */
public class CraftmenProcedures extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工序编号 */
    @Excel(name = "工序编号")
    private Long id;

    /** 工艺计划编号 */
    @Excel(name = "工艺计划编号")
    private Long planId;

    /** 工序顺序 */
    @Excel(name = "工序顺序")
    private Long sequence;

    /** 单件定额工时 */
    @Excel(name = "单件定额工时")
    private BigDecimal quotaTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setSequence(Long sequence) 
    {
        this.sequence = sequence;
    }

    public Long getSequence() 
    {
        return sequence;
    }
    public void setQuotaTime(BigDecimal quotaTime) 
    {
        this.quotaTime = quotaTime;
    }

    public BigDecimal getQuotaTime() 
    {
        return quotaTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planId", getPlanId())
            .append("sequence", getSequence())
            .append("quotaTime", getQuotaTime())
            .toString();
    }
}
