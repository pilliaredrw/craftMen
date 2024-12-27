package com.craftmen.system.service;

import java.util.List;
import com.craftmen.system.domain.CraftmenProcessRequirements;

/**
 * 工艺要求Service接口
 * 
 * @author craftMen
 * @date 2024-12-26
 */
public interface ICraftmenProcessRequirementsService 
{
    /**
     * 查询工艺要求
     * 
     * @param id 工艺要求主键
     * @return 工艺要求
     */
    public CraftmenProcessRequirements selectCraftmenProcessRequirementsById(Long id);

    /**
     * 查询工艺要求列表
     * 
     * @param craftmenProcessRequirements 工艺要求
     * @return 工艺要求集合
     */
    public List<CraftmenProcessRequirements> selectCraftmenProcessRequirementsList(CraftmenProcessRequirements craftmenProcessRequirements);

    /**
     * 新增工艺要求
     * 
     * @param craftmenProcessRequirements 工艺要求
     * @return 结果
     */
    public int insertCraftmenProcessRequirements(CraftmenProcessRequirements craftmenProcessRequirements);

    /**
     * 修改工艺要求
     * 
     * @param craftmenProcessRequirements 工艺要求
     * @return 结果
     */
    public int updateCraftmenProcessRequirements(CraftmenProcessRequirements craftmenProcessRequirements);

    /**
     * 批量删除工艺要求
     * 
     * @param ids 需要删除的工艺要求主键集合
     * @return 结果
     */
    public int deleteCraftmenProcessRequirementsByIds(Long[] ids);

    /**
     * 删除工艺要求信息
     * 
     * @param id 工艺要求主键
     * @return 结果
     */
    public int deleteCraftmenProcessRequirementsById(Long id);
}
