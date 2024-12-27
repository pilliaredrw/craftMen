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
import com.craftmen.system.domain.CraftmenCustomers;
import com.craftmen.system.service.ICraftmenCustomersService;
import com.craftmen.common.utils.poi.ExcelUtil;
import com.craftmen.common.core.page.TableDataInfo;

/**
 * 客户管理Controller
 * 
 * @author craftMen
 * @date 2024-12-25
 */
@RestController
@RequestMapping("/system/customers")
public class CraftmenCustomersController extends BaseController
{
    @Autowired
    private ICraftmenCustomersService craftmenCustomersService;

    /**
     * 查询客户管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:customers:list')")
    @GetMapping("/list")
    public TableDataInfo list(CraftmenCustomers craftmenCustomers)
    {
        startPage();
        List<CraftmenCustomers> list = craftmenCustomersService.selectCraftmenCustomersList(craftmenCustomers);
        return getDataTable(list);
    }

    /**
     * 导出客户管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:customers:export')")
    @Log(title = "客户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CraftmenCustomers craftmenCustomers)
    {
        List<CraftmenCustomers> list = craftmenCustomersService.selectCraftmenCustomersList(craftmenCustomers);
        ExcelUtil<CraftmenCustomers> util = new ExcelUtil<CraftmenCustomers>(CraftmenCustomers.class);
        util.exportExcel(response, list, "客户管理数据");
    }

    /**
     * 获取客户管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:customers:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(craftmenCustomersService.selectCraftmenCustomersById(id));
    }

    /**
     * 新增客户管理
     */
    @PreAuthorize("@ss.hasPermi('system:customers:add')")
    @Log(title = "客户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CraftmenCustomers craftmenCustomers)
    {
        return toAjax(craftmenCustomersService.insertCraftmenCustomers(craftmenCustomers));
    }

    /**
     * 修改客户管理
     */
    @PreAuthorize("@ss.hasPermi('system:customers:edit')")
    @Log(title = "客户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CraftmenCustomers craftmenCustomers)
    {
        return toAjax(craftmenCustomersService.updateCraftmenCustomers(craftmenCustomers));
    }

    /**
     * 删除客户管理
     */
    @PreAuthorize("@ss.hasPermi('system:customers:remove')")
    @Log(title = "客户管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(craftmenCustomersService.deleteCraftmenCustomersByIds(ids));
    }
}
