package com.miaosha.agent.until;

import com.miaosha.agent.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class BeanUtils {
    private BeanUtils() {
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (ObjectUtils.isEmpty(srcValue)) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void copyPropertiesIgnoreNull(Object src, Object target) {
        if (src != null) {
            org.springframework.beans.BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
        }
    }

    public static <T> T copyPropertiesIgnoreNull(Object src, Class<T> tClass) {
        try {
            T t = tClass.getDeclaredConstructor().newInstance();
            copyPropertiesIgnoreNull(src, t);
            return t;
        } catch (Exception e) {
            log.error("", e);
            throw new BaseException(500,"参数错误");
        }
    }

    public static <E> List<E> copyPropertiesIgnoreNull(List<?> source, Class<E> eClass) {
        if (CollectionUtils.isEmpty(source)) {
            return Collections.emptyList();
        }
        return source.stream().filter(Objects::nonNull).map(s -> {
            try {
                E e = eClass.getDeclaredConstructor().newInstance();
                copyPropertiesIgnoreNull(s, e);
                return e;
            } catch (Exception e) {
                log.error("", e);
                throw new BaseException(500,"参数错误");
            }
        }).collect(Collectors.toList());
    }
}
