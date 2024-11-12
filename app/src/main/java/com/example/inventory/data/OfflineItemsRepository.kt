/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

/**
 * OfflineItemsRepository adalah kelas yang mengimplementasikan ItemsRepository
 * berfungsi sebagai repositori ketika aplikasi berjalan dalam mode offline.
 * Kelas ini mengakses itemDao untuk melakukan operasi database.
 */

class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
    /**
     * mengembalikan list item yang ada pada database dalam bentuk Flow<List<Item>>
     */
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()
    /**
     * digunakan untuk mengambil satu item dari database berdasarkan id yang berjalan secara real-time
     */
    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)
    /**
     * digunakan untuk menambahkan satu item ke database
     */
    override suspend fun insertItem(item: Item) = itemDao.insert(item)
    /**
     * digunakan untuk menghapus satu item ke database
     */
    override suspend fun deleteItem(item: Item) = itemDao.delete(item)
    /**
     * digunakan untuk memperbarui satu item ke database
     */
    override suspend fun updateItem(item: Item) = itemDao.update(item)
}
