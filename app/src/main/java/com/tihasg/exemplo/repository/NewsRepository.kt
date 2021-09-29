package com.tihasg.exemplo.repository

import com.tihasg.exemplo.network.LoginApiVia
import com.tihasg.exemplo.network.model.BranchGetResponse
import retrofit2.Response

class Repository(private val api: LoginApiVia) {

    suspend fun searchByFlagAndBranch(bandeira: Int, filial: Int): Response<BranchGetResponse> {
        return api.searchByFlagAndBranch(bandeira = bandeira, filial = filial)
    }
}