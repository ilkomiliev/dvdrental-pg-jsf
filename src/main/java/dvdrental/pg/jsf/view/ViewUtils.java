package dvdrental.pg.jsf.view;

import dvdrental.pg.jsf.entities.Customer;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ViewUtils {

    public static <T> Example<T> getExampleAllContaining(Map<String, FilterMeta> filterBy, T o) {
        return genericExample(createProbe(o, filterBy),
                ExampleMatcher.matchingAll()
                    .withIgnoreCase()
                    .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING));
    }
    public static <T> Example<T> getExampleAnyContaining(Map<String, FilterMeta> filterBy, T o) {
        return genericExample(createProbe(o, filterBy),
                ExampleMatcher.matchingAny()
                        .withIgnoreCase()
                        .withStringMatcher(
                                ExampleMatcher.StringMatcher.CONTAINING));
    }

    public static <T> Sort getSort(Map<String, SortMeta> sortBy, Class<T> clazz) {
        if (sortBy != null && !sortBy.isEmpty()) {
            Sort sort = Sort.sort(clazz);
            for (SortMeta sm : sortBy.values()) {
                if (sm.getOrder() != SortOrder.UNSORTED) {
                    Sort.Direction direction =
                            sm.getOrder() == SortOrder.ASCENDING ? Sort.Direction.ASC : Sort.Direction.DESC;
                    sort = sort.and(Sort.by(direction, sm.getField()));
                }
            }
            return sort;
        }
        return Sort.unsorted();
    }
    public static <T> void setValueViaReflection(T o, String property, Object value)
            throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        new PropertyDescriptor(property, o.getClass())
                .getWriteMethod()
                .invoke(o, value);
    }

    private static <T> Example<T> genericExample(T probe, ExampleMatcher matcher) {
        return Example.of(probe, matcher);
    }

    private static <T> T createProbe(T o, Map<String, FilterMeta> filterBy) {
        filterBy.forEach((k, v) ->
        {
            try {
                setValueViaReflection(o, v.getField(), v.getFilterValue());
            }
            catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
                // ignore it here;
            }
        });
        return o;
    }
}
