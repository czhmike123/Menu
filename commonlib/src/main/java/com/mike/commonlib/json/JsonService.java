package com.mike.commonlib.json;

import java.util.List;

public interface JsonService {
    <T> T parseObject(String var1, Class<T> var2);

    <T> List<T> parseArray(String var1, Class<T> var2);

    String toJsonString(Object var1);

    public static class Factory {
        private static volatile JsonService jsonService;

        public Factory() {
        }

        public static JsonService getSingletonImpl() {
            if (jsonService == null) {
                Class var0 = JsonService.Factory.class;
                synchronized(JsonService.Factory.class) {
                    if (jsonService == null) {
                        jsonService = new JsonServiceImpl();
                    }
                }
            }
            return jsonService;
        }
    }
}