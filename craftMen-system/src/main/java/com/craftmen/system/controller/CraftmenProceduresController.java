package com.craftmen.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.craftmen.common.annotation.Log;
import com.craftmen.common.core.controller.BaseController;
import com.craftmen.common.core.domain.AjaxResult;
import com.craftmen.common.enums.BusinessType;
import com.craftmen.system.domain.CraftmenProcedures;
import com.craftmen.system.service.ICraftmenProceduresService;
import com.craftmen.common.utils.poi.ExcelUtil;
import com.craftmen.common.core.page.TableDataInfo;

/**
 * 工序管理Controller
 * 
 * @author craftMen
 * @date 2024-12-26
 */
@RestController
@RequestMapping("/system/procedures")
public class CraftmenProceduresController extends BaseController
{
    @Autowired
    private ICraftmenProceduresService craftmenProceduresService;

    /**
     * 查询工序管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:procedures:list')")
    @GetMapping("/list")
    public TableDataInfo list(CraftmenProcedures craftmenProcedures)
    {
        startPage();
        List<CraftmenProcedures> list = craftmenProceduresService.selectCraftmenProceduresList(craftmenProcedures);
        return getDataTable(list);
    }

    /**
     * 导出工序管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:procedures:export')")
    @Log(title = "工序管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CraftmenProcedures craftmenProcedures)
    {
        List<CraftmenProcedures> list = craftmenProceduresService.selectCraftmenProceduresList(craftmenProcedures);
        ExcelUtil<CraftmenProcedures> util = new ExcelUtil<CraftmenProcedures>(CraftmenProcedures.class);
        util.exportExcel(response, list, "工序管理数据");
    }

    /**
     * 获取工序管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:procedures:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(craftmenProceduresService.selectCraftmenProceduresById(id));
    }

    /**
     * 新增工序管理
     */
    @PreAuthorize("@ss.hasPermi('system:procedures:add')")
    @Log(title = "工序管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CraftmenProcedures craftmenProcedures)
    {
        return toAjax(craftmenProceduresService.insertCraftmenProcedures(craftmenProcedures));
    }

    /**
     * 修改工序管理
     */
    @PreAuthorize("@ss.hasPermi('system:procedures:edit')")
    @Log(title = "工序管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CraftmenProcedures craftmenProcedures)
    {
        return toAjax(craftmenProceduresService.updateCraftmenProcedures(craftmenProcedures));
    }

    /**
     * 删除工序管理
     */
    @PreAuthorize("@ss.hasPermi('system:procedures:remove')")
    @Log(title = "工序管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(craftmenProceduresService.deleteCraftmenProceduresByIds(ids));
    }
}
