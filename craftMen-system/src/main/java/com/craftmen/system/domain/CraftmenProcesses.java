package com.craftmen.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.craftmen.common.annotation.Excel;
import com.craftmen.common.core.domain.BaseEntity;

/**
 * 工艺管理对象 craftmen_processes
 * 
 * @author craftMen
 * @date 2024-12-26
 */
public class CraftmenProcesses extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工艺编号 */
    @Excel(name = "工艺编号")
    private Long id;

    /** 工艺名称 */
    @Excel(name = "工艺名称")
    private String name;

    /** 外协价格 */
    @Excel(name = "外协价格")
    private BigDecimal outsourcingPrice;

    /** 瓶颈工序工期 */
    @Excel(name = "瓶颈工序工期")
    private BigDecimal bottleneckDuration;

    /** 标准架构能力 */
    @Excel(name = "标准架构能力")
    private BigDecimal standardCapacity;

    /** 加班标准架构能力 */
    @Excel(name = "加班标准架构能力")
    private BigDecimal overtimeStandardCapacity;

    /** 加班超额加工能力 */
    @Excel(name = "加班超额加工能力")
    private BigDecimal overtimeExcessCapacity;

    /** 二班工序能力 */
    @Excel(name = "二班工序能力")
    private BigDecimal secondShiftCapacity;

    /** 超负荷工序能力 */
    @Excel(name = "超负荷工序能力")
    private BigDecimal overloadCapacity;

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
    public void setOutsourcingPrice(BigDecimal outsourcingPrice) 
    {
        this.outsourcingPrice = outsourcingPrice;
    }

    public BigDecimal getOutsourcingPrice() 
    {
        return outsourcingPrice;
    }
    public void setBottleneckDuration(BigDecimal bottleneckDuration) 
    {
        this.bottleneckDuration = bottleneckDuration;
    }

    public BigDecimal getBottleneckDuration() 
    {
        return bottleneckDuration;
    }
    public void setStandardCapacity(BigDecimal standardCapacity) 
    {
        this.standardCapacity = standardCapacity;
    }

    public BigDecimal getStandardCapacity() 
    {
        return standardCapacity;
    }
    public void setOvertimeStandardCapacity(BigDecimal overtimeStandardCapacity) 
    {
        this.overtimeStandardCapacity = overtimeStandardCapacity;
    }

    public BigDecimal getOvertimeStandardCapacity() 
    {
        return overtimeStandardCapacity;
    }
    public void setOvertimeExcessCapacity(BigDecimal overtimeExcessCapacity) 
    {
        this.overtimeExcessCapacity = overtimeExcessCapacity;
    }

    public BigDecimal getOvertimeExcessCapacity() 
    {
        return overtimeExcessCapacity;
    }
    public void setSecondShiftCapacity(BigDecimal secondShiftCapacity) 
    {
        this.secondShiftCapacity = secondShiftCapacity;
    }

    public BigDecimal getSecondShiftCapacity() 
    {
        return secondShiftCapacity;
    }
    public void setOverloadCapacity(BigDecimal overloadCapacity) 
    {
        this.overloadCapacity = overloadCapacity;
    }

    public BigDecimal getOverloadCapacity() 
    {
        return overloadCapacity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("outsourcingPrice", getOutsourcingPrice())
            .append("bottleneckDuration", getBottleneckDuration())
            .append("standardCapacity", getStandardCapacity())
            .append("overtimeStandardCapacity", getOvertimeStandardCapacity())
            .append("overtimeExcessCapacity", getOvertimeExcessCapacity())
            .append("secondShiftCapacity", getSecondShiftCapacity())
            .append("overloadCapacity", getOverloadCapacity())
            .append("remark", getRemark())
            .toString();
    }
}
