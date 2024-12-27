package com.craftmen.system.service;

import java.util.List;
import com.craftmen.system.domain.CraftmenCustomers;

/**
 * 客户管理Service接口
 * 
 * @author craftMen
 * @date 2024-12-25
 */
public interface ICraftmenCustomersService 
{
    /**
     * 查询客户管理
     * 
     * @param id 客户管理主键
     * @return 客户管理
     */
    public CraftmenCustomers selectCraftmenCustomersById(Long id);

    /**
     * 查询客户管理列表
     * 
     * @param craftmenCustomers 客户管理
     * @return 客户管理集合
     */
    public List<CraftmenCustomers> selectCraftmenCustomersList(CraftmenCustomers craftmenCustomers);

    /**
     * 新增客户管理
     * 
     * @param craftmenCustomers 客户管理
     * @return 结果
     */
    public int insertCraftmenCustomers(CraftmenCustomers craftmenCustomers);

    /**
     * 修改客户管理
     * 
     * @param craftmenCustomers 客户管理
     * @return 结果
     */
    public int updateCraftmenCustomers(CraftmenCustomers craftmenCustomers);

    /**
     * 批量删除客户管理
     * 
     * @param ids 需要删除的客户管理主键集合
     * @return 结果
     */
    public int deleteCraftmenCustomersByIds(Long[] ids);

    /**
     * 删除客户管理信息
     * 
     * @param id 客户管理主键
     * @return 结果
     */
    public int deleteCraftmenCustomersById(Long id);
}
