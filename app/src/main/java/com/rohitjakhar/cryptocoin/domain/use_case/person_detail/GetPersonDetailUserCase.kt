package com.rohitjakhar.cryptocoin.domain.use_case.person_detail

import com.rohitjakhar.cryptocoin.common.Resource
import com.rohitjakhar.cryptocoin.data.remote.dto.toPersonDetail
import com.rohitjakhar.cryptocoin.domain.model.PersonDetail
import com.rohitjakhar.cryptocoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPersonDetailUserCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(personId: String): Flow<Resource<PersonDetail>> = flow {
        try {
            emit(Resource.Loading())
            val personDetail = repository.getPersonDetails(personId).toPersonDetail()
            emit(Resource.Success(data = personDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown"))
        }
    }
}
