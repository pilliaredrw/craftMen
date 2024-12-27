package com.craftmen.system.service;

import java.util.List;
import com.craftmen.system.domain.CraftmenProducts;

/**
 * 产品管理Service接口
 * 
 * @author craftMen
 * @date 2024-12-25
 */
public interface ICraftmenProductsService 
{
    /**
     * 查询产品管理
     * 
     * @param id 产品管理主键
     * @return 产品管理
     */
    public CraftmenProducts selectCraftmenProductsById(Long id);

    /**
     * 查询产品管理列表
     * 
     * @param craftmenProducts 产品管理
     * @return 产品管理集合
     */
    public List<CraftmenProducts> selectCraftmenProductsList(CraftmenProducts craftmenProducts);

    /**
     * 新增产品管理
     * 
     * @param craftmenProducts 产品管理
     * @return 结果
     */
    public int insertCraftmenProducts(CraftmenProducts craftmenProducts);

    /**
     * 修改产品管理
     * 
     * @param craftmenProducts 产品管理
     * @return 结果
     */
    public int updateCraftmenProducts(CraftmenProducts craftmenProducts);

    /**
     * 批量删除产品管理
     * 
     * @param ids 需要删除的产品管理主键集合
     * @return 结果
     */
    public int deleteCraftmenProductsByIds(Long[] ids);

    /**
     * 删除产品管理信息
     * 
     * @param id 产品管理主键
     * @return 结果
     */
    public int deleteCraftmenProductsById(Long id);
}