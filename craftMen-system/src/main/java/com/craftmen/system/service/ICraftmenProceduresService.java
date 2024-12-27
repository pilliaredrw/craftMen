package com.craftmen.system.service;

import java.util.List;
import com.craftmen.system.domain.CraftmenProcedures;

/**
 * 工序管理Service接口
 * 
 * @author craftMen
 * @date 2024-12-26
 */
public interface ICraftmenProceduresService 
{
    /**
     * 查询工序管理
     * 
     * @param id 工序管理主键
     * @return 工序管理
     */
    public CraftmenProcedures selectCraftmenProceduresById(Long id);

    /**
     * 查询工序管理列表
     * 
     * @param craftmenProcedures 工序管理
     * @return 工序管理集合
     */
    public List<CraftmenProcedures> selectCraftmenProceduresList(CraftmenProcedures craftmenProcedures);

    /**
     * 新增工序管理
     * 
     * @param craftmenProcedures 工序管理
     * @return 结果
     */
    public int insertCraftmenProcedures(CraftmenProcedures craftmenProcedures);

    /**
     * 修改工序管理
     * 
     * @param craftmenProcedures 工序管理
     * @return 结果
     */
    public int updateCraftmenProcedures(CraftmenProcedures craftmenProcedures);

    /**
     * 批量删除工序管理
     * 
     * @param ids 需要删除的工序管理主键集合
     * @return 结果
     */
    public int deleteCraftmenProceduresByIds(Long[] ids);

    /**
     * 删除工序管理信息
     * 
     * @param id 工序管理主键
     * @return 结果
     */
    public int deleteCraftmenProceduresById(Long id);
}
