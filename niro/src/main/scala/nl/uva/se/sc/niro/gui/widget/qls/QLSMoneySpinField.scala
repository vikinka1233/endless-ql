package nl.uva.se.sc.niro.gui.widget.qls

import java.lang

import javafx.beans.value.{ ChangeListener, ObservableValue }
import javafx.scene.control.Spinner
import nl.uva.se.sc.niro.gui.widget.{ DecimalFormatterBuilder, FormatMasks }
import nl.uva.se.sc.niro.gui.widget.ql.QLWidget

class QLSMoneySpinField()
    extends Spinner[Double](Double.MinValue, Double.MaxValue, 0.0, 0.01)
    with QLWidget[java.math.BigDecimal] with FormatMasks {
  setEditable(true)
  getEditor.setTextFormatter(DecimalFormatterBuilder().buildInputFilter(MONEY_MASK).buildConverter().build())
  valueProperty().addListener(new ChangeListener[Double] {
    override def changed(observable: ObservableValue[_ <: Double], oldValue: Double, newValue: Double): Unit =
      valueChanged()
  })
  focusedProperty().addListener(new ChangeListener[lang.Boolean] {
    override def changed(
        observable: ObservableValue[_ <: lang.Boolean],
        oldValue: lang.Boolean,
        newValue: lang.Boolean): Unit = {
      if (!newValue) {
        increment(0)
        valueChanged()
      }
    }
  })
  override def value(newValue: java.math.BigDecimal): Unit =
    if (newValue != null) getValueFactory.valueProperty().setValue(newValue.doubleValue())
  override def value: java.math.BigDecimal =
    java.math.BigDecimal.valueOf(getValueFactory.valueProperty().getValue.doubleValue())
}
