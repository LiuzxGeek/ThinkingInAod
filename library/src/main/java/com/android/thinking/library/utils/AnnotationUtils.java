package com.android.thinking.library.utils;

import android.app.Activity;
import android.view.View;

import com.android.thinking.library.annotation.BindView;

import java.lang.reflect.Field;

/**
 * @Author liuxian
 * @Date 2018/5/31
 * @Desc
 */
public class AnnotationUtils {
    public static void initBindView(Activity activity) {
        // 通过反射获取到全部属性，反射的字段可能是一个类（静态）字段或实例字段
        Field[] fields = activity.getClass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                // 返回BindView类型的注解内容
                BindView bindView = field.getAnnotation(BindView.class);
                if (bindView != null) {
                    int viewId = bindView.id();
                    try {
                        field.setAccessible(true);
                        // 将currentClass的field赋值为sourceView.findViewById(viewId)
                        field.set(activity, activity.findViewById(viewId));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
