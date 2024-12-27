package com.craftmen.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.craftmen.system.mapper.CraftmenProceduresMapper;
import com.craftmen.system.domain.CraftmenProcedures;
import com.craftmen.system.service.ICraftmenProceduresService;

/**
 * 工序管理Service业务层处理
 * 
 * @author craftMen
 * @date 2024-12-26
 */
@Service
public class CraftmenProceduresServiceImpl implements ICraftmenProceduresService 
{
    @Autowired
    private CraftmenProceduresMapper craftmenProceduresMapper;

    /**
     * 查询工序管理
     * 
     * @param id 工序管理主键
     * @return 工序管理
     */
    @Override
    public CraftmenProcedures selectCraftmenProceduresById(Long id)
    {
        return craftmenProceduresMapper.selectCraftmenProceduresById(id);
    }

    /**
     * 查询工序管理列表
     * 
     * @param craftmenProcedures 工序管理
     * @return 工序管理
     */
    @Override
    public List<CraftmenProcedures> selectCraftmenProceduresList(CraftmenProcedures craftmenProcedures)
    {
        return craftmenProceduresMapper.selectCraftmenProceduresList(craftmenProcedures);
    }

    /**
     * 新增工序管理
     * 
     * @param craftmenProcedures 工序管理
     * @return 结果
     */
    @Override
    public int insertCraftmenProcedures(CraftmenProcedures craftmenProcedures)
    {
        return craftmenProceduresMapper.insertCraftmenProcedures(craftmenProcedures);
    }

    /**
     * 修改工序管理
     * 
     * @param craftmenProcedures 工序管理
     * @return 结果
     */
    @Override
    public int updateCraftmenProcedures(CraftmenProcedures craftmenProcedures)
    {
        return craftmenProceduresMapper.updateCraftmenProcedures(craftmenProcedures);
    }

    /**
     * 批量删除工序管理
     * 
     * @param ids 需要删除的工序管理主键
     * @return 结果
     */
    @Override
    public int deleteCraftmenProceduresByIds(Long[] ids)
    {
        return craftmenProceduresMapper.deleteCraftmenProceduresByIds(ids);
    }

    /**
     * 删除工序管理信息
     * 
     * @param id 工序管理主键
     * @return 结果
     */
    @Override
    public int deleteCraftmenProceduresById(Long id)
    {
        return craftmenProceduresMapper.deleteCraftmenProceduresById(id);
    }
}
