# deepseek-client Java客户端

## 项目中使用

### 1. 配置文件

```yaml
yuanxmo:
  deepseek:
    appKey: yourAppKey
    mode: chat # 默认chat，目前就一种模式
    model: v3 # v3 / r1
    # 系统消息，指定角色，返回结果类型指定，下方是一个让Deepseek返回Json类型数据示例
    systemMessage: "The user will provide some exam text. Please parse the \"question\" and \"answer\" and output them in JSON format.EXAMPLE INPUT: 太阳从西边升起。 Mount Everest.EXAMPLE JSON OUTPUT:{\"question\": \"Which is the highest mountain in the world?\",\"isTrue\": \"false\""

```

### 2. 引入

```java
@Data
public class Demo {
    private String question;
    private Boolean isTrue;
}
```

```java
@Service
public class DemoServiceImpl implements DemoService{
    @Resource
    private DeepseekClient deepseekClient;
    
    public Demo test(String question) {
        DeepseekResponse deepseekResponse = deepseekClient.newCall(question);
        Demo result = deepseekResponse.getResultObject(Demo.class);
        return result;
    }
    
}
```

