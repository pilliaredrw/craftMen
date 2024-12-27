package com.craftmen.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.craftmen.system.mapper.CraftmenProductsMapper;
import com.craftmen.system.domain.CraftmenProducts;
import com.craftmen.system.service.ICraftmenProductsService;

/**
 * 产品管理Service业务层处理
 * 
 * @author craftMen
 * @date 2024-12-25
 */
@Service
public class CraftmenProductsServiceImpl implements ICraftmenProductsService 
{
    @Autowired
    private CraftmenProductsMapper craftmenProductsMapper;

    /**
     * 查询产品管理
     * 
     * @param id 产品管理主键
     * @return 产品管理
     */
    @Override
    public CraftmenProducts selectCraftmenProductsById(Long id)
    {
        return craftmenProductsMapper.selectCraftmenProductsById(id);
    }

    /**
     * 查询产品管理列表
     * 
     * @param craftmenProducts 产品管理
     * @return 产品管理
     */
    @Override
    public List<CraftmenProducts> selectCraftmenProductsList(CraftmenProducts craftmenProducts)
    {
        return craftmenProductsMapper.selectCraftmenProductsList(craftmenProducts);
    }

    /**
     * 新增产品管理
     * 
     * @param craftmenProducts 产品管理
     * @return 结果
     */
    @Override
    public int insertCraftmenProducts(CraftmenProducts craftmenProducts)
    {
        return craftmenProductsMapper.insertCraftmenProducts(craftmenProducts);
    }

    /**
     * 修改产品管理
     * 
     * @param craftmenProducts 产品管理
     * @return 结果
     */
    @Override
    public int updateCraftmenProducts(CraftmenProducts craftmenProducts)
    {
        return craftmenProductsMapper.updateCraftmenProducts(craftmenProducts);
    }

    /**
     * 批量删除产品管理
     * 
     * @param ids 需要删除的产品管理主键
     * @return 结果
     */
    @Override
    public int deleteCraftmenProductsByIds(Long[] ids)
    {
        return craftmenProductsMapper.deleteCraftmenProductsByIds(ids);
    }

    /**
     * 删除产品管理信息
     * 
     * @param id 产品管理主键
     * @return 结果
     */
    @Override
    public int deleteCraftmenProductsById(Long id)
    {
        return craftmenProductsMapper.deleteCraftmenProductsById(id);
    }
}
