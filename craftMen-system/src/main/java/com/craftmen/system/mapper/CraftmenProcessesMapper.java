package com.craftmen.system.mapper;

import java.util.List;
import com.craftmen.system.domain.CraftmenProcesses;

/**
 * 工艺管理Mapper接口
 * 
 * @author craftMen
 * @date 2024-12-26
 */
public interface CraftmenProcessesMapper 
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
     * 删除工艺管理
     * 
     * @param id 工艺管理主键
     * @return 结果
     */
    public int deleteCraftmenProcessesById(Long id);

    /**
     * 批量删除工艺管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCraftmenProcessesByIds(Long[] ids);
}
