package readObjectAndNestedObjectFromAYamlPropertiesFile.converter;

import java.util.LinkedHashMap;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import readObjectAndNestedObjectFromAYamlPropertiesFile.configuration.MyConfigurationBean.MySecondObject;

@Component
@ConfigurationPropertiesBinding
public class MyMySecondObjectConverter implements Converter<LinkedHashMap<String, String> , MySecondObject> {
	@Override
    public MySecondObject convert(LinkedHashMap<String, String> sourceFromJson) {
        return (MySecondObject) MyObjectConverterUtil.copyHashMapContentIntoEquivalentMyObject(sourceFromJson, MySecondObject.class);
    }
}
