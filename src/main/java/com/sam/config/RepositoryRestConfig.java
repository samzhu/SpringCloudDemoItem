package com.sam.config;

import com.sam.domain.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Created by samchu on 2016/12/6.
 */
@Configuration
public class RepositoryRestConfig extends RepositoryRestConfigurerAdapter {

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        //設置使 NotEmpty 之類的驗證器可以生效
        //validatingListener.addValidator("afterCreate", validator());
        validatingListener.addValidator("beforeCreate", validator());
        //validatingListener.addValidator("afterSave", validator());
        //validatingListener.addValidator("beforeSave", validator());
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        //設置返回的json Body中顯示id
        config.exposeIdsFor(Item.class);
        //config.exposeIdsFor(Author.class);
    }
}
