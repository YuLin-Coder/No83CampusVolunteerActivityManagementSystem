<template>
  <Content :style="{margin: '24px',padding: '24px',background: '#fff'}">
    <Table border :columns="columns" :data="volunteers"></Table>
  </Content>
</template>

<script>
import { getExcellentVolunteers } from '@/services'

export default {
  name: 'volunteers',
  components: {
  },
  data () {
    return {
      pageSize: 100,
      count: 0,
      columns: [
        {
          title: '学院',
          key: 'userSchool',
          filters: [
            {
              label: '计算机工程学院',
              value: '计算机工程学院'
            },
            {
              label: '机械工程学院',
              value: '机械工程学院'
            },
            {
              label: '通信工程学院',
              value: '通信工程学院'
            },
            {
              label: '自动化工程学院',
              value: '自动化工程学院'
            },
            {
              label: '电力工程学院',
              value: '电力学院'
            },
            {
              label: '能源与动力工程学院',
              value: '能源与动力工程学院'
            },
            {
              label: '经济与管理学院',
              value: '经济与管理学院'
            },
            {
              label: '工业中心',
              value: '工业中心'
            },
            {
              label: '艺术与设计学院',
              value: '艺术与设计学院'
            }
          ],
          filterMethod (value, row) {
            return row.userSchool.indexOf(value) > -1
          }
        },
        {
          title: '班级',
          key: 'userClass',
          filters: [
            {
              label: '数嵌161',
              value: '数嵌161'
            },
            {
              label: '网嵌162',
              value: '网嵌162'
            }
          ],
          filterMethod (value, row) {
            return row.userClass.indexOf(value) > -1
          }
        },
        {
          title: '姓名',
          key: 'userName'
        },
        {
          title: '学号',
          key: 'stuId'
        },
        {
          title: '积分',
          key: 'userScore'
        }
      ],
      volunteers: []
    }
  },
  methods: {
    async getVolunteers (page = 1) {
      let res = await getExcellentVolunteers({ current: page, size: this.pageSize })
      console.log('getVolunteers:', res)
      if (res) {
        this.volunteers = res.records
        this.count = res.total
      } else {
        this.$Modal.error({
          title: '出错啦'
        })
      }
    }
  },
  mounted () {
    this.getVolunteers()
  }
}
</script>
