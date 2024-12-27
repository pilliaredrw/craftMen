import request from '@/utils/request'

// 查询工序管理列表
export function listProcedures(query) {
  return request({
    url: '/system/procedures/list',
    method: 'get',
    params: query
  })
}

// 查询工序管理详细
export function getProcedures(id) {
  return request({
    url: '/system/procedures/' + id,
    method: 'get'
  })
}

// 新增工序管理
export function addProcedures(data) {
  return request({
    url: '/system/procedures',
    method: 'post',
    data: data
  })
}

// 修改工序管理
export function updateProcedures(data) {
  return request({
    url: '/system/procedures',
    method: 'put',
    data: data
  })
}

// 删除工序管理
export function delProcedures(id) {
  return request({
    url: '/system/procedures/' + id,
    method: 'delete'
  })
}
