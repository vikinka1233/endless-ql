package ui.model

import ui.model.domain.Question
import tornadofx.ItemViewModel
import ui.controller.DogeController

abstract class QuestionViewModel(question: Question) : ItemViewModel<Question>(question) {

    private val dogeController: DogeController by inject()

    val readOnly = question.readOnly

    var questionInFocus : Question? = null

    fun update() {
        // Only update if there are changes
        // Added this check to remove unnecessary updates
        if (dirtyProperties.size > 0 && dirtyProperties.first().value != null) {
            questionInFocus = item
            synchronizeDataModel()
            dogeController.evaluate(item)
            load()
        }
    }

    fun load() {
        dogeController.reload()
    }


    abstract fun setViewModelValue(question: Question)

    abstract fun synchronizeDataModel()
}


