/** spring 容器事件处理
 * 采用标准的 观察者设计模式
 * 内建事件:
 *      ContextRefreshedEvent
 *      ContextStartedEvent
 *      ContextStoppedEvent
 *      ContextClosedEvent
 *      RequestHandledEvent: only web
 *      ServletRequestHandledEvent: only web
 * 自定义事件：
 *      创建：
 *          继承 ApplicationEvent 类
 *      触发：
 *          实现 ApplicationEventPublisherAware 接口
 *      处理：
 *          实现 ApplicationListener 接口的类
 * 基于注解的事件处理器：
 *      事件处理器处理个事件，然后又触发一个事件，
 *      spel 表达式
 *          #root.event : 事件实例
 *          #event
 *          #root.args : 事件参数
 *          #args
 *          #arg[0]: 第一个事件参数
 *          #blEvent
 *          #a0:
 * 异步事件处理器：
 *
 * 事件处理器的优先级：
 *
 * 泛型事件:
 *
 * */
package kasei.spring.ioc.extension.event;

