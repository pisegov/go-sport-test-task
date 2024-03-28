package com.example.pizza_test_task.data.banners

import com.example.pizza_test_task.domain.model.Banner
import com.example.pizza_test_task.domain.repository.BannersRepository
import javax.inject.Inject

class BannersRepositoryImpl @Inject constructor(
    private val bannersInMemoryDataSource: BannersInMemoryDataSource,
) : BannersRepository {
    override fun getBanners(): List<Banner> {
        return bannersInMemoryDataSource.banners
    }
}