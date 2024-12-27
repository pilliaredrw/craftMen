import request from '@/utils/request'

// 查询工艺计划列表
export function listPlans(query) {
  return request({
    url: '/system/plans/list',
    method: 'get',
    params: query
  })
}

// 查询工艺计划详细
export function getPlans(id) {
  return request({
    url: '/system/plans/' + id,
    method: 'get'
  })
}

// 新增工艺计划
export function addPlans(data) {
  return request({
    url: '/system/plans',
    method: 'post',
    data: data
  })
}

// 修改工艺计划
export function updatePlans(data) {
  return request({
    url: '/system/plans',
    method: 'put',
    data: data
  })
}

// 删除工艺计划
export function delPlans(id) {
  return request({
    url: '/system/plans/' + id,
    method: 'delete'
  })
}
