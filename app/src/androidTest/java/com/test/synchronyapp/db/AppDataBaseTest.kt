package com.test.synchronyapp.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.test.synchronyapp.models.entity.UserProfileEntity
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppDataBaseTest: TestCase() {

    private lateinit var db: AppDatabase
    private lateinit var dao: UserProfileDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.getUserProfileDao()
    }

    @Test
    fun insertAndReadProfile() = runBlocking {
        val profile = getUserProfileEntity()
        dao.insertRecords(profile)
        val profiles = dao.getAllProfile()
        Assert.assertEquals(profiles.size, 1)
    }

    @After
    fun closeDb() {
        db.close()
    }

    private fun getUserProfileEntity(): UserProfileEntity {
        return UserProfileEntity(1, "ravi", "kkk", "ravik@gmail.com", "9082345566", "MCA", "12Year", "Nice", null)
    }
}