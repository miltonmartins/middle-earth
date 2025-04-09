package com.martins.middle.earth

import androidx.lifecycle.ViewModel
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import com.lemonappdev.konsist.api.ext.list.withAllParentsOf
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertTrue
import kotlin.test.Test

class AppKonsistTest {
    @Test
    fun `classes with 'UseCase' suffix should reside in 'usecase' package`() {
        Konsist.scopeFromProject()
            .classes()
            .withNameEndingWith("UseCase")
            .assertTrue { it.resideInPackage("..usecase..") }
    }

    @Test
    fun `classes extending 'ViewModel' should have 'ViewModel' suffix`() {
        Konsist.scopeFromProject()
            .classes()
            .withAllParentsOf(ViewModel::class)
            .assertTrue { it.name.endsWith("ViewModel") }
    }

    @Test
    fun `check if the layers architecture has correct dependencies`() {
        Konsist
            .scopeFromProject()
            .assertArchitecture {
                val packagePrefix = "com.martins.milton.middle.earth"
                val presentation = Layer("Presentation", "$packagePrefix.presentation..")
                val data = Layer("Data", "$packagePrefix.data..")
                val domain = Layer("Domain", "$packagePrefix.domain..")

                presentation.dependsOn(data)
                presentation.dependsOn(domain)
                data.dependsOn(domain)
                data.doesNotDependOn(presentation)
                domain.dependsOnNothing()
            }
    }
}