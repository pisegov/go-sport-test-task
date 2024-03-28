package com.example.pizza_test_task.domain.repository

import com.example.pizza_test_task.domain.model.Banner

interface BannersRepository {
    fun getBanners(): List<Banner>
}