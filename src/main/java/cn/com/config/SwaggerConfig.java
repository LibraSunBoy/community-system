package cn.com.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.AllowableListValues;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Filename      :  SwaggerConfig
 * Package       :  cn.com.config
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2019年12月2019/12/17日
 * </pre>
 *
 * @author : yangdong.jia
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        //添加head参数start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("managementName").description("系统名称").modelRef(new ModelRef("string")).allowableValues(new AllowableListValues(Lists.newArrayList("TMS","BMS"),"string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        //添加head参数end
        return new Docket(DocumentationType.SWAGGER_2)
                //.globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.com"))
                .paths(PathSelectors.any())
                .build();
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//                .apis(RequestHandlerSelectors.basePackage("cn.com")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
         return new ApiInfoBuilder()
                .title("使用Swagger2构建RESTful APIs")
                .description("rest api说明")
                .termsOfServiceUrl("http://blog.venus.com/")
                .version("1.0")
                .build();
    }
}
