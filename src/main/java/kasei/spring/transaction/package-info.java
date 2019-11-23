package kasei.spring.transaction;


/** todo 事务隔离级别介绍
 * read_uncommited: 事务A 可以读取 事务B 未提交的数据
 * read_commited: 事务A 只有在 事务B 提交之后才能读到 事务B 更新的数据，否则只能读取旧的数据
 * repeatable_read: 事务A 在 事务B 执行过程中不能对 事务B  正在操作的数据，做 增、删、改 操作，能做查询
 * serializable: 任何事务在 事务B 执行完成之前禁止操作 事务B 正在操作的数据，包括查询
 * */



/** todo Spring 事务使用时的注意事项
 * 1. 使用 Spring 声明式事务必须存在接口
 *      原因： Spring 声明式事务采用 aop 实现的， 而 aop 由动态代理的设计模式实现，该设计模式必然存在接口，至于通过继承实现代理的方式暂时不清楚
 * 2. Spring 声明式事务在同一类中调用会失败，
 *      例如： methodA methodB 同属于一个类，methodB 是一个事务方法，然后 methodA（不是事务方法） 调用了 methodB，那么 methodB 的事务就失效了
 *      原因： 类内部调用时直接通过 this 引用调用对应的方法，而没有通过 spring 生成的代理对象去调用该方法，所以无法进行动态代理（即失效），如果需要实现两个事务同时存在，那么需要进行额外的配置
 * 3. 方法必须 throws 异常，且该异常为 Error 或者 RuntimeException 时，事务才会回滚，捕获异常后不抛出，或者抛出类型不对，都将导致回滚失败
 * */

