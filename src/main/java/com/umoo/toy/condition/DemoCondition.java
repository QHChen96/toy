package com.umoo.toy.condition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Administrator on 2017/1/18.
 */
public class DemoCondition implements Condition{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    //根据上下文和元注解信息进行配置
    //对于需要这套规则的方法进行@Conditional注解
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return false;
    }
}
