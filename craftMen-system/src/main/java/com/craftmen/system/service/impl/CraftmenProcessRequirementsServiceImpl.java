package com.craftmen.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.craftmen.system.mapper.CraftmenProcessRequirementsMapper;
import com.craftmen.system.domain.CraftmenProcessRequirements;
import com.craftmen.system.service.ICraftmenProcessRequirementsService;

/**
 * 工艺要求Service业务层处理
 * 
 * @author craftMen
 * @date 2024-12-26
 */
@Service
public class CraftmenProcessRequirementsServiceImpl implements ICraftmenProcessRequirementsService 
{
    @Autowired
    private CraftmenProcessRequirementsMapper craftmenProcessRequirementsMapper;

    /**
     * 查询工艺要求
     * 
     * @param id 工艺要求主键
     * @return 工艺要求
     */
    @Override
    public CraftmenProcessRequirements selectCraftmenProcessRequirementsById(Long id)
    {
        return craftmenProcessRequirementsMapper.selectCraftmenProcessRequirementsById(id);
    }

    /**
     * 查询工艺要求列表
     * 
     * @param craftmenProcessRequirements 工艺要求
     * @return 工艺要求
     */
    @Override
    public List<CraftmenProcessRequirements> selectCraftmenProcessRequirementsList(CraftmenProcessRequirements craftmenProcessRequirements)
    {
        return craftmenProcessRequirementsMapper.selectCraftmenProcessRequirementsList(craftmenProcessRequirements);
    }

    /**
     * 新增工艺要求
     * 
     * @param craftmenProcessRequirements 工艺要求
     * @return 结果
     */
    @Override
    public int insertCraftmenProcessRequirements(CraftmenProcessRequirements craftmenProcessRequirements)
    {
        return craftmenProcessRequirementsMapper.insertCraftmenProcessRequirements(craftmenProcessRequirements);
    }

    /**
     * 修改工艺要求
     * 
     * @param craftmenProcessRequirements 工艺要求
     * @return 结果
     */
    @Override
    public int updateCraftmenProcessRequirements(CraftmenProcessRequirements craftmenProcessRequirements)
    {
        return craftmenProcessRequirementsMapper.updateCraftmenProcessRequirements(craftmenProcessRequirements);
    }

    /**
     * 批量删除工艺要求
     * 
     * @param ids 需要删除的工艺要求主键
     * @return 结果
     */
    @Override
    public int deleteCraftmenProcessRequirementsByIds(Long[] ids)
    {
        return craftmenProcessRequirementsMapper.deleteCraftmenProcessRequirementsByIds(ids);
    }

    /**
     * 删除工艺要求信息
     * 
     * @param id 工艺要求主键
     * @return 结果
     */
    @Override
    public int deleteCraftmenProcessRequirementsById(Long id)
    {
        return craftmenProcessRequirementsMapper.deleteCraftmenProcessRequirementsById(id);
    }
}
