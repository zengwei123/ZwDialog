package com.example.zwdialogs;

import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Field;

/**
 * Created by zengwei on 2018/9/19.
 * 注解绑定控件
 */

public class ZwBindActivity extends AppCompatActivity {

    protected void injectViews(){
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ZwBind.class)) {
                ZwBind inject = field.getAnnotation(ZwBind.class);
                int id = inject.value();
                if (id > 0) {
                    field.setAccessible(true);
                    try {
                        field.set(this, this.findViewById(id));
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
