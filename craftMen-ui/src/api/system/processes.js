import request from '@/utils/request'

// 查询工艺管理列表
export function listProcesses(query) {
  return request({
    url: '/system/processes/list',
    method: 'get',
    params: query
  })
}

// 查询工艺管理详细
export function getProcesses(id) {
  return request({
    url: '/system/processes/' + id,
    method: 'get'
  })
}

// 新增工艺管理
export function addProcesses(data) {
  return request({
    url: '/system/processes',
    method: 'post',
    data: data
  })
}

// 修改工艺管理
export function updateProcesses(data) {
  return request({
    url: '/system/processes',
    method: 'put',
    data: data
  })
}

// 删除工艺管理
export function delProcesses(id) {
  return request({
    url: '/system/processes/' + id,
    method: 'delete'
  })
}
