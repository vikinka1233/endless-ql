package data.value

import common.Color
import data.question.SymbolType


class ColorValue(var value: Color) : BaseSymbolValue(SymbolType.Color) {

    constructor(value: String) : this(Color(value))

    override fun valueString(): String {
        return value.toString()
    }

}