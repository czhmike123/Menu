package com.mike.commonlib.network.retrofit;

import com.mike.commonlib.logger.Log;
import com.mike.commonlib.network.NetRequest;
import com.mike.commonlib.network.NetResponse;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * 项目名称: Menu
 * 类描述:RetrofitOkRequest
 * 作者: Mike
 * 创建时间: 2018/8/31 10:50
 * 邮箱:2468139903@qq.com
 */
public abstract class RetrofitOkRequest<T,R extends NetResponse> implements NetRequest<R> {
    protected T apiService;

    public RetrofitOkRequest(){
        OkHttpClient  okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return interceptResponse(chain);
                    }
                })
                // .cache(AppConfig.getCache())
                .build();
        Retrofit  retrofit= new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(MyGsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        apiService=  retrofit.create(getApiServiceClass());
    }


   protected Log log= Log.Factory.getInstance().setTag(getClass().getSimpleName());

    private Response interceptResponse(Interceptor.Chain chain) throws IOException {
        //获得url上面的请求参数
        Request request = chain.request();
        HttpUrl httpUrl = request.url();
        HttpUrl.Builder urlBuilder = httpUrl.newBuilder();
        log.d(urlBuilder.toString());
        if(request.body()!=null){
            Buffer buffer = new Buffer();
            request.body().writeTo(buffer);
            log.d(buffer.readUtf8());
        }
        Response response=chain.proceed(request);
        log.json(getResponeString(response));

        return response;
    }

    private String getResponeString(Response response) throws IOException {
        ResponseBody responseBody = response.body();
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();

        Charset charset = Charset.forName("UTF8");
        okhttp3.MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(Charset.forName("UTF8"));
        }
        if (responseBody.contentLength()!=0) {
            String s = buffer.clone().readString(charset);
            return s;
        }
        return "";
    }

    public abstract Class<T> getApiServiceClass();

    public abstract String getBaseUrl();

}
