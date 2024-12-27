package com.craftmen.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.craftmen.system.mapper.CraftmenProcessPlansMapper;
import com.craftmen.system.domain.CraftmenProcessPlans;
import com.craftmen.system.service.ICraftmenProcessPlansService;

/**
 * 工艺计划Service业务层处理
 * 
 * @author craftMen
 * @date 2024-12-26
 */
@Service
public class CraftmenProcessPlansServiceImpl implements ICraftmenProcessPlansService 
{
    @Autowired
    private CraftmenProcessPlansMapper craftmenProcessPlansMapper;

    /**
     * 查询工艺计划
     * 
     * @param id 工艺计划主键
     * @return 工艺计划
     */
    @Override
    public CraftmenProcessPlans selectCraftmenProcessPlansById(Long id)
    {
        return craftmenProcessPlansMapper.selectCraftmenProcessPlansById(id);
    }

    /**
     * 查询工艺计划列表
     * 
     * @param craftmenProcessPlans 工艺计划
     * @return 工艺计划
     */
    @Override
    public List<CraftmenProcessPlans> selectCraftmenProcessPlansList(CraftmenProcessPlans craftmenProcessPlans)
    {
        return craftmenProcessPlansMapper.selectCraftmenProcessPlansList(craftmenProcessPlans);
    }

    /**
     * 新增工艺计划
     * 
     * @param craftmenProcessPlans 工艺计划
     * @return 结果
     */
    @Override
    public int insertCraftmenProcessPlans(CraftmenProcessPlans craftmenProcessPlans)
    {
        return craftmenProcessPlansMapper.insertCraftmenProcessPlans(craftmenProcessPlans);
    }

    /**
     * 修改工艺计划
     * 
     * @param craftmenProcessPlans 工艺计划
     * @return 结果
     */
    @Override
    public int updateCraftmenProcessPlans(CraftmenProcessPlans craftmenProcessPlans)
    {
        return craftmenProcessPlansMapper.updateCraftmenProcessPlans(craftmenProcessPlans);
    }

    /**
     * 批量删除工艺计划
     * 
     * @param ids 需要删除的工艺计划主键
     * @return 结果
     */
    @Override
    public int deleteCraftmenProcessPlansByIds(Long[] ids)
    {
        return craftmenProcessPlansMapper.deleteCraftmenProcessPlansByIds(ids);
    }

    /**
     * 删除工艺计划信息
     * 
     * @param id 工艺计划主键
     * @return 结果
     */
    @Override
    public int deleteCraftmenProcessPlansById(Long id)
    {
        return craftmenProcessPlansMapper.deleteCraftmenProcessPlansById(id);
    }
}
