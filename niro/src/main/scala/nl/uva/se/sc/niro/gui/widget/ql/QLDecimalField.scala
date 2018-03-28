package nl.uva.se.sc.niro.gui.widget.ql

import nl.uva.se.sc.niro.gui.widget.DecimalFormatterBuilder

class QLDecimalField() extends AbstractQLTextField[java.math.BigDecimal] {
  val DECIMAL_MASK = "\\d*(\\.\\d*)?"
  private val decimalFormatter = DecimalFormatterBuilder().buildInputFilter(DECIMAL_MASK).buildConverter().build()
  setTextFormatter(decimalFormatter)
  override def value(value: java.math.BigDecimal): Unit = decimalFormatter.setValue(value)
  override def value: java.math.BigDecimal = decimalFormatter.getValue
}