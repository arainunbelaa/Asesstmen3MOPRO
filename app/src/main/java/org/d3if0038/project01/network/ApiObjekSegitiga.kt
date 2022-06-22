package org.d3if0038.project01.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if0038.project01.model.ObjekSegitiga
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/arainunbelaa/Asesstmen1MOPRO/master/"
private const val BASE_IMG_URL = "https://raw.githubusercontent.com/arainunbelaa/Asesstmen1MOPRO/master/img/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface ApiObjekSegitiga {
    @GET("benda-segitiga.json")
    suspend fun getObjekSegitiga(): List<ObjekSegitiga>
}
object ObjekSegitigaApi {
    val service: ApiObjekSegitiga by lazy {
        retrofit.create(ApiObjekSegitiga::class.java)
    }
    fun getObjekSegitigaUrl(gambar: String): String {
        return "$BASE_IMG_URL$gambar"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }