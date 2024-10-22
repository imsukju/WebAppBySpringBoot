package com.example1.springDemo1.selector;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.example1.springDemo1.config.DeferredConfig;
import com.example1.springDemo1.config.DelayedConfig;

public class MyDeferredImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 필요한 설정 클래스를 명확하게 지정
        return new String[] {
            "com.example1.springDemo1.config.DelayedConfig"
        };
    }

    @Override
    public Class<? extends Group> getImportGroup() {
        return MyDeferredImportGroup.class;
    }

    public static class MyDeferredImportGroup implements Group {
        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            // 필요한 로직을 여기에 추가 (현재는 빈 처리와 관계 없으므로 비워둠)

        }

        @Override
        public Iterable<Entry> selectImports() {
            return Collections.emptyList();
            // 빈을 로드하는 방식으로, "helloDelayed" 메서드 로드
//            return List.of(new Entry(AnnotationMetadata.introspect(DelayedConfig.class), "helloDelayed"));
        }
    }
}

