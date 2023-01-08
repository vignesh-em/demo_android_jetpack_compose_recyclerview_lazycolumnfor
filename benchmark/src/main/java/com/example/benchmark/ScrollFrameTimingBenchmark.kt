package com.example.benchmark

import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScrollFrameTimingBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    private fun scroll(type: String) =
        benchmarkRule.measureRepeated(
            packageName = "com.example.recyclerview",
            metrics = listOf(FrameTimingMetric()),
            iterations = 1,
            setupBlock = {
                pressHome()
                startActivityAndWait()
                device.findObject(By.text(type)).click()
            }
        ) {
            repeat(50

            ) {
                device.swipe(650, 1300, 650, 550, 2)
            }
        }

    @Test
    fun scrollRvItemPlusComposable() {
        scroll("Rv Item + Composable")
    }

    @Test
    fun scrollComposeLazyColumn() {
        scroll("Compose LazyColumn")
    }

    @Test
    fun scrollHybridRecyclerView() {
        scroll("Hybrid RecyclerView")
    }

    @Test
    fun scrollNormalRecyclerView() {
        scroll("Normal RecyclerView")
    }
}