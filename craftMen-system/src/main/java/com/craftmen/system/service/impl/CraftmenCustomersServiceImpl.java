package com.craftmen.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.craftmen.system.mapper.CraftmenCustomersMapper;
import com.craftmen.system.domain.CraftmenCustomers;
import com.craftmen.system.service.ICraftmenCustomersService;

/**
 * 客户管理Service业务层处理
 * 
 * @author craftMen
 * @date 2024-12-25
 */
@Service
public class CraftmenCustomersServiceImpl implements ICraftmenCustomersService 
{
    @Autowired
    private CraftmenCustomersMapper craftmenCustomersMapper;

    /**
     * 查询客户管理
     * 
     * @param id 客户管理主键
     * @return 客户管理
     */
    @Override
    public CraftmenCustomers selectCraftmenCustomersById(Long id)
    {
        return craftmenCustomersMapper.selectCraftmenCustomersById(id);
    }

    /**
     * 查询客户管理列表
     * 
     * @param craftmenCustomers 客户管理
     * @return 客户管理
     */
    @Override
    public List<CraftmenCustomers> selectCraftmenCustomersList(CraftmenCustomers craftmenCustomers)
    {
        return craftmenCustomersMapper.selectCraftmenCustomersList(craftmenCustomers);
    }

    /**
     * 新增客户管理
     * 
     * @param craftmenCustomers 客户管理
     * @return 结果
     */
    @Override
    public int insertCraftmenCustomers(CraftmenCustomers craftmenCustomers)
    {
        return craftmenCustomersMapper.insertCraftmenCustomers(craftmenCustomers);
    }

    /**
     * 修改客户管理
     * 
     * @param craftmenCustomers 客户管理
     * @return 结果
     */
    @Override
    public int updateCraftmenCustomers(CraftmenCustomers craftmenCustomers)
    {
        return craftmenCustomersMapper.updateCraftmenCustomers(craftmenCustomers);
    }

    /**
     * 批量删除客户管理
     * 
     * @param ids 需要删除的客户管理主键
     * @return 结果
     */
    @Override
    public int deleteCraftmenCustomersByIds(Long[] ids)
    {
        return craftmenCustomersMapper.deleteCraftmenCustomersByIds(ids);
    }

    /**
     * 删除客户管理信息
     * 
     * @param id 客户管理主键
     * @return 结果
     */
    @Override
    public int deleteCraftmenCustomersById(Long id)
    {
        return craftmenCustomersMapper.deleteCraftmenCustomersById(id);
    }
}
