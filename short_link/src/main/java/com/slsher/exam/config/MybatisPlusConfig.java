package com.slsher.exam.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * @program: laiweilai
 * @description:
 * @author: zhuzhiwen
 * @date: 2023/02/22 22:13
 **/
public class MybatisPlusConfig {
        /**
         * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
         * 3.4.3不用设置
         */
        @Bean
        public MybatisPlusInterceptor mybatisPlusInterceptor1() {
            MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
            interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
            return interceptor;
        }





        //BlockAttackInnerInterceptor
        //针对 update 和 delete 语句 作用: 阻止恶意的全表更新删除
        @Bean
        public MybatisPlusInterceptor mybatisPlusInterceptor3() {
            MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
            // 执行分析插件
            interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
            return interceptor;
        }

        //乐观锁插件
        @Bean
        public MybatisPlusInterceptor mybatisPlusInterceptor4() {
            MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
            interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
            return interceptor;
        }


}
