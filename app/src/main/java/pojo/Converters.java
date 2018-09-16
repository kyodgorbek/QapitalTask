package pojo;

import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Converters {
    @TypeConverter
    public static List<Integer> convertJsonToListOfIntegers(String json) {
        if (json == null)
            return Collections.emptyList();
        Type listType = new TypeToken<List<Integer>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }
@TypeConverter
    public static String convertListOfIntegersToString(List<Integer> list) {
        if (list == null)
            list = new ArrayList<>();
        return new Gson().toJson(list);
    }

    @TypeConverter
    public static Object convertJsonToObject(String json) {
        if (json == null)
            return new Object();
        Type objectType = new TypeToken<Object>() {
        }.getType();
        return new Gson().fromJson(json, objectType);
    }
    @TypeConverter
    public static String convertObjectString(Object object) {
        if (object == null)
            object = new Object();
        return new Gson().toJson(object);
    }

}
