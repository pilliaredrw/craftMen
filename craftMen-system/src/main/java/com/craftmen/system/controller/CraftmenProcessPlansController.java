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
import com.craftmen.system.domain.CraftmenProcessPlans;
import com.craftmen.system.service.ICraftmenProcessPlansService;
import com.craftmen.common.utils.poi.ExcelUtil;
import com.craftmen.common.core.page.TableDataInfo;

/**
 * 工艺计划Controller
 * 
 * @author craftMen
 * @date 2024-12-26
 */
@RestController
@RequestMapping("/system/plans")
public class CraftmenProcessPlansController extends BaseController
{
    @Autowired
    private ICraftmenProcessPlansService craftmenProcessPlansService;

    /**
     * 查询工艺计划列表
     */
    @PreAuthorize("@ss.hasPermi('system:plans:list')")
    @GetMapping("/list")
    public TableDataInfo list(CraftmenProcessPlans craftmenProcessPlans)
    {
        startPage();
        List<CraftmenProcessPlans> list = craftmenProcessPlansService.selectCraftmenProcessPlansList(craftmenProcessPlans);
        return getDataTable(list);
    }

    /**
     * 导出工艺计划列表
     */
    @PreAuthorize("@ss.hasPermi('system:plans:export')")
    @Log(title = "工艺计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CraftmenProcessPlans craftmenProcessPlans)
    {
        List<CraftmenProcessPlans> list = craftmenProcessPlansService.selectCraftmenProcessPlansList(craftmenProcessPlans);
        ExcelUtil<CraftmenProcessPlans> util = new ExcelUtil<CraftmenProcessPlans>(CraftmenProcessPlans.class);
        util.exportExcel(response, list, "工艺计划数据");
    }

    /**
     * 获取工艺计划详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:plans:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(craftmenProcessPlansService.selectCraftmenProcessPlansById(id));
    }

    /**
     * 新增工艺计划
     */
    @PreAuthorize("@ss.hasPermi('system:plans:add')")
    @Log(title = "工艺计划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CraftmenProcessPlans craftmenProcessPlans)
    {
        return toAjax(craftmenProcessPlansService.insertCraftmenProcessPlans(craftmenProcessPlans));
    }

    /**
     * 修改工艺计划
     */
    @PreAuthorize("@ss.hasPermi('system:plans:edit')")
    @Log(title = "工艺计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CraftmenProcessPlans craftmenProcessPlans)
    {
        return toAjax(craftmenProcessPlansService.updateCraftmenProcessPlans(craftmenProcessPlans));
    }

    /**
     * 删除工艺计划
     */
    @PreAuthorize("@ss.hasPermi('system:plans:remove')")
    @Log(title = "工艺计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(craftmenProcessPlansService.deleteCraftmenProcessPlansByIds(ids));
    }
}
