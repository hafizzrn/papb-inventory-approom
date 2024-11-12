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

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
/*
* Anotasi @Dao digunakan untuk mendeklarasikan ItemDao sebagai Data Access Object (DAO).
* DAO adalah komponen yang menyediakan metode untuk berinteraksi dengan database.
 */
@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    /*
    Method untuk menambahkan item baru ke database
     */
    suspend fun insert(item: Item)
    /*
    Method untuk memperbari item dari database
    */
    @Update
    suspend fun update(item: Item)
    /*
    Method untuk menghapus item dari database
    */
    @Delete
    suspend fun delete(item: Item)
    /*
    digunakan untuk mengambil satu item dari database berdasarkan id
    */
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>
    /*
    *digunakan untuk mengambil semua item
    *mengurutkannya berdasarkan nama secara ascending
    */
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}
