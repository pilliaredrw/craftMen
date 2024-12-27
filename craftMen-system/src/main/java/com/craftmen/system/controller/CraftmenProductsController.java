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
import com.craftmen.system.domain.CraftmenProducts;
import com.craftmen.system.service.ICraftmenProductsService;
import com.craftmen.common.utils.poi.ExcelUtil;
import com.craftmen.common.core.page.TableDataInfo;

/**
 * 产品管理Controller
 * 
 * @author craftMen
 * @date 2024-12-25
 */
@RestController
@RequestMapping("/system/products")
public class CraftmenProductsController extends BaseController
{
    @Autowired
    private ICraftmenProductsService craftmenProductsService;

    /**
     * 查询产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:products:list')")
    @GetMapping("/list")
    public TableDataInfo list(CraftmenProducts craftmenProducts)
    {
        startPage();
        List<CraftmenProducts> list = craftmenProductsService.selectCraftmenProductsList(craftmenProducts);
        return getDataTable(list);
    }

    /**
     * 导出产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:products:export')")
    @Log(title = "产品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CraftmenProducts craftmenProducts)
    {
        List<CraftmenProducts> list = craftmenProductsService.selectCraftmenProductsList(craftmenProducts);
        ExcelUtil<CraftmenProducts> util = new ExcelUtil<CraftmenProducts>(CraftmenProducts.class);
        util.exportExcel(response, list, "产品管理数据");
    }

    /**
     * 获取产品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:products:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(craftmenProductsService.selectCraftmenProductsById(id));
    }

    /**
     * 新增产品管理
     */
    @PreAuthorize("@ss.hasPermi('system:products:add')")
    @Log(title = "产品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CraftmenProducts craftmenProducts)
    {
        return toAjax(craftmenProductsService.insertCraftmenProducts(craftmenProducts));
    }

    /**
     * 修改产品管理
     */
    @PreAuthorize("@ss.hasPermi('system:products:edit')")
    @Log(title = "产品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CraftmenProducts craftmenProducts)
    {
        return toAjax(craftmenProductsService.updateCraftmenProducts(craftmenProducts));
    }

    /**
     * 删除产品管理
     */
    @PreAuthorize("@ss.hasPermi('system:products:remove')")
    @Log(title = "产品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(craftmenProductsService.deleteCraftmenProductsByIds(ids));
    }
}
