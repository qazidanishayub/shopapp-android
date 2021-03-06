package com.shopapp.domain.interactor.account

import com.nhaarman.mockito_kotlin.verify
import com.shopapp.domain.repository.AuthRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetCustomerUseCaseTest {

    private lateinit var useCase: GetCustomerUseCase

    @Mock
    private lateinit var authRepository: AuthRepository

    @Before
    fun setUpTest() {
        useCase = GetCustomerUseCase(authRepository)
    }

    @Test
    fun shouldDelegateCallToRepository() {
        useCase.buildUseCaseSingle(Unit)
        verify(authRepository).getCustomer()
    }

}