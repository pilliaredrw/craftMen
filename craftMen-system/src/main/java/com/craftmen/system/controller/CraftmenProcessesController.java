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
import com.craftmen.system.domain.CraftmenProcesses;
import com.craftmen.system.service.ICraftmenProcessesService;
import com.craftmen.common.utils.poi.ExcelUtil;
import com.craftmen.common.core.page.TableDataInfo;

/**
 * 工艺管理Controller
 * 
 * @author craftMen
 * @date 2024-12-26
 */
@RestController
@RequestMapping("/system/processes")
public class CraftmenProcessesController extends BaseController
{
    @Autowired
    private ICraftmenProcessesService craftmenProcessesService;

    /**
     * 查询工艺管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:processes:list')")
    @GetMapping("/list")
    public TableDataInfo list(CraftmenProcesses craftmenProcesses)
    {
        startPage();
        List<CraftmenProcesses> list = craftmenProcessesService.selectCraftmenProcessesList(craftmenProcesses);
        return getDataTable(list);
    }

    /**
     * 导出工艺管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:processes:export')")
    @Log(title = "工艺管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CraftmenProcesses craftmenProcesses)
    {
        List<CraftmenProcesses> list = craftmenProcessesService.selectCraftmenProcessesList(craftmenProcesses);
        ExcelUtil<CraftmenProcesses> util = new ExcelUtil<CraftmenProcesses>(CraftmenProcesses.class);
        util.exportExcel(response, list, "工艺管理数据");
    }

    /**
     * 获取工艺管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:processes:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(craftmenProcessesService.selectCraftmenProcessesById(id));
    }

    /**
     * 新增工艺管理
     */
    @PreAuthorize("@ss.hasPermi('system:processes:add')")
    @Log(title = "工艺管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CraftmenProcesses craftmenProcesses)
    {
        return toAjax(craftmenProcessesService.insertCraftmenProcesses(craftmenProcesses));
    }

    /**
     * 修改工艺管理
     */
    @PreAuthorize("@ss.hasPermi('system:processes:edit')")
    @Log(title = "工艺管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CraftmenProcesses craftmenProcesses)
    {
        return toAjax(craftmenProcessesService.updateCraftmenProcesses(craftmenProcesses));
    }

    /**
     * 删除工艺管理
     */
    @PreAuthorize("@ss.hasPermi('system:processes:remove')")
    @Log(title = "工艺管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(craftmenProcessesService.deleteCraftmenProcessesByIds(ids));
    }
}
