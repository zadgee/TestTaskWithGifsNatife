package di.network
import org.koin.dsl.module

val networkModule = module{
    single { provideHttpLoggingInterceptor() }
    single { provideOkhttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideGiphyApi(get()) }
}