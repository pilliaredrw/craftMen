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
import com.craftmen.system.domain.CraftmenProcessRequirements;
import com.craftmen.system.service.ICraftmenProcessRequirementsService;
import com.craftmen.common.utils.poi.ExcelUtil;
import com.craftmen.common.core.page.TableDataInfo;

/**
 * 工艺要求Controller
 * 
 * @author craftMen
 * @date 2024-12-26
 */
@RestController
@RequestMapping("/system/requirements")
public class CraftmenProcessRequirementsController extends BaseController
{
    @Autowired
    private ICraftmenProcessRequirementsService craftmenProcessRequirementsService;

    /**
     * 查询工艺要求列表
     */
    @PreAuthorize("@ss.hasPermi('system:requirements:list')")
    @GetMapping("/list")
    public TableDataInfo list(CraftmenProcessRequirements craftmenProcessRequirements)
    {
        startPage();
        List<CraftmenProcessRequirements> list = craftmenProcessRequirementsService.selectCraftmenProcessRequirementsList(craftmenProcessRequirements);
        return getDataTable(list);
    }

    /**
     * 导出工艺要求列表
     */
    @PreAuthorize("@ss.hasPermi('system:requirements:export')")
    @Log(title = "工艺要求", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CraftmenProcessRequirements craftmenProcessRequirements)
    {
        List<CraftmenProcessRequirements> list = craftmenProcessRequirementsService.selectCraftmenProcessRequirementsList(craftmenProcessRequirements);
        ExcelUtil<CraftmenProcessRequirements> util = new ExcelUtil<CraftmenProcessRequirements>(CraftmenProcessRequirements.class);
        util.exportExcel(response, list, "工艺要求数据");
    }

    /**
     * 获取工艺要求详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:requirements:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(craftmenProcessRequirementsService.selectCraftmenProcessRequirementsById(id));
    }

    /**
     * 新增工艺要求
     */
    @PreAuthorize("@ss.hasPermi('system:requirements:add')")
    @Log(title = "工艺要求", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CraftmenProcessRequirements craftmenProcessRequirements)
    {
        return toAjax(craftmenProcessRequirementsService.insertCraftmenProcessRequirements(craftmenProcessRequirements));
    }

    /**
     * 修改工艺要求
     */
    @PreAuthorize("@ss.hasPermi('system:requirements:edit')")
    @Log(title = "工艺要求", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CraftmenProcessRequirements craftmenProcessRequirements)
    {
        return toAjax(craftmenProcessRequirementsService.updateCraftmenProcessRequirements(craftmenProcessRequirements));
    }

    /**
     * 删除工艺要求
     */
    @PreAuthorize("@ss.hasPermi('system:requirements:remove')")
    @Log(title = "工艺要求", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(craftmenProcessRequirementsService.deleteCraftmenProcessRequirementsByIds(ids));
    }
}
