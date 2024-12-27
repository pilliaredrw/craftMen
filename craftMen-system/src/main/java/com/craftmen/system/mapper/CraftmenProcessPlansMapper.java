package com.craftmen.system.mapper;

import java.util.List;
import com.craftmen.system.domain.CraftmenProcessPlans;

/**
 * 工艺计划Mapper接口
 * 
 * @author craftMen
 * @date 2024-12-26
 */
public interface CraftmenProcessPlansMapper 
{
    /**
     * 查询工艺计划
     * 
     * @param id 工艺计划主键
     * @return 工艺计划
     */
    public CraftmenProcessPlans selectCraftmenProcessPlansById(Long id);

    /**
     * 查询工艺计划列表
     * 
     * @param craftmenProcessPlans 工艺计划
     * @return 工艺计划集合
     */
    public List<CraftmenProcessPlans> selectCraftmenProcessPlansList(CraftmenProcessPlans craftmenProcessPlans);

    /**
     * 新增工艺计划
     * 
     * @param craftmenProcessPlans 工艺计划
     * @return 结果
     */
    public int insertCraftmenProcessPlans(CraftmenProcessPlans craftmenProcessPlans);

    /**
     * 修改工艺计划
     * 
     * @param craftmenProcessPlans 工艺计划
     * @return 结果
     */
    public int updateCraftmenProcessPlans(CraftmenProcessPlans craftmenProcessPlans);

    /**
     * 删除工艺计划
     * 
     * @param id 工艺计划主键
     * @return 结果
     */
    public int deleteCraftmenProcessPlansById(Long id);

    /**
     * 批量删除工艺计划
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCraftmenProcessPlansByIds(Long[] ids);
}
