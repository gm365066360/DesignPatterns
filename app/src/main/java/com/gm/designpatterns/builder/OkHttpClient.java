package com.gm.designpatterns.builder;


import java.util.ArrayList;
import java.util.List;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/11 15:18
 * Description: OkHttpClient
 * Company : 北京四维图新科技股份有限公司
 */
public class OkHttpClient  {
    int connectTimeout;
    int readTimeout;
    int writeTimeout;
    List<Interceptor> interceptors;

    public OkHttpClient() {
        this(new Builder());
    }

    OkHttpClient(Builder builder) {
        this.connectTimeout = builder.connectTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.readTimeout = builder.readTimeout;
        this.interceptors = builder.interceptors;
    }

    public static class Interceptor {

    }

    public static final class Builder {

        int connectTimeout;
        int readTimeout;
        int writeTimeout;
        List<Interceptor> interceptors;

        public Builder() {
            connectTimeout = 10_000;
            readTimeout = 10_000;
            writeTimeout = 10_000;
            interceptors = new ArrayList<>();
        }

        public Builder connectTimeout(int timeout) {
            connectTimeout = timeout;
            return this;
        }

        public Builder writeTimeout(int timeout) {
            writeTimeout = timeout;
            return this;
        }

        public Builder readTimeout(int timeout) {
            readTimeout = timeout;
            return this;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            interceptors.add(interceptor);
            return this;
        }

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }

    }

}
