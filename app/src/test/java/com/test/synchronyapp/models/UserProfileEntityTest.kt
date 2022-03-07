package com.test.synchronyapp.models

import com.test.synchronyapp.models.entity.UserProfileEntity
import junit.framework.TestCase
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class UserProfileEntityTest {
    lateinit var userProfileEntity: UserProfileEntity
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        buildUserProfileEntity()
    }

    @Test
    fun UserProfileEntity_NotNull_Test() {
        TestCase.assertNotNull(userProfileEntity)
    }

    @Test
    fun UserProfileEntity_Fname_Test() {
        TestCase.assertEquals(userProfileEntity.fName, "ravi")
    }

    @Test
    fun UserProfileEntity_Lname_Test() {
        TestCase.assertEquals(userProfileEntity.lName, "kkk")
    }

    @Test
    fun UserProfileEntity_Email_Test() {
        TestCase.assertEquals(userProfileEntity.email, "ravik@gmail.com")
    }

    @Test
    fun UserProfileEntity_Phone_Test() {
        TestCase.assertEquals(userProfileEntity.phone, "9082345566")
    }

    @Test
    fun UserProfileEntity_Edu_Test() {
        TestCase.assertEquals(userProfileEntity.education, "MCA")
    }

    @Test
    fun UserProfileEntity_Exp_Test() {
        TestCase.assertEquals(userProfileEntity.work, "12Year")
    }

    private fun buildUserProfileEntity() {
        userProfileEntity = UserProfileEntity(1, "ravi", "kkk", "ravik@gmail.com", "9082345566", "MCA", "12Year", "Nice", null)
    }
}