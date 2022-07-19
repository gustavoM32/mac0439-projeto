package com.mac0439.projeto.config

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect
import nz.net.ultraq.thymeleaf.layoutdialect.decorators.strategies.GroupingStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ViewConfiguration {
    @Bean
    fun layoutDialect(): LayoutDialect {
        return LayoutDialect(GroupingStrategy())
    }
}
