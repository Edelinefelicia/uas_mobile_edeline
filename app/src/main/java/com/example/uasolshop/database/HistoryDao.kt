package com.example.uasolshop.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.uasolshop.dataclass.Products

@Dao
interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(history: History)
    @Update
    fun update(history: History)
    @Delete
    fun delete(history: History)
    @get:Query("SELECT * from historiprodukGB ORDER BY id ASC")
    val allNotes: LiveData<List<History>>
    @Query("SELECT * from historiprodukGB WHERE id = :id")
    suspend fun getProdukbyId(id: String): History?
//    @Query("UPDATE historiprodukGB SET stok = stok-1 WHERE id= :id")
//    suspend fun decreaseStok(id: String)

}