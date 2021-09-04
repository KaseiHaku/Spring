Synopsis：
    Global Transaction: 全局事务
        JTA：
            优点: 
                1. 支持多个事务性资源，比如: 关系型数据库，消息队列，NoSQL 等
            downside:
                1. JTA 异常模型导致 API 十分笨重
                2. 因为 JTA  UserTransaction  从 JNDI 读取数据，所以必须使用 JNDI
                3. JTA 的代码必须在 应用服务器的环境下 才能正常执行，导致应用代码无法复用
        EJB CMT(Container Managed Transaction):
            由于 JTA 的各种毛病，以前更喜欢使用 EJB CMT(Container Managed Transaction) 来使用 全局事务，
            CMT 也是一种 声明式事务，他虽然移除了大多数代码，但是需要编写 代码来 控制事务，
            缺点：
                CMT 和 JTA，应用服务器环境 强耦合
                
    Local Transaction:
        缺点：
            1. 无法管理多个 事务资源，只能管理一个
            2. 本地事务 代码对 业务代码 有侵入性
    
    Spring Transaction Manager: 
        提供两种模式的事务管理： 声明式事务，编程式事务
        优点：
            1. 解决 Global and Local Transaction 的缺点，在任何 环境下(而不仅仅是 应用服务器环境)，提供一致的编程模型
            2. 和 事务管理 底层逻辑解耦
        
Spring Transaction Manager 相关 接口、类说明:
    TransactionManager: 事务管理器的顶层接口
        PlatformTransactionManager: imperative  命令式编程
            TransactionStatus: 代表一个新的 transaction 或者 一个在当前 call stack 中已经存在的 transaction，JavaEE(Servlet) 中是单线程，所以 context 和 call stack 一个意思
        ReactiveTransactionManager: reactive    响应式编程
            ReactiveTransaction: 代表一个新的 transaction 或者 一个在当前 context 中已经存在的 transaction
    TransactionException: 事务异常顶层类
    TransactionDefinition: 事务定义
        Propagation: 传播属性：定义当当前 context 中已经存在 transaction 时，碰到一个新的 transaction 方法时，是沿用老的 transaction 还是 将老的挂起，创建新的 transaction
        Isolation: 隔离级别：定义当前事务是否可以看到其他事务 uncommitted 的数据
        Timeout: 超时时间：
        Read-only status: 只读状态：
    TransactionInterceptor: 事务拦截器，在方法调用时，管理事务
    
    @Transactional: 放在方法上面，表示该方法开启事务
    @EnableTransactionManagement: 开启 spring 事务管理器
    
 Declarative Transaction Management:
    实现原理：
        1. 使用基于 AOP 的 Around Advice 拦截 @Transaction 注解注释的方法
        2. 由于事务 sql 的执行，需要 tx 实例，而拦截方法一般不会传递 tx 实例作为参数，所以 tx 实例一般通过 ThreadLocal 来隐式传递
           Reactor 中通过 Context 来隐式传递
    调用流程：
        Caller          AOP Proxy           Transaction Advisor             Custom Advisors             TargetMethod
           |----- call ------>|-------- call ------->| --------- call -------->|------------- call ---------->|
                              
        
    特性：
        unchecked 异常自动回滚
    
    
