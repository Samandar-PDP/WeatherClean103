package com.sdk.weatherclean.domain.use_case.local

import com.sdk.weatherclean.domain.repository.LocalRepository
import com.sdk.weatherclean.domain.use_case.all.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetThemeBaseUseCase = BaseUseCase<Unit, Flow<Int>>

class GetThemeUseCase @Inject constructor(
    private val repository: LocalRepository
): GetThemeBaseUseCase {
    override suspend fun invoke(parameter: Unit): Flow<Int> {
        return repository.getTheme()
    }
}