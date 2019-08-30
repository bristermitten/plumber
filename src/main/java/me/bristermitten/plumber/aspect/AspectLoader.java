package me.bristermitten.plumber.aspect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.inject.Injector;
import me.bristermitten.plumber.PlumberPlugin;
import me.bristermitten.plumber.injection.PlumberPluginModule;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AspectLoader {

    private final Reflections reflections;
    private final PlumberPlugin plumberPlugin;
    private Set<Class<? extends Aspect>> requiredAspects = new HashSet<>();
    private BiMap<Class<? extends Annotation>, Class<? extends Aspect>> mappings;

    public AspectLoader(PlumberPlugin plumberPlugin, Reflections reflections) {
        this.plumberPlugin = plumberPlugin;
        this.reflections = reflections;
        this.mappings = HashBiMap.create();
    }

    public AspectLoader addThirdPartyAspectAnnotation(Class<? extends Annotation> annotation,
                                                      Class<? extends Aspect> aspect) {
        mappings.put(annotation, aspect);
        return this;
    }

    private void makeMappings() {
        reflections.getTypesAnnotatedWith(AspectAnnotation.class)
                .stream().filter(Class::isAnnotation)
                .map(c -> (Class<? extends Annotation>) c)
                .forEach(annotation -> {
                    AspectAnnotation aa = annotation.getAnnotation(AspectAnnotation.class);
                    mappings.put(annotation, aa.target());
                });
    }

    public Set<Aspect> loadAll() {
        makeMappings();
        findAll();

        PlumberPluginModule module = new PlumberPluginModule(plumberPlugin, reflections, requiredAspects);
        Injector injector = module.createInjector();

        Set<Aspect> aspects = requiredAspects.stream()
                .map(injector::getInstance)
                .collect(Collectors.toSet());

        aspects.forEach(a -> {
            a.enable();
            a.loadParts(findAspectChildren(a.getClass()));
        });
        return aspects;
    }

    private Set<Class> findAspectChildren(Class<? extends Aspect> a) {

        Class<? extends Annotation> mapping = mappings.inverse().get(a);
        return reflections.getTypesAnnotatedWith(mapping)
                .stream().filter(c -> !c.isInterface() && !c.isEnum())
                .collect(Collectors.toSet());
    }

    private void findAll() {
        try {
            mappings.forEach((a, as) -> {
                if (!reflections.getTypesAnnotatedWith(a).isEmpty()) {
                    requiredAspects.add(as);
                }
            });
        } catch (Throwable f) {
            f.printStackTrace();
        }

    }
}
