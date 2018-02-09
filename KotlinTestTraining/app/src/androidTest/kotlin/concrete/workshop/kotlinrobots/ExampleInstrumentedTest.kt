package concrete.workshop.kotlinrobots

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule @JvmField val rule = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun execute() {
        setTextInputs()
        clickSum()
        checkResult()
    }

    fun setTextInputs() {
        onView(withId(R.id.firstNumber)).perform(typeText("1"))
        onView(withId(R.id.secondNumber)).perform(typeText("3"))
    }

    fun clickSum() {
        onView(withId(R.id.sum)).check(matches(withText("Somar"))).perform(click(), closeSoftKeyboard())
    }

    fun checkResult() {
        onView(withText("Sum total 4")).check(matches(isDisplayed()))
    }

}
