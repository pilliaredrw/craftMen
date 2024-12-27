import request from '@/utils/request'

// 查询工艺要求列表
export function listRequirements(query) {
  return request({
    url: '/system/requirements/list',
    method: 'get',
    params: query
  })
}

// 查询工艺要求详细
export function getRequirements(id) {
  return request({
    url: '/system/requirements/' + id,
    method: 'get'
  })
}

// 新增工艺要求
export function addRequirements(data) {
  return request({
    url: '/system/requirements',
    method: 'post',
    data: data
  })
}

// 修改工艺要求
export function updateRequirements(data) {
  return request({
    url: '/system/requirements',
    method: 'put',
    data: data
  })
}

// 删除工艺要求
export function delRequirements(id) {
  return request({
    url: '/system/requirements/' + id,
    method: 'delete'
  })
}
