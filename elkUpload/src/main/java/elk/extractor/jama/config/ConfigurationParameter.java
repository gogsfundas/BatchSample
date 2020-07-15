package elk.extractor.jama.config;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.batch.core.JobParameter;

public class ConfigurationParameter<T extends Serializable> extends JobParameter {
        private T customParam;
        public ConfigurationParameter(T customParam){
            super(UUID.randomUUID().toString());//This is to avoid duplicate JobInstance error
            this.customParam = customParam;
        }
        public T getValue(){
            return customParam;
        }
    }