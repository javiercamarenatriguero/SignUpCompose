package com.akole.signupcompose

import com.akole.signupcompose.utils.isValidDate
import com.akole.signupcompose.utils.isValidPassword
import com.akole.signupcompose.utils.isValidPhoneNumber
import org.junit.Test

import org.junit.Assert.assertFalse

class StringExtTest {
    @Test
    fun `9 characters phone numbers are valid`() {
        assert("999333999".isValidPhoneNumber())
        assert("111111111".isValidPhoneNumber())
        assert("345345345".isValidPhoneNumber())
        assert("999333999".isValidPhoneNumber())
        assert("999333999".isValidPhoneNumber())
    }

    @Test
    fun `Non-9 characters phone numbers are invalid`() {
        // Empty number
        assertFalse("".isValidPhoneNumber())
        // Less than 9
        assertFalse("1".isValidPhoneNumber())
        // More than 9
        assertFalse("1212121212".isValidPhoneNumber())
    }

    @Test
    fun `ddMMyyyy dates are valid`() {
        assert("12122020".isValidDate())
        assert("02122020".isValidDate())
        assert("30042021".isValidDate())
    }

    @Test
    fun `Non-ddMMyyyy dates are invalid`() {
        // Empty number
        assertFalse("".isValidDate())
        // Wrong formats
        assertFalse("".isValidDate())
        assertFalse("1".isValidDate())
        assertFalse("123".isValidDate())
        assertFalse("21212121212121".isValidDate())
        // Wrong Year
        assertFalse("12122300".isValidDate())
        // Wrong Month
        assertFalse("12132020".isValidDate())
        // Wrong day
        assertFalse("32012020".isValidDate())
    }

    @Test
    fun `8-15 characters passwords are valid`() {
        assert("123jmlk3124".isValidPassword())
        assert("123mlk456".isValidPassword())
        assert("123mklasdqpoe".isValidPassword())
    }

    @Test
    fun `Non 8-15 characters passwords are invalid`() {
        assertFalse("12".isValidPassword())
        assertFalse("123456".isValidPassword())
        assertFalse("123456789012345678".isValidPassword())
    }
}