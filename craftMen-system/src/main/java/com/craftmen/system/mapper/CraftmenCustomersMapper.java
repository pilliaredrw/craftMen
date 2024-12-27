package com.craftmen.system.mapper;

import java.util.List;
import com.craftmen.system.domain.CraftmenCustomers;

/**
 * 客户管理Mapper接口
 * 
 * @author craftMen
 * @date 2024-12-25
 */
public interface CraftmenCustomersMapper 
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
     * 删除客户管理
     * 
     * @param id 客户管理主键
     * @return 结果
     */
    public int deleteCraftmenCustomersById(Long id);

    /**
     * 批量删除客户管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCraftmenCustomersByIds(Long[] ids);
}
