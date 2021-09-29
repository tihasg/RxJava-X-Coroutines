package com.tihasg.exemplo.network

import com.tihasg.exemplo.network.model.BranchGetResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginApiVia {
    @GET("uaa/bandeiras/{bandeira}/filiais/{filial}")
    suspend fun searchByFlagAndBranch(
        @Path("bandeira") bandeira: Int,
        @Path("filial") filial: Int
    ): Response<BranchGetResponse>
}