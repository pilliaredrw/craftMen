import request from '@/utils/request'

// 查询产品管理列表
export function listProducts(query) {
  return request({
    url: '/system/products/list',
    method: 'get',
    params: query
  })
}

// 查询产品管理详细
export function getProducts(id) {
  return request({
    url: '/system/products/' + id,
    method: 'get'
  })
}

// 新增产品管理
export function addProducts(data) {
  return request({
    url: '/system/products',
    method: 'post',
    data: data
  })
}

// 修改产品管理
export function updateProducts(data) {
  return request({
    url: '/system/products',
    method: 'put',
    data: data
  })
}

// 删除产品管理
export function delProducts(id) {
  return request({
    url: '/system/products/' + id,
    method: 'delete'
  })
}
