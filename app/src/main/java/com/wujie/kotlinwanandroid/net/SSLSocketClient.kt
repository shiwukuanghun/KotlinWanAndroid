package com.wujie.kotlinwanandroid.net

import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/23 16:11
 *  @Description：
 **/
class SSLSocketClient {

    companion object {

        fun getSSLSocketFactory(): SSLSocketFactory {
            var sslContext: SSLContext = SSLContext.getInstance("TLS")
//            sslContext.init(null, getTrustManager(), SecureRandom())
//            sslContext.init(null, arrayOf(CustomTrustManager()), SecureRandom())
            sslContext.init(null, arrayOf(getCustomTrustManager()), SecureRandom())
            return sslContext.socketFactory
        }

        fun getTrustManager(): Array<TrustManager> {
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                override fun checkClientTrusted(
                    chain: Array<out X509Certificate>?,
                    authType: String?
                ) {
                }

                override fun checkServerTrusted(
                    chain: Array<out X509Certificate>?,
                    authType: String?
                ) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }

            })
            return trustAllCerts
        }

        fun getHostnameVerifier(): HostnameVerifier {
            val hostnameVerifier: HostnameVerifier = HostnameVerifier { hostname, session -> true }
            return hostnameVerifier
        }

/*        class CustomTrustManager : X509TrustManager {
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            }

            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        }*/

        fun getCustomTrustManager() = object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            }

            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        }

    }


}