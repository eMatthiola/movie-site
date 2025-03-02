# movie-site

一、数据库操作（MyBatis）
CRUD（增删改查）

@Mapper + @Select / @Insert / @Update / @Delete
ResultMap 处理复杂映射
关联查询（one-to-one / one-to-many）
分页查询

LIMIT + OFFSET 方式
使用 MyBatis 插件（如 PageHelper）
动态 SQL

<if>、<choose>、<foreach> 处理复杂查询
事务管理

@Transactional 事务注解
配置 事务传播机制（PROPAGATION_REQUIRED、PROPAGATION_NESTED）


二、Spring 核心功能
依赖注入（DI）& 控制反转（IoC）

@Component、@Service、@Repository
@Autowired / @Qualifier / @Resource
AOP（面向切面编程）

日志、权限校验、事务管理
@Aspect、@Before、@AfterReturning
事件监听

ApplicationListener 监听自定义事件
应用场景：用户注册成功后发送通知


三、Spring MVC 处理请求
请求映射

@RequestMapping（@GetMapping / @PostMapping）
@PathVariable 处理 URL 变量
@RequestParam 处理 GET/POST 参数
返回 JSON 数据

@ResponseBody
@RestController 代替 @Controller + @ResponseBody
统一封装 Result<T> 响应格式
全局异常处理

@ExceptionHandler 处理特定异常
@ControllerAdvice 统一异常捕获


四、拦截器、过滤器、权限控制
拦截器（Interceptor）

处理 登录校验、权限控制
实现 HandlerInterceptor 接口
过滤器（Filter）

跨域处理（CORS）
请求日志打印
实现 javax.servlet.Filter
Shiro / Spring Security 权限控制

JWT 认证
@PreAuthorize 注解权限管理
五、缓存 & 高并发优化
Redis 作为缓存

@Cacheable / @CachePut
Redis 存储 用户会话信息（分布式 Session）
防止缓存穿透、击穿、雪崩

布隆过滤器
缓存预热 + 限流
使用 Redis 分布式锁
MQ（消息队列）

异步任务处理
结合 Kafka / RabbitMQ 实现 秒杀/抢购系统


六、日志管理
SLF4J + Logback

统一日志格式
日志级别（DEBUG、INFO、ERROR）
链路追踪（Log + TraceId）

MDC.put("traceId", UUID.randomUUID().toString())
配合 ELK（Elasticsearch + Logstash + Kibana）


七、文件上传 & 下载
Spring MVC 处理上传

@RequestParam("file") MultipartFile file
限制 上传大小
大文件断点续传

分片上传 + 秒传机制
使用 MinIO / OSS / S3


八、测试 & CI/CD
单元测试

@SpringBootTest
Mockito + @MockBean
CI/CD

Jenkins 持续集成
Docker + Kubernetes 部署
