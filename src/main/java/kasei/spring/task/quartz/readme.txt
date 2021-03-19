Quartz:
    Quartz 通过以下三个类来实现(realize)对 定时任务 的抽象:
        Trigger: 任务触发器
        Job: 任务对象
        JobDetail: 任务细节描述
    
    Spring 对 Quartz 进行的封装:
        JobDetailFactoryBean: 用于构建 JobDetail 实例
        MethodInvokingJobDetailFactoryBean: 通过指定类方法的形式, 构建 JobDetail
        CronTriggerFactoryBean: 用于构建 Trigger 
        SimpleTriggerFactoryBean: 用于构建 Trigger
        SchedulerFactoryBean: 用于构建 Scheduler(调度器) 来处理 Trigger 


