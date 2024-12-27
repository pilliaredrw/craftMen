package com.craftmen.system.service;

import java.util.List;
import com.craftmen.system.domain.CraftmenProcesses;

/**
 * 工艺管理Service接口
 * 
 * @author craftMen
 * @date 2024-12-26
 */
public interface ICraftmenProcessesService 
{
    /**
     * 查询工艺管理
     * 
     * @param id 工艺管理主键
     * @return 工艺管理
     */
    public CraftmenProcesses selectCraftmenProcessesById(Long id);

    /**
     * 查询工艺管理列表
     * 
     * @param craftmenProcesses 工艺管理
     * @return 工艺管理集合
     */
    public List<CraftmenProcesses> selectCraftmenProcessesList(CraftmenProcesses craftmenProcesses);

    /**
     * 新增工艺管理
     * 
     * @param craftmenProcesses 工艺管理
     * @return 结果
     */
    public int insertCraftmenProcesses(CraftmenProcesses craftmenProcesses);

    /**
     * 修改工艺管理
     * 
     * @param craftmenProcesses 工艺管理
     * @return 结果
     */
    public int updateCraftmenProcesses(CraftmenProcesses craftmenProcesses);

    /**
     * 批量删除工艺管理
     * 
     * @param ids 需要删除的工艺管理主键集合
     * @return 结果
     */
    public int deleteCraftmenProcessesByIds(Long[] ids);

    /**
     * 删除工艺管理信息
     * 
     * @param id 工艺管理主键
     * @return 结果
     */
    public int deleteCraftmenProcessesById(Long id);
}
