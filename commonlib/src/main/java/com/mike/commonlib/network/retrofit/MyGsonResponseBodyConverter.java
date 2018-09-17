package com.mike.commonlib.network.retrofit;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Converter;

public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private static final String TAG = MyGsonResponseBodyConverter.class.getSimpleName();

    private final Gson gson;
    private final TypeAdapter<T> adapter;

    MyGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        BufferedSource source = value.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();

        Charset charset = Charset.forName("UTF8");
        okhttp3.MediaType contentType = value.contentType();
        if (contentType != null) {
            charset = contentType.charset(Charset.forName("UTF8"));
        }

        String s = buffer.readString(charset).replaceAll("\\r\\n", "");

        if (s.charAt(0) != '{') {
            s = s.substring(s.indexOf("{"), s.indexOf("}") + 1);
        }
        try {
            return adapter.fromJson(s.replaceFirst("\"data\":\"\",", ""));
        } finally {
            value.close();
        }
    }
}