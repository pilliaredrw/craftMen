package com.craftmen.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.craftmen.system.mapper.CraftmenProcessesMapper;
import com.craftmen.system.domain.CraftmenProcesses;
import com.craftmen.system.service.ICraftmenProcessesService;

/**
 * 工艺管理Service业务层处理
 * 
 * @author craftMen
 * @date 2024-12-26
 */
@Service
public class CraftmenProcessesServiceImpl implements ICraftmenProcessesService 
{
    @Autowired
    private CraftmenProcessesMapper craftmenProcessesMapper;

    /**
     * 查询工艺管理
     * 
     * @param id 工艺管理主键
     * @return 工艺管理
     */
    @Override
    public CraftmenProcesses selectCraftmenProcessesById(Long id)
    {
        return craftmenProcessesMapper.selectCraftmenProcessesById(id);
    }

    /**
     * 查询工艺管理列表
     * 
     * @param craftmenProcesses 工艺管理
     * @return 工艺管理
     */
    @Override
    public List<CraftmenProcesses> selectCraftmenProcessesList(CraftmenProcesses craftmenProcesses)
    {
        return craftmenProcessesMapper.selectCraftmenProcessesList(craftmenProcesses);
    }

    /**
     * 新增工艺管理
     * 
     * @param craftmenProcesses 工艺管理
     * @return 结果
     */
    @Override
    public int insertCraftmenProcesses(CraftmenProcesses craftmenProcesses)
    {
        return craftmenProcessesMapper.insertCraftmenProcesses(craftmenProcesses);
    }

    /**
     * 修改工艺管理
     * 
     * @param craftmenProcesses 工艺管理
     * @return 结果
     */
    @Override
    public int updateCraftmenProcesses(CraftmenProcesses craftmenProcesses)
    {
        return craftmenProcessesMapper.updateCraftmenProcesses(craftmenProcesses);
    }

    /**
     * 批量删除工艺管理
     * 
     * @param ids 需要删除的工艺管理主键
     * @return 结果
     */
    @Override
    public int deleteCraftmenProcessesByIds(Long[] ids)
    {
        return craftmenProcessesMapper.deleteCraftmenProcessesByIds(ids);
    }

    /**
     * 删除工艺管理信息
     * 
     * @param id 工艺管理主键
     * @return 结果
     */
    @Override
    public int deleteCraftmenProcessesById(Long id)
    {
        return craftmenProcessesMapper.deleteCraftmenProcessesById(id);
    }
}
